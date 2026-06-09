package com.ucr.store.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.store.dto.SalesDto;
import com.ucr.store.entities.Client;
import com.ucr.store.entities.Product;
import com.ucr.store.entities.SaleDetail;
import com.ucr.store.entities.Sales;
import com.ucr.store.exceptions.ResourceNotFoundException;
import com.ucr.store.models.ClientInfoResponseModel;
import com.ucr.store.models.ClientSalesSummaryResponseModel;
import com.ucr.store.models.SaleFullDetailResponseModel;
import com.ucr.store.models.SaleProductItemResponseModel;
import com.ucr.store.repositories.ClientRepository;
import com.ucr.store.repositories.SaleDetailRepository;
import com.ucr.store.repositories.SalesRepository;

@Service
public class SalesService implements ISalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SaleDetailRepository saleDetailRepository;

    @Override
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @Override
    public Sales getSaleById(Long id) {
        return salesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Sale not found with id: " + id));
    }

    @Override
    public Sales createSale(SalesDto dto) {
        Client client = clientRepository.findById(dto.clientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

        Sales sale = new Sales();
        sale.setClient(client);
        sale.setSaleDate(dto.saleDate());
        sale.setTotalAmount(dto.totalAmount());
        sale.setStatus(dto.status());

        return salesRepository.save(sale);
    }

    @Override
    public Sales updateSale(Long id, SalesDto dto) {
        Sales sale = getSaleById(id);

        Client client = clientRepository.findById(dto.clientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

        sale.setClient(client);
        sale.setSaleDate(dto.saleDate());
        sale.setTotalAmount(dto.totalAmount());
        sale.setStatus(dto.status());

        return salesRepository.save(sale);
    }

    @Override
    public void deleteSale(Long id) {
        Sales sale = getSaleById(id);
        salesRepository.delete(sale);
    }

    @Override
    public List<ClientSalesSummaryResponseModel> getSalesHistoryByClientId(Long clientId) {
        clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + clientId));

        List<Sales> sales = salesRepository.findByClient_Id(clientId);
        return sales.stream()
                .map(sale -> {
                    List<SaleDetail> details = saleDetailRepository.findBySale_Id(sale.getId());
                    return new ClientSalesSummaryResponseModel(
                            sale.getId(),
                            sale.getSaleDate(),
                            sale.getTotalAmount(),
                            sale.getStatus(),
                            (long) details.size()
                    );
                })
                .collect(Collectors.toList());
    }

    @Override
    public SaleFullDetailResponseModel getSaleFullDetail(Long saleId) {
        Sales sale = getSaleById(saleId);
        List<SaleDetail> details = saleDetailRepository.findBySale_Id(saleId);

        List<SaleProductItemResponseModel> products = details.stream()
                .map(detail -> {
                    Product product = detail.getProduct();
                    String productName = product != null ? product.getName() : null;
                    String designName = product != null && product.getDesign() != null
                            ? product.getDesign().getName() : null;
                    String sizeLabel = product != null && product.getSize() != null
                            ? product.getSize().getLabel() : null;
                    BigDecimal subtotal = detail.getUnitPrice()
                            .multiply(BigDecimal.valueOf(detail.getQuantity()));
                    return new SaleProductItemResponseModel(
                            productName, designName, sizeLabel,
                            detail.getQuantity(), detail.getUnitPrice(), subtotal
                    );
                })
                .collect(Collectors.toList());

        Client client = sale.getClient();
        ClientInfoResponseModel clientInfo = client != null
                ? new ClientInfoResponseModel(
                        client.getFirstName() + " " + client.getLastName(),
                        client.getEmail())
                : null;

        return new SaleFullDetailResponseModel(
                sale.getId(),
                sale.getSaleDate(),
                sale.getTotalAmount(),
                sale.getStatus(),
                products,
                clientInfo
        );
    }
}

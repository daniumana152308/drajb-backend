package com.ucr.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.store.dto.CartDetailDto;
import com.ucr.store.entities.CartDetail;
import com.ucr.store.entities.Product;
import com.ucr.store.entities.ShoppingCart;
import com.ucr.store.exceptions.ResourceNotFoundException;
import com.ucr.store.repositories.CartDetailRepository;
import com.ucr.store.repositories.ProductRepository;
import com.ucr.store.repositories.ShoppingCartRepository;

@Service
public class CartDetailService {

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<CartDetail> getAllCartDetails() {

        return cartDetailRepository.findAll();
    }

    public CartDetail getCartDetailById(Long id) {

        return cartDetailRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cart detail not found with id: " + id));
    }

    public CartDetail createCartDetail(CartDetailDto dto) {

        ShoppingCart cart = shoppingCartRepository
                .findById(dto.cartId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cart not found"));

        Product product = productRepository
                .findById(dto.productId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found"));

        CartDetail cartDetail = new CartDetail();

        cartDetail.setCart(cart);
        cartDetail.setProduct(product);
        cartDetail.setQuantity(dto.quantity());
        cartDetail.setUnitPrice(dto.unitPrice());

        return cartDetailRepository.save(cartDetail);
    }

    public CartDetail updateCartDetail(
            Long id,
            CartDetailDto dto) {

        CartDetail cartDetail = getCartDetailById(id);

        ShoppingCart cart = shoppingCartRepository
                .findById(dto.cartId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cart not found"));

        Product product = productRepository
                .findById(dto.productId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found"));

        cartDetail.setCart(cart);
        cartDetail.setProduct(product);
        cartDetail.setQuantity(dto.quantity());
        cartDetail.setUnitPrice(dto.unitPrice());

        return cartDetailRepository.save(cartDetail);
    }

    public void deleteCartDetail(Long id) {

        CartDetail cartDetail = getCartDetailById(id);

        cartDetailRepository.delete(cartDetail);
    }
}
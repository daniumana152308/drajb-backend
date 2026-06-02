package com.ucr.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_cart")
    private ShoppingCart cart;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "sale_date")
    private LocalDateTime saleDate;

    @Column(name = "status", length = 20)
    private String status;
}

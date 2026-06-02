package com.ucr.store.entities;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "price", precision = 38, scale = 2, nullable = false)
    private BigDecimal price;

    // 🔗 Relación con Design
    @ManyToOne
    @JoinColumn(name = "id_design")
    private Design design;

    // 🔗 Relación con Size
    @ManyToOne
    @JoinColumn(name = "id_size")
    private Size size;
}
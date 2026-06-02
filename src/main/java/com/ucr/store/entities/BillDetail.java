package com.ucr.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;

@Entity
@Table(name = "bill_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bill_detail")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_bill")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "id_service")
    private ServiceEntity service;

    @Column(name = "price", nullable = false)
    private BigDecimal price;
}

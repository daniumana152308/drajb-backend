package com.ucr.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bill")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_sale")
    private Sales sale;

    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    @Column(name = "shipping_date")
    private LocalDate shippingDate;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;
}
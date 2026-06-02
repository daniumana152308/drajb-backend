package com.ucr.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity
@Table(name = "shopping_cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cart")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "status", length = 20)
    private String status;
}

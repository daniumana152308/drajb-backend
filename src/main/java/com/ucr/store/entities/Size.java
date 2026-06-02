package com.ucr.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Table(name = "size")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_size")
    private Long id;

    @Column(name = "label", nullable = false, length = 10)
    private String label;

    @Column(name = "description", length = 100)
    private String description;
}

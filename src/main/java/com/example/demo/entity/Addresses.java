package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "addresses")
@Data
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @Column(name = "province", nullable = false)
    private String province;

    @NotNull
    @Column(name = "district", nullable = false)
    private String district;

    @NotNull
    @Column(name = "nearest_town", nullable = false)
    private String nearestTown;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private BuddhistUsers user;
}
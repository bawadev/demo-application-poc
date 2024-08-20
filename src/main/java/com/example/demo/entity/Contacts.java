package com.example.demo.entity;

import com.example.demo.enums.UserInfoEnums.PhoneTypeEnum;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "contacts")
@Data
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "phone_type", nullable = false)
    private PhoneTypeEnum phoneType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private BuddhistUsers user;
}
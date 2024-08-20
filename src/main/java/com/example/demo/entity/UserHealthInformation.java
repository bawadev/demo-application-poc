package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.Instant;

import com.example.demo.enums.UserInfoEnums;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user_health_information")
@Data
public class UserHealthInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "health_info_id")
    private Long healthInfoId;

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "physical_attractiveness")
    private UserInfoEnums.PhysicalAttractiveness physicalAttractiveness;

    @Enumerated(EnumType.STRING)
    @Column(name = "skin_tone")
    private UserInfoEnums.SkinTone skinTone;

    @Column(name = "kids_expectancy")
    private Integer kidsExpectancy;

    @Enumerated(EnumType.STRING)
    @Column(name = "smoking")
    private UserInfoEnums.UsageFrequency smoking;

    @Enumerated(EnumType.STRING)
    @Column(name = "drug_usage")
    private UserInfoEnums.UsageFrequency drugUsage;

    @Column(name = "health_condition", columnDefinition = "TEXT")
    private String healthCondition;

    @Column(name = "disability", columnDefinition = "TEXT")
    private String disability;

    @Column(name = "mental_health")
    private String mentalHealth;

    @Column(name = "genetic_risks")
    private String geneticRisks;

    @Column(name = "your_message", columnDefinition = "TEXT")
    private String yourMessage;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private BuddhistUsers user;
}
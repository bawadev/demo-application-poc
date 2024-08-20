package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.Instant;

import com.example.demo.enums.UserInfoEnums.HighestEducationQualificationEnum;
import com.example.demo.enums.UserInfoEnums.MarriageStatus;
import com.example.demo.enums.UserInfoEnums.HouseOwnershipEnum;
import com.example.demo.enums.UserInfoEnums.VehicleOwnershipEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "user_social_information")
@Data
public class UserSocialInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "social_info_id")
    private Long socialInfoId;

    @Enumerated(EnumType.STRING)
    @Column(name = "marriage_status")
    private MarriageStatus marriageStatus;

    @Column(name = "occupation")
    private String occupation;

    @Enumerated(EnumType.STRING)
    @Column(name = "highest_education_qualification")
    private HighestEducationQualificationEnum highestEducationQualification;

    @Column(name = "job_or_profession")
    private String jobOrProfession;

    @Column(name = "monthly_income")
    private BigDecimal monthlyIncome;

    @Enumerated(EnumType.STRING)
    @Column(name = "house_ownership")
    private HouseOwnershipEnum houseOwnership;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_ownership")
    private VehicleOwnershipEnum vehicleOwnership;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private BuddhistUsers user;
}
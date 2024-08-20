package com.example.demo.repository;

import com.example.demo.entity.UserHealthInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHealthInformationRepository extends JpaRepository<UserHealthInformation, Long> {
    // You can add custom query methods here if needed
}
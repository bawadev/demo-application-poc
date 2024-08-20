package com.example.demo.service;

import com.example.demo.entity.UserHealthInformation;
import java.util.List;
import java.util.Optional;

public interface UserHealthInformationService {
    List<UserHealthInformation> getAllHealthInformation();
    Optional<UserHealthInformation> getHealthInformationById(Long id);
    UserHealthInformation saveHealthInformation(UserHealthInformation healthInfo);
    void deleteHealthInformation(Long id);
    // Add any additional method signatures as needed
}
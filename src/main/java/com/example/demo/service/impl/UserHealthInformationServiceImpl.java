package com.example.demo.service.impl;

import com.example.demo.entity.UserHealthInformation;
import com.example.demo.repository.UserHealthInformationRepository;
import com.example.demo.service.UserHealthInformationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserHealthInformationServiceImpl implements UserHealthInformationService {

    private final UserHealthInformationRepository repository;

    @Autowired
    public UserHealthInformationServiceImpl(UserHealthInformationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserHealthInformation> getAllHealthInformation() {
        return repository.findAll();
    }

    @Override
    public Optional<UserHealthInformation> getHealthInformationById(Long id) {
        return repository.findById(id);
    }

    @Override
    public UserHealthInformation saveHealthInformation(UserHealthInformation healthInfo) {
        return repository.save(healthInfo);
    }

    @Override
    public void deleteHealthInformation(Long id) {
        repository.deleteById(id);
    }

    // Implement any additional methods defined in the interface
}
package com.example.demo.service.impl;

import com.example.demo.entity.UserBuddhistPractice;
import com.example.demo.repository.UserBuddhistPracticeRepository;
import com.example.demo.service.UserBuddhistPracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.time.Instant;

@Service
public class UserBuddhistPracticeServiceImpl implements UserBuddhistPracticeService {

    private final UserBuddhistPracticeRepository userBuddhistPracticeRepository;

    @Autowired
    public UserBuddhistPracticeServiceImpl(UserBuddhistPracticeRepository userBuddhistPracticeRepository) {
        this.userBuddhistPracticeRepository = userBuddhistPracticeRepository;
    }

    @Override
    public Page<UserBuddhistPractice> getAllUserBuddhistPractices(Pageable pageable) {
        return userBuddhistPracticeRepository.findAll(pageable);
    }

    @Override
    public Optional<UserBuddhistPractice> getUserBuddhistPracticeById(Long id) {
        return userBuddhistPracticeRepository.findById(id);
    }

    @Override
    public UserBuddhistPractice saveUserBuddhistPractice(UserBuddhistPractice practice) {
        practice.setCreatedAt(Instant.now());
        return userBuddhistPracticeRepository.save(practice);
    }

    @Override
    public void deleteUserBuddhistPractice(Long id) {
        userBuddhistPracticeRepository.deleteById(id);
    }
}
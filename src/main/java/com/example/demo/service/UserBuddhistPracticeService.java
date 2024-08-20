package com.example.demo.service;

import com.example.demo.entity.UserBuddhistPractice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface UserBuddhistPracticeService {
    Page<UserBuddhistPractice> getAllUserBuddhistPractices(Pageable pageable);
    Optional<UserBuddhistPractice> getUserBuddhistPracticeById(Long id);
    UserBuddhistPractice saveUserBuddhistPractice(UserBuddhistPractice practice);
    void deleteUserBuddhistPractice(Long id);
}
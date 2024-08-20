package com.example.demo.repository;

import com.example.demo.entity.UserBuddhistPractice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBuddhistPracticeRepository extends JpaRepository<UserBuddhistPractice, Long> {
    Page<UserBuddhistPractice> findAll(Pageable pageable);
}
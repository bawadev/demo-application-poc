package com.example.demo.repository;

import com.example.demo.entity.BuddhistUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuddhistUsersRepository extends JpaRepository<BuddhistUsers, Long> {
}
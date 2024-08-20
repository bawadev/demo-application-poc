package com.example.demo.service;

import com.example.demo.entity.BuddhistUsers;
import java.util.List;
import java.util.Optional;

public interface BuddhistUsersService {
    List<BuddhistUsers> getAllBuddhistUsers();
    Optional<BuddhistUsers> getBuddhistUserById(Long id);
    BuddhistUsers saveBuddhistUser(BuddhistUsers buddhistUser);
    void deleteBuddhistUser(Long id);
}
package com.example.demo.service.impl;

import com.example.demo.entity.BuddhistUsers;
import com.example.demo.repository.BuddhistUsersRepository;
import com.example.demo.service.BuddhistUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BuddhistUsersServiceImpl implements BuddhistUsersService {

    private final BuddhistUsersRepository buddhistUsersRepository;

    @Autowired
    public BuddhistUsersServiceImpl(BuddhistUsersRepository buddhistUsersRepository) {
        this.buddhistUsersRepository = buddhistUsersRepository;
    }

    @Override
    public List<BuddhistUsers> getAllBuddhistUsers() {
        return buddhistUsersRepository.findAll();
    }

    @Override
    public Optional<BuddhistUsers> getBuddhistUserById(Long id) {
        return buddhistUsersRepository.findById(id);
    }

    @Override
    public BuddhistUsers saveBuddhistUser(BuddhistUsers buddhistUser) {
        return buddhistUsersRepository.save(buddhistUser);
    }

    @Override
    public void deleteBuddhistUser(Long id) {
        buddhistUsersRepository.deleteById(id);
    }
}
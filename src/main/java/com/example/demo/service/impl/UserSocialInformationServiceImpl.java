package com.example.demo.service.impl;

import com.example.demo.entity.UserSocialInformation;
import com.example.demo.repository.UserSocialInformationRepository;
import com.example.demo.service.UserSocialInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserSocialInformationServiceImpl implements UserSocialInformationService {

    private final UserSocialInformationRepository userSocialInformationRepository;

    @Autowired
    public UserSocialInformationServiceImpl(UserSocialInformationRepository userSocialInformationRepository) {
        this.userSocialInformationRepository = userSocialInformationRepository;
    }

    @Override
    public Page<UserSocialInformation> getAllUserSocialInformation(Pageable pageable) {
        return userSocialInformationRepository.findAll(pageable);
    }

    @Override
    public Optional<UserSocialInformation> getUserSocialInformationById(Long id) {
        return userSocialInformationRepository.findById(id);
    }

    @Override
    public UserSocialInformation saveUserSocialInformation(UserSocialInformation socialInfo) {
        return userSocialInformationRepository.save(socialInfo);
    }

    @Override
    public void deleteUserSocialInformation(Long id) {
        userSocialInformationRepository.deleteById(id);
    }
}
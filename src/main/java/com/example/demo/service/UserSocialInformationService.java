package com.example.demo.service;

import com.example.demo.entity.UserSocialInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface UserSocialInformationService {
    Page<UserSocialInformation> getAllUserSocialInformation(Pageable pageable);
    Optional<UserSocialInformation> getUserSocialInformationById(Long id);
    UserSocialInformation saveUserSocialInformation(UserSocialInformation socialInfo);
    void deleteUserSocialInformation(Long id);
}
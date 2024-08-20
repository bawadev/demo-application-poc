package com.example.demo.controller;

import com.example.demo.entity.UserSocialInformation;
import com.example.demo.service.UserSocialInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/social-information")
@CrossOrigin(origins = {"http://localhost:3000" , "https://bawadev.github.io", "https://boduviwaha.lk"})
public class UserSocialInformationController {

    private final UserSocialInformationService userSocialInformationService;

    @Autowired
    public UserSocialInformationController(UserSocialInformationService userSocialInformationService) {
        this.userSocialInformationService = userSocialInformationService;
    }

    @GetMapping
    public Page<UserSocialInformation> getAllUserSocialInformation(Pageable pageable) {
        return userSocialInformationService.getAllUserSocialInformation(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSocialInformation> getUserSocialInformationById(@PathVariable Long id) {
        return userSocialInformationService.getUserSocialInformationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserSocialInformation createUserSocialInformation(@RequestBody UserSocialInformation socialInfo) {
        return userSocialInformationService.saveUserSocialInformation(socialInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserSocialInformation> updateUserSocialInformation(@PathVariable Long id, @RequestBody UserSocialInformation socialInfo) {
        return userSocialInformationService.getUserSocialInformationById(id)
                .map(existingSocialInfo -> {
                    socialInfo.setSocialInfoId(id);
                    return ResponseEntity.ok(userSocialInformationService.saveUserSocialInformation(socialInfo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserSocialInformation(@PathVariable Long id) {
        userSocialInformationService.deleteUserSocialInformation(id);
        return ResponseEntity.noContent().build();
    }
}
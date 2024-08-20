package com.example.demo.controller;

import com.example.demo.entity.UserBuddhistPractice;
import com.example.demo.service.UserBuddhistPracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/buddhist-practices")
@CrossOrigin(origins = {"http://localhost:3000" , "https://bawadev.github.io", "https://boduviwaha.lk"})
public class UserBuddhistPracticeController {

    private final UserBuddhistPracticeService userBuddhistPracticeService;

    @Autowired
    public UserBuddhistPracticeController(UserBuddhistPracticeService userBuddhistPracticeService) {
        this.userBuddhistPracticeService = userBuddhistPracticeService;
    }

    @GetMapping
    public Page<UserBuddhistPractice> getAllUserBuddhistPractices(Pageable pageable) {
        return userBuddhistPracticeService.getAllUserBuddhistPractices(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserBuddhistPractice> getUserBuddhistPracticeById(@PathVariable Long id) {
        return userBuddhistPracticeService.getUserBuddhistPracticeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserBuddhistPractice createUserBuddhistPractice(@RequestBody UserBuddhistPractice practice) {
        return userBuddhistPracticeService.saveUserBuddhistPractice(practice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserBuddhistPractice> updateUserBuddhistPractice(@PathVariable Long id, @RequestBody UserBuddhistPractice practice) {
        return userBuddhistPracticeService.getUserBuddhistPracticeById(id)
                .map(existingPractice -> {
                    practice.setPracticeId(id);
                    return ResponseEntity.ok(userBuddhistPracticeService.saveUserBuddhistPractice(practice));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserBuddhistPractice(@PathVariable Long id) {
        userBuddhistPracticeService.deleteUserBuddhistPractice(id);
        return ResponseEntity.noContent().build();
    }
}
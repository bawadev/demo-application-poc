package com.example.demo.controller;

import com.example.demo.entity.BuddhistUsers;
import com.example.demo.service.BuddhistUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buddhist-users")
@CrossOrigin(origins = {"http://localhost:3000" , "https://bawadev.github.io", "https://boduviwaha.lk"})
public class BuddhistUsersController {

    private final BuddhistUsersService buddhistUsersService;

    @Autowired
    public BuddhistUsersController(BuddhistUsersService buddhistUsersService) {
        this.buddhistUsersService = buddhistUsersService;
    }

    @GetMapping
    public List<BuddhistUsers> getAllBuddhistUsers() {
        return buddhistUsersService.getAllBuddhistUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuddhistUsers> getBuddhistUserById(@PathVariable Long id) {
        return buddhistUsersService.getBuddhistUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BuddhistUsers createBuddhistUser(@RequestBody BuddhistUsers buddhistUser) {
        return buddhistUsersService.saveBuddhistUser(buddhistUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BuddhistUsers> updateBuddhistUser(@PathVariable Long id, @RequestBody BuddhistUsers buddhistUser) {
        return buddhistUsersService.getBuddhistUserById(id)
                .map(existingUser -> {
                    buddhistUser.setUserId(id);
                    return ResponseEntity.ok(buddhistUsersService.saveBuddhistUser(buddhistUser));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuddhistUser(@PathVariable Long id) {
        buddhistUsersService.deleteBuddhistUser(id);
        return ResponseEntity.noContent().build();
    }
}
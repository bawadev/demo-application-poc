package com.example.demo.controller;

import com.example.demo.entity.UserHealthInformation;
import com.example.demo.service.UserHealthInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/health-information")
@CrossOrigin(origins = {"http://localhost:3000" , "https://bawadev.github.io", "https://boduviwaha.lk"})
public class UserHealthInformationController {

    private final UserHealthInformationService service;

    @Autowired
    public UserHealthInformationController(UserHealthInformationService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserHealthInformation> getAllHealthInformation() {
        return service.getAllHealthInformation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserHealthInformation> getHealthInformationById(@PathVariable Long id) {
        return service.getHealthInformationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserHealthInformation createHealthInformation(@RequestBody UserHealthInformation healthInfo) {
        return service.saveHealthInformation(healthInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserHealthInformation> updateHealthInformation(@PathVariable Long id, @RequestBody UserHealthInformation healthInfo) {
        return service.getHealthInformationById(id)
                .map(existingInfo -> {
                    healthInfo.setHealthInfoId(id);
                    return ResponseEntity.ok(service.saveHealthInformation(healthInfo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHealthInformation(@PathVariable Long id) {
        return service.getHealthInformationById(id)
                .map(existingInfo -> {
                    service.deleteHealthInformation(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
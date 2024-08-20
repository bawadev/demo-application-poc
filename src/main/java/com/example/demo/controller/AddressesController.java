package com.example.demo.controller;

import com.example.demo.entity.Addresses;
import com.example.demo.service.AddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@CrossOrigin(origins = {"http://localhost:3000" , "https://bawadev.github.io", "https://boduviwaha.lk"})
public class AddressesController {

    private final AddressesService addressesService;

    @Autowired
    public AddressesController(AddressesService addressesService) {
        this.addressesService = addressesService;
    }

    @GetMapping
    public List<Addresses> getAllAddresses() {
        return addressesService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Addresses> getAddressById(@PathVariable Long id) {
        return addressesService.getAddressById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Addresses createAddress(@RequestBody Addresses address) {
        return addressesService.saveAddress(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Addresses> updateAddress(@PathVariable Long id, @RequestBody Addresses address) {
        return addressesService.getAddressById(id)
                .map(existingAddress -> {
                    address.setAddressId(id);
                    return ResponseEntity.ok(addressesService.saveAddress(address));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressesService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
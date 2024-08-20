package com.example.demo.service;

import com.example.demo.entity.Addresses;
import java.util.List;
import java.util.Optional;

public interface AddressesService {
    List<Addresses> getAllAddresses();
    Optional<Addresses> getAddressById(Long id);
    Addresses saveAddress(Addresses address);
    void deleteAddress(Long id);
}
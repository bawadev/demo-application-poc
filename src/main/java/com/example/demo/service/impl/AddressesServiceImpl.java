package com.example.demo.service.impl;

import com.example.demo.entity.Addresses;
import com.example.demo.repository.AddressesRepository;
import com.example.demo.service.AddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressesServiceImpl implements AddressesService {

    private final AddressesRepository addressesRepository;

    @Autowired
    public AddressesServiceImpl(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    @Override
    public List<Addresses> getAllAddresses() {
        return addressesRepository.findAll();
    }

    @Override
    public Optional<Addresses> getAddressById(Long id) {
        return addressesRepository.findById(id);
    }

    @Override
    public Addresses saveAddress(Addresses address) {
        return addressesRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressesRepository.deleteById(id);
    }
}
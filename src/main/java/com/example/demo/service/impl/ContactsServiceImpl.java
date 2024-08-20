package com.example.demo.service.impl;

import com.example.demo.entity.Contacts;
import com.example.demo.repository.ContactsRepository;
import com.example.demo.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactsServiceImpl implements ContactsService {

    private final ContactsRepository contactsRepository;

    @Autowired
    public ContactsServiceImpl(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @Override
    public List<Contacts> getAllContacts() {
        return contactsRepository.findAll();
    }

    @Override
    public Optional<Contacts> getContactById(Long id) {
        return contactsRepository.findById(id);
    }

    @Override
    public Contacts saveContact(Contacts contact) {
        return contactsRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactsRepository.deleteById(id);
    }
}
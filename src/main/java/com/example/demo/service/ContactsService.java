package com.example.demo.service;

import com.example.demo.entity.Contacts;
import java.util.List;
import java.util.Optional;

public interface ContactsService {
    List<Contacts> getAllContacts();
    Optional<Contacts> getContactById(Long id);
    Contacts saveContact(Contacts contact);
    void deleteContact(Long id);
}
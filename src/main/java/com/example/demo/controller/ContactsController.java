package com.example.demo.controller;

import com.example.demo.entity.Contacts;
import com.example.demo.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = {"http://localhost:3000" , "https://bawadev.github.io", "https://boduviwaha.lk"})
public class ContactsController {

    private final ContactsService contactsService;

    @Autowired
    public ContactsController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @GetMapping
    public List<Contacts> getAllContacts() {
        return contactsService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contacts> getContactById(@PathVariable Long id) {
        return contactsService.getContactById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contacts createContact(@RequestBody Contacts contact) {
        return contactsService.saveContact(contact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contacts> updateContact(@PathVariable Long id, @RequestBody Contacts contact) {
        return contactsService.getContactById(id)
                .map(existingContact -> {
                    contact.setContactId(id);
                    return ResponseEntity.ok(contactsService.saveContact(contact));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactsService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}
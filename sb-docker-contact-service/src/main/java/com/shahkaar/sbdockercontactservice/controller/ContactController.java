package com.shahkaar.sbdockercontactservice.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shahkaar.sbdockercontactservice.entity.Contact;
import com.shahkaar.sbdockercontactservice.repository.ContactRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ContactController {

	private ContactRepository contactRepository;

    @GetMapping("/contacts")
    public ResponseEntity<Iterable<Contact>> getContacts(){
        return ResponseEntity.ok(contactRepository.findAll());
    }

    @GetMapping("/contacts/contains/{name}")
    public ResponseEntity<Iterable<Contact>> getContactsByNameContains(@PathVariable String name){
        return ResponseEntity.ok(contactRepository.findByNameContainsIgnoreCase(name));
    }

    @GetMapping("/contacts/{email}")
    public ResponseEntity<Contact> getContact(@PathVariable String email){
        return ResponseEntity.ok(contactRepository.findById(email).orElseThrow(() -> new RuntimeException("Contact not found!")));
    }

    @PostMapping("/contacts")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact){
        URI location = URI.create(String.format("/contacts/%s", contact.getEmail()));
        return ResponseEntity.created(location).body(contactRepository.save(contact));
    }

    @DeleteMapping("/contacts/{email}")
    @ResponseStatus(HttpStatus.OK)
    public void removeContact(@PathVariable String email){
        contactRepository.deleteById(email);
    }
    
}
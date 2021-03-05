package com.example.contactsadmin.controller;

import com.example.contactsadmin.service.ContactService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.contact.dto.ContactDto;
import org.example.contact.dto.NewContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class ContactController {
    private NewContactDto newContactDto;
    private ContactService contactService;

    // TODO add http client service and autowire
    @Autowired
    ContactController(NewContactDto newContactDto, ContactService contactService) {
        this.newContactDto = newContactDto;
        this.contactService = contactService;
    }

    @GetMapping("/v1/contact/{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable Long id) {
        ContactDto contactDto = contactService.getContactById(id);

        System.out.println("Found contact!");
        System.out.println();
        return ResponseEntity.ok().body(contactDto);
    }

    @PostMapping("/v1/contact")
    public ResponseEntity<ContactDto> postContact(@RequestBody NewContactDto newContactDto) throws JsonProcessingException {
        System.out.println("Got a new contact!");
        System.out.println(newContactDto);

        ContactDto createdContactDto = contactService.postContact(newContactDto);

        URI uri = URI.create("/contact/" + createdContactDto.getContactId());
        return ResponseEntity.created(uri).body(createdContactDto);
    }
}

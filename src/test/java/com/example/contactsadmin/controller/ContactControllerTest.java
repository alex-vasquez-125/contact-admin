package com.example.contactsadmin.controller;

import com.example.contactsadmin.fixtures.TestObjects;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.contact.dto.ContactDto;
import org.example.contact.dto.NewContactDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ContactControllerTest {
    @Autowired
    ContactController contactController;

    @Test
    void post_newContact_should_return_contact() throws JsonProcessingException {
        ResponseEntity<ContactDto> responseEntity =
                contactController.postContact(new NewContactDto("Alex", "Vasquez", "Software Engineer", "123-456-7890","email@email.com"));

        assertEquals(201, responseEntity.getStatusCodeValue());
        assertEquals("/contact/1", responseEntity.getHeaders().getLocation().toString());
        assertEquals(TestObjects.EXPECTED_CONTACT_DTO_ALEX, responseEntity.getBody());
    }
}

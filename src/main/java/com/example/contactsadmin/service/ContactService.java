package com.example.contactsadmin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.contact.dto.ContactDto;
import org.example.contact.dto.NewContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ContactService {
    private RestTemplate restTemplate;
    // todo make autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    ContactService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // todo handle exception
    // todo extract string to constant
    public ContactDto postContact(NewContactDto newContactDto) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<String>(objectMapper.writeValueAsString(newContactDto), headers);
        ResponseEntity<ContactDto> responseEntity = restTemplate.postForEntity("http://localhost:8080/v1/contact", request, ContactDto.class);

        return responseEntity.getBody();
    }

    public ContactDto getContactById(Long id) {
        ResponseEntity<ContactDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/v1/contact/" + id, ContactDto.class);

        return responseEntity.getBody();
    }
}

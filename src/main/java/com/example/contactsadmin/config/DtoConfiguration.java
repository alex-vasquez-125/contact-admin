package com.example.contactsadmin.config;

import org.example.contact.dto.ContactDto;
import org.example.contact.dto.NewContactDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoConfiguration {
    @Bean
    public ContactDto contactDto() {
        return new ContactDto();
    }

    @Bean
    public NewContactDto newContactDto() {
        return new NewContactDto();
    }
}
// TODO: make sure these are not singleton, are thread safe, etc
package com.shahkaar.sbdockercontactui.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.shahkaar.sbdockercontactui.properties.ContactsProperties;

import lombok.extern.slf4j.Slf4j;

@EnableConfigurationProperties({ContactsProperties.class})
@Configuration
@Slf4j
public class ContactsConfiguration {

    @Bean
    public RestTemplate restTemplate(ContactsProperties contactsProperties){
    	log.info("Creating RestTemplate : " + contactsProperties.toString());
        return new RestTemplateBuilder().basicAuthentication(contactsProperties.getUsername(), contactsProperties.getPassword()).build();
    }
}
package com.shahkaar.sbdockercontactservice.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shahkaar.sbdockercontactservice.entity.Contact;
import com.shahkaar.sbdockercontactservice.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ContactConfig {
	
    @Bean
    public CommandLineRunner init(ContactRepository contactRepository){
    	
    	log.info("ContactConfig.init. Inserting data.");
        return args -> {
            contactRepository.save(new Contact("admin","Administrator","1-800-CONTACTS","admin","ADMIN,ACTUATOR",true));
            
            contactRepository.save(new Contact("sam@email.com","Sam","1-800-CONTACTS","sam","USER,ACTUATOR",true));
            contactRepository.save(new Contact("dan@email.com","Dan","1-800-CONTACTS","dan","USER,ACTUATOR",true));
            contactRepository.save(new Contact("ron@email.com","Ron","1-800-CONTACTS","admin","VIEWER,ACTUATOR",true));
        };
    }
}
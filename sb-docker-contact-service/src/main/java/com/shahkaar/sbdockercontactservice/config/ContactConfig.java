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
            
            contactRepository.save(new Contact("rr@email.com","Road Runner","1-800-CONTACTS","rr","USER,ACTUATOR",true));
            contactRepository.save(new Contact("scooby@email.com","Scooby Doo","1-800-CONTACTS","scooby","USER,ACTUATOR",true));
            contactRepository.save(new Contact("bbunny@email.com","Bugs Bunny","1-800-CONTACTS","bbunny","VIEWER,ACTUATOR",true));
        };
    }
}

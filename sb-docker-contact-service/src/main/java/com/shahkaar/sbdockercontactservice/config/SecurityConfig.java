package com.shahkaar.sbdockercontactservice.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shahkaar.sbdockercontactservice.entity.Contact;
import com.shahkaar.sbdockercontactservice.repository.ContactRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private ContactRepository contactRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	log.info("Inside SecurityConfig.configure");
        auth.userDetailsService( email -> {

        	log.info("Call to auth.userDetailsService : " + email);
            Contact contact = this.contactRepository.findById(email).orElseThrow(() -> new RuntimeException("Contact not found!"));

            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            String password = encoder.encode(contact.getPassword());

            return User
                    .withUsername(email)
                    .password(password)
                    .accountLocked(!contact.isActive())
                    .roles(contact.getRoles().split(","))
                    .build();
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
            .antMatchers("/actuator/health/**","/actuator/info","/").permitAll()
            .anyRequest().fullyAuthenticated()
            .and()
                .httpBasic()
            .and()
                .formLogin();

    }

}
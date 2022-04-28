package com.shahkaar.sbdockercontactservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.shahkaar.sbdockercontactservice.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact,String> {

    Iterable<Contact> findByNameContainsIgnoreCase(String name);

}
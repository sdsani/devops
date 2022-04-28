package com.shahkaar.sbdockercontactui.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper=true, includeFieldNames=true)
@ConfigurationProperties(prefix = "contacts")
public class ContactsProperties {
    private String server = "http://localhost:8080/contacts";
    private String username = "xxxx";
    private String password = "yyyy";
}
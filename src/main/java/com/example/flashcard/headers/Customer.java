package com.example.flashcard.headers;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Customer {

    private @GeneratedValue
    @Id Long id;
    private @Version Long version;
    private @JsonIgnore
    @LastModifiedDate LocalDateTime lastModifiedDate;

    private final String firstname, lastname;
    private final String gender;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) //
    private final Address address;

    public Customer(String firstname, String lastname, String gender, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.gender = gender;
    }

}

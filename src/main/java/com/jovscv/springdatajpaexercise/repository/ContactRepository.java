package com.jovscv.springdatajpaexercise.repository;

import com.jovscv.springdatajpaexercise.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}

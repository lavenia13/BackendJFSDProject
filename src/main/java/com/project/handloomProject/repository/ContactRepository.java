package com.project.handloomProject.repository;

import com.project.handloomProject.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, String> {
}

package com.project.handloomProject.service;

import com.project.handloomProject.model.Contact;
import com.project.handloomProject.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void saveContact(Contact contact) {
        contactRepository.save(contact);  // Saves the contact to the database
    }
}

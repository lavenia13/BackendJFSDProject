package com.project.handloomProject.controller;

import com.project.handloomProject.model.Contact;
import com.project.handloomProject.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/submit")
    public String submitContact(@RequestBody Contact contact) {
        contactService.saveContact(contact);
        return "Contact details submitted successfully!";
    }
}

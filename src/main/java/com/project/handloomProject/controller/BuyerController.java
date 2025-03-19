package com.project.handloomProject.controller;

import com.project.handloomProject.model.BuyerSignup;
import com.project.handloomProject.service.BuyerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/buyer")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @PostMapping("/login")
    public String loginBuyer(@RequestBody BuyerSignup buyer) {
        BuyerSignup existingBuyer = buyerService.getBuyerByEmail(buyer.getEmail());
        
        if (existingBuyer == null) {
            return "User not found";
        }
        
        if (!existingBuyer.getPassword().equals(buyer.getPassword())) {
            return "Invalid credentials";
        }
        
        return "Login successful";
    }

    @PostMapping("/register")
    public String registerBuyer(@Validated @RequestBody BuyerSignup buyer) {
        BuyerSignup existingBuyer = buyerService.getBuyerByEmail(buyer.getEmail());
        
        if (existingBuyer != null) {
            return "User already exists";
        }
        
        buyerService.saveBuyer(buyer);
        return "Signup successful";
    }

    @GetMapping("/all")
    public List<BuyerSignup> getAllBuyers() {
        return buyerService.getAllBuyers();
    }

    // Method to update a buyer's details
    @PutMapping("/update/{id}")
    public String updateBuyer(@PathVariable Long id, @RequestBody BuyerSignup buyer) {
        BuyerSignup existingBuyer = buyerService.getBuyerById(id);
        
        if (existingBuyer == null) {
            return "Buyer not found";
        }
        
        existingBuyer.setName(buyer.getName());
        existingBuyer.setEmail(buyer.getEmail());
        existingBuyer.setPhone(buyer.getPhone());
        existingBuyer.setAddress(buyer.getAddress());
        existingBuyer.setPassword(buyer.getPassword());
        
        buyerService.saveBuyer(existingBuyer);
        
        return "Buyer updated successfully";
    }

    // Method to delete a buyer
    @DeleteMapping("/delete/{id}")
    public String deleteBuyer(@PathVariable Long id) {
        BuyerSignup existingBuyer = buyerService.getBuyerById(id);
        
        if (existingBuyer == null) {
            return "Buyer not found";
        }
        
        buyerService.deleteBuyer(id);
        
        return "Buyer deleted successfully";
    }
}

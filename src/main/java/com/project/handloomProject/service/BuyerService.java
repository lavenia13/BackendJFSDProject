package com.project.handloomProject.service;

import com.project.handloomProject.model.BuyerSignup;
import com.project.handloomProject.repository.BuyerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    public BuyerSignup getBuyerByEmail(String email) {
        return buyerRepository.findByEmail(email);
    }

    public void saveBuyer(BuyerSignup buyer) {
        buyerRepository.save(buyer);
    }

    public boolean doesEmailExist(String email) {
        return buyerRepository.findByEmail(email) != null;
    }

    public List<BuyerSignup> getAllBuyers() {
        return buyerRepository.findAll();
    }

    // Get a buyer by their ID
    public BuyerSignup getBuyerById(Long id) {
        return buyerRepository.findById(id).orElse(null);
    }

    // Delete a buyer by ID
    public void deleteBuyer(Long id) {
        buyerRepository.deleteById(id);
    }
}

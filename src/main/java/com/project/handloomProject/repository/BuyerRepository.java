package com.project.handloomProject.repository;

import com.project.handloomProject.model.BuyerSignup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<BuyerSignup, Long> {
    BuyerSignup findByEmail(String email);
}

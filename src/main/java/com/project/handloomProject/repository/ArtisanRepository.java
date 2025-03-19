package com.project.handloomProject.repository;

import com.project.handloomProject.model.ArtisanSignup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtisanRepository extends JpaRepository<ArtisanSignup, Long> {
    ArtisanSignup findByEmail(String email);
}

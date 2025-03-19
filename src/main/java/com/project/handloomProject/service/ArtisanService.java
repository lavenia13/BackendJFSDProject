package com.project.handloomProject.service;

import com.project.handloomProject.model.ArtisanSignup;
import com.project.handloomProject.repository.ArtisanRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtisanService {

    @Autowired
    private ArtisanRepository artisanRepository;

    public ArtisanSignup getArtisanByEmail(String email) {
        return artisanRepository.findByEmail(email);
    }

    public void saveArtisan(ArtisanSignup artisan) {
        artisanRepository.save(artisan);
    }

    public boolean doesEmailExist(String email) {
        return artisanRepository.findByEmail(email) != null;
    }

    public List<ArtisanSignup> getAllArtisans() {
        return artisanRepository.findAll();
    }

    // Fetch Artisan by ID
    public Optional<ArtisanSignup> getArtisanById(Long id) {
        return artisanRepository.findById(id);
    }

    // Delete Artisan by ID
    public void deleteArtisan(Long id) {
        artisanRepository.deleteById(id);
    }
}

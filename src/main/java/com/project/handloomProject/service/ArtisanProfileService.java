package com.project.handloomProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.handloomProject.model.ArtisanProfile;
import com.project.handloomProject.repository.ArtisanProfileRepository;

@Service
public class ArtisanProfileService {

    @Autowired
    private ArtisanProfileRepository artisanRepository;

    public ArtisanProfile getArtisan() {
        return artisanRepository.findById(1L).orElse(new ArtisanProfile());
    }

    public ArtisanProfile saveArtisan(ArtisanProfile artisan) {
        return artisanRepository.save(artisan);
    }
}

package com.project.handloomProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.handloomProject.model.ArtisanProfile;
import com.project.handloomProject.service.ArtisanProfileService;

@RestController
@RequestMapping("/api/artisan-profile")
public class ArtisanProfileController {

    @Autowired
    private ArtisanProfileService artisanService;

    @GetMapping
    public ArtisanProfile getArtisan() {
        return artisanService.getArtisan();
    }

    @PostMapping
    public ArtisanProfile createArtisan(@RequestBody ArtisanProfile artisan) {
        return artisanService.saveArtisan(artisan);
    }

}

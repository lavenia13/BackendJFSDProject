package com.project.handloomProject.controller;

import com.project.handloomProject.model.ArtisanSignup;
import com.project.handloomProject.service.ArtisanService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/artisan")
public class ArtisanController {

    @Autowired
    private ArtisanService artisanService;

    @PostMapping("/login")
    public String loginArtisan(@RequestBody ArtisanSignup artisan) {
        ArtisanSignup existingArtisan = artisanService.getArtisanByEmail(artisan.getEmail());

        if (existingArtisan == null) {
            return "User not found";
        }

        if (!existingArtisan.getPassword().equals(artisan.getPassword())) {
            return "Invalid credentials";
        }

        return "Login successful";
    }

    @PostMapping("/register")
    public String registerArtisan(@Validated @RequestBody ArtisanSignup artisan) {
        ArtisanSignup existingArtisan = artisanService.getArtisanByEmail(artisan.getEmail());

        if (existingArtisan != null) {
            return "User already exists";
        }

        artisanService.saveArtisan(artisan);
        return "Signup successful";
    }

    @GetMapping("/all")
    public List<ArtisanSignup> getAllArtisans() {
        return artisanService.getAllArtisans();
    }

    // Update Artisan
    @PutMapping("/update/{id}")
    public String updateArtisan(@PathVariable Long id, @RequestBody ArtisanSignup updatedArtisan) {
        Optional<ArtisanSignup> existingArtisan = artisanService.getArtisanById(id);

        if (existingArtisan.isPresent()) {
            ArtisanSignup artisan = existingArtisan.get();
            artisan.setName(updatedArtisan.getName());
            artisan.setEmail(updatedArtisan.getEmail());
            artisan.setPhone(updatedArtisan.getPhone());
            artisan.setPassword(updatedArtisan.getPassword());
            artisanService.saveArtisan(artisan);
            return "Artisan updated successfully";
        } else {
            return "Artisan not found";
        }
    }

    // Delete Artisan
    @DeleteMapping("/delete/{id}")
    public String deleteArtisan(@PathVariable Long id) {
        Optional<ArtisanSignup> existingArtisan = artisanService.getArtisanById(id);

        if (existingArtisan.isPresent()) {
            artisanService.deleteArtisan(id);
            return "Artisan deleted successfully";
        } else {
            return "Artisan not found";
        }
    }
}

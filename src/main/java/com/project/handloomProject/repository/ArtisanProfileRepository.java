package com.project.handloomProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.handloomProject.model.ArtisanProfile;

@Repository
public interface ArtisanProfileRepository extends JpaRepository<ArtisanProfile, Long> {
}

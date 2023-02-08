package com.example.hiringMaster.controllers;

import com.example.hiringMaster.models.Profile;
import com.example.hiringMaster.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("")
    public ResponseEntity<List<Profile>> getProfiles(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(profileService.getProfiles());
    }
}

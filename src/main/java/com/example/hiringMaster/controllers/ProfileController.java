package com.example.hiringMaster.controllers;

import com.example.hiringMaster.models.Profile;
import com.example.hiringMaster.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
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
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Profile>> getProfiles(@PathVariable("id") long profileId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(profileService.getProfileById(profileId));
    }


}

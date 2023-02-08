package com.example.hiringMaster.services;

import com.example.hiringMaster.models.Activity;
import com.example.hiringMaster.models.Profile;
import com.example.hiringMaster.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> getProfiles(/*criterias*/){
        return profileRepository.findAll();
    }
}

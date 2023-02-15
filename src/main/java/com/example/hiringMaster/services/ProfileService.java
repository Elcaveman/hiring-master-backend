package com.example.hiringMaster.services;

import com.example.hiringMaster.models.Profile;
import com.example.hiringMaster.repositories.ActivityRepository;
import com.example.hiringMaster.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository, ActivityRepository activityRepository) {
        this.profileRepository = profileRepository;
        this.activityRepository = activityRepository;
    }

    public List<Profile> getProfiles(){
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfileById(Long profileId) { return profileRepository.findById(profileId); }
    public List<Profile> getProfileAllById(List<Long> profileIds ) {
        return profileRepository.findAllById(profileIds);
    }

    public List<Profile> getOtherParticipantsByActivityId(Long activityId){
        List<Profile> otherParticipants = this.profileRepository.findParticipantsNotInActivityId(activityId);
        return otherParticipants;
    }
}

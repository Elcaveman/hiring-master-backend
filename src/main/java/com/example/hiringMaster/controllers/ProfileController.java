package com.example.hiringMaster.controllers;

import com.example.hiringMaster.models.Profile;
import com.example.hiringMaster.services.ActivityService;
import com.example.hiringMaster.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {
    private final ProfileService profileService;
    private final ActivityService activityService;

    @Autowired
    public ProfileController(ProfileService profileService, ActivityService activityService) {
        this.profileService = profileService;
        this.activityService = activityService;
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

    @GetMapping("/participants")
    public ResponseEntity<List<Profile>> getParticipants(
            @RequestParam(required = true) Long activityId,
            @RequestParam(required = false, defaultValue="false") Boolean other
            ){
       if (other){
           var profiles = this.profileService.getOtherParticipantsByActivityId(activityId);
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body(profiles);
       }
       else{
           var activity = this.activityService.getActivitiyById(activityId);
           if (activity.isPresent()) {
               return ResponseEntity
                       .status(HttpStatus.OK)
                       .body(activity.get().getParticipants());
           }
       }
       return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ArrayList<>());

    }

}

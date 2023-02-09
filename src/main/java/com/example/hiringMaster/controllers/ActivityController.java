package com.example.hiringMaster.controllers;

import com.example.hiringMaster.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hiringMaster.services.ActivityService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/activities")
public class ActivityController {
    private final ActivityService activityService;
    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("")
    public ResponseEntity<List<Activity>> getActivities(){
        return ResponseEntity.status(HttpStatus.OK).body(activityService.getActivities());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Activity>> getActivity(@PathVariable("id") long activityId){
        return ResponseEntity.status(HttpStatus.OK).body(activityService.getActivitiyById(activityId));
    }
    @PostMapping("")
    public ResponseEntity<Activity> addActivity(Activity activity){
        return ResponseEntity.status(HttpStatus.OK).body(activityService.addActivity(activity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable("id") long activityId){
        try{
            activityService.deleteActivity(activityId);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }
}

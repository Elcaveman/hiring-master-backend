package com.example.hiringMaster.services;

import com.example.hiringMaster.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hiringMaster.repositories.ActivityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getActivities(/*criterias*/){
        return activityRepository.findAll();
    }
    public Optional<Activity> getActivitiyById(Long activityId/*criterias*/){
        return activityRepository.findById(activityId);
    }

    public Activity addActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public void deleteActivity(Long activityId){
        activityRepository.deleteById(activityId);
    }
}

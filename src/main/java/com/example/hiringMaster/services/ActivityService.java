package com.example.hiringMaster.services;

import com.example.hiringMaster.dto.activity.ActivityDto;
import com.example.hiringMaster.models.Activity;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hiringMaster.repositories.ActivityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final ModelMapper mapper = new ModelMapper();
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

    public void updateActivity(ActivityDto activityDto) {
        this.mapper.getConfiguration().setSkipNullEnabled(true);
        this.mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE );
        Optional<Activity> originalActivity = activityRepository.findById(activityDto.getId());
        if ( originalActivity.isPresent()){
            Activity a = originalActivity.get();
            Activity copyActivity = a.toBuilder().build();//copy object using a builder
            this.mapper.map(activityDto,copyActivity);//change id
            System.out.println(copyActivity.getId());
            //activityRepository.save(a);
        }
    }
}

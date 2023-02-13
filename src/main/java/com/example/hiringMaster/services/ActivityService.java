package com.example.hiringMaster.services;

import com.example.hiringMaster.mapper.CustomModelMapper;
import com.example.hiringMaster.converters.ProfileIdDtoToProfileConverter;
import com.example.hiringMaster.dto.activity.ActivityDto;
import com.example.hiringMaster.dto.profile.ProfileIdDto;
import com.example.hiringMaster.models.Activity;
import com.example.hiringMaster.models.Profile;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hiringMaster.repositories.ActivityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final ProfileService profileService;
    private final ModelMapper mapper = CustomModelMapper.modelMapper();
    private TypeMap<ActivityDto,Activity> dto2ActivityTypeMap;
    private TypeMap<ProfileIdDto,Profile> dto2ProfileTypeMap;
//    private final ProfileIdDtoToProfileConverter profileDtoToProfileConverter;
//    private final ProfileIdDtoListToProfileConverter profileIdDtoListToProfileConverter;

    @Autowired
    public ActivityService(ActivityRepository activityRepository, ProfileService profileService) {
        this.profileService = profileService;
        this.activityRepository = activityRepository;
//        this.dto2ActivityTypeMap =  this.mapper.createTypeMap(ActivityDto.class, Activity.class);
//        this.dto2ProfileTypeMap =  this.mapper.createTypeMap(ProfileIdDto.class, Profile.class);
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
        // add deep mapping to flatten source's Player object into a single field in destination
//        dto2ActivityTypeMap.addMappings(
//                mapper -> mapper.using(this.profileDtoToProfileConverter)
//                        .map(ActivityDto::getCandidate, Activity::setCandidate)
//        );
        Optional<Activity> originalActivity = activityRepository.findById(activityDto.getId());
        if ( originalActivity.isPresent()){
            Activity a = originalActivity.get();
            Activity copyActivity = a.toBuilder().build();//copy object using a builder
            this.mapper.map(activityDto,copyActivity);//change id
            // TODO: set composite fields (Entities) automatically
            List<Profile> participants = new ArrayList<>();
            Profile candidate = null;
            if(activityDto.getCandidate()!=null)
                candidate = this.profileService.getProfileById(activityDto.getCandidate().getId()).orElse(null);

            if (activityDto.getParticipants()!=null)
                participants = this.profileService.getProfileAllById(activityDto.getParticipants()
                        .stream().map(participant->participant.getId())
                        .collect(Collectors.toList())
                );
            copyActivity.setCandidate(candidate);
            copyActivity.setParticipants(participants);
            activityRepository.save(copyActivity);
        }
    }
}

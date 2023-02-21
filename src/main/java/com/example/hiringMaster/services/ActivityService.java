package com.example.hiringMaster.services;

import com.example.hiringMaster.mapper.CustomModelMapper;
import com.example.hiringMaster.dto.activity.ActivityDto;
import com.example.hiringMaster.dto.profile.ProfileIdDto;
import com.example.hiringMaster.models.Activity;
import com.example.hiringMaster.models.Job;
import com.example.hiringMaster.models.Profile;
import com.example.hiringMaster.repositories.JobRepository;
import com.example.hiringMaster.repositories.ProfileRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hiringMaster.repositories.ActivityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final ProfileRepository profileRepository;
    private final ModelMapper mapper = CustomModelMapper.modelMapper();
    private TypeMap<ActivityDto,Activity> dto2ActivityTypeMap;
    private TypeMap<ProfileIdDto,Profile> dto2ProfileTypeMap;
    private JobRepository jobRepository;
//    private final ProfileIdDtoToProfileConverter profileDtoToProfileConverter;
//    private final ProfileIdDtoListToProfileConverter profileIdDtoListToProfileConverter;

    @Autowired
    public ActivityService(ActivityRepository activityRepository, ProfileRepository profileRepository, JobRepository jobRepository) {
        this.profileRepository = profileRepository;
        this.activityRepository = activityRepository;
        this.jobRepository = jobRepository;
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
        // TODO: check the source of data ( is it the DTO default values or did the user actually set then to null )
        Optional<Activity> originalActivity = activityRepository.findById(activityDto.getId());
        if ( originalActivity.isPresent()){
            Activity a = originalActivity.get();
            Activity copyActivity = a.toBuilder().build();//copy object using a builder
            this.mapper.map(activityDto,copyActivity);//change id
            // TODO: set composite fields (Entities) automatically
            List<Profile> participants = new ArrayList<>();
            Profile candidate = null;
            Job job = null;
            if(activityDto.getCandidate()!=null){
                candidate = this.profileRepository.findById(activityDto.getCandidate().getId()).orElse(null);
                copyActivity.setCandidate(candidate);
            }
            if (activityDto.getParticipants()!=null && activityDto.getParticipants().size()>0){
                participants = this.profileRepository.findAllById(activityDto.getParticipants()
                        .stream().map(participant->participant.getId())
                        .collect(Collectors.toList())
                );
                copyActivity.setParticipants(participants);
            }
            if (activityDto.getJob()!=null){
                job = this.jobRepository.findById(activityDto.getJob().getId()).orElse(null);
                copyActivity.setJob(job);
            }
            activityRepository.save(copyActivity);
        }
    }

    public List<Activity> finishActivities(List<ActivityDto> activityDtoList) {
        List<Long> activityIdList = activityDtoList.stream()
                .map(activityDto -> activityDto.getId())
                .collect(Collectors.toList());
        List<Activity> activityList = this.activityRepository.findAllById(activityIdList);
        List<Activity> updatedActivityList = IntStream
                .range(0, activityList.size())
                .filter((i)-> {
                    if (activityList.get(i) == null) return false;
                    else {
                        activityList.get(i).setFinished(activityDtoList.get(i).getFinished());
                        return true;
                    }})
                .mapToObj(i -> activityList.get(i))
                .collect(Collectors.toList());
        return this.activityRepository.saveAll(updatedActivityList);

    }
}

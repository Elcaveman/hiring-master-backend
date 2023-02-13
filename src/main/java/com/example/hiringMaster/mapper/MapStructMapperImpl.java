package com.example.hiringMaster.mapper;

import com.example.hiringMaster.dto.activity.ActivityDto;
import com.example.hiringMaster.dto.activity.ActivityFinishedDto;
import com.example.hiringMaster.dto.profile.ProfileIdDto;
import com.example.hiringMaster.models.Activity;
import com.example.hiringMaster.models.Profile;
import com.example.hiringMaster.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;
import java.util.Optional;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class MapStructMapperImpl implements MapStructMapper{
    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public ActivityDto activityToActivityDto(Activity activity){
        if ( activity == null ) {
            return null;
        }
        return ActivityDto.builder().build();
    }
    @Override
    public ProfileIdDto profileToProfileIdDto(Profile profile){
        if ( profile == null ) {
            return null;
        }
        return ProfileIdDto.builder()
                .id(profile.getId())
                .build();
    }

    @Override
    public Optional<Profile> profileIdDtoToProfile(ProfileIdDto profileIdDto) {
        return profileRepository.findById(profileIdDto.getId());
    }

    @Override
    public ActivityFinishedDto activityToActivityFinishedDto(Activity activity){
        if ( activity == null ) {
            return null;
        }
        return ActivityFinishedDto.builder()
                .id(activity.getId())
                .finished(activity.isFinished())
                .build();
    }
}

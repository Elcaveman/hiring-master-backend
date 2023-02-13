package com.example.hiringMaster.mapper;

import com.example.hiringMaster.dto.activity.ActivityDto;
import com.example.hiringMaster.dto.activity.ActivityFinishedDto;
import com.example.hiringMaster.dto.profile.ProfileIdDto;
import com.example.hiringMaster.models.Activity;
import com.example.hiringMaster.models.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    ActivityDto activityToActivityDto(Activity activity);
    ProfileIdDto profileToProfileIdDto(Profile profile);
//    Activity activityDtoToActivity(ActivityDto activityDto);
    Optional<Profile> profileIdDtoToProfile(ProfileIdDto profileIdDto);
    ActivityFinishedDto activityToActivityFinishedDto(Activity activity);
}

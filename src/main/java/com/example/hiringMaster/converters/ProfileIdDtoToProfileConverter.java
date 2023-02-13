package com.example.hiringMaster.converters;

import com.example.hiringMaster.dto.activity.ActivityDto;
import com.example.hiringMaster.dto.profile.ProfileIdDto;
import com.example.hiringMaster.models.Activity;
import com.example.hiringMaster.models.Profile;
import com.example.hiringMaster.services.ProfileService;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProfileIdDtoToProfileConverter implements Converter<ProfileIdDto, Profile> {
    private final ProfileService profileService;

    public ProfileIdDtoToProfileConverter(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Override
    public Profile convert(MappingContext<ProfileIdDto, Profile> mappingContext) {
        ProfileIdDto source = mappingContext.getSource();
        Optional<Profile> profile = profileService.getProfileById(source.getId());
        return profile.orElse(null);
    }
}

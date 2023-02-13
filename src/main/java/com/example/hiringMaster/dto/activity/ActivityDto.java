package com.example.hiringMaster.dto.activity;

import com.example.hiringMaster.dto.profile.ProfileIdDto;
import com.example.hiringMaster.models.Activity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Builder(toBuilder=true)
@Getter
@Setter
public class ActivityDto {
    private Long id = null;
    private String visibility;
    private String comment;
    private String title;
    private Date time;
    private String description;
    private List<ProfileIdDto> participants;
    private ProfileIdDto owner;// should be fetched from userPrincipal
    private ProfileIdDto candidate;
    private String subActivities;
    private String job;
    private String address;
    private String medium;//add medium validation
    private String type;//add medium validation
    private Activity.ActivityTypes activityType;
    private Date deadline;
    private Boolean finished;
}

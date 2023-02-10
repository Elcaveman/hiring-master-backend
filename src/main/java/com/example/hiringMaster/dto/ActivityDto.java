package com.example.hiringMaster.dto;

import com.example.hiringMaster.models.Activity;
import com.example.hiringMaster.models.Profile;
import lombok.Builder;

import java.util.Date;
import java.util.List;

@Builder
public class ActivityDto {
    private Long id;
    private String visibility;
    private String comment;
    private String title;
    private Date time;
    private List<Profile> participants;
    private String description;
    private Profile owner;
    private Profile candidate;
    private String subActivities;
    private String job;
    private String address;
    private String medium;
    private String type;
    private Activity.ActivityTypes activityType;
    private Date deadline;

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    private boolean finished;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<Profile> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Profile> participants) {
        this.participants = participants;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Profile getOwner() {
        return owner;
    }

    public void setOwner(Profile owner) {
        this.owner = owner;
    }

    public Profile getCandidate() {
        return candidate;
    }

    public void setCandidate(Profile candidate) {
        this.candidate = candidate;
    }

    public String getSubActivities() {
        return subActivities;
    }

    public void setSubActivities(String subActivities) {
        this.subActivities = subActivities;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Activity.ActivityTypes getActivityType() {
        return activityType;
    }

    public void setActivityType(Activity.ActivityTypes activityType) {
        this.activityType = activityType;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}

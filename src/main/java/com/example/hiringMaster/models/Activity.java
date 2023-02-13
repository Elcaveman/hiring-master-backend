package com.example.hiringMaster.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder=true)
public class Activity {
    public static enum ActivityTypes {
        INTERVIEW,REUNION,TASK,REMINDER
    }
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String visibility;
    private String comment;
    private String title;
    private Date time;

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    private Date deadline;
    @ManyToMany
    @JoinTable(
            name="activity_profile_participation",
            joinColumns = @JoinColumn(name="activity_id"),
            inverseJoinColumns = @JoinColumn(name="profile_id")
    )
    private List<Profile> participants;
    private String description;
    @ManyToOne
    @JoinColumn(name="owner_id")
    private Profile owner;
    @ManyToOne
    @JoinColumn(name="candidate_id")
    private Profile candidate;
    private String subActivities;
    private String job;
    private String address;
    private String medium;
    private String type;
    private ActivityTypes activityType;
    private boolean finished;

    public Profile getCandidate() {
        return candidate;
    }

    public void setCandidate(Profile candidate) {
        this.candidate = candidate;
    }
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

    public ActivityTypes getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityTypes activityType) {
        this.activityType = activityType;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Activity: "+this.id+" "+this.title;
    }

}

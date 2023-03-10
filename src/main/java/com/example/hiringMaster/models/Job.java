package com.example.hiringMaster.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Job {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name="parent_id")
    @JsonIgnore
    private Job parentJob;
    @OneToMany(mappedBy = "parentJob")
    private List<Job> childJobs;

    @OneToMany(mappedBy = "job")
    private List<Activity> activityList;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Job getParentJob() {
        return parentJob;
    }

    public void setParentJob(Job parentJob) {
        this.parentJob = parentJob;
    }

    public List<Job> getChildJobs() {
        return childJobs;
    }

    public void setChildJobs(List<Job> childJobs) {
        this.childJobs = childJobs;
    }
}

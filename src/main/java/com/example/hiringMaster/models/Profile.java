package com.example.hiringMaster.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profile {
    /* We can link a user to an account this way he can log in */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private List<Activity> ownedActivityList;

    @ManyToMany(mappedBy = "participants")
    @JsonIgnore
    private List<Activity> participatedInActivityList;

    @Override
    public String toString() {
        return "Profile "+this.id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Activity> getOwnedActivityList() {
        return ownedActivityList;
    }

    public void setOwnedActivityList(List<Activity> ownedActivityList) {
        this.ownedActivityList = ownedActivityList;
    }

    public List<Activity> getParticipatedInActivityList() {
        return participatedInActivityList;
    }

    public void setParticipatedInActivityList(List<Activity> participatedInActivityList) {
        this.participatedInActivityList = participatedInActivityList;
    }
}

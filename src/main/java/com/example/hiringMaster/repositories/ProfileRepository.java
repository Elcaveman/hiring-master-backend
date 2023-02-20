package com.example.hiringMaster.repositories;

import com.example.hiringMaster.models.Activity;
import com.example.hiringMaster.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {
    List<Profile> findAll();
    Optional<Profile> findById(Long id);
    @Query(value = "SELECT p FROM Profile p WHERE NOT EXISTS ( SELECT a FROM p.participatedInActivityList a WHERE a.id = :activityId )",nativeQuery = false)
    List<Profile> findParticipantsNotInActivityId(@Param("activityId") Long activityId);
    @Query(value = "SELECT p FROM Profile p WHERE NOT EXISTS ( SELECT a FROM p.candidateActivityList a WHERE a.id = :activityId )",nativeQuery = false)
    List<Profile> findCandidatesNotInActivityId(@Param("activityId") Long activityId);
}

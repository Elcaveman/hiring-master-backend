package com.example.hiringMaster.repositories;

import com.example.hiringMaster.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
    List<Activity> findAll();
    Optional<Activity> findById(Long id);
}


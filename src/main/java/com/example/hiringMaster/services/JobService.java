package com.example.hiringMaster.services;

import com.example.hiringMaster.models.Job;
import com.example.hiringMaster.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> findAllJobs() {
        return this.jobRepository.findAll();
    }

    public Optional<Job> findJobById(Long jobId) {
        return this.jobRepository.findById(jobId);
    }
}

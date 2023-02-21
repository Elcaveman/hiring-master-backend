package com.example.hiringMaster.controllers;

import com.example.hiringMaster.models.Job;
import com.example.hiringMaster.services.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/jobs")
public class JobsController {

    private JobService jobService;

    public JobsController(JobService jobService) {
        this.jobService = jobService;
    }
    @GetMapping("")
    public ResponseEntity<List<Job>> getJobsAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.jobService.findAllJobs());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable("id") long jobId){
        var job = this.jobService.findJobById(jobId);
        if (job.isPresent()) return ResponseEntity.status(HttpStatus.OK).body(job.get());
        else return (ResponseEntity<Job>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }

}

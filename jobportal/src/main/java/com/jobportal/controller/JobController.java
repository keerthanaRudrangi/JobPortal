package com.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.entity.Job;
import com.jobportal.service.JobService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestParam;

@RestController

public class JobController {
	
	 private final JobService jobService;

	    public JobController(JobService jobService) {
	        this.jobService = jobService;
	    }
	    
	    @GetMapping("/jobs")
	    public List<Job> getAllJobs() {
	        return jobService.getAllJobs();
	    }
	    
	    @GetMapping("/jobs/search")
	    public List<Job> searchJobsByLocation(@RequestParam String location) {
	        return jobService.searchJobsByLocation(location);
	    }
	    
	    @GetMapping("/jobs/search/title")
	    public List<Job> searchJobsByTitle(@RequestParam String title) {
	        return jobService.searchJobsByTitle(title);
	    }
	    
	    @GetMapping("/jobs/search/skills")
	    public List<Job> searchJobsBySkills(@RequestParam String skills) {
	        return jobService.searchJobsBySkills(skills);
	    }
	    
	    @GetMapping("/jobs/{id}")
	    public Job getJobById(@PathVariable Long id) {
	        return jobService.getJobById(id);
	    }
	    
	    @PostMapping("/jobs")
	    public Job createJob(@Valid @RequestBody Job job) {
	        return jobService.createJob(job);
	    }
	    
	    @PutMapping("/jobs/{id}")
	    public Job updateJob(
	            @PathVariable Long id,
	            @Valid @RequestBody Job job) {

	        return jobService.updateJob(id, job);
	    }
	    
	    @DeleteMapping("/jobs/{id}")
	    public String deleteJob(@PathVariable Long id) {
	        jobService.deleteJob(id);
	        return "Job deleted successfully";
	    }

}

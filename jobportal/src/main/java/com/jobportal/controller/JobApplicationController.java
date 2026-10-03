package com.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.jobportal.dto.ApplicationResponse;
import com.jobportal.entity.JobApplication;
import com.jobportal.service.JobApplicationService;

import org.springframework.web.bind.annotation.PathVariable;
import com.jobportal.dto.StatusUpdateRequest;

@RestController

public class JobApplicationController {
	
	 private final JobApplicationService jobApplicationService;

	    public JobApplicationController(JobApplicationService jobApplicationService) {
	        this.jobApplicationService = jobApplicationService;
	    }

	    @GetMapping("/applications")
	    public List<ApplicationResponse> getAllApplications() {
	        return jobApplicationService.getAllApplications();
	    }
	    
	    @GetMapping("/applications/{id}")
	    public ApplicationResponse getApplicationById(@PathVariable Long id) {
	        return jobApplicationService.getApplicationById(id);
	    }
	    
	    @GetMapping("/applications/candidate/{candidateId}")
	    public List<ApplicationResponse> getApplicationsByCandidateId(
	            @PathVariable Long candidateId) {

	        return jobApplicationService.getApplicationsByCandidateId(candidateId);
	    }
	    
	    @GetMapping("/applications/job/{jobId}")
	    public List<ApplicationResponse> getApplicationsByJobId(
	            @PathVariable Long jobId) {

	        return jobApplicationService.getApplicationsByJobId(jobId);
	    }
	    
	    @DeleteMapping("/applications/{id}")
	    public String deleteApplication(@PathVariable Long id) {
	        jobApplicationService.deleteApplication(id);
	        return "Application deleted successfully";
	    }

	    @PostMapping("/applications")
	    public JobApplication createApplication(@Valid @RequestBody JobApplication application) {
	        return jobApplicationService.createApplication(application);
	    }
	    
	    @PutMapping("/applications/{id}/status")
	    public ApplicationResponse updateStatus(
	            @PathVariable Long id,
	            @Valid @RequestBody StatusUpdateRequest request) {

	        return jobApplicationService.updateStatus(id, request.getStatus());
	    }
	    
	    @GetMapping("/applications/status/{status}")
	    public List<ApplicationResponse> getApplicationsByStatus(
	            @PathVariable String status) {

	        return jobApplicationService.getApplicationsByStatus(status);
	    }
	    
	    @GetMapping("/applications/candidate/{candidateId}/status/{status}")
	    public List<ApplicationResponse> getApplicationsByCandidateAndStatus(
	            @PathVariable Long candidateId,
	            @PathVariable String status) {

	        return jobApplicationService
	                .getApplicationsByCandidateAndStatus(candidateId, status);
	    }

}

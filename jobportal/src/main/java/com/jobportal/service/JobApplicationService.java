package com.jobportal.service;

import com.jobportal.repository.CandidateRepository;
import com.jobportal.repository.JobRepository;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jobportal.entity.JobApplication;
import com.jobportal.repository.JobApplicationRepository;

import com.jobportal.exception.ApplicationNotFoundException;

import com.jobportal.exception.DuplicateApplicationException;

import com.jobportal.exception.CandidateNotFoundException;
import com.jobportal.exception.JobNotFoundException;

import com.jobportal.dto.ApplicationResponse;

@Service

public class JobApplicationService {
	
	private final JobApplicationRepository jobApplicationRepository;
	
	private final CandidateRepository candidateRepository;
	private final JobRepository jobRepository;

	public JobApplicationService(
	        JobApplicationRepository jobApplicationRepository,
	        CandidateRepository candidateRepository,
	        JobRepository jobRepository) {

	    this.jobApplicationRepository = jobApplicationRepository;
	    this.candidateRepository = candidateRepository;
	    this.jobRepository = jobRepository;
	}

	public List<ApplicationResponse> getAllApplications() {

	    return jobApplicationRepository.findAll()
	            .stream()
	            .map(this::convertToResponse)
	            .toList();
	}
    
	public ApplicationResponse getApplicationById(Long id) {

	    JobApplication application = jobApplicationRepository.findById(id)
	            .orElseThrow(() ->
	                    new ApplicationNotFoundException("Application not found"));

	    return convertToResponse(application);
	}
    
	public List<ApplicationResponse> getApplicationsByCandidateId(Long candidateId) {

	    if (!candidateRepository.existsById(candidateId)) {
	        throw new CandidateNotFoundException("Candidate not found");
	    }

	    return jobApplicationRepository.findByCandidateId(candidateId)
	            .stream()
	            .map(this::convertToResponse)
	            .toList();
	}
    
	public List<ApplicationResponse> getApplicationsByJobId(Long jobId) {

	    if (!jobRepository.existsById(jobId)) {
	        throw new JobNotFoundException("Job not found");
	    }

	    return jobApplicationRepository.findByJobId(jobId)
	            .stream()
	            .map(this::convertToResponse)
	            .toList();
	}
	
	public List<ApplicationResponse> getApplicationsByStatus(String status) {

	    return jobApplicationRepository.findByStatusIgnoreCase(status)
	            .stream()
	            .map(this::convertToResponse)
	            .toList();
	}
	
	public List<ApplicationResponse> getApplicationsByCandidateAndStatus(
	        Long candidateId,
	        String status) {

	    if (!candidateRepository.existsById(candidateId)) {
	        throw new CandidateNotFoundException("Candidate not found");
	    }

	    return jobApplicationRepository
	            .findByCandidateIdAndStatusIgnoreCase(candidateId, status)
	            .stream()
	            .map(this::convertToResponse)
	            .toList();
	}
    
    public void deleteApplication(Long id) {
        JobApplication existingApplication = jobApplicationRepository.findById(id)
                .orElseThrow(() ->
                        new ApplicationNotFoundException("Application not found"));

        jobApplicationRepository.delete(existingApplication);
    }

    public JobApplication createApplication(JobApplication application) {
        Long candidateId = application.getCandidate().getId();
        Long jobId = application.getJob().getId();

        if (!candidateRepository.existsById(candidateId)) {
            throw new CandidateNotFoundException("Candidate not found");
        }

        if (!jobRepository.existsById(jobId)) {
            throw new JobNotFoundException("Job not found");
        }

        if (jobApplicationRepository.existsByCandidateIdAndJobId(candidateId, jobId)) {
            throw new DuplicateApplicationException(
                "Candidate has already applied for this job"
            );
        }

        return jobApplicationRepository.save(application);
    }
    
    public ApplicationResponse updateStatus(Long id, String status) {

        JobApplication application = jobApplicationRepository.findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("Application not found"));

        application.setStatus(status);

        JobApplication updatedApplication =
                jobApplicationRepository.save(application);

        return convertToResponse(updatedApplication);
    }
    
    private ApplicationResponse convertToResponse(JobApplication application) {

        ApplicationResponse response = new ApplicationResponse();

        response.setApplicationId(application.getId());

        response.setCandidateId(application.getCandidate().getId());
        response.setCandidateName(application.getCandidate().getFullName());

        response.setJobId(application.getJob().getId());
        response.setJobTitle(application.getJob().getTitle());
        response.setCompanyName(application.getJob().getCompanyName());

        response.setApplicationDate(application.getApplicationDate());
        response.setLocation(application.getLocation());
        response.setStatus(application.getStatus());

        return response;
    }

}

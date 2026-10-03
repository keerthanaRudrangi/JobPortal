package com.jobportal.service;

import com.jobportal.repository.JobApplicationRepository;
import com.jobportal.exception.CandidateHasApplicationsException;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobportal.entity.Candidate;
import com.jobportal.repository.CandidateRepository;

import com.jobportal.exception.CandidateNotFoundException;

@Service

public class CandidateService {
	
	 private final CandidateRepository candidateRepository;
	 
	 private final JobApplicationRepository jobApplicationRepository;

	 public CandidateService(
		        CandidateRepository candidateRepository,
		        JobApplicationRepository jobApplicationRepository) {

		    this.candidateRepository = candidateRepository;
		    this.jobApplicationRepository = jobApplicationRepository;
		}

	    public List<Candidate> getAllCandidates() {
	        return candidateRepository.findAll();
	    }
	    
	    public List<Candidate> searchCandidatesByJobRole(String jobRole) {
	        return candidateRepository.findByJobRoleContainingIgnoreCase(jobRole);
	    }
	    
	    public List<Candidate> searchCandidatesByLocation(String location) {
	        return candidateRepository.findByLocationIgnoreCase(location);
	    }
	    
	    public Candidate getCandidateById(Long id) {
	        return candidateRepository.findById(id)
	                .orElseThrow(() -> new CandidateNotFoundException("Candidate not found"));
	    }

	    public Candidate createCandidate(Candidate candidate) {
	        return candidateRepository.save(candidate);
	    }
	    
	    public Candidate updateCandidate(Long id, Candidate candidate) {
	        Candidate existingCandidate = candidateRepository.findById(id)
	                .orElseThrow(() -> new CandidateNotFoundException("Candidate not found"));

	        existingCandidate.setFullName(candidate.getFullName());
	        existingCandidate.setContact(candidate.getContact());
	        existingCandidate.setEmail(candidate.getEmail());
	        existingCandidate.setPassword(candidate.getPassword());
	        existingCandidate.setSkills(candidate.getSkills());
	        existingCandidate.setLocation(candidate.getLocation());
	        existingCandidate.setJobRole(candidate.getJobRole());
	        existingCandidate.setEducation(candidate.getEducation());
	        existingCandidate.setGraduationYear(candidate.getGraduationYear());
	        existingCandidate.setStream(candidate.getStream());
	        existingCandidate.setYearsOfExperience(candidate.getYearsOfExperience());
	        existingCandidate.setResume(candidate.getResume());
	        existingCandidate.setConsent(candidate.getConsent());

	        return candidateRepository.save(existingCandidate);
	    }
	    
	    public void deleteCandidate(Long id) {
	        Candidate existingCandidate = candidateRepository.findById(id)
	                .orElseThrow(() -> new CandidateNotFoundException("Candidate not found"));

	        if (jobApplicationRepository.existsByCandidateId(id)) {
	            throw new CandidateHasApplicationsException(
	                    "Candidate cannot be deleted because applications exist");
	        }

	        candidateRepository.delete(existingCandidate);
	    }

}

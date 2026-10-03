package com.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobportal.entity.Recruiter;
import com.jobportal.repository.RecruiterRepository;

import com.jobportal.exception.RecruiterNotFoundException;

@Service

public class RecruiterService {
	
	 private final RecruiterRepository recruiterRepository;

	    public RecruiterService(RecruiterRepository recruiterRepository) {
	        this.recruiterRepository = recruiterRepository;
	    }

	    public List<Recruiter> getAllRecruiters() {
	        return recruiterRepository.findAll();
	    }
	    
	    public Recruiter getRecruiterById(Long id) {
	        return recruiterRepository.findById(id)
	                .orElseThrow(() -> new RecruiterNotFoundException("Recruiter not found"));
	    }

	    public Recruiter createRecruiter(Recruiter recruiter) {
	        return recruiterRepository.save(recruiter);
	    }
	    
	    public Recruiter updateRecruiter(Long id, Recruiter recruiter) {
	        Recruiter existingRecruiter = recruiterRepository.findById(id)
	                .orElseThrow(() -> new RecruiterNotFoundException("Recruiter not found"));

	        existingRecruiter.setFullName(recruiter.getFullName());
	        existingRecruiter.setEmail(recruiter.getEmail());
	        existingRecruiter.setPassword(recruiter.getPassword());
	        existingRecruiter.setCompanyName(recruiter.getCompanyName());
	        existingRecruiter.setContact(recruiter.getContact());

	        return recruiterRepository.save(existingRecruiter);
	    }
	    
	    public void deleteRecruiter(Long id) {
	        Recruiter existingRecruiter = recruiterRepository.findById(id)
	                .orElseThrow(() -> new RecruiterNotFoundException("Recruiter not found"));

	        recruiterRepository.delete(existingRecruiter);
	    }

}

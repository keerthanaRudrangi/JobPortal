package com.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.entity.Recruiter;
import com.jobportal.service.RecruiterService;

import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.Valid;

@RestController

public class RecruiterController {
	
	 private final RecruiterService recruiterService;

	    public RecruiterController(RecruiterService recruiterService) {
	        this.recruiterService = recruiterService;
	    }

	    @GetMapping("/recruiters")
	    public List<Recruiter> getAllRecruiters() {
	        return recruiterService.getAllRecruiters();
	    }
	    
	    @GetMapping("/recruiters/{id}")
	    public Recruiter getRecruiterById(@PathVariable Long id) {
	        return recruiterService.getRecruiterById(id);
	    }

	    @PostMapping("/recruiters")
	    public Recruiter createRecruiter(@Valid @RequestBody Recruiter recruiter) {
	        return recruiterService.createRecruiter(recruiter);
	    }
	    
	    @PutMapping("/recruiters/{id}")
	    public Recruiter updateRecruiter(
	            @PathVariable Long id,
	            @Valid @RequestBody Recruiter recruiter) {

	        return recruiterService.updateRecruiter(id, recruiter);
	    }
	    
	    @DeleteMapping("/recruiters/{id}")
	    public String deleteRecruiter(@PathVariable Long id) {
	        recruiterService.deleteRecruiter(id);
	        return "Recruiter deleted successfully";
	    }

}

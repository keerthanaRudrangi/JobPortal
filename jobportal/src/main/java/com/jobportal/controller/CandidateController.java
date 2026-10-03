package com.jobportal.controller;

import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.entity.Candidate;
import com.jobportal.service.CandidateService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;

@RestController

public class CandidateController {
	
	 private final CandidateService candidateService;

	    public CandidateController(CandidateService candidateService) {
	        this.candidateService = candidateService;
	    }

	    @GetMapping("/candidates")
	    public List<Candidate> getAllCandidates() {
	        return candidateService.getAllCandidates();
	    }
	    
	    @GetMapping("/candidates/search")
	    public List<Candidate> searchCandidatesByJobRole(@RequestParam String jobRole) {
	        return candidateService.searchCandidatesByJobRole(jobRole);
	    }
	    
	    @GetMapping("/candidates/search/location")
	    public List<Candidate> searchCandidatesByLocation(@RequestParam String location) {
	        return candidateService.searchCandidatesByLocation(location);
	    }
	    
	    @GetMapping("/candidates/{id}")
	    public Candidate getCandidateById(@PathVariable Long id) {
	        return candidateService.getCandidateById(id);
	    }

	    @PostMapping("/candidates")
	    public Candidate createCandidate(@Valid @RequestBody Candidate candidate) {
	        return candidateService.createCandidate(candidate);
	    }

	    @PutMapping("/candidates/{id}")
	    public Candidate updateCandidate(
	            @PathVariable Long id,
	            @Valid @RequestBody Candidate candidate) {

	        return candidateService.updateCandidate(id, candidate);
	    }
	    
	    @DeleteMapping("/candidates/{id}")
	    public String deleteCandidate(@PathVariable Long id) {
	        candidateService.deleteCandidate(id);
	        return "Candidate deleted successfully";
	    }
}

package com.jobportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity

public class JobApplication {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @jakarta.validation.constraints.NotNull(message = "Candidate is required")
	    @ManyToOne
	    private Candidate candidate;

	    @jakarta.validation.constraints.NotNull(message = "Job is required")
	    @ManyToOne
	    private Job job;
	    
	    @jakarta.validation.constraints.NotNull(message = "Application date is required")
	    private LocalDate applicationDate;
	    
	    @jakarta.validation.constraints.NotBlank(message = "Application location is required")
	    private String location;
	    
	    @jakarta.validation.constraints.NotBlank(message = "Status is required")
	    @jakarta.validation.constraints.Pattern(
	    	    regexp = "Applied|Shortlisted|Rejected|Selected",
	    	    message = "Status must be Applied, Shortlisted, Rejected, or Selected"
	    )
	    private String status;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Candidate getCandidate() {
			return candidate;
		}
		public void setCandidate(Candidate candidate) {
			this.candidate = candidate;
		}
		public Job getJob() {
			return job;
		}
		public void setJob(Job job) {
			this.job = job;
		}
		
		public LocalDate getApplicationDate() {
			return applicationDate;
		}
		public void setApplicationDate(LocalDate applicationDate) {
			this.applicationDate = applicationDate;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

}

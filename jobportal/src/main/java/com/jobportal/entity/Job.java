package com.jobportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import jakarta.validation.constraints.Min;

@Entity

public class Job {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotBlank(message = "Job title is required")
	    private String title;
	    
	    @NotBlank(message = "Job description is required")
	    private String description;
	    
	    @NotBlank(message = "Job location is required")
	    private String location;
	    
	    @NotBlank(message = "Company name is required")
	    private String companyName;
	    
	    @Positive(message = "Salary must be greater than 0")
	    private Double salary;
	    
	    @Min(value = 0, message = "Years of experience cannot be negative")
	    private Integer yearsOfExperience;
	    
	    @NotBlank(message = "Job type is required")
	    private String jobType;
	    
	    @NotBlank(message = "Skills are required")
	    private String skills;
	    
	    @Positive(message = "CTC must be greater than 0")
	    private Double ctc;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public Double getSalary() {
			return salary;
		}
		public void setSalary(Double salary) {
			this.salary = salary;
		}
		public Integer getYearsOfExperience() {
			return yearsOfExperience;
		}
		public void setYearsOfExperience(Integer yearsOfExperience) {
			this.yearsOfExperience = yearsOfExperience;
		}
		public String getJobType() {
			return jobType;
		}
		public void setJobType(String jobType) {
			this.jobType = jobType;
		}
		public String getSkills() {
			return skills;
		}
		public void setSkills(String skills) {
			this.skills = skills;
		}
		public Double getCtc() {
			return ctc;
		}
		public void setCtc(Double ctc) {
			this.ctc = ctc;
		}
		
		
		
		

}

package com.jobportal.entity;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.AssertTrue;

@Entity

public class Candidate {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotBlank(message = "Full name is required")
	    private String fullName;
	    
	    @Pattern(regexp = "^[0-9]{10}$", message = "Contact must contain exactly 10 digits")
	    private String contact;
	    
	    @Email(message = "Please enter a valid email address")
	    private String email;
	    
	    @com.fasterxml.jackson.annotation.JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY)
	    @Size(min = 6, message = "Password must be at least 6 characters")
	    private String password;
	    
	    @NotBlank(message = "Skills are required")
	    private String skills;
	    
	    @NotBlank(message = "Candidate location is required")
	    private String location;
	    
	    @NotBlank(message = "Job role is required")
	    private String jobRole;
	    
	    @NotBlank(message = "Education is required")
	    private String education;
	    
	    @jakarta.validation.constraints.Min(value = 1950, message = "Graduation year must be 1950 or later")
	    private Integer graduationYear;
	    
	    @NotBlank(message = "Stream is required")
	    private String stream;
	    
	    @jakarta.validation.constraints.Min(value = 0, message = "Years of experience cannot be negative")
	    private Integer yearsOfExperience;
	    
	    @NotBlank(message = "Resume is required")
	    private String resume;
	    
	    @AssertTrue(message = "Consent is required")
	    private Boolean consent;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getSkills() {
			return skills;
		}
		public void setSkills(String skills) {
			this.skills = skills;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getJobRole() {
			return jobRole;
		}
		public void setJobRole(String jobRole) {
			this.jobRole = jobRole;
		}
		public String getEducation() {
			return education;
		}
		public void setEducation(String education) {
			this.education = education;
		}
		public Integer getGraduationYear() {
			return graduationYear;
		}
		public void setGraduationYear(Integer graduationYear) {
			this.graduationYear = graduationYear;
		}
		public String getStream() {
			return stream;
		}
		public void setStream(String stream) {
			this.stream = stream;
		}
		public Integer getYearsOfExperience() {
			return yearsOfExperience;
		}
		public void setYearsOfExperience(Integer yearsOfExperience) {
			this.yearsOfExperience = yearsOfExperience;
		}
		public String getResume() {
			return resume;
		}
		public void setResume(String resume) {
			this.resume = resume;
		}
		public Boolean getConsent() {
			return consent;
		}
		public void setConsent(Boolean consent) {
			this.consent = consent;
		}

}

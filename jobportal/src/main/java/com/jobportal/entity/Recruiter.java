package com.jobportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Entity

public class Recruiter {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotBlank(message = "Recruiter name is required")
	    private String fullName;
	    
	    @NotBlank(message = "Email is required")
	    @Email(message = "Please enter a valid email address")
	    private String email;
	    
	    @com.fasterxml.jackson.annotation.JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY)
	    @NotBlank(message = "Password is required")
	    @Size(min = 6, message = "Password must be at least 6 characters")
	    private String password;
	    
	    @NotBlank(message = "Company name is required")
	    private String companyName;
	    
	    @NotBlank(message = "Contact is required")
	    @Pattern(regexp = "^[0-9]{10}$", message = "Contact must contain exactly 10 digits")
	    private String contact;
	    
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
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}

}

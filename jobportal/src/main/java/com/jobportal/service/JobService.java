package com.jobportal.service;

import com.jobportal.exception.JobNotFoundException;
import java.util.List;

import org.springframework.stereotype.Service;
import com.jobportal.entity.Job;

import com.jobportal.repository.JobRepository;



@Service

public class JobService {
	 private final JobRepository jobRepository;

	    public JobService(JobRepository jobRepository) {
	        this.jobRepository = jobRepository;
	    }
	    
	    public List<Job> getAllJobs() {
	        return jobRepository.findAll();
	    }
	    
	    public List<Job> searchJobsByLocation(String location) {
	        return jobRepository.findByLocationIgnoreCase(location);
	    }
	    
	    public List<Job> searchJobsByTitle(String title) {
	        return jobRepository.findByTitleContainingIgnoreCase(title);
	    }
	    
	    public List<Job> searchJobsBySkills(String skills) {
	        return jobRepository.findBySkillsContainingIgnoreCase(skills);
	    }
	    
	    public Job getJobById(Long id) {
	        return jobRepository.findById(id)
	                .orElseThrow(() -> new JobNotFoundException("Job not found"));
	    }
	    
	    public Job createJob(Job job) {
	        return jobRepository.save(job);
	    }
	    
	    public Job updateJob(Long id, Job job) {
	        Job existingJob = jobRepository.findById(id)
	                .orElseThrow(() -> new JobNotFoundException("Job not found"));

	        existingJob.setTitle(job.getTitle());
	        existingJob.setDescription(job.getDescription());
	        existingJob.setLocation(job.getLocation());
	        existingJob.setCompanyName(job.getCompanyName());
	        existingJob.setSalary(job.getSalary());
	        existingJob.setYearsOfExperience(job.getYearsOfExperience());
	        existingJob.setJobType(job.getJobType());
	        existingJob.setSkills(job.getSkills());
	        existingJob.setCtc(job.getCtc());

	        return jobRepository.save(existingJob);
	    }
	    
	    public void deleteJob(Long id) {
	        Job existingJob = jobRepository.findById(id)
	                .orElseThrow(() -> new JobNotFoundException("Job not found"));

	        jobRepository.delete(existingJob);
	    }

}

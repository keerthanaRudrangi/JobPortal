package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.entity.JobApplication;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long>{
	
	boolean existsByCandidateIdAndJobId(Long candidateId, Long jobId);
	
	boolean existsByCandidateId(Long candidateId);
	
	List<JobApplication> findByCandidateId(Long candidateId);
	
	List<JobApplication> findByJobId(Long jobId);
	
	List<JobApplication> findByStatusIgnoreCase(String status);
	
	List<JobApplication> findByCandidateIdAndStatusIgnoreCase(
	        Long candidateId,
	        String status);

}

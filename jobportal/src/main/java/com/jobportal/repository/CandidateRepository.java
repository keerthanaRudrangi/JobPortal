package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jobportal.entity.Candidate;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long>{
	
	 List<Candidate> findByJobRoleContainingIgnoreCase(String jobRole);
	 
	 List<Candidate> findByLocationIgnoreCase(String location);

}

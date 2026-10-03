package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.entity.Job;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long>{
	
	List<Job> findByLocationIgnoreCase(String location);
	
	List<Job> findByTitleContainingIgnoreCase(String title);
	
	List<Job> findBySkillsContainingIgnoreCase(String skills);

}

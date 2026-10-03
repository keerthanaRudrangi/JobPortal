package com.jobportal.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.http.HttpStatus;

@RestControllerAdvice

public class GlobalExceptionHandler {
	
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationExceptions(
	            MethodArgumentNotValidException ex) {

	        Map<String, String> errors = new HashMap<>();

	        ex.getBindingResult().getFieldErrors().forEach(error ->
	            errors.put(error.getField(), error.getDefaultMessage())
	        );

	        return ResponseEntity.badRequest().body(errors);
	    }
	    
	    @ExceptionHandler(ApplicationNotFoundException.class)
	    public ResponseEntity<Map<String, String>> handleApplicationNotFound(
	            ApplicationNotFoundException ex) {

	        Map<String, String> error = new HashMap<>();
	        error.put("error", ex.getMessage());

	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	    }
	    
	    @ExceptionHandler(DuplicateApplicationException.class)
	    public ResponseEntity<Map<String, String>> handleDuplicateApplication(
	            DuplicateApplicationException ex) {

	        Map<String, String> error = new HashMap<>();
	        error.put("error", ex.getMessage());

	        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	    }
	    
	    @ExceptionHandler(JobNotFoundException.class)
	    public ResponseEntity<Map<String, String>> handleJobNotFound(
	            JobNotFoundException ex) {

	        Map<String, String> error = new HashMap<>();
	        error.put("error", ex.getMessage());

	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	    }
	    
	    @ExceptionHandler(CandidateNotFoundException.class)
	    public ResponseEntity<Map<String, String>> handleCandidateNotFound(
	            CandidateNotFoundException ex) {

	        Map<String, String> error = new HashMap<>();
	        error.put("error", ex.getMessage());

	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	    }
	    
	    @ExceptionHandler(RecruiterNotFoundException.class)
	    public ResponseEntity<Map<String, String>> handleRecruiterNotFound(
	            RecruiterNotFoundException ex) {

	        Map<String, String> error = new HashMap<>();
	        error.put("error", ex.getMessage());

	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	    }
	    
	    @ExceptionHandler(CandidateHasApplicationsException.class)
	    public ResponseEntity<Map<String, String>> handleCandidateHasApplications(
	            CandidateHasApplicationsException ex) {

	        Map<String, String> error = new HashMap<>();
	        error.put("error", ex.getMessage());

	        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	    }

}

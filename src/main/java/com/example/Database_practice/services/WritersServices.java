package com.example.Database_practice.services;

import org.springframework.http.ResponseEntity;

import com.example.Database_practice.models.Writers;

public interface WritersServices {
	
	ResponseEntity<?> add (Writers writers);
	ResponseEntity<?> getAll();
	ResponseEntity<?> get(Long id);
	ResponseEntity<?> update(Writers writers, Long id);
	ResponseEntity<?> delete(Long id);

}

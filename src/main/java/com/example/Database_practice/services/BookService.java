package com.example.Database_practice.services;

import org.springframework.http.ResponseEntity;



public interface BookService {

	ResponseEntity<?> toggleStatus( Long id);
}
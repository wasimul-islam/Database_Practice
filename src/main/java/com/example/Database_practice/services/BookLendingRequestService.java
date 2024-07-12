package com.example.Database_practice.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Database_practice.models.BookLendingRequest;

@Service
public interface BookLendingRequestService {
	ResponseEntity<?> addRequest(BookLendingRequest request);
	ResponseEntity<?> approveRequest();
	ResponseEntity<?> returnBook();
}

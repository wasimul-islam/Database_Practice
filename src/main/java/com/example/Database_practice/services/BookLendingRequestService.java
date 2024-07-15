package com.example.Database_practice.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Database_practice.models.BookLendingRequest;

public interface BookLendingRequestService {
	ResponseEntity<?> addRequest(BookLendingRequest request);
	ResponseEntity<?> approveRequest(Long id,String approval);
	ResponseEntity<?> returnBook(Long id);
}

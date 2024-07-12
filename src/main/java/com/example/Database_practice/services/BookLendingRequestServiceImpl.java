package com.example.Database_practice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.Database_practice.repositories.BookLendingRequestRepository;

public class BookLendingRequestServiceImpl implements BookLendingRequestService {
	
	@Autowired
	private BookLendingRequestRepository bookLendingRequestRepository;

	@Override
	public ResponseEntity<?> addRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> approveRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> returnBook() {
		// TODO Auto-generated method stub
		return null;
	}

}

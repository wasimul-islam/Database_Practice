package com.example.Database_practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Database_practice.services.BookLendingRequestService;

@RestController
@RequestMapping("/lend-request")
public class BookLendingRequestController {

	@Autowired
	private BookLendingRequestService bookLendingRequestService;
	
	
	@PostMapping("/request/{id}")
	
	
	
}

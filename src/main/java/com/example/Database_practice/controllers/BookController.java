package com.example.Database_practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Database_practice.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PutMapping("/toggleStatus/{id}")
	public ResponseEntity<?> toggleStatus(@PathVariable (name = "id") Long id){
		return bookService.toggleStatus(id);
	}
}

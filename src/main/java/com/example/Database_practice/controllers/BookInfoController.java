package com.example.Database_practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Database_practice.models.Book;
import com.example.Database_practice.models.BookInfo;
import com.example.Database_practice.services.BookInfoService;

@RestController
@RequestMapping("/book-info")
public class BookInfoController {


	@Autowired
	private BookInfoService bookInfoService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addBookInfo(@RequestBody BookInfo bookInfo){
		return bookInfoService.addBookInfo(bookInfo);
	}
	
	@PostMapping("/get")
	public ResponseEntity<?> getBookInfo(){
		return bookInfoService.getBookInfo();
	}
	
	@PostMapping("/add-book/{id}")
	public ResponseEntity<?> addBookToInfo(@PathVariable(name = "id") Long bookInfoId,
			@RequestBody Book book){
		return bookInfoService.addBookToInfo(bookInfoId, book);
	}
	
}
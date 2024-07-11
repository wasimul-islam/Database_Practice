package com.example.Database_practice.services;

import org.springframework.http.ResponseEntity;

import com.example.Database_practice.models.Book;
import com.example.Database_practice.models.BookInfo;

public interface BookInfoService {
	ResponseEntity<?> addBookInfo(BookInfo bookInfo);
	ResponseEntity<?> getBookInfo();
	ResponseEntity<?> addBookToInfo(Long bookInfoId, Book book);
}

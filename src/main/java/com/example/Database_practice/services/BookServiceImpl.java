package com.example.Database_practice.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Database_practice.models.Book;
import  com.example.Database_practice.enums.Status;
import com.example.Database_practice.models.ResponseMessage;
import com.example.Database_practice.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	
	@Override
	public ResponseEntity<?> toggleStatus(Long id) {
		Optional<Book> optionalExistingBU = bookRepository.findById(id);
		if(optionalExistingBU.isPresent()) {
			Book book = optionalExistingBU.get();
			if(Objects.equals(book.getStatus(),Status.AVAILABLE))
			{
				book.setStatus(Status.UNAVAILABLE);
			}
			else
			book.setStatus(Status.AVAILABLE);
		
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Status succesfully changed"));
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Status not changed"));
	}

}

package com.example.Database_practice.services;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Database_practice.models.BookwormUser;
import com.example.Database_practice.models.ResponseMessage;
import com.example.Database_practice.repositories.BookwormUserRepository;

@Service
public class BookwormUserServiceImpl implements BookwormUserService{
	
	@Autowired
	private BookwormUserRepository bookwormUserRepository;

	@Override
	public ResponseEntity<?> add(BookwormUser bookwormUser) {
		if(Objects.isNull(bookwormUser.getName()) || bookwormUser.getName().trim().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid name"));
		}
		return ResponseEntity.ok(bookwormUserRepository.save(bookwormUser));
	}

	@Override
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(bookwormUserRepository.findAll());
	}

	@Override
	public ResponseEntity<?> update(Long id, BookwormUser bookwormUser) {
		Optional<BookwormUser> optionalExistingBU = bookwormUserRepository.findById(id);
		if(optionalExistingBU.isPresent()) {
			optionalExistingBU.get().setEmail(bookwormUser.getEmail().trim());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Not Found"));
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		Optional<BookwormUser> optionalExistingBU = bookwormUserRepository.findById(id);
		if(optionalExistingBU.isPresent()) {
			bookwormUserRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Element deleted"));
	}

}
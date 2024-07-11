package com.example.Database_practice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Database_practice.models.Book;
import com.example.Database_practice.models.BookInfo;
import com.example.Database_practice.models.ResponseMessage;
import com.example.Database_practice.repositories.BookInfoRepository;

@Service
public class BookInfoServiceImpl implements BookInfoService {
	
	
	@Autowired
	private BookInfoRepository bookInfoRepository;

	@Override
	public ResponseEntity<?> addBookInfo(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(bookInfoRepository.save(bookInfo));
	}

	@Override
	public ResponseEntity<?> getBookInfo() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(bookInfoRepository.findAll());
	}

	@Override
	public ResponseEntity<?> addBookToInfo(Long bookInfoId, Book book) {
		// TODO Auto-generated method stub
		Optional<BookInfo> optionalBookInfo = bookInfoRepository.findById(bookInfoId);
		if(!optionalBookInfo.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Not Found"));
		}
		BookInfo bookInfo = optionalBookInfo.get();
		List<Book> books =  bookInfo.getBooks();
		book.setStatus(book.getStatus());
		books.add(book);
		bookInfo.setBooks(books);
		bookInfo = bookInfoRepository.save(bookInfo);
		return ResponseEntity.ok(new ResponseMessage("Book added succesfully"));
	}

}

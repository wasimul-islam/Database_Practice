package com.example.Database_practice.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Database_practice.enums.BookStatus;
import com.example.Database_practice.enums.RequestStatus;
import com.example.Database_practice.models.Book;
import com.example.Database_practice.models.BookLendingRequest;
import com.example.Database_practice.models.ResponseMessage;
import com.example.Database_practice.repositories.BookLendingRequestRepository;

@Service
public class BookLendingRequestServiceImpl implements BookLendingRequestService {
	
	@Value("${max.limit.books}")
	private Long maxBookLimit;
	
	@Autowired
	private BookLendingRequestRepository bookLendingRequestRepository;

	@Override
	public ResponseEntity<?> addRequest(BookLendingRequest request)  {
		
		if(request.getBooks().size()>maxBookLimit)
		{
			throw new ArithmeticException("Maximum book request can be 3");
		}

		//Optional<BookLendingRequest> optionalRequest = bookLendingRequestRepository.findById(request.getId());
		
		//if(bookLendingRequestRepository.;
		//{
		//	
		//}
		request.setReqStatus(RequestStatus.PENDING);		
		request= bookLendingRequestRepository.save(request);
		return ResponseEntity.ok(request);
	}

	@Override
	public ResponseEntity<?> approveRequest(Long id, String approval) {
		// TODO Auto-generated method stub
		Optional<BookLendingRequest> optionalRequest = bookLendingRequestRepository.findById(id);
		
		
		if(optionalRequest.isPresent() && optionalRequest.get().getReqStatus()==RequestStatus.PENDING)
		{
			if( approval == "APPROVED")
			{
				optionalRequest.get().setReqStatus(RequestStatus.APPROVED);
				Date date = new Date();
				optionalRequest.get().setApprovalDate(date);
			
				for(Book book: optionalRequest.get().getBooks())
					{
						book.setStatus(BookStatus.UNAVAILABLE);
					}
				bookLendingRequestRepository.save(optionalRequest.get());
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("APPROVED"));
		    }
			else {
				optionalRequest.get().setReqStatus(RequestStatus.REJECTED);
				bookLendingRequestRepository.save(optionalRequest.get());
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("REJECTED"));
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ResponseMessage("Approve Request Not Valid"));

		}

		
	}

	@Override
	public ResponseEntity<?> returnBook(Long id) {

		Optional<BookLendingRequest> optionalRequest = bookLendingRequestRepository.findById(id);
		
		
		if(optionalRequest.isPresent())
		{
			Date date = new Date();
			optionalRequest.get().setReturnDate(date);
			
			for(Book book: optionalRequest.get().getBooks())
					{
						book.setStatus(BookStatus.AVAILABLE);
					}
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ResponseMessage("Request Not Found"));

		}
		bookLendingRequestRepository.save(optionalRequest.get());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Book Returned"));

	}

	
}

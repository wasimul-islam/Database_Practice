package com.example.Database_practice.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.example.Database_practice.enums.RequestStatus;
import com.example.Database_practice.models.BookLendingRequest;

public interface BookLendingRequestService {
	ResponseEntity<?> addRequest(BookLendingRequest request);
	ResponseEntity<?> getRequests();
	ResponseEntity<?> approveRequest(Long id,String approval);
	ResponseEntity<?> returnBook(Long id);
	ResponseEntity<?> getRequestsByStatus(List<RequestStatus> requestStatuses);
	ResponseEntity<?> deleteRequest(Long id);
}

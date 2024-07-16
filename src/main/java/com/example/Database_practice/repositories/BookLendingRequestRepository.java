package com.example.Database_practice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Database_practice.enums.RequestStatus;
import com.example.Database_practice.models.BookLendingRequest;

@Repository
public interface BookLendingRequestRepository extends JpaRepository<BookLendingRequest, Long> {

	List<BookLendingRequest> findByReqStatus(RequestStatus requestStatus);

	List<BookLendingRequest> findByReqStatusIn(List<RequestStatus> requestStatuses);

	@Query(value = ".... where status = ?1", nativeQuery = true)
	List<BookLendingRequest> findByReqStatusIncustom(List<RequestStatus> requestStatuses);



}

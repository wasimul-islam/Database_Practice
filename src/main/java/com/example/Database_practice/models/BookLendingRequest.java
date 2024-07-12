package com.example.Database_practice.models;

import java.time.LocalDate;
import java.util.List;

import com.example.Database_practice.enums.RequestStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name ="book_requests")
public class BookLendingRequest extends Root{
	
	
	private BookwormUser requester;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "request_id", referencedColumnName = "id")
	private List<Book> books;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDate creationDate;
	
	@Enumerated(EnumType.STRING)
	private RequestStatus reqStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDate approvalDate;
	
	@Transient
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDate estimatedReturnDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDate returnDate;

	public BookwormUser getRequester() {
		return requester;
	}

	public void setRequester(BookwormUser requester) {
		this.requester = requester;
	}

	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void setEstimatedReturnDate(LocalDate estimatedReturnDate) {
		this.estimatedReturnDate = estimatedReturnDate;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;;
	}

	public RequestStatus getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(RequestStatus reqStatus) {
		this.reqStatus = reqStatus;
	}

	public LocalDate getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(LocalDate approvalDate) {
		this.approvalDate = approvalDate;
	}

	public LocalDate getEstimatedReturnDate() {
		return this.creationDate.plusDays(14);
	}

	public void setReqExpireDate(LocalDate estimatedReturnDate) {
		this.estimatedReturnDate = estimatedReturnDate.plusDays(14);
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	

}

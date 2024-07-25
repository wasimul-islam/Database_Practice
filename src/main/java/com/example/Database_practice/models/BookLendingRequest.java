package com.example.Database_practice.models;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.example.Database_practice.enums.RequestStatus;
import com.example.Database_practice.helpers.DateCalculationHelper;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name ="book_requests")
public class BookLendingRequest extends Root{
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	//@JoinColumn(name = "requester_id", referencedColumnName = "id")
	private BookwormUser requester;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "request_id", referencedColumnName = "id")
	private List<Book> books;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date creationDate;
	
	@Enumerated(EnumType.STRING)
	private RequestStatus reqStatus;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date approvalDate;
	
	@Transient
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date estimatedReturnDate;
	
	@Transient
	@Value("${max.keep.days}")
	private int incrementDays;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date returnDate;

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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;;
	}

	public RequestStatus getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(RequestStatus reqStatus) {
		this.reqStatus = reqStatus;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public Date getEstimatedReturnDate() {
		return estimatedReturnDate;
	}

	public void setEstimatedReturnDate(Date approvaLocalDate) {
		this.estimatedReturnDate = DateCalculationHelper.incrementDay(approvaLocalDate, incrementDays);
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	

}

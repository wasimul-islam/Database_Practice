package com.example.Database_practice.models;

import java.sql.Date;

import com.example.Database_practice.enums.BookStatus;
import com.example.Database_practice.enums.RequestStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name ="book_requests")
public class BookLendingRequest extends Root{
	
	@ManyToOne
	private BookwormUser requester;
	
	@OneToOne
	private Book book;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date creationDate;
	
	@Enumerated(EnumType.STRING)
	private RequestStatus reqStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date approvalDate;
	
	@Transient
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date reqExpireDate;
	
	@Transient
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date returnDate;
	
	

}

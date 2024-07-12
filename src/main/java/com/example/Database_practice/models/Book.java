package com.example.Database_practice.models;


import com.example.Database_practice.enums.BookStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="book")
public class Book extends Root{
	
	@ManyToOne
	private BookwormUser owner;
	
	@Enumerated(EnumType.STRING)
	private BookStatus status;

	public BookwormUser getOwner() {
		return owner;
	}

	public void setOwner(BookwormUser ownerBookwormUser) {
		this.owner = ownerBookwormUser;
	}

	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}

}

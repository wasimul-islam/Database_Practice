package com.example.Database_practice.models;


import com.example.Database_practice.enums.Status;

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
	private Status status;

	public BookwormUser getOwner() {
		return owner;
	}

	public void setOwner(BookwormUser ownerBookwormUser) {
		this.owner = ownerBookwormUser;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}

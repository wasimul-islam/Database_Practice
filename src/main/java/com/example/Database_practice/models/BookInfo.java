package com.example.Database_practice.models;

import java.util.List;

import com.example.Database_practice.enums.Catagory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "book_info")
public class BookInfo extends Root {

	@Column(name = "book_name")
	private String bookName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_info_id", referencedColumnName = "id")
	private List<Book> books;
	
	@ManyToOne
	private Writers writer;
	
	@Enumerated(EnumType.STRING)
	private Catagory catagory;

	public Catagory getCatagory() {
		return catagory;
	}

	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Writers getWriter() {
		return writer;
	}

	public void setWriter(Writers writer) {
		this.writer = writer;
	}
	
	
}

package com.example.Database_practice.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.Database_practice.enums.BookCategory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "book_info")
public class BookInfo extends Root {

	@Column(name = "book_name")
	private String bookName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "book_info_id", referencedColumnName = "id")
	private List<Book> books;
	
	@ManyToOne
	private Writers writer;
	
	@Enumerated(EnumType.STRING)
	private BookCategory catagory;

	public BookCategory getCatagory() {
		return catagory;
	}

	public void setCatagory(BookCategory catagory) {
		this.catagory = catagory;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public List<Book> getBooks() {
		return Objects.isNull(books) ? new ArrayList<Book>() : books;
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

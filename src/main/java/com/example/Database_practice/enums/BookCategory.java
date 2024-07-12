package com.example.Database_practice.enums;

public enum BookCategory {
		SCIFI("SCI-FI"),DRAMA("DRAMA"),THRILLER("THRILLER"),COMEDY("COMEDY"),ROMANCE("ROMANCE"),FANTASY("FANASY"),ADVENTURE("ADVENTURE");

	private String value;

	public String getValue() {
		return value;
	}

	private BookCategory(String value) {
		// TODO Auto-generated constructor stub{
		this.value = value;
	}
	
}

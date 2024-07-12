package com.example.Database_practice.enums;

public enum BookStatus {

	AVAILABLE("AVAILABLE"), UNAVAILABLE("UNAVAILABLE");
	
	private String value;

	public String getValue() {
		return value;
	}

	private BookStatus(String value) {
		this.value = value;
	}
	
}
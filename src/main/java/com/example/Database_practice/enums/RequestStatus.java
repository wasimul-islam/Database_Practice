package com.example.Database_practice.enums;

public enum RequestStatus {
	PENDING("PENDING"), APPROVED("APPROVED");
	
	private String value;

	public String getValue() {
		return value;
	}

	private RequestStatus(String value) {
		this.value = value;
	}
	
}

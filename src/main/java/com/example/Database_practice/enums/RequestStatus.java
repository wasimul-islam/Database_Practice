package com.example.Database_practice.enums;

public enum RequestStatus {
	REJECTED("REJECTED"), APPROVED("APPROVED");
	
	private String value;

	public String getValue() {
		return value;
	}

	private RequestStatus(String value) {
		this.value = value;
	}
	
}

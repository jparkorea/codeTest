package com.example.codeTest.web.entity;

import java.io.Serializable;

public class DocumentKey implements Serializable{
	
	private static final long serialVersionUID = 6305579602603548837L;
	String query;
	String placeName;
	String roadAddressName;
	
	protected DocumentKey() {
	}
	
	public DocumentKey(String query, String placeName, String roadAddressName) {
		this.query = query;
		this.placeName = placeName;
		this.roadAddressName = roadAddressName;
	}
}

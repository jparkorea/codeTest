package com.example.codeTest.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.example.codeTest.web.dto.Documents;

import lombok.Getter;
import lombok.Setter;


@Entity
@IdClass(DocumentKey.class)
public class Document {

	@Id
	public String query;
	@Id
	public String placeName;
	@Id
	public String roadAddressName;
	
	public String addressName;
	public String phone;
	public String placeUrl;
	public String id;
	public String mapUrl;
	
	protected Document() {
	}
	
	public Document(Documents documents) {
		this.addressName = documents.address_name;
		this.roadAddressName = documents.road_address_name;
		this.phone = documents.phone;
		this.placeUrl = documents.place_url;
		this.id = documents.id;
		this.mapUrl = documents.map_url;
		
		this.query = documents.query;
		this.placeName = documents.place_name;
	}
	
}



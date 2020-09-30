package com.example.codeTest.web.entity;

import javax.persistence.*;

import com.example.codeTest.web.dto.Documents;

// TODO 롬복 적용 여부 결정
@Entity
//@IdClass(DocumentKey.class)
public class Document {

	// 고유 ID를 Primary Key로 사용하면 됨.
	/*@Id
	public String query;
	@Id
	public String placeName;
	@Id
	public String roadAddressName;*/

	@Id
	public String id;

	public String query;
	public String placeName;
	public String roadAddressName;
	public String addressName;
	public String phone;
	public String placeUrl;
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



package com.example.codeTest.web.dto;

import lombok.Data;

/**
 * API 응답 내 Documents 객체
 * @author JUNKYU PARK
 *
 */
@Data
public class Documents {

	public String address_name;
	public String road_address_name;
	public String phone;
	public String place_name;
	public String place_url;
	public String id;
	
	public String map_url;
	public String query;
}

package com.example.codeTest.web.dto;

import lombok.Data;

@Data
public class Documents {
	public Long id;
	public String address_name;
	public String road_address_name;
	public String phone;
	public String place_name;
	public String place_url;
	
	public String map_url;
}

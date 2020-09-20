package com.example.codeTest.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;

@Entity
public class Keyword {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String keyword;
	
	@Column
	private Integer count = 1;
	
	protected Keyword() {
	}
	
	public Keyword(String keyword) {
		this.keyword = keyword;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Builder
	public Keyword(Long id, String keyword, Integer count) {
		this.id = id;
		this.keyword = keyword;
		this.count = count;
	}
}

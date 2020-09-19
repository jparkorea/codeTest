package com.example.codeTest.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "keyword")
public class KeywordEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	String keyword;
	
	@Column
	Integer count = 1;
	
	protected KeywordEntity() {
	}
	
	public KeywordEntity(String keyword) {
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
	public KeywordEntity(Long id, String keyword, Integer count) {
		this.id = id;
		this.keyword = keyword;
		this.count = count;
	}
}

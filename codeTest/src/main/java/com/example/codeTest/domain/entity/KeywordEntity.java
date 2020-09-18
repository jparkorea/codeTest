package com.example.codeTest.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class KeywordEntity {

	@Id
	@GeneratedValue
	@Getter @Setter
	String keyword;
	int cnt;
	
}

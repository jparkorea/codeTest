package com.example.codeTest.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "user")
public class LoginEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String user_id;
	
	@Column(length = 100, nullable = false)
	private String user_enc_pwd;
	
	@Builder
	public LoginEntity(Long id, String user_id, String user_enc_pwd) {
		this.id = id;
		this.user_id = user_id;
		this.user_enc_pwd = user_enc_pwd;
	}
	
	
}

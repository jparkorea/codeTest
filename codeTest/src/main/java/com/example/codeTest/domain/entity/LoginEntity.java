package com.example.codeTest.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "user")
public class LoginEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String userId;

	@Column
	private String userPwd;

	protected LoginEntity() {
	}

	public LoginEntity(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public Long getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	@Builder
	public LoginEntity(Long id, String userId, String userPwd) {
		this.id = id;
		this.userId = userId;
		this.userPwd = userPwd;
	}

}

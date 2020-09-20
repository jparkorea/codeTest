package com.example.codeTest.web.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	
	@ManyToMany(mappedBy = "roles") 
	private List<Account> accounts;
	
	
	/*
	 * @ManyToMany(cascade = {CascadeType.PERSIST})
	 * 
	 * @JoinTable( name = "AccountRole", joinColumns = @JoinColumn(name =
	 * "role_id"), inverseJoinColumns = @JoinColumn(name = "account_id"))
	 */
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
}

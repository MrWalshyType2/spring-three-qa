package com.example.persistence.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Account {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true, nullable=false)
	private long accountNumber;
	
	public Account() {
		super();
	}
	
	public Account(long accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}
	
	public Account(long id, long accountNumber) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
}

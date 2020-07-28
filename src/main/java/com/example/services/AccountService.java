package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.persistence.domain.Account;
import com.example.persistence.repos.AccountRepo;

@Service
public class AccountService implements IAccountService {
	
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public List<Account> findAll() {
		return accountRepo.findAll();
	}

}

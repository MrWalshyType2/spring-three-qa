package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.persistence.domain.Account;

public interface IAccountService {

	List<Account> findAll();
}

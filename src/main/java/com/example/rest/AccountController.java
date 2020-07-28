package com.example.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.tomcat.util.digester.ArrayStack;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.AccountAlreadyExistsException;
import com.example.persistence.domain.Account;
import com.example.services.IAccountService;

@RestController
public class AccountController {
	
	@Autowired
	private IAccountService accountService;
	
	private static final Logger logger = Logger.getLogger(AccountController.class.getName());
	private static ArrayList<Account> accounts = new ArrayList<>() {
		{
			add(new Account(1, 4323423));
			add(new Account(2, 4384322));
		}
	};
	
	private static final Account getByAccNum(long accNum) {
		for (Account acc : accounts) {
			if (acc.getAccountNumber() == accNum) {
				return acc;
			}
		}
		return null;
	}


	@GetMapping("/getAll")
	public List<Account> getAllAccounts() {
		return accountService.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Account getAccount(@PathVariable("id") long id) {
		for (Account acc : accounts) {
			if (acc.getId() == id) {
				return acc;
			}
		}
		return null;
	}
	
	// Throwing an internal server error, returns null
	@GetMapping("/get/response/status/{id}")
	public ResponseEntity<Account> getAccountResponse(Long id) {
		return new ResponseEntity<Account>(getAccount(Long.parseLong(id.toString())), HttpStatus.OK);
	}
	
	@PutMapping("/put")
	public Account updateAccount(@RequestBody Account acc) {
		long id = acc.getId();
		long accountNum = acc.getAccountNumber();
		for (int i = 0; i < accounts.size(); i++) {
			if (id == accounts.get(i).getId()) {
				accounts.set(i, acc);
			}
		}
		return getAccount(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/create")
	public Account createAccount(@RequestBody Account account) throws AccountAlreadyExistsException {
		long accNum = account.getAccountNumber();
		try {
			if (getByAccNum(accNum) != null) {
				throw new AccountAlreadyExistsException("Account already exists");
			}
			accounts.add(account);
			return getByAccNum(accNum);
		} finally {
			//logger.log(Level.DEBUG, "How...");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		return accounts.remove(getAccount(id));
	}
}

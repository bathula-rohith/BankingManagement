package com.spring.bankapp.service;


import java.util.List;

import com.spring.bankapp.entity.Account;
public interface AccountService {
	public Account createAccount(Account account);
	public Account getDetailsByAccountNumber(Long accountNumber);
	public List<Account> getAllAccountDetails();
	public Account depositAmount(Long accountNumber,Double Amount);
	public Account withdrawAmount(Long accountNumber,Double Amount);
	public void closeAccount(Long accountNumber);
	

}


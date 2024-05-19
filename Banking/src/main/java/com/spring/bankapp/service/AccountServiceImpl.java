package com.spring.bankapp.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bankapp.entity.Account;
import com.spring.bankapp.repo.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService  {

	@Autowired
	AccountRepository repo;
		@Override
		public Account createAccount(Account account) {
			// TODO Auto-generated method stub
		Account save =repo.save(account);
		
		
			return save;
		}

		@Override
		public Account getDetailsByAccountNumber(Long accountNumber) {
			
         Optional<Account> account =repo.findById(accountNumber);
         if(account.isEmpty())
         {
        	 throw new RuntimeException("Account is not present");
         }
		  Account account_found=account.get();
		  
			return account_found;
		}

		@Override
		public List<Account> getAllAccountDetails() {
		List<Account>listOfAccounts =	repo.findAll();
		
			return listOfAccounts;
		}

		@Override
		public Account depositAmount(Long accountNumber, Double amount) {
			// TODO Auto-generated method stub
		Optional<Account>account=repo.findById(accountNumber);
		if(account.isEmpty())
		{
			throw new RuntimeException("Account is not found");
		}
		Account accountPresent =account.get();
		Double totalBalance= accountPresent.getAccount_balance()+amount;
		accountPresent.setAccount_balance(totalBalance);
		repo.save(accountPresent);
	
		
			return accountPresent;
		}

		@Override
		public Account withdrawAmount(Long accountNumber, Double amount) {
			
			Optional<Account>account=repo.findById(accountNumber);
			if(account.isEmpty())
			{
				throw new RuntimeException("Account is not found");
			}
			Account accountisPresent =account.get();
		Double accountBalance =	accountisPresent.getAccount_balance()-amount;
		
		accountisPresent.setAccount_balance(accountBalance);
		repo.save(accountisPresent);
		    
			return accountisPresent;
		}

		@Override
		public void closeAccount(Long accountNumber) {
			// TODO Auto-generated method stub
			
			getDetailsByAccountNumber(accountNumber);
			repo.deleteById(accountNumber);
			
				}


	}

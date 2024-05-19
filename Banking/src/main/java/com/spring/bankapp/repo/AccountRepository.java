package com.spring.bankapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.bankapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}

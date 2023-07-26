package com.jancy.springboot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jancy.springboot.model.Account;
import com.jancy.springboot.repository.AccountRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	//get all account list
	@GetMapping("/accountbankdetails")
	public List<Account> getAllAccount(){
		return accountRepository.findAll();
	}
	
	//add account
	@PostMapping("/accountbankdetails")
	public Account addAccount(@RequestBody Account account) {
		
		System.out.println("date: "+account.getCreatedDate());
		System.out.println("account: "+account);
		account.setCreatedDate(new Date());
		return accountRepository.save(account);
	}
	
	//get account by ID
	@GetMapping("/accountbankdetails/{accountId}")
	public Account getAccountById(@PathVariable Long accountId) {
		return accountRepository.findById(accountId).get();
	}
	
	
	//update account by id
	@PutMapping("/accountbankdetails/{accountId}")
	public Account getAccountUpdate(@PathVariable Long accountId, @RequestBody Account accountDetails) {
		Account accountupdate=accountRepository.findById(accountId).get();
		System.out.println("before" +accountupdate);
		accountupdate.setCustomerId(accountDetails.getCustomerId());
		accountupdate.setAccountBalance(accountDetails.getAccountBalance());
		accountupdate.setCreatedDate(accountDetails.getCreatedDate());
		accountupdate.setCreatedBy(accountDetails.getCreatedBy());
		System.out.println("after" +accountupdate);
		Account updatedaccount=accountRepository.save(accountupdate);
		return updatedaccount;
	}
	
	//delete account by id
	@DeleteMapping("/accountbankdetails/{accountId}")
	public Account deleteAccount(@PathVariable Long accountId) {
		Account delteaccount=accountRepository.findById(accountId).get();
		accountRepository.delete(delteaccount);
		return delteaccount;
	}

}

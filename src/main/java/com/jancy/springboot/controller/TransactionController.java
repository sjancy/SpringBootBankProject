package com.jancy.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jancy.springboot.model.Account;
import com.jancy.springboot.model.Bank;
import com.jancy.springboot.model.Transaction;
import com.jancy.springboot.repository.AccountRepository;
import com.jancy.springboot.repository.TransactionRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping("/transactioncustomer")
	public List<Transaction> getTransaction() {
		return transactionRepository.findAll();
	}
	
	
	@PostMapping("/transactioncustomer")
	public Transaction addtransaction(@RequestBody Transaction transaction) {
		  transactionRepository.save(transaction);
		  Double finalamount=0.0;
		 Account getaccount=accountRepository.findById(transaction.getAccountId()).get();
		  System.out.println("first:"+getaccount);
		
			  Double currenttransaction= transaction.getTransactionAmount(); 
			  String transtype=transaction.getTransactionType();
			  if(transtype.equals("Deposit")) { 
				finalamount=getaccount.getAccountBalance()+currenttransaction;
			  }else 
			  if(transtype.equals("Withdraw")) {
				  finalamount=getaccount.getAccountBalance()-currenttransaction;
				  
			  }
			  
			  getaccount.setAccountBalance(finalamount);
			  accountRepository.save(getaccount);
		  return transaction;
	}

}



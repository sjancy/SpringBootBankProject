package com.jancy.springboot.controller;

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

import com.jancy.springboot.model.Bank;
import com.jancy.springboot.repository.BankRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class BankController {
	
	@Autowired
	private BankRepository bankRepository;
	
	//get alll bankemployee details
	
	@GetMapping("/bankcustomer")
		public List<Bank> geAllCustomerDeatils(){
		return bankRepository.findAll();
	}
	
	// add banlcutomerdetails
	@PostMapping("/bankcustomer")
	public Bank addBankDetails(@RequestBody Bank bank) {
		return bankRepository.save(bank);
	}
	
	
	//get customerbyid
	@GetMapping("/bankcustomer/{id}")
	public Bank getCustomerById(@PathVariable Long id) {
		Bank getbank=bankRepository.findById(id).get();
		return getbank;
	}
	
	
	//update customer
	@PutMapping("/bankcustomer/{id}")
	public Bank updateCustomer(@PathVariable Long id, @RequestBody Bank bankDetails) {
		Bank updatebank=bankRepository.findById(id).get();
		updatebank.setCustomerName(bankDetails.getCustomerName());
		updatebank.setCustomerAddress(bankDetails.getCustomerAddress());
		updatebank.setCustomerCity(bankDetails.getCustomerCity());
		updatebank.setPhoneno(bankDetails.getPhoneno());
		updatebank.setCreatedDate(bankDetails.getCreatedDate());
		updatebank.setCreatedBy(bankDetails.getCreatedBy());
		
		Bank updatecustomer=bankRepository.save(updatebank);
		
		return updatecustomer;
	}
	
	//delete customer
	
	@DeleteMapping("/bankcustomer/{id}")
		public Bank deleteBankCustomer(@PathVariable Long id) {
			Bank deleteBank=bankRepository.findById(id).get();
	bankRepository.delete(deleteBank);
			return deleteBank;
		}
	

}

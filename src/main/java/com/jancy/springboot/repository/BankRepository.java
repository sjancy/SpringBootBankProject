package com.jancy.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jancy.springboot.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long>{

}

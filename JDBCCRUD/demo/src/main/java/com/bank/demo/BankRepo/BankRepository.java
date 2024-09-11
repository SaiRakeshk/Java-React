package com.bank.demo.BankRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.demo.Entities.Bank;



@Repository
public interface BankRepository extends CrudRepository<Bank,Integer>{

}
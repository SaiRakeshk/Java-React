package com.example.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Bank {
	@GeneratedValue
	@Id
	int accNo;
	String Name;
	double balance;
	String email;
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Bank()
	{
		
	}
	public Bank(int accNo, String name, double balance, String email) {
		super();
		this.accNo = accNo;
		Name = name;
		this.balance = balance;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Bank [accNo=" + accNo + ", Name=" + Name + ", balance=" + balance + ", email=" + email + "]";
	}
	
	

}

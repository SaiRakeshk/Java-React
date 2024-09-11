package com.bank.demo.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bank {

    @Id
    private int actNo;
    private String name;
    private double balance;
    private String email;

    public int getActNo() {
        return actNo;
    }

    public void setActNo(int actNo) {
        this.actNo = actNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Bank [" +
                "actNo=" + actNo +
                ", name=" + name +
                ", balance=" + balance +
                ", email=" + email +
                ']';
    }
}


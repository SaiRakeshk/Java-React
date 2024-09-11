package com.bank.demo.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.bank.demo.BankRepo.*;
import com.bank.demo.Entities.Bank;

@Service
public class Services {


    @Autowired
    public BankRepository rep;
    public Bank openAccount(int actNo, String name, double balance, String email) {
        Bank acc = new Bank();
        acc.setActNo(actNo);
        acc.setName(name);
        acc.setBalance(balance);
        acc.setEmail(email);
        return rep.save(acc);
    }

    public void searchAccDetails(int actNo) {
        Optional<Bank> acc = rep.findById(actNo);
        if (acc.isPresent()) {
            System.out.println("Account details: " + acc.toString());
        } else {
            System.out.println("Account Not Found");
        }
    }

    public void deleteAccount(int actNo) {
        Optional<Bank> acc = rep.findById(actNo);
        if (acc.isPresent()) {
            rep.deleteById(actNo);
            System.out.println("Account deleted"+"---> " + actNo);
        } else {
            System.out.println("Account Not Found");
        }
    }

    public void deposit(int actNo, double amount) {
        Optional<Bank> acc = rep.findById(actNo);
        if (acc.isPresent()) {
            Bank b = acc.get();
            b.setBalance(b.getBalance() + amount);
            rep.save(b);
            System.out.println("Deposit successful! New Balance: " + b.getBalance());
        } else {
            System.out.println("Account Not Found");
        }
    }

    public void withdraw(int actNo, double amount) {
        Optional<Bank> acc = rep.findById(actNo);
        if (acc.isPresent()) {
            Bank b = acc.get();
            System.out.println("Account before withdrawal: " + b);
            if (b.getBalance() >= amount) {
                b.setBalance(b.getBalance() - amount);
                rep.save(b);
                System.out.println("Withdrawal successful! New Balance: " + b.getBalance());
            } else {
                System.out.println("Insufficient funds for withdrawal");
            }
        } else {
            System.out.println("Account Not Found");
        }
    }

    public void transfer(int fromActNo, int toActNo, double amount) {
        Optional<Bank> fromAcc = rep.findById(fromActNo);
        Optional<Bank> toAcc = rep.findById(toActNo);

        if (fromAcc.isPresent() && toAcc.isPresent()) {
            Bank fromAccount = fromAcc.get();
            Bank toAccount = toAcc.get();

            if (fromAccount.getBalance() >= amount) {
                fromAccount.setBalance(fromAccount.getBalance() - amount);
                toAccount.setBalance(toAccount.getBalance() + amount);
                rep.save(fromAccount);
                rep.save(toAccount);
                System.out.println("Transfer successful! New Balance (transferer): " + fromAccount.getBalance() +
                                   ", New Balance (gainee): " + toAccount.getBalance());
            } else {
                System.out.println("Insufficient funds for transfer");
            }
        } else {
            System.out.println("One or both accounts not found");
        }
    }
    
}

package com.example.demo;
import org.springframework.context.ApplicationContext;

import com.example.demo.Entities.Bank;
import com.example.demo.Entities.BankRepo.BankRepository;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	
		ApplicationContext  context=SpringApplication.run(Application.class, args);
		BankRepository repo= context.getBean(BankRepository.class);
		while(true)
		{
		System.out.println("1....Open Account in Bank ");
		System.out.println("2....Deposit Amount");
		
		System.out.println("3... Withdraw ");
		System.out.println(" 4...search by Account Number");
		
		System.out.println("5...transfer Amount");
		System.out.println("6...close account");
		System.out.println("enter your choice");
		int ch =sc.nextInt();
		
	    switch(ch)
	    {
	    case 1:
	    	System.out.println("Enter Your Name");
	    	sc.nextLine();
	    	String name=sc.nextLine();
	    	System.out.println("Enter Your Balance...Minimum balance is 1000");
	    	
	    	double bal =sc.nextDouble();
	    	sc.nextLine();
	    	System.out.println("Enter Your Email Id");
	    	String email=sc.nextLine();
	    	
	    	Bank b=new Bank();
	    	b.setName(name);
	    	if(bal>1000) {
	    		b.setBalance(bal);
	    		b.setEmail(email);
		    	repo.save(b);
		    	System.out.println("Account opening successfull");
	    	}
	    	else
	    	{
	    		System.out.println("Sorry Minimum balance should be 1000");
	    	}
	    	
	    	
	    	break;
	    case 2:
	    	System.out.println("Enter the Account number to deposit money");
	    	int accNo=sc.nextInt();
	    	Optional<Bank>bank=repo.findById(accNo);
	    	if(bank.isPresent())
	    	{
	    		Bank b1 =bank.get();
	    		double currentBal =b1.getBalance();
	    		System.out.println("Enter the Amount to deposit ");
	    		double depositAmt=sc.nextDouble();
	    		double amt=currentBal+depositAmt;
	    		b1.setBalance(amt);
	    		repo.save(b1);
	    		System.out.println("Amount deposited successfull");
	    	}
	    	else
	    	{
	    		System.out.println("Account number not found");
	    	}
	    	break;
	    	
	    	
	    case 3:
	    	System.out.println("Enter the Account number to withdraw money");
	    	int accoNo=sc.nextInt();
	    	Optional<Bank>bank1=repo.findById(accoNo);
	    	if(bank1.isPresent())
	    	{
	    		System.out.println("Enter the Amount to withdraw ");
	    		double withdrawAmt=sc.nextDouble();
	    		Bank b2=bank1.get();
	    		double currentBalance=b2.getBalance();
	    		if(currentBalance < withdrawAmt)
	    		{
	    			System.out.println("Insufficient Balance");
	    		}
	    		else
	    		{
	    			double accBal=currentBalance- withdrawAmt;
	    			if(accBal<1000)
	    			{
	    				System.out.println("Minimum Balance of Rs 1000 should be maintained");
	    			}
	    			else
	    			{
		    			b2.setBalance(accBal);
		    			repo.save(b2);
		    			System.out.println("Amount withdrawn successfull");
	    			}
	    		}
	    	}
	    	else
	    	{
	    		System.out.println("Account number not found");
	    	}
	    	
	    	break;
	    case 4:
	    	System.out.println("Enter the Account number to search");
	    	int accountNo=sc.nextInt();
	    	Optional<Bank>bank2=repo.findById(accountNo);
	    	if(bank2.isPresent())
	    	{
	    	  Bank b3=bank2.get();
	    	  System.out.println(b3.toString());
	    		
	    		
	    	}
	    	else
	    	{
	    		System.out.println("Account number not found");
	    	}
	    		
	    	break;
	    case 5:
	    	System.out.println("Enter the sender Account number ");
	    	int senderAccountNo=sc.nextInt();
	    	Optional<Bank>bank3=repo.findById(senderAccountNo);
	    	if(bank3.isPresent())
	    	{
	    		
	    		System.out.println("Enter the receiver Account number ");
		    	int receiverAccountNo=sc.nextInt();
	    		Optional<Bank>bank4=repo.findById(receiverAccountNo);
		    	if(bank4.isPresent())
		    	{
		    		System.out.println("Enter the Amount to transfer ");
		    		double transferAmt=sc.nextDouble();
		    		Bank b4=bank3.get();
		    		double senderBal=b4.getBalance();	
		    		if(senderBal <transferAmt)
		    		{
		    			System.out.println("Insufficient Balance in senders account");
		    		}
		    		else
		    		{
		    			double senderBalAfterTransfer=senderBal-transferAmt;
		    			if(senderBalAfterTransfer<1000)
		    			{
		    				System.out.println("Minimum Balance of Rs 1000 should be maintained");
		    			}
		    			else
		    			{
			    			b4.setBalance(senderBalAfterTransfer);
			    			repo.save(b4);
			    			Bank b5=bank4.get();
			    			double receiverBal=b5.getBalance();
			    			double receiverBalAfterTransfer=receiverBal+transferAmt;
			    			b5.setBalance(receiverBalAfterTransfer);
			    			repo.save(b5);
			    			System.out.println("Amount transferred successfully");
		    			}
		    		}
		    		
		    	
		    	}
		    	else
		    	{
		    		System.out.println("Incorrect receiver Account number ");
		    	}
	    	}
	    	else
	    	{
	    		System.out.println("Incorrect sender Account number ");
	    	}
	    		
	    
	  
	    	
	    	
	    	break;
	    case 6:
	    	System.out.println("Enter the  Account number to close");
	    	int closingAccountNo=sc.nextInt();
	    	Optional<Bank>bank5=repo.findById(closingAccountNo);
	    	if(bank5.isPresent())
	    	{
	    		
	    		repo.deleteById(closingAccountNo);
	    		
		    	System.out.println(" Account Closed Successfully");
	    		
	    	}
	    	else
	    	{
	    		System.out.println(" Account number not exist ");
	    	}
	    	
	    	break;
	    default :
	     System.out.println("Invalid Choice");
	    }
	    
				
		
	}

}
}
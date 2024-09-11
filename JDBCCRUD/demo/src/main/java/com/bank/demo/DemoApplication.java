package com.bank.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.bank.demo.Entities.Bank;
import com.bank.demo.Services.*;
import java.util.Scanner;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        Services service = context.getBean(Services.class);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Bank Menu:");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Search Account Details");
            System.out.println("5. Transfer Amount");
            System.out.println("6. Delete Account");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    openAccount(scanner, service);
                    break;
                case 2:
                    deposit(scanner, service);
                    break;
                case 3:
                    withdraw(scanner, service);
                    break;
                case 4:
                    searchAccountDetails(scanner, service);
                    break;
                case 5:
                    transferAmount(scanner, service);
                    break;
                case 6:
                    deleteAccount(scanner, service);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 7);

        scanner.close();
    }

    private static void openAccount(Scanner scanner, Services service) {
        System.out.print("Enter Account Number: ");
        int actNo = scanner.nextInt();
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Enter Email: ");
        String email = scanner.next();

        Bank account = service.openAccount(actNo, name, balance, email);
        System.out.println("Account opened successfully! Account details: " + account);
    }

    private static void deposit(Scanner scanner, Services service) {
        System.out.print("Enter Account Number: ");
        int actNo = scanner.nextInt();
        System.out.print("Enter Amount to Deposit: ");
        double amount = scanner.nextDouble();

        service.deposit(actNo, amount);
    }

    private static void withdraw(Scanner scanner, Services service) {
        System.out.print("Enter Account Number: ");
        int actNo = scanner.nextInt();
        System.out.print("Enter Amount to Withdraw: ");
        double amount = scanner.nextDouble();

        service.withdraw(actNo, amount);
    }

    private static void searchAccountDetails(Scanner scanner, Services service) {
        System.out.print("Enter Account Number: ");
        int actNo = scanner.nextInt();

        service.searchAccDetails(actNo);
    }

    private static void transferAmount(Scanner scanner, Services service) {
        System.out.print("Enter Source Account Number: ");
        int fromActNo = scanner.nextInt();
        System.out.print("Enter Destination Account Number: ");
        int toActNo = scanner.nextInt();
        System.out.print("Enter Amount to Transfer: ");
        double amount = scanner.nextDouble();

        service.transfer(fromActNo, toActNo, amount);
    }

    private static void deleteAccount(Scanner scanner, Services service) {
        System.out.print("Enter Account Number to Delete: ");
        int actNo = scanner.nextInt();

        service.deleteAccount(actNo);
    }
}







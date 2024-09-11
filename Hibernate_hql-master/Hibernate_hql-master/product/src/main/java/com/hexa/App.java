package com.hexa;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
    SessionFactory fac;
    Session ses;
    Transaction tx;
    Scanner sc;

    App() {
        fac = new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();
        ses = fac.openSession();
        sc = new Scanner(System.in);
    }

    void addNewItem() {
        tx = ses.beginTransaction();
        System.out.println("Enter Product ID:");
        int pid = sc.nextInt();
        System.out.println("Enter Product Name:");
        String name = sc.next();
        System.out.println("Enter Product Price:");
        double price = sc.nextDouble();

        Product p = new Product(pid, name, price);
        ses.save(p);
        tx.commit();
        System.out.println("Product added successfully.");
    }

    void removeItemByCode() {
        tx = ses.beginTransaction();
        System.out.println("Enter Product ID to remove:");
        int pid = sc.nextInt();

        String hql = "delete from Product P where P.Pid=:pid";
        Query q = ses.createQuery(hql);
        q.setParameter("pid", pid);

        int result = q.executeUpdate();
        if (result > 0) {
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found.");
        }
        tx.commit();
    }

    void updatePriceByCode() {
        tx = ses.beginTransaction();
        System.out.println("Enter Product ID to update:");
        int pid = sc.nextInt();
        System.out.println("Enter new Product Price:");
        double newPrice = sc.nextDouble();

        String hql = "update Product P set P.Price=:price where P.Pid=:pid";
        Query q = ses.createQuery(hql);
        q.setParameter("price", newPrice);
        q.setParameter("pid", pid);

        int result = q.executeUpdate();
        if (result > 0) {
            System.out.println("Product price updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
        tx.commit();
    }

    void calculateBill() {
        tx = ses.beginTransaction();
        ses.clear();
        System.out.println("Enter Product ID to calculate bill:");
        int pid = sc.nextInt();
        System.out.println("Enter Quantity:");
        int qty = sc.nextInt();
        

        String hql = "from Product P where P.Pid=:pid";
        Query q = ses.createQuery(hql, Product.class);
        q.setParameter("pid", pid);

        Product p = (Product) q.uniqueResult();
        if (p != null) {
            double totalBill = p.getPrice() * qty;
            System.out.println("Total Bill: " + totalBill);
        } else {
            System.out.println("Product not found.");
        }
        tx.commit();
    }

    void exit() {
        ses.close();
        fac.close();
        sc.close();
        System.out.println("Session closed. Exiting...");
    }

    public static void main(String[] args) {
        App app = new App();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add new Item");
            System.out.println("2. Remove Item by Code");
            System.out.println("3. Update Price by Code");
            System.out.println("4. Calculate Bill");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    app.addNewItem();
                    break;
                case 2:
                    app.removeItemByCode();
                    break;
                case 3:
                    app.updatePriceByCode();
                    break;
                case 4:
                    app.calculateBill();
                    break;
                case 5:
                    app.exit();
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

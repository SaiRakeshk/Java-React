package com.hexa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    int Pid;

    @Column
    String Name;

    @Column
    Double Price;

    // Constructors, getters, and setters
    public Product() {}

    public Product(int pid, String name, Double price) {
        this.Pid = pid;
        this.Name = name;
        this.Price = price;
    }

    public int getPid() {
        return Pid;
    }

    public void setPid(int pid) {
        this.Pid = pid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        this.Price = price;
    }

    @Override
    public String toString() {
        return "Product [Pid=" + Pid + ", Name=" + Name + ", Price=" + Price + "]";
    }
}

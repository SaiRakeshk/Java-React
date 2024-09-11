package com.hexaware.hibernate.com.hexaware;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITBook")
public class Book {
	@Id
	int Bno;
	@Column(name="bkname")
	String Name;
	@Column
	int price;
	public int getBno() {
		return Bno;
	}
	public void setBno(int bno) {
		Bno = bno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [Bno=" + Bno + ", Name=" + Name + ", price=" + price + "]";
	}
}

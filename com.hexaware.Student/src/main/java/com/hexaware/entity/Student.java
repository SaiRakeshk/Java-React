package com.hexaware.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "Student")
public class Student {
	
	@Id
	@Column(name="RollNo")
	int roll;
	
	@Column(name="Name")
	String name;
	
	@Column(name="Fees")
	double fee;
	
	Student(){
		
	}
	
	
	public Student(int roll, String name, double fee) {
		super();
		this.roll = roll;
		this.name = name;
		this.fee = fee;
	}


	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}


	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", fee=" + fee + "]";
	}
	
	
}
package com.hexaware.hibernate.com.hexaware;

public class Student {
	int Roll;
	String Name;
	Double Fee;
	
	Result res;
	
	public Result getRes() {
		return res;
	}
	public void setRes(Result res) {
		this.res = res;
	}
	public int getRoll() {
		return Roll;
	}
	public void setRoll(int roll) {
		Roll = roll;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Double getFee() {
		return Fee;
	}
	public void setFee(Double fee) {
		Fee = fee;
	}
	@Override
	public String toString() {
		return "Student [Roll=" + Roll + ", Name=" + Name + ", Fee=" + Fee + "]";
	}

 
}

package com.hexaware.hibernate.com.hexaware;

public class Result {
	int marks;
	String remarks;
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Result [marks=" + marks + ", remarks=" + remarks + "]";
	}

}
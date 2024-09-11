package com.hexaware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RepoStudent;
import com.hexaware.entity.Student;

@Service
public class StudentService {
	@Autowired
	RepoStudent repostud;
public Student  saveSt(Student s)
	
	{
		Student s2=repostud.save(s);
		return s2;
	}
public Student removeSt(int rNo) {
	// TODO Auto-generated method stub
	Student s=repostud.findById(rNo).orElse(null);
	if(s!=null) {
		repostud.delete(s);
	}
	return s;
	
}
public String updateNm(int roll, String name) {
	// TODO Auto-generated method stub
	Student s=repostud.findById(roll).orElse(null);
	if(s!=null) {
		s.setName(name);
		repostud.save(s);
		return "Student details updated";
	}
	return "Not found";
}
public List<Student> getStudents() {
	// TODO Auto-generated method stub
	List<Student> l=(List) repostud.findAll();
	return l;
}
public String findSt(int roll) {
	// TODO Auto-generated method stub
	Student s= repostud.findById(roll).orElse(null);
	if(s!=null) {
		return s.getName();
	}
	return "Not found";
}


}

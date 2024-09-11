package com.hexaware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.entity.Student;
import com.hexaware.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService stdser;

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student s) {
        return stdser.saveSt(s);
    }
    @DeleteMapping("/removeStudent/{roll}")
	public Student removeStudent(@PathVariable int roll) {
		Student s=stdser.removeSt(roll);
		return s;
	}
    @PutMapping("updateStudent/{roll}/{name}")
	public String updateName(@PathVariable int roll,@PathVariable String name) {
		String s=stdser.updateNm(roll,name);
		return s;
	}
    @GetMapping("/getStudent")
	public List<Student> getStudent(){
		List<Student> s=stdser.getStudents();
		return s;
	}
    @GetMapping("/findByRoll/{roll}")
	public String findByRoll(@PathVariable int roll) {
		String s=stdser.findSt(roll);
		return s;
	}

    @GetMapping("/testing")
    public String test() {
    	return "Working";
    }
}

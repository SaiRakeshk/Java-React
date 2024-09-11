package com.example.webex.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	List <String> users=new ArrayList<>();
	
	MainController(){
		users.add("shrutee");
		users.add("amit");
		users.add("ajay");
		users.add("tina");
	}
	
	@GetMapping("/getData")
	public List<String> getData() {
		return (users);
	}
	
	//request param is used to take data from the frontend
	@PostMapping("/saveData")
	public String saveData(@RequestParam String name) {
		users.add(name);
		return "save data";
	}
	
	@DeleteMapping("/removeData/{name}")
	public String removeData(@PathVariable String name) {
		users.remove(name);
		return "Removed";
	}
	
	@PutMapping("/updateData/{pos}")
	public String updateData(@PathVariable int pos, @RequestParam String newData) {
		users.set(pos, newData);
		return "Updated";
	}
	
}


// get, post, put(patch), delete
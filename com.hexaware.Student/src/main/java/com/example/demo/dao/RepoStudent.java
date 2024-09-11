package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.entity.Student;
@Repository
public interface RepoStudent extends CrudRepository<Student,Integer> {

}

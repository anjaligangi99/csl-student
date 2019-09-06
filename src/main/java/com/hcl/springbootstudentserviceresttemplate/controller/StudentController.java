package com.hcl.springbootstudentserviceresttemplate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.springbootstudentserviceresttemplate.entity.Student;

@RestController
public class StudentController {

	@GetMapping("/all")
	public List<Student> getAll(){
		
		List<Student> students = new ArrayList<Student>();
		Student student = new Student();
		student.setId(1L);
		student.setFirstName("fname1");
		student.setLastName("lname1");
		students.add(student);

		student = new Student();
		student.setId(2L);
		student.setFirstName("fname2");
		student.setLastName("lname2");
		students.add(student);
		
		return students;
		
	}
	
	@PostMapping("/test5")
	public ResponseEntity<List<Student>> postMethod(@RequestBody Student student){
	
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(student);
		return new ResponseEntity<List<Student>>(students,HttpStatus.CREATED);
	}
	
	@PostMapping("/test3")
	public ResponseEntity<Student> postWithPathParam(@PathParam(value = "firstName") String firstName, @PathParam(value = "lastName") String lastName){
		
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		return new ResponseEntity<Student>(student,HttpStatus.CREATED);
	}
	
	@PostMapping("/test4/{id}")
	public ResponseEntity<Long> postWithPathVariable(@PathVariable Long id){
		return new ResponseEntity<Long>(id,HttpStatus.OK);
		
	}

	
}

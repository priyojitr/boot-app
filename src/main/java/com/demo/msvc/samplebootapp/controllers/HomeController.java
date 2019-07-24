package com.demo.msvc.samplebootapp.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.msvc.samplebootapp.model.EmployeeModel;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employees")
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	private List<EmployeeModel> emps = new ArrayList<>(getEmployees());

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> emp() {
		return new ResponseEntity<>(emps, HttpStatus.OK);
	}

	// delete emp based on id
	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> delEmp(@PathVariable("id") String id) {
		emps = emps.stream().filter(emp -> !emp.getId().equals(id)).collect(Collectors.toList());
		log.info("{}", emps);
		return new ResponseEntity<>(emps, HttpStatus.ACCEPTED);
	}

	// create emp based on id
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> createEmp(@RequestBody EmployeeModel emp) {
		emps.add(emp);
		log.info("{}", emps);
		return new ResponseEntity<>(emps, HttpStatus.CREATED);
	}

	private List<EmployeeModel> getEmployees() {
		return Arrays.asList(new EmployeeModel("id-1", "name-1", "designation-1"),
				new EmployeeModel("id-2", "name-2", "designation-2"));
	}
}

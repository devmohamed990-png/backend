package com.crud.api.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.demo.model.Student;
import com.crud.api.demo.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
@Slf4j
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		log.info("Starting Date >>>>>>>>>>>>> {}", new Date());
		log.info(">>>>>> GET request to /student : StudentController : findAll");
		ResponseEntity<?> response = studentService.findAll();
		log.info("Finishing Date >>>>>>>>>>>>> {}", new Date());
		return response;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		log.info("Starting Date >>>>>>>>>>>>> {}", new Date());
		log.info(">>>>>> GET request to /student : StudentController : findById");
		log.info("id >>>>>>>>>>>>> {}", id);
		ResponseEntity<?> response = studentService.findById(id);
		log.info("Finishing Date >>>>>>>>>>>>> {}", new Date());
		return response;
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Student student) {
		log.info("Starting Date >>>>>>>>>>>>> {}", new Date());
		log.info(">>>>>> POST request to /student : StudentController : save");
		ResponseEntity<?> response = studentService.save(student);
		log.info("Finishing Date >>>>>>>>>>>>> {}", new Date());
		return response;
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Student student) {
		log.info("Starting Date >>>>>>>>>>>>> {}", new Date());
		log.info(">>>>>> PUT request to /student : StudentController : update");
		ResponseEntity<?> response = studentService.update(student);
		log.info("Finishing Date >>>>>>>>>>>>> {}", new Date());
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		log.info("Starting Date >>>>>>>>>>>>> {}", new Date());
		log.info(">>>>>> DELETE request to /student : StudentController : delete");
		log.info("id >>>>>>>>>> {}", id);
		ResponseEntity<?> response = studentService.delete(id);
		log.info("Starting Date >>>>>>>>>>>>> {}", new Date());
		return response;
	}
}
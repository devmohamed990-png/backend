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

import com.crud.api.demo.model.Department;
import com.crud.api.demo.service.DeparmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/dep")
@CrossOrigin("*")
@Slf4j
public class DeparmentController {

	@Autowired
	private DeparmentService deparmentService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		log.info("Starting Date >>>>>>>>>>>>> {}", new Date());
		log.info(">>>>>> GET request to /dep : DeparmentController : findAll");
		ResponseEntity<?> response = deparmentService.findAll();
		log.info("Finishing Date >>>>>>>>>>>>> {}", new Date());
		return response;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		log.info("Starting Date >>>>>>>>>>>>> {}", new Date());
		log.info(">>>>>> GET request to /dep : DeparmentController : findById");
		log.info("id >>>>>>>>>>>>> {}", id);
		ResponseEntity<?> response = deparmentService.findById(id);
		log.info("Finishing Date >>>>>>>>>>>>> {}", new Date());
		return response;
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Department department) {
		log.info("Starting Date >>>>>>>>>>>>> {}", new Date());
		log.info(">>>>>> POST request to /dep : DeparmentController : save");
		ResponseEntity<?> response = deparmentService.save(department);
		log.info("Finishing Date >>>>>>>>>>>>> {}", new Date());
		return response;
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Department department) {
		log.info("Starting Date >>>>>>>>>>>>> {}", new Date());
		log.info(">>>>>> PUT request to /dep : DeparmentController : update");
		ResponseEntity<?> response = deparmentService.update(department);
		log.info("Finishing Date >>>>>>>>>>>>> {}", new Date());
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		log.info("Starting Date >>>>>>>>>>>>> {}", new Date());
		log.info(">>>>>> DELETE request to /dep : DeparmentController : delete");
		log.info("id >>>>>>>>>> {}", id);
		ResponseEntity<?> response = deparmentService.delete(id);
		log.info("Starting Date >>>>>>>>>>>>> {}", new Date());
		return response;
	}
}
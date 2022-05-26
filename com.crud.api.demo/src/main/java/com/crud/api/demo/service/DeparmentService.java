package com.crud.api.demo.service;

import org.springframework.http.ResponseEntity;

import com.crud.api.demo.model.Department;

public interface DeparmentService {

	ResponseEntity<?> findAll();

	ResponseEntity<?> findById(int id);

	ResponseEntity<?> save(Department department);

	ResponseEntity<?> update(Department department);

	ResponseEntity<?> delete(int id);
}
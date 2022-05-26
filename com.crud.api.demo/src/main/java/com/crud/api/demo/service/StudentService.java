package com.crud.api.demo.service;

import org.springframework.http.ResponseEntity;

import com.crud.api.demo.model.Student;

public interface StudentService {

	ResponseEntity<?> findAll();

	ResponseEntity<?> findById(int id);

	ResponseEntity<?> save(Student student);

	ResponseEntity<?> update(Student student);

	ResponseEntity<?> delete(int id);
}
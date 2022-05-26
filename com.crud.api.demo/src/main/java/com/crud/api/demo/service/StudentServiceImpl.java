package com.crud.api.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.api.demo.dao.StudentDAO;
import com.crud.api.demo.model.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public ResponseEntity<?> findAll() {
		log.info(">>>>>>>> StudentServiceImpl : findAll : Start");
		List<Student> students = studentDAO.findAll();
		log.info("students size >>>>>>>>> {}", students.size());
		ResponseEntity<?> response = new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		log.info(">>>>>>>> StudentServiceImpl : findAll : Finish");
		return response;
	}

	@Override
	public ResponseEntity<?> findById(int id) {
		log.info(">>>>>>>> StudentServiceImpl : findById : Start");
		log.info("id >>>>>>>>>>> {}", id);
		ResponseEntity<?> response;
		Optional<Student> studentOptional = studentDAO.findById(id);
		if (studentOptional.isPresent())
			response = new ResponseEntity<Student>(studentOptional.get(), HttpStatus.OK);
		else
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		log.info(">>>>>>>> StudentServiceImpl : findById : finish");
		return response;
	}

	@Override
	public ResponseEntity<?> save(Student student) {
		log.info(">>>>>>>> StudentServiceImpl : save : Start");
		student = studentDAO.save(student);
		ResponseEntity<?> response = new ResponseEntity<Student>(student, HttpStatus.OK);
		log.info(">>>>>>>> StudentServiceImpl : save : Finish");
		return response;
	}

	@Override
	public ResponseEntity<?> update(Student student) {
		log.info(">>>>>>>> StudentServiceImpl : update : Start");
		student = studentDAO.save(student);
		ResponseEntity<?> response = new ResponseEntity<Student>(student, HttpStatus.OK);
		log.info(">>>>>>>> StudentServiceImpl : update : Finish");
		return response;
	}

	@Override
	public ResponseEntity<?> delete(int id) {
		log.info(">>>>>>>> StudentServiceImpl : delete : Start");
		log.info("id >>>>>>>>>>>> {}", id);
		studentDAO.deleteById(id);
		ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.OK);
		log.info(">>>>>>>> StudentServiceImpl : delete : Finish");
		return response;
	}
}
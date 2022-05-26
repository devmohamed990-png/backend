package com.crud.api.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.api.demo.dao.DepartmentDAO;
import com.crud.api.demo.model.Department;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeparmentServiceImpl implements DeparmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	public ResponseEntity<?> findAll() {
		log.info(">>>>>>>> DeparmentServiceImpl : findAll : Start");
		List<Department> departments = departmentDAO.findAll();
		log.info("departments size >>>>>>>>> {}", departments.size());
		ResponseEntity<?> response = new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
		log.info(">>>>>>>> DeparmentServiceImpl : findAll : Finish");
		return response;
	}

	@Override
	public ResponseEntity<?> findById(int id) {
		log.info(">>>>>>>> DeparmentServiceImpl : findById : Start");
		log.info("id >>>>>>>>>> {}", id);
		ResponseEntity<?> response;
		Optional<Department> departmentOptional = departmentDAO.findById(id);
		if (departmentOptional.isPresent())
			response = new ResponseEntity<Department>(departmentOptional.get(), HttpStatus.OK);
		else
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		log.info(">>>>>>>> DeparmentServiceImpl : findById : Finish");
		return response;
	}

	@Override
	public ResponseEntity<?> save(Department department) {
		log.info(">>>>>>>> DeparmentServiceImpl : save : Start");
		department = departmentDAO.save(department);
		ResponseEntity<?> response = new ResponseEntity<Department>(departmentDAO.save(department), HttpStatus.OK);
		log.info(">>>>>>>> DeparmentServiceImpl : save : Finish");
		return response;
	}

	@Override
	public ResponseEntity<?> update(Department department) {
		log.info(">>>>>>>> DeparmentServiceImpl : update : Start");
		department = departmentDAO.save(department);
		ResponseEntity<?> response = new ResponseEntity<Department>(department, HttpStatus.OK);
		log.info(">>>>>>>> DeparmentServiceImpl : update : Finish");
		return response;
	}

	@Override
	public ResponseEntity<?> delete(int id) {
		log.info(">>>>>>>> DeparmentServiceImpl : delete : Start");
		log.info("id >>>>>>>>>>> {}", id);
		departmentDAO.deleteById(id);
		ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.OK);
		log.info(">>>>>>>> DeparmentServiceImpl : delete : Finish");
		return response;
	}
}
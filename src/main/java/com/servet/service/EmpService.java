package com.servet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servet.entity.Employee;
import com.servet.repository.EmpRepository;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepository empRepo;
	
	public void addEmp(Employee emp) {
		empRepo.save(emp);
	}
	
	public List<Employee>getAllEmp(){
		//veri listelemek icin 
		return empRepo.findAll();
	}
	
	public Employee getEmpById(int id) {
		Optional<Employee> emp=empRepo.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		return null;
	}
	
	public void deleteEmp(int id) {
		empRepo.deleteById(id);
	}
}

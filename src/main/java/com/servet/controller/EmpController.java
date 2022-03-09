package com.servet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.servet.entity.Employee;
import com.servet.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String Index(Model model) {
		List<Employee> emp=service.getAllEmp();
		model.addAttribute("emp",emp);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmployeeForm() {
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee employee, HttpSession session) {
		System.out.println(employee);
		service.addEmp(employee);
		session.setAttribute("msg", "Calasisan eklendi...");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmp(@PathVariable int id, Model m) {
		Employee e=service.getEmpById(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	@PostMapping("/update")
	public String UpdateEmp(@ModelAttribute Employee e,HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Employee Data Update Successfully...");
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session) {
		service.deleteEmp(id); 
		session.setAttribute("msg", "Employee Data Delete Successfully...");
		return "redirect:/";
	}
}

package com.firstdevelop.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firstdevelop.boot.entity.Employee;
import com.firstdevelop.boot.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/searchAll")
	public String searchAll(Model model) {
		List<Employee>emp_list = employeeService.searchAll();
		model.addAttribute("emp_list",emp_list);
		return "/employee/all";
	
	}

}

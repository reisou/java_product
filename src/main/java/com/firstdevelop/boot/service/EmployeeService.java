package com.firstdevelop.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstdevelop.boot.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	private com.firstdevelop.boot.mapper.EmployeeMapper EmployeeMapper;
	
	public List<Employee> searchAll(){
		return EmployeeMapper.searchAll();
	}
}

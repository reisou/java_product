package com.firstdevelop.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.firstdevelop.boot.entity.Employee;

@Mapper
public interface EmployeeMapper {
	
	List<Employee> searchAll();

}

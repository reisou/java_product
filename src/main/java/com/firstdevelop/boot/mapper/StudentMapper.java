package com.firstdevelop.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.firstdevelop.boot.entity.*;

@Mapper

public interface StudentMapper {
 List<Student> searchAll(); 
 List<Student> info(); 
 	public void insert (@Param("name")String name,@Param("stu_class") int stu_class,@Param("age")int age);
}
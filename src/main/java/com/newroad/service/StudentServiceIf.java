package com.newroad.service;

import java.util.List;

import com.newroad.entity.Student;

public interface StudentServiceIf {

	List<Student> getAll();
	
	List<Student> listByPage(Integer page,Integer rows);
	
	Integer getCount();
	
	Student getById(Integer id);
	
	Boolean removeById(Integer id);
	
	Integer add(Student stu);
	
	Integer updateById(Student stu);
}

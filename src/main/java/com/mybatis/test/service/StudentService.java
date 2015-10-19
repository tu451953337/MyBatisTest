package com.mybatis.test.service;

import java.util.List;

import com.mybatis.test.model.Student;

public interface StudentService {
	List<Student> getList();
	
	Student get(Integer id);

	void update(Student student);
	
	void insert(Student student);
	
	void delete(Integer id);
}

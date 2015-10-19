package com.mybatis.test.mapper;

import java.util.List;

import com.mybatis.test.model.Student;

public interface StudentMapper {
	List<Student> getList();
	
	Student get(Integer id);

	void update(Student student);
	
	void insert(Student student);
	
	void delete(Integer id);
}

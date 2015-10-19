package com.mybatis.test.service.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.mybatis.test.mapper.StudentMapper;
import com.mybatis.test.model.Student;
import com.mybatis.test.service.StudentService;

public class StudentServiceImpl extends SqlSessionDaoSupport implements StudentService {

	public List<Student> getList() {
		StudentMapper mapper = this.getSqlSession().getMapper(StudentMapper.class);
		return mapper.getList();
	}

	public Student get(Integer id) {
		return null;
	}

	public void update(Student student) {
		
	}

	public void insert(Student student) {
		StudentMapper mapper = this.getSqlSession().getMapper(StudentMapper.class);
		mapper.insert(student);
		
		System.out.println("111".substring(10, 20));
	}

	public void delete(Integer id) {
		StudentMapper mapper = this.getSqlSession().getMapper(StudentMapper.class);
		mapper.delete(id);
	}

}

package com.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.test.model.Student;
import com.mybatis.test.service.StudentService;

public class TestSpring {
	
	static ApplicationContext context;
	static SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("spring/spring-context.xml");
		sqlSessionFactory = context.getBean("sqlSessionFactory", SqlSessionFactory.class);
	}

	@Test
	public void testGetList() {
		StudentService stuService = context.getBean("studentService", StudentService.class);
		List<Student> list = stuService.getList();
		for(Student stu : list) {
			System.err.println(stu);
		}
		System.out.println();
		System.out.println();
		for(int i=0; i<100; i++) {
			list = stuService.getList();
		}
		
	}

	@Test
	public void testInsert() {
		StudentService stuService = context.getBean("studentService", StudentService.class);
		
		Student student = new Student();
		student.setName("飞流");
		student.setClassname("Class_2");
		student.setScore(95);
		student.setAge(18);
		
		stuService.insert(student);
	}
	
	@Test
	public void testDelete() {
		StudentService stuService = context.getBean("studentService", StudentService.class);
		stuService.delete(12);
	}
}

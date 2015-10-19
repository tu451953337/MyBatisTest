package com.mybatis.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.test.mapper.StudentMapper;
import com.mybatis.test.model.Student;

public class TestStudent {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException {
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
	}
	
	@Test
	public void testGetList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> list = mapper.getList();
		for(Student stu : list) {
			System.out.println(stu);
		}
		sqlSession.close();
	}
	
	@Test
	public void testGet() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		Student stu = mapper.get(1);
		System.out.println(stu);
		sqlSession.close();
	}
	
	@Test
	public void testInsert() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Student student = new Student();
		student.setName("飞流");
		student.setClassname("Class_2");
		student.setScore(95);
		student.setAge(18);
		
		mapper.insert(student);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testUpdate() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Student student = new Student();
		student.setId(1);
		student.setAge(37);
		
		mapper.update(student);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testDelete() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		mapper.delete(9);
		
		sqlSession.commit();
		sqlSession.close();
	}
}

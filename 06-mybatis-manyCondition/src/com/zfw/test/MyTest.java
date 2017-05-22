package com.zfw.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zfw.beans.Student;
import com.zfw.dao.IStudentDao;
import com.zfw.utils.MybatieUtils;

public class MyTest {
	private SqlSession sqlSession;
	private IStudentDao dao;

	@Before
	public void before() {
		sqlSession = MybatieUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
	}

	@After
	public void after() {
		sqlSession.close();
	}
	
	@Test
	public void testSelectStudent1(){
		List<Student> selectStudents1 = dao.selectStudents1("五", 12,35);
		for (Student student : selectStudents1) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testSelectStudentsMap(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("namekey", "五");
		map.put("agekey", 12);
		List<Student> studentsMap = dao.selectStudentsMap(map);
		for (Student student : studentsMap) {
			System.out.println(student);
		}
	}
}

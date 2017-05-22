package com.zfw.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zfw.beans.Student;
import com.zfw.dao.IStudentDao;
import com.zfw.utils.MyBatiesUtils;

public class MyTest {
	private SqlSession sqlSession;
	private IStudentDao dao;

	@Before
	public void before(){
		sqlSession = MyBatiesUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
	}
	@After
	public void after(){
		sqlSession.close();
	}
	@Test
	public void testSelectCountryById(){
		List<Student> student = dao.selectStudentById(1);
		System.out.println(student);
	}
}

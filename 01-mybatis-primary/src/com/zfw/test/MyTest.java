package com.zfw.test;

import org.junit.Before;
import org.junit.Test;

import com.zfw.beans.Student;
import com.zfw.dao.IStudentDao;
import com.zfw.dao.StudentDaoImpl;

public class MyTest {
	private IStudentDao studentDao;
	@Before
	public void testBefore(){
		studentDao = new StudentDaoImpl();
		
	}
	@Test
	public void testInsert(){
		Student student = new Student("张三", 32, 45.5);
		studentDao.insertStu(student);
	}
	@Test
	public void testss(){
		System.out.println("sysot");
	}
}
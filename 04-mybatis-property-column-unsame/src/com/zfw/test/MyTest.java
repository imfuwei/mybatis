package com.zfw.test;

import org.junit.Test;

import com.zfw.beans.Student;
import com.zfw.dao.IStudentDao;
import com.zfw.dao.StudentImpl;

public class MyTest {
	@Test
	public void test() {
		IStudentDao dao =new StudentImpl();
		Student student = dao.selectStudentById(3);
		System.out.println(student);
	}
	@Test
	public void test2() {
		IStudentDao dao =new StudentImpl();
		Student student = dao.selectStudentById2(3);
		System.out.println(student);
	}
}

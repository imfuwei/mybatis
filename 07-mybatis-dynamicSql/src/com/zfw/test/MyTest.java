package com.zfw.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zfw.beans.Student;
import com.zfw.dao.IStudentDao;
import com.zfw.utils.MybatiesUtils;

public class MyTest {
	private SqlSession sqlSession;
	private IStudentDao dao;
	@Before
	public void before(){
		sqlSession = MybatiesUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
	}
	
	@Test
	public void testSelectsIf(){
		Student stu=new Student("五", 3, 112);
		List<Student> students = dao.selectStudentsIf(stu);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void testSelectStudentWhere(){
		Student student = new Student("", 0, 23);
		List<Student> students = dao.selectStudentsWhere(student);
		for (Student student2 : students) {
			System.out.println(student2);
		}
	}
	@Test
	public void testSelectStudentsChoose(){
		Student student=new Student("", 23, 21);
		List<Student> students = dao.selectStudentsChoose(student);
		for (Student student2 : students) {
			System.out.println(student2);
		}
	}
	@Test
	public void testSelectStudentForeachArray(){
		Object[] object={1,2,3};
		List<Student> students = dao.selectStudentForeachArray(object);
		System.out.println(students);
	}
	
	@Test
	public void testSelectStudentForeachList(){
		List<Integer> list=new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		List<Student> students = dao.selectStudentForeachBaseList(list);
		System.out.println(students);
	}
	@Test
	public void testSelectStudentForeachGenericList(){
		List<Student> students=new ArrayList<Student>();
		Student student1 = new Student();
		Student student2 = new Student();
		student1.setId(2);
		student2.setId(3);
		students.add(student1);
		students.add(student2);
		List<Student> studentForeachGenericList = dao.selectStudentForeachGenericList(students);
		System.out.println(studentForeachGenericList);
	}
	
	@Test
	public void testSelectStudentSql(){
		Student student = dao.selectStudentSql(3);
		System.out.println(student);
	}
	@After
	public void after(){
		sqlSession.close();
	}
	
}

package com.zfw.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zfw.beans.Student;
import com.zfw.dao.IStudentDao;
import com.zfw.utils.MybatiesUtil;

public class MyTest {
	private SqlSession sqlSession;
	private IStudentDao dao;
	@Before
	public void testBefore(){
		sqlSession = MybatiesUtil.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
	}
	@Test
	public void testInsertStudent() {
		Student student=new Student("张三", 21, 66);
		dao.insertStudent(student);
		sqlSession.commit();
	}
	
	@Test
	public void testInsertStudentCatchId(){
		Student student=new Student("王五",32,43);
		dao.insertStudentCatchId(student);
		System.out.println(student);
		sqlSession.commit();
	}
	@Test
	public void testDeleteStudentById(){
		dao.deleteStudentById(1);
		sqlSession.commit();
	}
	@Test
	public void testUpdateStudentById(){
		Student student=new Student();
		student.setId(2);
		student.setName("李四");
		dao.updateStudentById(student);
		sqlSession.commit();
	}
	@Test
	public void testSelectStudentById(){
		Student student = dao.selectStudentById(2);
		System.out.println(student);
	}
	@Test
	public void testSelectAllStudent(){
		List<Student> students = dao.selectAllStudent();
		for (Student student : students) {
			System.out.println(student);
		}
	}
	@Test
	public void testSelectStudentByName(){
		List<Student> students = dao.selectStudentByName("五");
		for (Student student : students) {
			System.out.println(student);
		}
		sqlSession.commit();
	}
	@After
	public void testAfter(){
		sqlSession.close();
	}
}

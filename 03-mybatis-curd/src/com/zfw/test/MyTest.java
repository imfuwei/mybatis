package com.zfw.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.zfw.beans.Student;
import com.zfw.dao.IStudentDao;
import com.zfw.dao.StudentImpl;

public class MyTest {
	private IStudentDao dao;
	@Before
	public void beforeDao(){
		dao = new StudentImpl();
	}
	@Test
	public void test01(){
		for (int i = 0; i < 10; i++) {
			Student student = new Student("n_"+i, 10+i, 60+i);
			dao.insertStu(student);
		}
	}
	
	@Test
	public void testInsert(){
		Student student=new Student("lisi", 123, 47);
		dao.insertStu(student);
	}
	@Test
	public void testInsertCatchId(){
		Student student=new Student("lisi", 123, 47);
		System.out.println(student);
		dao.insertStudentCatchId(student);
		System.out.println(student);
	}
	@Test
	public void testDeleteStudentById(){
		dao.deleteStudentById(12);
	}
	@Test
	public void testUpdateStudentById(){
		Student student=new Student("张三", 23,52);
		student.setId(1);
		dao.updateStudent(student);
	}
	@Test
	public void testSelectStudentById(){
		Student student = dao.selectStudentById(1);
		System.out.println(student);
	}
	
	@Test
	public void testSelectAllStudents(){
		List<Student> students = dao.selectAllStudents();
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}
	@Test
	public void testSelectAllStudentsMap(){
		Map<String, Student> students = dao.selectStudentMap();
		Set<Entry<String,Student>> entrySet = students.entrySet();
		for (Entry<String, Student> entry : entrySet) {
			System.out.println(entry.getKey()+"   ======   "+entry.getValue());
		}
	}
	@Test
	public void testSelectStudentsByName(){
		List<Student> students = dao.selectStudentsByName("n");
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testSelectStudentByMap(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("StudentId", 2);
		Student student = dao.selectStudentByMap(map);
		System.out.println(student);
	}
	
	@Test
	public void testSelectStudentByMap2(){
		Map<String, Object> map=new HashMap<String, Object>();
		Student student = new Student();
		student.setId(3);
		map.put("student", student);
		student = dao.selectStudentByMap2(map);
		System.out.println(student);
	}
}

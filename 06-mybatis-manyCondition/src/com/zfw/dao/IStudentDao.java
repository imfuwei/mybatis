package com.zfw.dao;

import java.util.List;
import java.util.Map;

import com.zfw.beans.Student;

public interface IStudentDao {
	List<Student> selectStudents1(String name,int age,int score);
	List<Student> selectStudentsMap(Map<String, Object> map);
}

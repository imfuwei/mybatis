package com.zfw.dao;

import java.util.List;

import com.zfw.beans.Student;

public interface IStudentDao {
	List<Student> selectStudentsIf(Student student);

	List<Student> selectStudentsWhere(Student student);

	List<Student> selectStudentsChoose(Student student);

	List<Student> selectStudentForeachArray(Object[] object);

	List<Student> selectStudentForeachBaseList(List<Integer> ids);

	List<Student> selectStudentForeachGenericList(List<Student> students);
	Student selectStudentSql(int id);
}

package com.zfw.dao;

import java.util.List;

import com.zfw.beans.Student;

public interface IStudentDao {
	Student selectStudentById(int id);
	Student selectStudentById2(int id);
	void insertStudent(Student student);
}

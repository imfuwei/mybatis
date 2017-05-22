package com.zfw.dao;

import java.util.List;

import com.zfw.beans.Student;

public interface IStudentDao {
	public List<Student> selectStudentById(int id);
}

package com.zfw.dao;

import com.zfw.beans.Student;

/**
 * @author zhang
 *
 */
public interface IStudentDao {
	Student selectStudentById(int id);
	Student selectStudentById2(int id);
}

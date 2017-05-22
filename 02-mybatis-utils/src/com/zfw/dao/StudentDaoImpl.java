package com.zfw.dao;

import org.apache.ibatis.session.SqlSession;

import com.zfw.beans.Student;
import com.zfw.utils.MyUtils;

public class StudentDaoImpl implements IStudentDao {
	private SqlSession session = null;

	@Override
	public void insertStu(Student student) {
		try {
			session = MyUtils.getSqlSession();
			session.insert("insertStudent", student);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
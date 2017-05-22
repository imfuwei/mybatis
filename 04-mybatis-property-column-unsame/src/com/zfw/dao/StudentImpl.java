package com.zfw.dao;

import org.apache.ibatis.session.SqlSession;

import com.zfw.beans.Student;
import com.zfw.utils.MyBatiesUtils;

public class StudentImpl implements IStudentDao {

	private SqlSession sqlSession;

	@Override
	public Student selectStudentById(int id) {
		Student student;
		try {
			sqlSession = MyBatiesUtils.getSqlSession();
			student = sqlSession.selectOne("selectStudentById", id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return student;
	}

	@Override
	public Student selectStudentById2(int id) {
		Student student;
		try {
			sqlSession = MyBatiesUtils.getSqlSession();
			student = sqlSession.selectOne("selectStuentById2", id);
			sqlSession.commit();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		return student;
	}
}

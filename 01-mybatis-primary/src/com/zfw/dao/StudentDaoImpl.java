package com.zfw.dao;



import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zfw.beans.Student;

public class StudentDaoImpl implements IStudentDao {
	private SqlSession session=null;

	@Override
	public void insertStu(Student student) {
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			session.insert("insertStudent",student);
			session.commit();
		} catch (IOException e) {
			e.printStackTrace();
			if (session!=null) {
				session.close();
			}
		}
	}

}
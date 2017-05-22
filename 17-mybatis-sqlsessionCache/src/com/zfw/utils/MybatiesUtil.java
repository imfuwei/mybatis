package com.zfw.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatiesUtil {
	private static SqlSessionFactory sessionFactory;
	public static SqlSession getSqlSession(){
		InputStream config;
		try {
			config = Resources.getResourceAsStream("mybatis.xml");
			if (sessionFactory==null) {
				sessionFactory = new SqlSessionFactoryBuilder().build(config);
			}
			return sessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

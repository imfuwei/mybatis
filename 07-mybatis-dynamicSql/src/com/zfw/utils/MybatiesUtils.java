package com.zfw.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatiesUtils {
	
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSession getSqlSession(){
		InputStream config=null;
		try {
			config = Resources.getResourceAsStream("mybatis.xml");
			
			if (sqlSessionFactory==null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
			}
			return sqlSessionFactory.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}

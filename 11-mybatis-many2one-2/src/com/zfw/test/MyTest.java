package com.zfw.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zfw.beans.Minister;
import com.zfw.dao.IMinisterDao;
import com.zfw.utils.MyBatiesUtils;

public class MyTest {
	private SqlSession sqlSession;
	private IMinisterDao dao;

	@Before
	public void before(){
		sqlSession = MyBatiesUtils.getSqlSession();
		dao = sqlSession.getMapper(IMinisterDao.class);
	}
	@After
	public void after(){
		sqlSession.close();
	}
	@Test
	public void testSelectMinisterById(){
		Minister minister = dao.selectMinisterById(1);
		System.out.println(minister);
	}
}

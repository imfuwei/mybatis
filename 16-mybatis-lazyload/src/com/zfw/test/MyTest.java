package com.zfw.test;

import java.io.File;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zfw.beans.Country;
import com.zfw.beans.Minister;
import com.zfw.dao.ICountryDao;
import com.zfw.utils.MyBatiesUtils;

public class MyTest {
	private SqlSession sqlSession;
	private ICountryDao dao;

	@Before
	public void before() {
		sqlSession = MyBatiesUtils.getSqlSession();
		dao = sqlSession.getMapper(ICountryDao.class);
	}

	@After
	public void after() {
		sqlSession.close();
	}

	@Test
	public void testSelectCountryById() {
		Country country = dao.selectCountryById(1);
		System.out.println(country.getCid());
		System.out.println(country.getCname());
		/*country.getMinisters();*/
	}
}

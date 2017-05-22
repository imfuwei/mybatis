package com.zfw.test;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zfw.beans.NewLabel;
import com.zfw.dao.INewLabelDao;
import com.zfw.utils.MyBatiesUtils;

public class MyTest {
	private SqlSession sqlSession;
	private INewLabelDao dao;

	@Before
	public void before(){
		sqlSession = MyBatiesUtils.getSqlSession();
		dao = sqlSession.getMapper(INewLabelDao.class);
	}
	@After
	public void after(){
		sqlSession.close();
	}
	@Test
	public void testSelectNewLabelById(){
		List<NewLabel> label = dao.selectNewLabelByPid(2);
		System.out.println(label);
	}
}

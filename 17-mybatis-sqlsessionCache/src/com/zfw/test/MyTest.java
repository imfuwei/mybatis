package com.zfw.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zfw.beans.Student;
import com.zfw.dao.IStudentDao;
import com.zfw.utils.MybatiesUtil;

public class MyTest {
	private SqlSession sqlSession;
	private IStudentDao dao;
	@Before
	public void testBefore(){
		sqlSession = MybatiesUtil.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
	}
	@Test
	public void testSelectStudentById(){
		/*一级缓存的生命周期是当前sqlSession,当sqlSession关闭时，一级缓存清空，生命结束*/
		/*证明一级缓存的存在，第一次查询时，去数据库中查找，查找之后，将查询语句和结果放入sqlsession缓存中，然后第二次查询时，会直接去一级缓存中查找*/
		Student student = dao.selectStudentById(2);
		System.out.println(student);
		Student student2 = dao.selectStudentById(2);
		System.out.println(student2);
	}
	
	@Test
	public void testSelectStudentById2(){
		/*因为在上个sqlsession做相同的查询后，一级缓存关闭清空了，所以这次就直接去数据库中查询了*/
		Student student = dao.selectStudentById(2);
		System.out.println(student);
		Student student2 = dao.selectStudentById(2);
		System.out.println(student2);
	}
	@Test
	public void testSelectStudentById3(){
		Student student = dao.selectStudentById(2);
		System.out.println(student);
		
		//增删改操作无论是否提交，都会刷新清空一级缓存，因为对数据库修改了，所以缓存里的数据可能与数据库中的不一样了，所以才会清空缓存的
		dao.insertStudent(new Student("", 32, 33));
		
		Student student2 = dao.selectStudentById(2);
		System.out.println(student2);
	}
	//ORM框架底层缓存储是一个map集合，map的value是查询出来的对象
	//map的key，根据使用的框架不同，key也是不同的
	
	//证明mybatis缓存查询依据(map的key)是：sql语句+查询Id
	@Test
	public void testSelectStudentById4(){
		Student student = dao.selectStudentById(2);
		System.out.println(student);
		//虽然说查询语句相同，查询的对象也相同，但查询的id不同，所以，mybatis不会走缓存。（和hibernate不一样，hibernate一级缓存里是直接存的查询对象，而key则是对象的id）
		Student student2 = dao.selectStudentById2(2);
		System.out.println(student2);
	}
	
	
	@After
	public void testAfter(){
		sqlSession.close();
	}
}

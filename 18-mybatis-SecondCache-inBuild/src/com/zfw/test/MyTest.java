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
	//内置二级缓存的用法：1.在映射文件中，配上<cache/>标签；2.实体实现串行化接口
	/* 证明二级缓存的存在，把一级缓存关闭了之后，再次查询相同的sql语句的id以及对象的id，会从二级缓存中查询 */
	@Test
	public void testSelectStudentById() {
		sqlSession = MybatiesUtil.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
		Student student = dao.selectStudentById(2);
		System.out.println(student);
		sqlSession.close();

		sqlSession = MybatiesUtil.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
		Student student2 = dao.selectStudentById(2);
		System.out.println(student2);
	}

	// 通过以下，可以说明
	// 1.增删改同样也会清空二级缓存
	// 2.对于二级缓存的清空，实质上是对所查找Key对应的value设置为null,
	// 而不是将entry对象删除
	// 3.从数据库中进行select查询的条件是：
	// (1).缓存中根本就不存在这个key
	// (2).缓存中存在该key所对应的Entry对象，但其value为null
	@Test
	public void testSelectStudentById2() {
		sqlSession = MybatiesUtil.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
		Student student = dao.selectStudentById(2);
		System.out.println(student);
		sqlSession.close();

		sqlSession = MybatiesUtil.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);

		// 增删改操作无论是否提交，都会刷新清空二级缓存，因为对数据库修改了，所以缓存里的数据可能与数据库中的不一样了，所以才会清空缓存的

		dao.insertStudent(new Student("", 32, 33));
		// 但是，在第二次查询时，虽然去数据库中查了，但是在从数据库查之前，也去了二级缓存中查了，因为输出命中率了Cache Hit Ratio [com.zfw.dao.IStudentDao]: 0.5
		// 证明，二级缓存中也有这个要查询对象map所对应的key，
		// 只不过，这个key所对应value对象没有，才又去数据库中查的，
		// 可以说明增删改操作，并不是将此map中所对应查询的entry对象(key-value对)删除了，而是将这个key对应value对象给回收了（设为null了）
		Student student2 = dao.selectStudentById(2);
		System.out.println(student2);
	}
	
	//二级缓存局部开关，在要使用的select标签中配置，useCache=false
	@Test
	public void testSelectStudentById3() {
		sqlSession = MybatiesUtil.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
		Student student = dao.selectStudentById2(2);
		System.out.println(student);
		sqlSession.close();
		
		sqlSession = MybatiesUtil.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
		Student student2 = dao.selectStudentById2(2);
		System.out.println(student2);
	}
	
	//二级缓存局部开关，在要使用的select标签中配置，useCache=false
		@Test
		public void testSelectStudentById4() {
			sqlSession = MybatiesUtil.getSqlSession();
			dao = sqlSession.getMapper(IStudentDao.class);
			Student student = dao.selectStudentById2(2);
			System.out.println(student);
			sqlSession.close();
			
			sqlSession = MybatiesUtil.getSqlSession();
			dao = sqlSession.getMapper(IStudentDao.class);
			Student student2 = dao.selectStudentById2(2);
			System.out.println(student2);
		}
		//增删改操作不刷新二级缓存，在要使用的select标签中配置，flushCache=false。只为测试，谁会这么二逼
		@Test
		public void testSelectStudentById5() {
			sqlSession = MybatiesUtil.getSqlSession();
			dao = sqlSession.getMapper(IStudentDao.class);
			Student student = dao.selectStudentById3(2);
			System.out.println(student);
			sqlSession.close();
			
			sqlSession = MybatiesUtil.getSqlSession();
			dao = sqlSession.getMapper(IStudentDao.class);
			Student student2 = dao.selectStudentById3(2);
			System.out.println(student2);
		}
	
	
	@After
	public void testAfter() {
		sqlSession.close();
	}
}

package com.zfw.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.zfw.beans.Student;
import com.zfw.utils.MyBatiesUtils;

public class StudentImpl implements IStudentDao {

	private SqlSession sqlSession;

	@Override
	public void insertStu(Student student) {
		try {
			sqlSession = MyBatiesUtils.getSqlSession();
			sqlSession.insert("insertStudent", student);
			sqlSession.commit();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		
	}

	@Override
	public void insertStudentCatchId(Student student) {
		try {
			sqlSession=MyBatiesUtils.getSqlSession();
			sqlSession.insert("insertStudentCatchId", student);
			sqlSession.commit();
		}finally{
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
	}

	@Override
	public void deleteStudentById(int id) {
			try {
				sqlSession=MyBatiesUtils.getSqlSession();
				sqlSession.delete("deleteStudentById", id);
				sqlSession.commit();
			} finally {
				if (sqlSession!=null) {
					sqlSession.close();
				}
			}
	}

	@Override
	public void updateStudent(Student student) {
		try {
			sqlSession=MyBatiesUtils.getSqlSession();
			sqlSession.update("updateStudentById", student);
			sqlSession.commit();
		}finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		
	}
	@Override
	public Student selectStudentById(int id){
		Student student=null;
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
	public List<Student> selectAllStudents() {
		List<Student> students=null;
		try {
			sqlSession=MyBatiesUtils.getSqlSession();
			students = sqlSession.selectList("selectStudents");
			sqlSession.commit();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		return students;
	}

	@Override
	public Map<String, Student> selectStudentMap() {
		Map<String, Student> selectMap;
		try {
			sqlSession = MyBatiesUtils.getSqlSession();
			//此处的mapKey,指定要形成的key，封装对象的属性名
			//步骤：1.从数据库中查询出来一行后，将字段名通过Student对象的setter方法，把一行中所有的字段封装到Student对象中，
			//	2.然后再通过getter方法去这个已封装好的Student对象中拿你指定属性名的对应值，做为这个map集合的key，
			//	3.而这个map集合的value就是你当前的将这一行数据封装好的Student对象
			//  4.然后再通过Map的put方法将key-value封装到Map集合中，也就是说这一行数据对应一个Map.entry()对象
			//如果你这个属性名的对应的值不是唯一的，而你又拿了这个不是唯一的属性的值当key，因为map集合的key必须是唯一的，所以，这个map中key-value会以最后一次存入的key为准，前面的都覆盖掉
			//比如：你把属性a当key了，表中根本没有这一个字段，而对象中放了这个a属性，当然，这个属性没用，只是为了测试
			//所以会将null以字符串形式通过setter方法，为每一个对象的a属性赋值为null,然后你拿a当key，而每个对象的a的值都null
			//所以最后存进去的也就是最后一次存入map中对象了,之前的都会被干掉了，是Map集合的原理把那些干掉的，不是被Mybaties的这个方法给干掉的
			//selectMap = sqlSession.selectMap("selectStudents", "a");
			
			selectMap = sqlSession.selectMap("selectStudents", "name");
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return selectMap;
	}

	@Override
	public List<Student> selectStudentsByName(String name) {
		List<Student> students=null;
		try {
			sqlSession = MyBatiesUtils.getSqlSession();
			students = sqlSession.selectList("selectStudentsByName", "%"+name+"%");
			/*students = sqlSession.selectList("selectStudentsByName", name);*/
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return students;
	}

	@Override
	public Student selectStudentByMap(Map<String, Object> map) {
		Student student=null;
		try {
			sqlSession = MyBatiesUtils.getSqlSession();
			student = sqlSession.selectOne("selectStudentByMap", map);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return student;
	}

	@Override
	public Student selectStudentByMap2(Map<String, Object> map) {
		Student student=null;
		try {
			SqlSession sqlSession = MyBatiesUtils.getSqlSession();
			student = sqlSession.selectOne("selectStudentByMap2", map);
			sqlSession.commit();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		return student;
	}

}

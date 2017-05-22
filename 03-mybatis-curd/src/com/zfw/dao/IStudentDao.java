package com.zfw.dao;

import java.util.List;
import java.util.Map;

import com.zfw.beans.Student;

/**
 * @author zhang
 *
 */
public interface IStudentDao {
	/**
	 * 插入到student表中
	 * @param student
	 */
	 
	void insertStu(Student student);

	void insertStudentCatchId(Student student);

	/**
	 * 通过id删除
	 * @param id
	 */
	void deleteStudentById(int id);
	/**
	 * 更新
	 * @param student
	 */
	void updateStudent(Student student);
	
	
	/**
	 * @param id 通过id查询学生信息
	 * @return 查询结果封装成Student对象
	 */
	Student selectStudentById(int id);
	/**
	 * 查询所有学生
	 * @return 返回一个list<Student>集合
	 */
	List<Student> selectAllStudents();
	
	Map<String, Student> selectStudentMap();
	/**
	 * 通过名字模糊查询所有学生
	 * @param name
	 * @return	返回一个List<Student>
	 */
	List<Student> selectStudentsByName(String name);
	/**
	 * 根据Map进行查询
	 * @param map
	 * @return
	 */
	Student selectStudentByMap(Map<String, Object> map);
	Student selectStudentByMap2(Map<String, Object> map);
}

package com.zfw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.zfw.beans.Student;

public interface IStudentDao {
	@Insert(value = { "insert t_student(s_name,s_age,s_score) values(#{name},#{age},#{score})" })
	void insertStudent(Student student);

	@Insert(value = { "insert t_student(s_name,s_age,s_score) values(#{name},#{age},#{score})" })
	@SelectKey( statement = "select @@identity", before = false,keyProperty = "id", resultType = Integer.class)
	void insertStudentCatchId(Student student);

	@Delete("delete from t_student where s_id=#{id}")
	void deleteStudentById(int id);

	@Update("update t_student set s_name=#{name},s_age=#{age},s_score=#{score} where s_id=#{id}")
	void updateStudentById(Student student);

	@Select("select s_id id,s_name as name,s_age as age,s_score as score from t_student where s_id=#{id}")
	Student selectStudentById(int id);

	@Select("select s_id id,s_name as name,s_age as age,s_score as score from t_student")
	List<Student> selectAllStudent();

	@Select("select s_id id,s_name as name,s_age as age,s_score as score from t_student where s_name like '%' #{name} '%'")
	List<Student> selectStudentByName(String name);

}

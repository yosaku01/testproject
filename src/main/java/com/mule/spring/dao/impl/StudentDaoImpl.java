package com.mule.spring.dao.impl;

import java.util.List;

import org.python.google.common.base.Joiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mule.spring.dao.StudentDao;
import com.mule.spring.entity.Student;
import com.mule.spring.mapper.StudentMapper;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Student> getStudentsByIds(List<String> ids) 
	{
		String idListStr = Joiner.on(',').join(ids);
		String sql = "select * from students where id in (" + idListStr + ")";		
		List<Student> studentList =jdbcTemplate.query(
				sql, new StudentMapper());	
		
		return studentList;
	}

}

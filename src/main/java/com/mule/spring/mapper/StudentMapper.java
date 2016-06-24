package com.mule.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mule.spring.entity.Student;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException 
	{		
		Student student = new Student();		
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setClassName(rs.getString("class"));	
		return student;
	}

}

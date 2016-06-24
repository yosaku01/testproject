package com.mule.spring.dao;

import java.util.List;

import com.mule.spring.entity.Student;

public interface StudentDao 
{
		List<Student> getStudentsByIds(List<String> ids);
}

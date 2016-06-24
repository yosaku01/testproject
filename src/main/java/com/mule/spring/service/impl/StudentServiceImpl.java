package com.mule.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mule.spring.dao.StudentDao;
import com.mule.spring.entity.Student;
import com.mule.spring.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<Student> getStudentsByIds(List<String> ids) 
	{
		return studentDao.getStudentsByIds(ids);
	}

}

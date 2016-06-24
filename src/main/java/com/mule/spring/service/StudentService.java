package com.mule.spring.service;
import java.util.List;
import com.mule.spring.entity.Student;

public interface StudentService 
{
		List<Student> getStudentsByIds(List<String> ids);
}

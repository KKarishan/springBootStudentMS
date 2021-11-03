package net.studentmanagement.springboot.service;

import net.studentmanagement.springboot.model.Student;
import net.studentmanagement.springboot.web.dto.StudentRegistrationDto;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService{
	Student save(StudentRegistrationDto registrationDto);
	
//	step 01
	List<Student> getAllStudents();

}

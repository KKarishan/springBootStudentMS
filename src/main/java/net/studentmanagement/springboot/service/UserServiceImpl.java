package net.studentmanagement.springboot.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.studentmanagement.springboot.model.Role;
import net.studentmanagement.springboot.model.Student;
import net.studentmanagement.springboot.repository.StudentRepository;
import net.studentmanagement.springboot.web.dto.StudentRegistrationDto;

@Service
public class UserServiceImpl implements UserService{

	
	private StudentRepository studentRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public UserServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

//	step 02
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
//	----

	@Override
	public Student save(StudentRegistrationDto registrationDto) {
		
		Student student = new Student(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(), 
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
		
		return studentRepository.save(student);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Student student = studentRepository.findByEmail(username);
		if (student == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new User(student.getEmail(), student.getPassword(), mapRolesToAuthorities(student.getRoles()));
	}
	
	private Collection<?extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){ 
		return roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

	}

}
	
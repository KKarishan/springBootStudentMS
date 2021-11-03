package net.studentmanagement.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.studentmanagement.springboot.service.UserService;
import net.studentmanagement.springboot.web.dto.StudentRegistrationDto;

@Controller
@RequestMapping("/registration")
public class StudentRegistrationController {

	private UserService userService;

	public StudentRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("student")
	public StudentRegistrationDto studentRegistrationDto() {
		return new StudentRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerStudentAccount(@ModelAttribute("student")StudentRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:registration?success";
	}
	
	
	
//	step 03
//	handler method to handle list students and return mode and view
////	@GetMapping("/students")
//	public String listStudents(Model model) {
//		model.addAttribute("students", userService.getAllStudents());
//		return "students";
//	}
//	step 04 create students.html file
}

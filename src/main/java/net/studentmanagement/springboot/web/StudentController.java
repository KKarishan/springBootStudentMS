package net.studentmanagement.springboot.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.studentmanagement.springboot.service.UserService;

public class StudentController {
// step 08 create StudentController class
	
	private UserService userService;

	public StudentController(UserService userService) {
		super();
		this.userService = userService;
	}
	
//	handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", userService.getAllStudents());
		return "students";
	}
}

package net.studentmanagement.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
//	@GetMapping("/")
//	public String home() {
//		return "index";
//	}
	
	@GetMapping("/")
	public String home() {
		return "students";
	}
	
//	step 05
//	@GetMapping("/students")
//	public String studentpage() {
//		return "students";
//	}
}

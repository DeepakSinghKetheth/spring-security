package com.springsecurity.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		System.out.println("Fetching Home Page");
		return "home.jsp";
	}
	
	@GetMapping("/login")
	public String getEmployeeRecord() {
		System.out.println("Fetching Login Page");
		return "login.jsp";
	}
	
	@GetMapping("/logout-success")
	public String logoutSuccessPage() {
		System.out.println("Fetching Logout Page");
		return "logout.jsp";
	}
	
	@GetMapping("user")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}
	
}

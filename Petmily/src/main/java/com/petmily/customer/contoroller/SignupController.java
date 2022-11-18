package com.petmily.customer.contoroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petmily.customer.service.SignupService;

@Controller
public class SignupController {
	
	@Autowired
	SignupService service;
	
	@RequestMapping("/signup_page")
	public String signup() {
		return "signup";
	}
	
	@RequestMapping("/signup_form")
	public String signupForm() {
		return "signup_page";
	}
	
	@RequestMapping("/sign_up")
	public String signupClick(HttpServletRequest request, Model model) throws Exception {
		int result = service.executeInt(request, model);
		
		if(result == 0) {
			return "login";
		}else {
			return "signup";
		}
		
	}
	
	
	
}

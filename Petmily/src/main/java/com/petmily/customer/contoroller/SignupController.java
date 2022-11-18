package com.petmily.customer.contoroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String signupClick(MultipartHttpServletRequest request, Model model, MultipartFile file) throws Exception {
		service.execute(request, model, file);

		return "login";

	}

}

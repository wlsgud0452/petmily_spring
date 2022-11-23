package com.petmily.customer.contoroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping("/sign_up_kakao")
	public String signupKakao(HttpServletRequest request , Model model , RedirectAttributes redirectAttributes) throws Exception {
		
		service.signupKakao(request, model, redirectAttributes);
		
		return "redirect:signup_form";
	}

	@RequestMapping(value = "/sign_up_id_check", method = RequestMethod.POST)
	@ResponseBody
	public String signupIdCheck(HttpServletRequest request) throws Exception {

		return service.signupIdCheck(request) + "";

	}
	
	@RequestMapping(value = "/email", method = RequestMethod.POST)
	@ResponseBody
	public String emailCheck(HttpServletRequest request) throws Exception {

		return service.sendEmail(request) + "";

	}
	
	@RequestMapping(value = "/psbreeds_list", method = RequestMethod.GET)
	@ResponseBody
	public String psBreedsList(HttpServletRequest request) throws Exception {

		return service.psBreedsList(request);

	}
	
	@RequestMapping("/sign_up")
	public String signupClick(MultipartHttpServletRequest request, Model model, MultipartFile file) throws Exception {

		service.signup(request, model, file);
		
		return "login";

	}
	
	

}

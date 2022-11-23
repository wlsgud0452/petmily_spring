package com.petmily.customer.contoroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petmily.customer.dto.UserDTO;
import com.petmily.customer.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService service;

	HttpSession session;

	@RequestMapping("/login_page")
	public String loginPage() throws Exception {
		return "login";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) throws Exception {
		int result = service.login(request, model, session);

		if (result == 0) {
			return "login";
		} else if (result == 1) {
			return "redirect:home";
		} else {
			return "redirect:mypage_modify";
		}

	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model) throws Exception {
		session = request.getSession();
		session.invalidate();

		return "redirect:home";
	}
	
	@RequestMapping("/search_id")
	public String searchId() throws Exception {
		
		return "search_id";
	}
	
	@RequestMapping(value="/id_email", method = RequestMethod.POST)
	@ResponseBody
	public String signupIdCheck(HttpServletRequest request) throws Exception {

		return service.searchIdCheck(request);

	}
	
	@RequestMapping("/search_id_click")
	public String searchId(HttpServletRequest request) throws Exception {
		
		service.sendEmail(request);
		
		return "redirect:login_page";
	}
	
	@RequestMapping("/search_pw")
	public String searchPw() throws Exception {
		
		return "search_pw";
	}
	
	@RequestMapping(value="/pw_email", method = RequestMethod.POST)
	@ResponseBody
	public String signupPwCheck(HttpServletRequest request) throws Exception {

		return service.searchPwCheck(request);

	}
	
	@RequestMapping("/search_pw_click")
	public String searchPw(HttpServletRequest request) throws Exception {
		
		service.sendEmailPw(request);
		
		return "redirect:login_page";
	}
}

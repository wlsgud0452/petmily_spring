package com.petmily.customer.contoroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petmily.customer.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService service;

	@RequestMapping("/login_page")
	public String loginPage() throws Exception {
		return "login";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) throws Exception {
		int result = service.executeInt(request, model);

		if (result == 0) {
			return "redirect:home";
		} else {
			return "login";
		}

	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model) throws Exception {
		service.execute(request, model);
		
		return "redirect:home";
	}

}

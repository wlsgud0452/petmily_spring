package com.petmily.customer.contoroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		UserDTO dto = service.login(request, model , session);
		
		if (dto == null) {
			return "login";
		} else {
			session = request.getSession();
			session.setAttribute("user", dto);
			return "redirect:home";
		}

	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model) throws Exception {
		session = request.getSession();
		session.invalidate();
		
		return "redirect:home";
	}

}

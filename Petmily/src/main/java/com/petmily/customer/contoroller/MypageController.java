package com.petmily.customer.contoroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MypageController {
	
	
	@Autowired
	MypageService service;
	
	@RequestMapping("/mypage_modify")
	public String myPageModifyHome() {
		return "mypage_modify_login";
	}
	
	
	@RequestMapping("/mypage_modify_login")
	public String myPageModifyLogin(HttpServletRequest request) {
		int result = service.executeInt(request);
		
		if(result == 0) {
			return "redirect : mypage_modify_update";
		}else {
			return "mypage_modify_login";
		}
		
	}
	
	@RequestMapping("/mypage_modify_update")
	public String myPageModifyUdate(HttpServletRequest request , Model model) {
		
	}
	
}

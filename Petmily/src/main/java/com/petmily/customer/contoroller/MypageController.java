package com.petmily.customer.contoroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petmily.customer.service.MypageService;

@Controller
public class MypageController {
	
	
	@Autowired
	MypageService service;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/mypage_modify")
	public String myPageModifyHome() {
		return "mypage_modify_login";
	}
	
	
	@RequestMapping("/mypage_modify_login")
	public String myPageModifyLogin(HttpServletRequest request) throws Exception {
		session = request.getSession();
		int result = service.executeInt(request , session);
		
		if(result == 1) {
			return "redirect:mypage_modify_update";
		}else {
			return "mypage_modify_login";
		}
		
	}
	
	@RequestMapping("/mypage_modify_update")
	public String myPageModifyUdate(HttpServletRequest request , Model model) throws Exception {
		session = request.getSession();
		
		service.execute(request, model , session);
		
		return "mypage_modify";
	}
	
	@RequestMapping("/mypage_challenge")
	public String myPageChallenge(HttpServletRequest request, Model model) throws Exception {
		session = request.getSession();
		
		service.executeTwo(request, model, session);
		
		return "mypage_challenge";
	}
	
	@RequestMapping("/mypage_apply_list")
	public String myPageApplyList(HttpServletRequest request, Model model) throws Exception {
		session = request.getSession();
		
		service.executeThree(request, model, session);
		
		return "mypage_apply_list";
	}
	
}

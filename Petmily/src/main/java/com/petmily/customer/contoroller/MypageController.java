package com.petmily.customer.contoroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petmily.customer.service.MypageService;

@Controller
public class MypageController {
	
	
	@Autowired
	MypageService service;
	
	HttpSession session;
	
	@RequestMapping("/mypage_modify")
	public String myPageModifyHome() {
		return "mypage_modify_login";
	}
	
	
	@RequestMapping("/mypage_modify_login")
	public String myPageModifyLogin(HttpServletRequest request) throws Exception {
		session = request.getSession();
		int result = service.myPageModifyLogin(request , session);
		
		if(result == 1) {
			return "redirect:mypage_modify_update";
		}else {
			return "mypage_modify_login";
		}
		
	}
	
	@RequestMapping("/mypage_modify_update")
	public String myPageModifyUdate(HttpServletRequest request , Model model) throws Exception {
		session = request.getSession();
		
		service.myPageModifyUpdate(request, model , session);
		
		return "mypage_modify";
	}
	
	@RequestMapping("/mypage_challenge")
	public String myPageChallenge(HttpServletRequest request, Model model) throws Exception {
		session = request.getSession();
		
		service.myPageChallenge(request, model, session);
		
		return "mypage_challenge";
	}
	
	@RequestMapping("/mypage_apply_list")
	public String myPageApplyList(HttpServletRequest request, Model model) throws Exception {
		session = request.getSession();
		
		service.myPageApplyList(request, model, session);
		
		return "mypage_apply_list";
	}
	
	@RequestMapping("/apply_update")
	public String myPageApplyUpdate(HttpServletRequest request) throws Exception {
		service.myPageApplyUpdate(request);
		
		return "redirect:mypage_apply_list";
	}
	
	@RequestMapping("/apply_delete")
	public String myPageApplyDelete(HttpServletRequest request) throws Exception {
		service.myPageApplyDelete(request);
		
		return "redirect:mypage_apply_list";
	}
	
	@RequestMapping("/mypage_accept_list")
	public String myPageAcceptList(HttpServletRequest request, Model model , HttpSession session) throws Exception {
		session = request.getSession();
		
		service.myPageAcceptList(request, model, session);
		
		return "mypage_accept_list";
	}
	
	@RequestMapping("/mypage_accept_complete")
	public String myPageAcceptComplete(HttpServletRequest request, Model model) throws Exception {
		service.myPageAcceptComplete(request, model);
		
		return "mypage_review";
	}
	
	@RequestMapping("/review_insert")
	public String myPageReviewInsert(HttpServletRequest request, HttpSession session , RedirectAttributes  redirectAttributes) throws Exception {
		session = request.getSession();
		
		service.myPageReviewInsert(request, session , redirectAttributes);
		
		return "redirect:mypage_participate_list";
	}
	
	@RequestMapping("/mypage_accepted_list")
	public String myPageAcceptedlist(HttpServletRequest request, Model model , HttpSession session) throws Exception {
		session = request.getSession();
		
		service.myPageAcceptedList(request, model, session);
		
		return "mypage_accepted_list";
	}
	
	@RequestMapping("/mypage_accepted_complete")
	public String myPageAcceptedComplete(HttpServletRequest request, Model model) throws Exception {
		service.myPageAcceptedComplete(request, model);
		
		return "mypage_review";
	}
	
	@RequestMapping("/mypage_write_list")
	public String myPageWriteList(HttpServletRequest request, Model model , HttpSession session) throws Exception {
		session = request.getSession();
		
		service.myPageWriteList(request, model, session);
		
		return "mypage_write_list";
	}
	
	@RequestMapping("/mypage_participate_list")
	public String myPageParticipateList(HttpServletRequest request, Model model , HttpSession session) throws Exception {
		session = request.getSession();
		
		service.myPageParticipateList(request, model, session);
		
		return "mypage_participate_list";
	}
	
}

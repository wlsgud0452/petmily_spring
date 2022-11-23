package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface MypageService {
	
	public int myPageModifyLogin(HttpServletRequest request ,HttpSession session) throws Exception;
	
	public void myPageModifyUpdate(HttpServletRequest request, Model model ,HttpSession session) throws Exception;
	
	public void myPageChallenge(HttpServletRequest request, Model model ,HttpSession session) throws Exception;
	
	public void myPageApplyList(HttpServletRequest request, Model model ,HttpSession session) throws Exception;
	
	public void myPageApplyUpdate(HttpServletRequest request) throws Exception;
	
	public void myPageApplyDelete(HttpServletRequest request) throws Exception;
	
	public void myPageAcceptList(HttpServletRequest request, Model model ,HttpSession session) throws Exception;
	
	public void myPageAcceptComplete(HttpServletRequest request, Model model) throws Exception;
	
	public void myPageReviewInsert(HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes) throws Exception;
	
	public void myPageAcceptedList(HttpServletRequest request, Model model ,HttpSession session) throws Exception;
	
	public void myPageAcceptedComplete(HttpServletRequest request, Model model) throws Exception;
	
	public void myPageWriteList(HttpServletRequest request, Model model , HttpSession session) throws Exception;

	public void myPageParticipateList(HttpServletRequest request, Model model , HttpSession session) throws Exception;
}

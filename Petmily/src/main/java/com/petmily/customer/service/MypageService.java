package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface MypageService {
	
	public int myPageModifyLogin(HttpServletRequest request ,HttpSession session) throws Exception;
	public void myPageModifyUpdate(HttpServletRequest request, Model model ,HttpSession session) throws Exception;
	public void myPageChallenge(HttpServletRequest request, Model model ,HttpSession session) throws Exception;
	public void myPageApplyList(HttpServletRequest request, Model model ,HttpSession session) throws Exception;
	public void myPageApplyUpdate(HttpServletRequest request) throws Exception;
	public void myPageApplyDelete(HttpServletRequest request) throws Exception;
	
}

package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface LoginService {
	public int login(HttpServletRequest request, Model model , HttpSession session) throws Exception;
	
	public String searchIdCheck(HttpServletRequest request) throws Exception;
	
	public void sendEmail(HttpServletRequest request) throws Exception;
	
public String searchPwCheck(HttpServletRequest request) throws Exception;
	
	public void sendEmailPw(HttpServletRequest request) throws Exception;
}

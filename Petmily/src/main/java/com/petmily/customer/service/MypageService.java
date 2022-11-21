package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface MypageService {
	
	public int executeInt(HttpServletRequest request ,HttpSession session) throws Exception;
	public void execute(HttpServletRequest request, Model model ,HttpSession session) throws Exception;
	public void executeTwo(HttpServletRequest request, Model model ,HttpSession session) throws Exception;
	public void executeThree(HttpServletRequest request, Model model ,HttpSession session) throws Exception;
	
}

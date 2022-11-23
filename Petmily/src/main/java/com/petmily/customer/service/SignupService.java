package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface SignupService {
	
	public void signupKakao(HttpServletRequest request , Model model , RedirectAttributes redirectAttributes) throws Exception;
	
	public void signup(MultipartHttpServletRequest request, Model model , MultipartFile file) throws Exception;
	
	public int signupIdCheck(HttpServletRequest request) throws Exception;
	
	public String psBreedsList(HttpServletRequest request) throws Exception;
	
	public int sendEmail(HttpServletRequest request) throws Exception;
}

package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface SignupService {
	public void execute(MultipartHttpServletRequest request, Model model , MultipartFile file) throws Exception;
	public int executeTwo(HttpServletRequest request) throws Exception;
	public String executeThree(HttpServletRequest request) throws Exception;
}

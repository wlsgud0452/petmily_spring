package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface SignupService {
	public int executeInt(HttpServletRequest request, Model model) throws Exception;
}

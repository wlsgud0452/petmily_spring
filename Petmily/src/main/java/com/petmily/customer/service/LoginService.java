package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.petmily.customer.dto.UserDTO;

public interface LoginService {
	public UserDTO login(HttpServletRequest request, Model model) throws Exception;
}

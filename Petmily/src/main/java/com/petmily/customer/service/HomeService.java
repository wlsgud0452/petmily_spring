package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface HomeService {
	public void homeSlideOne(HttpServletRequest request, Model model) throws Exception;
}

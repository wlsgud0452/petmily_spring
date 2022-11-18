package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface CustomerService {
	public void execute(HttpServletRequest request, Model model);
	public int executeInt(HttpServletRequest request, Model model);
}

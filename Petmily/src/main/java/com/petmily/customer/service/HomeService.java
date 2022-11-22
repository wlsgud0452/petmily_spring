package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface HomeService {
	public void homeSlideOne(HttpServletRequest request, Model model ) throws Exception;
}

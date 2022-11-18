package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface PetDictionaryCardService {
	
	public void excute(HttpServletRequest request, Model model) throws Exception;

}

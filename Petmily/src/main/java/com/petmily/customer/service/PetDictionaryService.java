package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface PetDictionaryService {
	
	public void petDictionaryCard(HttpServletRequest request, Model model) throws Exception;
	
	public void petDictinaryDetail(HttpServletRequest request, Model model) throws Exception;

}

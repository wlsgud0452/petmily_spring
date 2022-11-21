package com.petmily.customer.contoroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petmily.customer.service.PetDictionaryService;

@Controller
public class PetDictionaryController {
	
	@Autowired
	PetDictionaryService service;
	
	@RequestMapping("/pet_dictionary_card")
	public String PetDictionaryCard(HttpServletRequest request, Model model) throws Exception{
		
		service.petDictionaryCard(request,model);
		
		return "pet_dictionary";
	}
	
	
	@RequestMapping("pet_dictionary_detail")
	 public String PetDictinaryDetail(HttpServletRequest request, Model model) throws Exception{
		 
		service.petDictinaryDetail(request, model);
		 
		 return "pet_dictionary";
	 }
	
	
	

}

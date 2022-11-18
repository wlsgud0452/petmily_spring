package com.petmily.customer.contoroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petmily.customer.service.PetDictinaryDetailService;
import com.petmily.customer.service.PetDictionaryCardService;

@Controller
public class PetDictionaryController {
	
	@Autowired
	PetDictionaryCardService cardService;
	
	@RequestMapping("/pet_dictionary_card")
	public String PetDictionaryCard(HttpServletRequest request, Model model) throws Exception{
		
		cardService.excute(request,model);
		
		return "pet_dictionary";
	}
	
	@Autowired
	PetDictinaryDetailService detailService;
	
	@RequestMapping("pet_dictionary_detail")
	 public String PetDictinaryDetail(HttpServletRequest request, Model model) throws Exception{
		 
		detailService.excute(request, model);
		 
		 return "pet_dictionary";
	 }
	
	
	

}

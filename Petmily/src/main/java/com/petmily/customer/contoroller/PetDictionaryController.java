package com.petmily.customer.contoroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petmily.customer.dao.PetspecDAO;

@Controller
public class PetDictionaryController {
	
	
	@RequestMapping("pet_dictionary_card")
	public String PetDictionaryCard(HttpServletRequest request, Model model) throws Exception{
		
		//service.excute(request,model);
		
		return "pet_dictionary";
	}

}

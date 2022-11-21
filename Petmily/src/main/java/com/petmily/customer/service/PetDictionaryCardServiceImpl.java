package com.petmily.customer.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.petmily.customer.dao.PetspecDAO;
import com.petmily.customer.dto.PetspecDTO;

@Service
public class PetDictionaryCardServiceImpl implements PetDictionaryCardService {
	
	@Autowired
	PetspecDAO petspecDAO;
	
	@Override
	public void excute(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		String pstype = request.getParameter("pstype");
		List<PetspecDTO> dto = petspecDAO.petSpecList(pstype);
		
		model.addAttribute("petList", dto); 
		model.addAttribute("content_viewpage", "pet_dictionary_card.jsp");
	}

}
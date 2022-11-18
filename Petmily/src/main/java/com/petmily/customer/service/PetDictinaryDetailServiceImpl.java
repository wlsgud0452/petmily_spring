package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.petmily.customer.dao.PetspecDAO;

@Service
public class PetDictinaryDetailServiceImpl implements PetDictinaryDetailService {
	
	@Autowired
	PetspecDAO petspecDAO;
	
	@Override
	public void excute(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		String psbreeds = request.getParameter("psbreeds");
		
		String pscontent = petspecDAO.pscontent(psbreeds);
		
		model.addAttribute("pscontent", pscontent);
		model.addAttribute("content_viewpage", "pet_dictionary_detail.jsp");
		
		
	}

}

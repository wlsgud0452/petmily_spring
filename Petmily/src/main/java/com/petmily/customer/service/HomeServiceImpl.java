package com.petmily.customer.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.petmily.customer.dao.PetspecDAO;
import com.petmily.customer.dto.PetspecDTO;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	PetspecDAO petspecDAO;

	@Override
	public void execute(HttpServletRequest request, Model model) throws Exception{
		
		String pstype = request.getParameter("pstype");
		
		if(pstype == null || pstype.equals("")) {
			pstype = "dog";
		}
		
		List<PetspecDTO> dto = petspecDAO.petSpecListFour(pstype);
		
		model.addAttribute("specList",dto);

	}


}

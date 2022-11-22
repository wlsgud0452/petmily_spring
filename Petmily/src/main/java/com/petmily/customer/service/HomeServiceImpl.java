package com.petmily.customer.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.google.gson.Gson;
import com.petmily.customer.dao.AbandonedDAO;
import com.petmily.customer.dao.PetspecDAO;
import com.petmily.customer.dto.PetspecDTO;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	PetspecDAO petspecDAO;
	
	@Autowired
	AbandonedDAO abandonedDAO;


	@Override
	public void homeSlideOne(HttpServletRequest request, Model model ) throws Exception{
		
		String pstype = request.getParameter("pstype");
				
		if(pstype == null || pstype.equals("")) {
			pstype = "dog";
		}
		
		List<PetspecDTO> dto = petspecDAO.petSpecListFour(pstype);
		
		model.addAttribute("specList",dto);

	}

	@Override
	public void homeSlideTwo(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		
		Gson gsonObj = new Gson();
		List<Map<Integer,Integer>> list = abandonedDAO.chart();
		
		String dataPoints = gsonObj.toJson(list);
		
		model.addAttribute("dataPoints", dataPoints);
	}
	
	@Override
	public void homeSlideThree(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		Gson gsonObj = new Gson();
		List<Map<Integer,Double>> list = abandonedDAO.ratio();
		
		String euthanasiaRatio = gsonObj.toJson(list);
		
		model.addAttribute("euthanasiaRatio", euthanasiaRatio);
	}
}

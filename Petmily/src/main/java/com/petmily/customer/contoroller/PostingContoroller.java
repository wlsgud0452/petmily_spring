package com.petmily.customer.contoroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petmily.customer.service.PostingService;

@Controller
public class PostingContoroller {

	@Autowired
	PostingService postingService;
	
	@RequestMapping("/posting")
	public String posting (HttpServletRequest request,Model model) throws Exception{
		
		postingService.excute(request,model);
		
		return "board_list";
	}
	
	
}

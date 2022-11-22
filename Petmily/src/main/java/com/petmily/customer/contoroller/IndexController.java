package com.petmily.customer.contoroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petmily.customer.service.HomeService;

@Controller
public class IndexController {
	
	@Autowired
	HomeService service;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request, Model model ) throws Exception{
		
		service.homeSlideOne(request, model );
		
		return "home";
	}
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request, Model model  ) throws Exception{
		
		service.homeSlideOne(request, model);
		
		return "home";
	}
	
	
}

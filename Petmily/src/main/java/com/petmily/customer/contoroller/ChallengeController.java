package com.petmily.customer.contoroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petmily.customer.service.LectureCheckService;

@Controller
public class ChallengeController {

	@Autowired
	LectureCheckService service;
	
	@RequestMapping("/challenge")
	public String challenge() throws Exception {
		
		return "challenge";
	}
	
	@RequestMapping("/lecture_check")
	public String lecture_check(HttpServletRequest request, Model model) throws Exception {
		
		service.execute(request, model);
		
		return "lecture_check";
	}
}

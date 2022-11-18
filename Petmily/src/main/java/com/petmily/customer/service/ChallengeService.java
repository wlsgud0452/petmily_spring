package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface ChallengeService {
	public void execute(HttpServletRequest request, Model model) throws Exception;
}

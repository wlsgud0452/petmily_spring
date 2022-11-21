package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.petmily.customer.dao.UserDAO;
import com.petmily.customer.dto.UserDTO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	public UserDTO executeDTO(HttpServletRequest request, Model model) throws Exception {
		
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		int result = userDAO.userPwCheck(uid, upw);
		
		if(result == 1) {
			UserDTO dto = userDAO.login(uid, upw);			
			return dto;
		}else {
			model.addAttribute("loginStatus", "아이디 및 비밀번호를 확인해 주세요");
			return null;
		}
	}
	
}

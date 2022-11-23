package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public UserDTO login(HttpServletRequest request, Model model , HttpSession session) throws Exception {
		session = request.getSession();
		
		String uid = "";
		String upw = "";
		
		if(session.getAttribute("user") == null) {
			 uid = request.getParameter("uid");
			 upw = request.getParameter("upw");
		}else {
			UserDTO userDTO = (UserDTO) session.getAttribute("user");
			uid = userDTO.getUid();
			upw = userDTO.getUpw();
		}
		
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

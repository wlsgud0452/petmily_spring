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
	public void execute(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int executeInt(HttpServletRequest request, Model model) throws Exception {
		
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		int result = userDAO.userPwCheck(uid, upw);
		
		if(result == 1) {
			UserDTO dto = userDAO.login(uid, upw);			
			HttpSession session = request.getSession();
			session.setAttribute("user", dto);
			return 0;
		}else {
			model.addAttribute("loginStatus", "아이디 및 비밀번호를 확인해 주세요");
			return 1;
		}
	}
	
}

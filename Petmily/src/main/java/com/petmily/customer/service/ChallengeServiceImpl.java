package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.petmily.customer.dao.LecturecheckDAO;
import com.petmily.customer.dto.UserDTO;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Autowired 
	LecturecheckDAO lecturecheckDAO;
	
	@Override
	public void execute(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		String categoryNum = request.getParameter("category_num");
		
		// session에서 user.uid
		HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("user");
		String uid = user.getUid();
	
		lecturecheckDAO.insertLecture(uid, categoryNum);
	}

}

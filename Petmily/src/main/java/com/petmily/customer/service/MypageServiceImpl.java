package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.petmily.customer.dao.ApplyDAO;
import com.petmily.customer.dao.LecturecheckDAO;
import com.petmily.customer.dao.UserDAO;
import com.petmily.customer.dto.UserDTO;

@Service
public class MypageServiceImpl implements MypageService {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	LecturecheckDAO lecturecheckDAO;
	
	@Autowired
	ApplyDAO applyDAO;
	
	@Override
	public int executeInt(HttpServletRequest request , HttpSession session) throws Exception {
		UserDTO udto = (UserDTO) session.getAttribute("user");
		String uid = udto.getUid();
		
		String upw = request.getParameter("upw");
		
		int result = 0;
		
		result = userDAO.userPwCheck(uid, upw);
		
		if(result == 1) {
			return 1;
		}else {
			return 0;
		}
		
	}

	@Override
	public void execute(HttpServletRequest request, Model model , HttpSession session) throws Exception {
		UserDTO udto = (UserDTO)session.getAttribute("user");
		String uid = udto.getUid();
		
		UserDTO userdto = userDAO.userInfo(uid);
		
		model.addAttribute("uid", uid);
		model.addAttribute("userInfo", userdto);
	}
	
	@Override
	public void executeTwo(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		UserDTO user = (UserDTO) session.getAttribute("user");
		String uid = user.getUid();


		int chapterOne = lecturecheckDAO.selectChapterOne(uid);
		int chapterTwo = lecturecheckDAO.selectChapterTwo(uid);
		int chapterThree = lecturecheckDAO.selectChapterThree(uid);

		int checkChapter = 0;
		if (chapterOne == 2) {
			checkChapter++;
		}

		if (chapterTwo >= 6) {
			checkChapter++;
		}

		if (chapterThree >= 3) {
			checkChapter++;
		}
		// 도전 과제 수행 했는지 안했는지
		model.addAttribute("checkChapter", checkChapter);


		// 같이 산책 completedate 찍힌 거 가져오기
		String pcategory = "walk";
		int countWalk = applyDAO.selectCategory(uid, pcategory);

		int checkWalk = 0;

		if (countWalk >= 3) {
			checkWalk++;
		}

		if (countWalk >= 5) {
			checkWalk++;
		}

		if (countWalk >= 10) {
			checkWalk++;
		}

		model.addAttribute("checkWalk", checkWalk);

		// 같이 펫카페 completedate 찍힌 거 가져오기
		pcategory = "petcafe";
		int countPetcafe = applyDAO.selectCategory(uid, pcategory);

		int checkPetcafe = 0;

		if (countPetcafe >= 3) {
			checkPetcafe++;
		}

		if (countPetcafe >= 5) {
			checkPetcafe++;
		}

		if (countPetcafe >= 10) {
			checkPetcafe++;
		}

		model.addAttribute("checkPetcafe", checkPetcafe);
		
		// 같이 봉사 completedate 찍힌 거 가져오기
		pcategory = "volunteer";
		int countVolunteer = applyDAO.selectCategory(uid, pcategory);
		
		int checkVolunteer = 0;

		if (countVolunteer >= 3) {
			checkVolunteer++;
		}

		if (countVolunteer >= 5) {
			checkVolunteer++;
		}

		if (countVolunteer >= 10) {
			checkVolunteer++;
		}

		request.setAttribute("checkVolunteer", checkVolunteer);
		// 찾아주세요 completedate 찍힌 거 가져오기
		pcategory = "find";
		int countFind = applyDAO.selectCategory(uid, pcategory);
		
		int checkFind = 0;

		if (countFind >= 3) {
			checkFind++;
		}

		if (countFind >= 5) {
			checkFind++;
		}

		if (countFind >= 10) {
			checkFind++;
		}

		model.addAttribute("checkFind", checkFind);
		
		// 찾았어요 completedate 찍힌 거 가져오기
		pcategory = "found";
		int countFound = applyDAO.selectCategory(uid, pcategory);
		
		int checkFound = 0;

		if (countFound >= 3) {
			checkFound++;
		}

		if (countFound >= 5) {
			checkFound++;
		}

		if (countFound >= 10) {
			checkFound++;
		}

		model.addAttribute("checkFound", checkFound);
	}
	
	@Override
	public void executeThree(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

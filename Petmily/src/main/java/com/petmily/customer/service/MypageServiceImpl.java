package com.petmily.customer.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petmily.customer.dao.ApplyDAO;
import com.petmily.customer.dao.LecturecheckDAO;
import com.petmily.customer.dao.PostingDAO;
import com.petmily.customer.dao.ReviewDAO;
import com.petmily.customer.dao.ShowDAO;
import com.petmily.customer.dao.UserDAO;
import com.petmily.customer.dto.ApplyDTO;
import com.petmily.customer.dto.PagingDTO;
import com.petmily.customer.dto.PostingDTO;
import com.petmily.customer.dto.ReviewDTO;
import com.petmily.customer.dto.UserDTO;

@Service
public class MypageServiceImpl implements MypageService {

	@Autowired
	UserDAO userDAO;

	@Autowired
	LecturecheckDAO lecturecheckDAO;

	@Autowired
	ApplyDAO applyDAO;

	@Autowired
	ReviewDAO reviewDAO;

	@Autowired
	PostingDAO postingDAO;

	@Autowired
	ShowDAO showDAO;

	@Override
	public int myPageModifyLogin(HttpServletRequest request, HttpSession session) throws Exception {
		UserDTO udto = (UserDTO) session.getAttribute("user");
		String uid = udto.getUid();

		String upw = request.getParameter("upw");

		int result = 0;

		result = userDAO.userPwCheck(uid, upw);

		if (result == 1) {
			return 1;
		} else {
			return 0;
		}

	}

	@Override
	public void myPageModifyUpdate(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		UserDTO udto = (UserDTO) session.getAttribute("user");
		String uid = udto.getUid();

		UserDTO userdto = userDAO.userInfo(uid);

		model.addAttribute("uid", uid);
		model.addAttribute("userInfo", userdto);
	}

	@Override
	public void myPageModifyUpdateComplete(MultipartHttpServletRequest request, Model model, MultipartFile file , HttpSession session)
			throws Exception {
		
		String uid = request.getParameter("uid");
		// uname
		String uname = request.getParameter("uname");
		// unickname
		String unickname = request.getParameter("unickname");
		// uemail
		String uemail = request.getParameter("uemail");
		// uphone
		String uphone = request.getParameter("uphone");
		// uaddress_basic
		String uaddress_basic = request.getParameter("uaddress_basic");
		// uaddress_detail
		String uaddress_detail = request.getParameter("uaddress_detail");

		userDAO.updateUser(uid, uname, unickname, uemail, uphone, uaddress_basic, uaddress_detail);

		// TODO Auto-generated method stub
		String uimage = request.getParameter("uimage");


		file = request.getFile("file");
		// ?????? ???????????? ?????? [S]
		// ?????? ??????
		if (!file.isEmpty()) {

			String path = System.getProperty("user.dir") + "//src//main//webapp//user";
			File oldFile = new File(path + uimage);
			oldFile.delete();

			// ????????? uid??? ????????? ?????? ????????????
			// ????????? ????????????
			String originalName = file.getOriginalFilename();
			String extension = originalName.substring(originalName.indexOf("."), originalName.length());

			// ?????? ?????? ??????
			uimage = uid + extension;
			
			userDAO.updateUimage(uid, uimage);
			// ????????? "name" ?????? saveFile??? ?????? ??? ???????????? ????????? ??????.
			File saveFile = new File(path, uimage);
			// file??? saveFile????????? path??? ????????? ??????
			file.transferTo(saveFile);
			// [E]
		}
		
		UserDTO udto = userDAO.userInfo(uid);

	}

	@Override
	public void myPageChallenge(HttpServletRequest request, Model model, HttpSession session) throws Exception {
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
		// ?????? ?????? ?????? ????????? ????????????
		model.addAttribute("checkChapter", checkChapter);

		// ?????? ?????? completedate ?????? ??? ????????????
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

		// ?????? ????????? completedate ?????? ??? ????????????
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

		// ?????? ?????? completedate ?????? ??? ????????????
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
		// ??????????????? completedate ?????? ??? ????????????
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

		// ???????????? completedate ?????? ??? ????????????
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
	public void myPageApplyList(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		UserDTO udto = (UserDTO) session.getAttribute("user");
		String uid = udto.getUid();

		int cPage = 0;
		int pageLength = 5;
		int totalRows = 0;
		int rowLength = 5;

		String tempPage = request.getParameter("page");

		if (tempPage == null || tempPage.length() == 0) {
			cPage = 1;
		}
		try {
			cPage = Integer.parseInt(tempPage);
		} catch (Exception e) {
			cPage = 1;
		}

		totalRows = applyDAO.applyListRow(uid);
		PagingDTO dto = new PagingDTO(cPage, totalRows, pageLength);
		int start = (cPage - 1) * rowLength;
		List<ApplyDTO> dtos = applyDAO.applyGetList(rowLength, start, uid);
		List<UserDTO> udtos = new ArrayList<>();
		Integer userRating = null;

		// uid??? ????????? ?????? uid ????????? ??????????????????.
		for (ApplyDTO list : dtos) {
			String apply_uid = list.getUser_uid();
			UserDTO udto2 = userDAO.userInfo(apply_uid);
			userRating = reviewDAO.selectRating(apply_uid);
			if (userRating == null) {
				userRating = 5;
			}
			udtos.add(udto2);
		}

		model.addAttribute("paging", dto);
		model.addAttribute("applyList", dtos);
		model.addAttribute("applyUserInfoList", udtos);
		model.addAttribute("userRating", userRating);

	}

	@Override
	public void myPageApplyUpdate(HttpServletRequest request) throws Exception {
		String index = request.getParameter("index");
		String[] apidArr = request.getParameterValues("apid");
		String[] pidArr = request.getParameterValues("posting_pid");

		// index??? ?????? apid?????? ?????? ??? ????????? ????????????
		String apid = apidArr[Integer.parseInt(index)];
		String pid = pidArr[Integer.parseInt(index)];

		String columnname = "";

		// ?????? ?????? ??????????????? ?????? ???????????? ????????? ?????? ???????????? ??????
		columnname = "apmatchingdate";
		// ????????? ???

		applyDAO.updateByApId(Integer.parseInt(apid), columnname);
		applyDAO.updateByPId(Integer.parseInt(pid));
		postingDAO.postingDelete(Integer.parseInt(pid));
	}

	@Override
	public void myPageApplyDelete(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String index = request.getParameter("index");
		String[] apidArr = request.getParameterValues("apid");

		// index??? ?????? apid?????? ?????? ??? ????????? ????????????
		String apid = apidArr[Integer.parseInt(index)];

		String columnname = "";

		// ?????? ?????? ??????????????? ?????? ???????????? ????????? ?????? ???????????? ??????
		// ?????? ????????? ???????????? ???
		columnname = "apcanceldate";

		// review table??? ?????? ????????????
		applyDAO.updateByApId(Integer.parseInt(apid), columnname);
	}

	@Override
	public void myPageAcceptList(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		UserDTO udto = (UserDTO) session.getAttribute("user");
		String uid = udto.getUid();

		int cPage = 0;
		int pageLength = 5;
		int totalRows = 0;
		int rowLength = 5;
		String tempPage = request.getParameter("page");

		if (tempPage == null || tempPage.length() == 0) {
			cPage = 1;
		}
		try {
			cPage = Integer.parseInt(tempPage);
		} catch (Exception e) {
			cPage = 1;
		}
		// paging ??? ????????? ????????? [S]
		totalRows = applyDAO.acceptListRow(uid);
		PagingDTO dto = new PagingDTO(cPage, totalRows, pageLength);
		int start = (cPage - 1) * rowLength;
		// [E]
		List<Integer> acceptApidList = applyDAO.acceptApidList(uid);
		List<PostingDTO> acceptPostingList = postingDAO.acceptPostingList(uid, rowLength, start);

		model.addAttribute("paging", dto);
		model.addAttribute("acceptList", acceptPostingList);
		model.addAttribute("apidList", acceptApidList);

	}

	@Override
	public void myPageAcceptComplete(HttpServletRequest request, Model model) throws Exception {
		// apid , posting_user_uid , posting_pid ??? ???????????? ??????.
		String[] apidArr = request.getParameterValues("apid");
		String index = request.getParameter("index");
		String apid = apidArr[Integer.parseInt(index)];
		String posting_user_uid = request.getParameter("posting_user_uid");
		String posting_pid = request.getParameter("posting_pid");

		// apid??? apcompletedate??? ?????? ?????? ????????? ???????????? ??????.
		String columnname = "apcompletedate_request";
		applyDAO.updateByApId(Integer.parseInt(apid), columnname);

		// review ?????? ???????????? ????????? posting_user??? uimage??? ????????????.
		String posting_user_uimage = userDAO.selectUimage(posting_user_uid);

		// review ???????????? ?????? ????????????????????? ?????????
		// posting_user_uid ??? posting_pid ?????? ????????????.
		model.addAttribute("to_uid", posting_user_uid);
		model.addAttribute("posting_pid", posting_pid);
		model.addAttribute("to_uimage", posting_user_uimage);

	}

	@Override
	public void myPageReviewInsert(HttpServletRequest request, HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		String revtext = request.getParameter("content");
		String revrating = request.getParameter("reviewStar");

		UserDTO user = (UserDTO) session.getAttribute("user");
		String from_uid = user.getUid();
		String posting_pid = request.getParameter("posting_pid");
		String to_uid = request.getParameter("to_uid");

		reviewDAO.insert(revtext, Integer.parseInt(revrating) * 2, from_uid, posting_pid, to_uid);

		redirectAttributes.addAttribute("page", 1);

	}

	@Override
	public void myPageAcceptedList(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		UserDTO udto = (UserDTO) session.getAttribute("user");
		String uid = udto.getUid();

		int cPage = 0;
		int pageLength = 5;
		int totalRows = 0;
		int rowLength = 5;

		String tempPage = request.getParameter("page");

		if (tempPage == null || tempPage.length() == 0) {
			cPage = 1;
		}
		try {
			cPage = Integer.parseInt(tempPage);
		} catch (Exception e) {
			cPage = 1;
		}

		totalRows = applyDAO.acceptedListRow(uid);

		PagingDTO dto = new PagingDTO(cPage, totalRows, pageLength);
		int start = (cPage - 1) * rowLength;

		List<ApplyDTO> dtos = applyDAO.acceptedGetList(rowLength, start, uid);
		List<UserDTO> udtos = new ArrayList<>();
		Integer userRating = null;

		// uid??? ????????? ?????? uid ????????? ??????????????????.
		for (ApplyDTO list : dtos) {
			String apply_uid = list.getUser_uid();
			UserDTO udto2 = userDAO.userInfo(apply_uid);
			userRating = reviewDAO.selectRating(apply_uid);
			if (userRating == null) {
				// ?????? ????????? ?????? ????????? ?????? 5??? ??????. ??????
				userRating = 5;
			}
			udtos.add(udto2);
		}

		model.addAttribute("paging", dto);
		model.addAttribute("acceptedList", dtos);
		model.addAttribute("acceptedUserInfoList", udtos);
		model.addAttribute("userRating", userRating);

	}

	@Override
	public void myPageAcceptedComplete(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		// apid , posting_user_uid , posting_pid ??? ???????????? ??????.
		String[] apidArr = request.getParameterValues("apid");
		String index = request.getParameter("index");
		String apid = apidArr[Integer.parseInt(index)];
		String user_uid = request.getParameter("user_uid");
		String posting_pid = request.getParameter("posting_pid");

		// apid??? apcompletedate??? ?????? ?????? ????????? ???????????? ??????.
		String columnname = "apcompletedate_response";
		applyDAO.updateByApId(Integer.parseInt(apid), columnname);

		// review ?????? ???????????? ????????? posting_user??? uimage??? ????????????.
		String posting_user_uimage = userDAO.selectUimage(user_uid);

		// review ???????????? ?????? ????????????????????? ?????????
		// posting_user_uid ??? posting_pid ?????? ????????????.
		model.addAttribute("to_uid", user_uid);
		model.addAttribute("posting_pid", posting_pid);
		model.addAttribute("to_uimage", posting_user_uimage);

	}

	@Override
	public void myPageWriteList(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		int cPage = 0;
		int pageLength = 5;
		int totalRows = 0;
		int rowLength = 5;
		UserDTO udto = (UserDTO) session.getAttribute("user");
		String uid = udto.getUid();
		String tempPage = request.getParameter("page");
		String pcategory_temp1 = request.getParameter("pcategory");
		String pcategory_temp2 = (String) request.getAttribute("pcategory");
		String pcategory = "";

		String option = request.getParameter("option");
		String query = request.getParameter("query");

		if (pcategory_temp1 == null || pcategory_temp1.equals("")) {
			pcategory = pcategory_temp2;
		}

		if (pcategory_temp2 == null || pcategory_temp2.equals("")) {
			pcategory = pcategory_temp1;
		}

		if (option == null) {
			option = "ptitle";
		}
		if (query == null) {
			query = "";
		}

		if (tempPage == null || tempPage.length() == 0) {
			cPage = 1;
		}
		try {
			cPage = Integer.parseInt(tempPage);
		} catch (Exception e) {
			cPage = 1;
		}

		totalRows = postingDAO.postingWriteListRow(uid, pcategory);
		PagingDTO dto = new PagingDTO(cPage, totalRows, pageLength);
		int start = (cPage - 1) * rowLength;

		List<PostingDTO> dtos = postingDAO.postingMypageWriteList(start, rowLength, uid, option, pcategory, query);

		List<Integer> showList = new ArrayList<>();
		List<Integer> likeList = new ArrayList<>();
		for (PostingDTO pdto : dtos) {
			int pid = pdto.getPid();
			int like = showDAO.showLikeAllCount(pid);
			int show = showDAO.showViewAllCount(pid);

			showList.add(show);
			likeList.add(like);

		}

		model.addAttribute("showList", showList);
		model.addAttribute("likeList", likeList);
		model.addAttribute("paging", dto);
		model.addAttribute("postingList", dtos);

	}

	@Override
	public void myPageParticipateList(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		int cPage = 0;
		int pageLength = 5;
		int totalRows = 0;
		int rowLength = 5;
		UserDTO udto = (UserDTO) session.getAttribute("user");
		String uid = udto.getUid();
		String tempPage = request.getParameter("page");
		String pcategory_temp1 = request.getParameter("pcategory");
		String pcategory_temp2 = (String) request.getAttribute("pcategory");
		String pcategory = "";

		String option = request.getParameter("option");
		String query = request.getParameter("query");

		if (pcategory_temp1 == null || pcategory_temp1.equals("")) {
			pcategory = pcategory_temp2;
		}

		if (pcategory_temp2 == null || pcategory_temp2.equals("")) {
			pcategory = pcategory_temp1;
		}

		if (option == null) {
			option = "ptitle";
		}
		if (query == null) {
			query = "";
		}

		if (tempPage == null || tempPage.length() == 0) {
			cPage = 1;
		}
		try {
			cPage = Integer.parseInt(tempPage);
		} catch (Exception e) {
			cPage = 1;
		}

		List<Integer> pidList = applyDAO.completePId(uid);

		System.out.println(pidList.size());

		totalRows = reviewDAO.selectCountReview(pidList, uid);

		System.out.println(totalRows);

		PagingDTO dto = new PagingDTO(cPage, totalRows, pageLength);
		int start = (cPage - 1) * rowLength;

		// ??? pidList??? review list??? ???????????? ?????????
		// ??? ??? to_uid ??? ???????????? ???????????? ??????. ????????? paging??? ?????? limit??? ?????? ??????.
		List<ReviewDTO> dtos = reviewDAO.selectReview(pidList, uid, start, rowLength);

		model.addAttribute("paging", dto);
		model.addAttribute("reviewList", dtos);
	}
}

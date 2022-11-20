package com.petmily.customer.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.petmily.customer.dao.ChooseDAO;
import com.petmily.customer.dao.PetDAO;
import com.petmily.customer.dao.PetspecDAO;
import com.petmily.customer.dao.UserDAO;
import com.petmily.customer.dto.ChooseDTO;
import com.petmily.customer.dto.PetDTO;

@Service
public class SignUpServiceImpl implements SignupService {

	@Autowired
	UserDAO userDAO;

	@Autowired
	PetDAO petDAO;

	@Autowired
	PetspecDAO petspecDAO;

	@Autowired
	ChooseDAO chooseDAO;

	@Override
	public void execute(MultipartHttpServletRequest request, Model model, MultipartFile file) throws Exception {
		String uimage = "";
		String uid = "";

		// 파일 저장하는 방법 [S]
		// 패스 지정
		if (!(file == null)) {
			String path = System.getProperty("user.dir") + "//src//main//resources//static//user";

			// 파일을 uid로 만들기 위한 기초단계
			uid = request.getParameter("uid");
			// 확장자 가져오기
			String originalName = file.getOriginalFilename();
			String extension = originalName.substring(originalName.indexOf("."), originalName.length());

			// 파일 네임 짓기
			uimage = uid + extension;
			// 패스에 "name" 으로 saveFile을 만들 빈 껍데기를 생성해 준다.
			File saveFile = new File(path, uimage);
			// file을 saveFile이름과 path로 지어서 넣기
			file.transferTo(saveFile);
			// [E]
		}

		// 넣어줄 parameter 값들 가져오기
		// user 테이블에 넣어줘야 될 값들
		// uid -> 파일에 넣으려고 선언한 uid 값 가져오면 됨
		// upw
		String upw = request.getParameter("upw");
		// uname
		String uname = request.getParameter("uname");
		// unickname
		String unickname = request.getParameter("unickname");
		// uemail
		String uemail = request.getParameter("uemail");
		// uphone
		String uphone = request.getParameter("uphone");
		// uaddress
		// uaddress_basic
		String uaddress_basic = request.getParameter("uaddress_basic");
		// uaddress_detail
		String uaddress_detail = request.getParameter("uaddress_detail");
		String uaddress = uaddress_basic + " " + uaddress_detail;
		// utype
		String utype = request.getParameter("utype");
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// database user table에 insert 하기
		userDAO.insert(uid, upw, uname, uphone, uemail, unickname, uaddress, utype, uimage);
		
		if (utype.equals("companion")) {
			// pet table에 들어가야 될 값들
			// petname
			String[] petname = request.getParameterValues("petname");
			// petgender
			String[] petgender = request.getParameterValues("petgender");
			
			
			// petname, petgender List<PetDTO>로 바꾸기
			List<PetDTO> list = new ArrayList<>();
			for(int i = 1 ; i< petname.length ; i++) {
				PetDTO dto = new PetDTO(petname[i], petgender[i]);
				list.add(dto);
			}
			
			petDAO.insert(list, uid);

			// choose table에 petspec pet 연결하기 위한 작업
			// petid list select 해오기
			List<Integer> petIdList = petDAO.selectPetId(uid);
			// pstype
			String[] pstypeArr = request.getParameterValues("pstype");
			// psbreeds
			String[] psbreedsArr = request.getParameterValues("psbreeds");
			
			List<String> pstype = new ArrayList<String>(Arrays.asList(pstypeArr));
			List<String> psbreeds = new ArrayList<String>(Arrays.asList(psbreedsArr));
			
			// pstype 과 psbreeds로 맞는 psid list 가져오기
			List<Integer> psidList = petspecDAO.selectPsId(pstype , psbreeds);
			
			System.out.println("petid : " + petIdList.size());
			System.out.println("psid : " + psidList.size());
			
			List<ChooseDTO> list3 = new ArrayList<>();
			for(int i=0; i<petIdList.size() ;i++) {
				ChooseDTO dto = new ChooseDTO(petIdList.get(i), psidList.get(i));
				list3.add(dto);
			}
			
			// choose table에 petid , psid list 같이 넣기
			chooseDAO.insert(list3);

		}

	}
	
	@Override
	public int executeTwo(HttpServletRequest request) throws Exception {
		
		String uid = request.getParameter("uid");
		
		return userDAO.registerCheck(uid);
		
	}
	
	@Override
	public String executeThree(HttpServletRequest request) throws Exception {
		
		String pstype = request.getParameter("pstype");
		
		return petspecDAO.psbreedsList(pstype).toString();
	}

}

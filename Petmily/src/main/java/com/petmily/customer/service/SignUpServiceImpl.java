package com.petmily.customer.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public void signup(MultipartHttpServletRequest request, Model model,MultipartFile file) throws Exception {
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
		// utype
		String utype = request.getParameter("utype");
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// database user table에 insert 하기
		userDAO.insert(uid, upw, uname, uphone, uemail, unickname, uaddress_basic, uaddress_detail , utype, uimage);
		
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
	public int signupIdCheck(HttpServletRequest request) throws Exception {
		
		String uid = request.getParameter("uid");
		
		return userDAO.registerCheck(uid);
		
	}
	
	@Override
	public String psBreedsList(HttpServletRequest request) throws Exception {
		
		String pstype = request.getParameter("pstype");
		
		return petspecDAO.psbreedsList(pstype).toString();
	}
	
	
	@Override
	public int sendEmail(HttpServletRequest request) throws Exception {
		String email = request.getParameter("uemail");

		Random random = new Random();

		int certifyNum = random.hashCode();

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

		String receiver = email; // 메일 받을 주소
		String title = "[펫밀리] 회원가입 이메일 인증";
		String content = "<div"
				+ "		style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 540px; height: 600px; border-top: 4px solid{$point_color\">"
				+ "		<h1" + "			style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"
				+ "			<span style=\"font-size: 30px; margin: 0 0 10px 3px; color: #de6637;\"><strong>Petmily</strong></span><br />"
				+ "			<span style=\"color: {$point_color\">메일인증</span> 안내입니다." + "		</h1>" + "		<p"
				+ "			style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"
				+ "			안녕하세요.<br /> Petmily에 가입해 주실려고 해서 진심으로 감사드립니다.<br /> 아래 <b"
				+ "				style=\"color: {$point_color\">'메일 인증 번호'</b>를 입력하여 회원가입을 완료해 주세요.<br />"
				+ "			<br />" + "			인증번호 : " + "			<br />" + "			<h2><strong>" + certifyNum
				+ "</strong></h2><br />" + "			<br /> 감사합니다." + "		</p>" + ""
				+ "		<div style=\"border-top: 1px solid #DDD; padding: 5px;\">"
				+ "			<p style=\"font-size: 13px; line-height: 21px; color: #555;\">"
				+ "				직업정보제공사업 신고번호 2016-서울강남-1234<br>" + "				주소 서울특별시 강남구"
				+ "				전화 010-9711-0641|고객문의 raindrop6651@gmail.com<br><br />" + "			</p>"
				+ "		</div>" + "	</div>";

		helper.setSubject(title);

		helper.setTo(receiver);

		helper.setText(content, true);
		
		javaMailSender.send(message);

		return certifyNum;
	}
}

package com.petmily.customer.service;

import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.petmily.customer.dao.ReviewDAO;
import com.petmily.customer.dao.UserDAO;
import com.petmily.customer.dto.UserDTO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ReviewDAO reviewDAO;
	
	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public int login(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		session = request.getSession();

		String uid = "";
		String upw = "";

		if (session.getAttribute("user") == null) {
			uid = request.getParameter("uid");
			upw = request.getParameter("upw");
			int result = userDAO.userPwCheck(uid, upw);
			if (result == 1) {
				UserDTO dto = userDAO.login(uid, upw);
				Integer rate = reviewDAO.selectRating(uid);
				if(rate != null) {
					session.setAttribute("rate", rate);
					
				}
				session.setAttribute("user", dto);
				return 1;
			} else {
				model.addAttribute("loginStatus", "아이디 및 비밀번호를 확인해 주세요");
				return 0;
			}
		} else {
			UserDTO userDTO = (UserDTO) session.getAttribute("user");
			uid = userDTO.getUid();
			upw = userDTO.getUpw();
			int result = userDAO.userPwCheck(uid, upw);
			if(result == 1) {
				UserDTO dto = userDAO.login(uid, upw);
				Integer rate = reviewDAO.selectRating(uid);
				if(rate != null) {
					session.setAttribute("rate", rate);
					
				}
				session.setAttribute("user", dto);
				return -1;
			}else {
				model.addAttribute("loginStatus", "아이디 및 비밀번호를 확인해 주세요");
				return 0;
			}
		}

	}
	
	@Override
	public String searchIdCheck(HttpServletRequest request) throws Exception {
		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		
		int result = userDAO.countId(uname, uemail);
		
		if(result >= 1) {
			Random random = new Random();

			int certifyNum = random.hashCode();

			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

			String receiver = uemail; // 메일 받을 주소
			String title = "[펫밀리] 아이디 찾기 이메일 인증";
			String content = "<div"
					+ "		style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 540px; height: 600px; border-top: 4px solid{$point_color\">"
					+ "		<h1" + "			style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"
					+ "			<span style=\"font-size: 30px; margin: 0 0 10px 3px; color: #de6637;\"><strong>Petmily</strong></span><br />"
					+ "			<span style=\"color: {$point_color\">메일인증</span> 안내입니다." + "		</h1>" + "		<p"
					+ "			style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"
					+ "			안녕하세요.<br /> Petmily에 가입해 주실려고 해서 진심으로 감사드립니다.<br /> 아래 <b"
					+ "				style=\"color: {$point_color\">'메일 인증 번호'</b>를 입력하여 로그인을 완료해 주세요.<br />"
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

			return Integer.toString(certifyNum);
			
			
			
			
		} else {
			return "입력하신 이름과 이메일로 일치하는 아이디가 없습니다.";
		}

	}
	
	@Override
	public void sendEmail(HttpServletRequest request) throws Exception {
		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		
		List<String> idList = userDAO.selectId(uname, uemail);
		String idListStr = String.join(",", idList);
		idListStr = idListStr.substring(1,idListStr.length());
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

		String receiver = uemail; // 메일 받을 주소
		String title = "[펫밀리] 회원가입 된 아이디 목록";
		String content = "<div"
				+ "		style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 540px; height: 600px; border-top: 4px solid{$point_color\">"
				+ "		<h1" + "			style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"
				+ "			<span style=\"font-size: 30px; margin: 0 0 10px 3px; color: #de6637;\"><strong>Petmily</strong></span><br />"
				+ "			<span style=\"color: {$point_color\">가입된 아이디 목록</span> 입니다." + "		</h1>" + "		<p"
				+ "			style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"
				+ "			안녕하세요.<br /> Petmily에 가입해 주실려고 해서 진심으로 감사드립니다.<br /> 아래 <b"
				+ "				style=\"color: {$point_color\">'아이디 목록'</b>을 확인하여 로그인을 완료해 주세요.<br />"
				+ "			<br />" + "			아이디 리스트  : " + "			<br />" + "			<h2><strong>" + idListStr
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
	}
	
	@Override
	public String searchPwCheck(HttpServletRequest request) throws Exception {
		String uid = request.getParameter("uid");
		String uemail = request.getParameter("uemail");
		
		int result = userDAO.countIdPw(uid, uemail);
		
		if(result == 1) {
			Random random = new Random();

			int certifyNum = random.hashCode();

			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

			String receiver = uemail; // 메일 받을 주소
			String title = "[펫밀리] 비밀번호 찾기 이메일 인증";
			String content = "<div"
					+ "		style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 540px; height: 600px; border-top: 4px solid{$point_color\">"
					+ "		<h1" + "			style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"
					+ "			<span style=\"font-size: 30px; margin: 0 0 10px 3px; color: #de6637;\"><strong>Petmily</strong></span><br />"
					+ "			<span style=\"color: {$point_color\">메일인증</span> 안내입니다." + "		</h1>" + "		<p"
					+ "			style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"
					+ "			안녕하세요.<br /> Petmily에 가입해 주실려고 해서 진심으로 감사드립니다.<br /> 아래 <b"
					+ "				style=\"color: {$point_color\">'메일 인증 번호'</b>를 입력하여 로그인을 완료해 주세요.<br />"
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

			return Integer.toString(certifyNum);
			
		} else {
			return "입력하신 아이디와 이메일로 일치하는 아이디가 없습니다.";
		}
	}
	
	@Override
	public void sendEmailPw(HttpServletRequest request) throws Exception {
		String uid = request.getParameter("uid");
		String uemail = request.getParameter("uemail");
		
		String pw = userDAO.selectPw(uid, uemail);
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

		String receiver = uemail; // 메일 받을 주소
		String title = "[펫밀리] 입력하신 아이디로 가입된 비밀번호";
		String content = "<div"
				+ "		style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 540px; height: 600px; border-top: 4px solid{$point_color\">"
				+ "		<h1" + "			style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"
				+ "			<span style=\"font-size: 30px; margin: 0 0 10px 3px; color: #de6637;\"><strong>Petmily</strong></span><br />"
				+ "			<span style=\"color: {$point_color\">입력하신 아이디로 등록된 비밀번호</span> 입니다." + "		</h1>" + "		<p"
				+ "			style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"
				+ "			안녕하세요.<br /> Petmily에 가입해 주실려고 해서 진심으로 감사드립니다.<br /> 아래 <b"
				+ "				style=\"color: {$point_color\">'비밀번호'</b>를 확인하여 로그인을 완료해 주세요.<br />"
				+ "			<br />" + "			비밀번호  : " + "			<br />" + "			<h2><strong>" + pw
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
	}

}

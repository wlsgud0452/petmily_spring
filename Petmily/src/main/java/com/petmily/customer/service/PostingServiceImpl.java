package com.petmily.customer.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.petmily.customer.dao.PostingDAO;
import com.petmily.customer.dto.PagingDTO;
import com.petmily.customer.dto.PostingDTO;
import com.petmily.customer.dto.UserDTO;

@Service
public class PostingServiceImpl implements PostingService {
	
	@Autowired
	PostingDAO postingDAO;
	
	@Override
	public void posting(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
//		String user_uid = (String) session.getAttribute("user.uid");
		
		int cPage = 0;
		int pageLength = 5;
		int totalRows = 0;
		int rowLength=5;
		String tempPage = request.getParameter("page");
		String pcategory_temp1 = request.getParameter("pcategory");
		String pcategory_temp2 = (String) request.getAttribute("pcategory");
		String pcategory = "";
		String option = request.getParameter("option");
		String query = request.getParameter("query");
		
		if(pcategory_temp1 == null || pcategory_temp1.equals("")) {
			pcategory = pcategory_temp2;
		}
		
		if(pcategory_temp2 == null || pcategory_temp2.equals("")) {
			pcategory = pcategory_temp1;
		}
		
		if(option == null) {
			option = "ptitle";
		}
		if(query == null) {
			query = "";
		}
		
		if(tempPage == null || tempPage.length()==0) {
			cPage = 1;
		}
		try {
			cPage = Integer.parseInt(tempPage);
		} catch (Exception e) {
			cPage = 1;
		}
		
		query = "%"+ query + "%";
		
		totalRows = postingDAO.postingListRow(pcategory);
		PagingDTO dto = new PagingDTO(cPage, totalRows, pageLength);
		
		int start = (cPage - 1) * rowLength;
		
		List<PostingDTO> dtos = postingDAO.postingGetList(cPage, rowLength, pcategory, option, query,start);
		
		model.addAttribute("paging", dto);
		model.addAttribute("postingList", dtos);
	}

	@Override
	public int postingWriteInsert(MultipartHttpServletRequest request, Model model,List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		UserDTO udto = (UserDTO)session.getAttribute("user");
		String user_uid = udto.getUid();
		
		String ptitle = request.getParameter("ptitle");
		String pcategory = request.getParameter("pcategory");
		String pcontent = request.getParameter("pcontent");
		String plocation_basic = request.getParameter("plocation_basic");
		String plocation_detail = request.getParameter("plocation_detail");
		String pimage1 = null;
		String pimage2 = null;
		String pimage3 = null;
		int lastPostingId;
		
		multipartFiles = request.getFiles("file");
		
		//텍스트만 입력
		postingDAO.postingInsertText(ptitle,pcategory,pcontent,plocation_basic,plocation_detail,user_uid);
		
		//이 유저의 마지막 포스팅 아이디
		lastPostingId = postingDAO.postingGetId(user_uid);
		
		int cnt = 1;
		
		for(MultipartFile file : multipartFiles) {
			  
			String path = System.getProperty("user.dir") + "//src//main//resources//static//posting";

			// 파일을 uid로 만들기 위한 기초단계
			// 확장자 가져오기
			String originalName = file.getOriginalFilename();
			if(cnt == 1) {
				originalName = lastPostingId + "_1_" + originalName;
				pimage1 = originalName;
			}else if (cnt == 2){
				originalName = lastPostingId + "_2_" + originalName;
				pimage2 = originalName;
			}else if(cnt == 3) {
				originalName = lastPostingId + "_3_" + originalName;
				pimage3 = originalName;
			}
			// 파일 네임 짓기
			// 패스에 "name" 으로 saveFile을 만들 빈 껍데기를 생성해 준다.
			File saveFile = new File(path, originalName);
			// file을 saveFile이름과 path로 지어서 넣기
			file.transferTo(saveFile);
			cnt++;
		}
		postingDAO.updateImages(pimage1, pimage2, pimage3, lastPostingId);
		
		return 1;
	}
}

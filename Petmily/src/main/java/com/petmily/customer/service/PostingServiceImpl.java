package com.petmily.customer.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.petmily.customer.dao.ApplyDAO;
import com.petmily.customer.dao.PostingDAO;
import com.petmily.customer.dao.ShowDAO;
import com.petmily.customer.dao.UserDAO;
import com.petmily.customer.dto.PagingDTO;
import com.petmily.customer.dto.PostingDTO;
import com.petmily.customer.dto.UserDTO;

@Service
public class PostingServiceImpl implements PostingService {
	
	@Autowired
	PostingDAO postingDAO;
	@Autowired
	ShowDAO showDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
	ApplyDAO applyDAO;
	
	
	@Override
	public void posting(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
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
	public int postingWriteInsert(MultipartHttpServletRequest request, Model model,List<MultipartFile> multipartFiles, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
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
		try {
			
		
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
		redirectAttributes.addAttribute("pcategory",pcategory);
		redirectAttributes.addAttribute("page",1);
		
		postingDAO.updateImages(pimage1, pimage2, pimage3, lastPostingId);
		return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public void postingClick(HttpServletRequest request, Model model, HttpSession session , RedirectAttributes redirectAttributes) throws Exception {
		
		UserDTO udto = (UserDTO)session.getAttribute("user");
		
		int view = 0;
		int like = 0;
		int likeCheck = 0;
		int viewCheck=0;
		int pid = 0;
		
		if(!(request.getParameter("pid") == null)) {
			pid = Integer.parseInt(request.getParameter("pid"));
		}
		
		Map<String, ?> redirectMap = RequestContextUtils.getInputFlashMap(request);  
	    if( redirectMap  != null ){
	        pid =  (int) redirectMap.get("pid") ;  
	       
	    }
		
		String postingUid = "";
		String postingUserNickname = "";
		String uimage = "";
		String user_uid = udto.getUid();
		
		PostingDTO pdto = postingDAO.postingGetDetail(pid); 
		
		postingUid = pdto.getUser_uid();
		
		
		viewCheck = showDAO.showViewCount(pid, user_uid);
		likeCheck = showDAO.showLikeCount(pid, user_uid);
		
		uimage = userDAO.selectImage(postingUid);
		
		if( viewCheck == 0 ) {
			showDAO.showInsertView(pid, user_uid);
		}
		
		view = showDAO.showViewAllCount(pid);
		like = showDAO.showLikeAllCount(pid);
		
		// 댓글 불러오기
		// pcontent , pinitdate , user_uid 가져오기
		List<PostingDTO> commentList = postingDAO.selectCommentList(pid);
		
//		System.out.println(commentList.size());
		
//		List<String> commentImageList = userDAO.selectImageList(commentList);
		
		model.addAttribute("user_uid", user_uid);
		model.addAttribute("pid", pid);
		model.addAttribute("postingView", view);
		model.addAttribute("postingLike", like);
		model.addAttribute("likeCheck", likeCheck);
		model.addAttribute("postingDetail", pdto);
		model.addAttribute("postingUid", postingUid);
		model.addAttribute("postingUimage", uimage);
		model.addAttribute("commentList", commentList);
//		model.addAttribute("commentImageList", commentImageList);
	}
	
	@Override
	public void postingApplyInsert(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		
		UserDTO udto = (UserDTO)session.getAttribute("user");
		
		String user_uid = "";
		String posting_user_uid = "";
		String aptitle = "";
		String apcontent = "";
		int posting_pid = 0;
		int count = 0;
		
		user_uid = udto.getUid();
		posting_pid = Integer.parseInt(request.getParameter("pid"));
		posting_user_uid = request.getParameter("user_uid");
		aptitle = request.getParameter("aptitle");
		apcontent = request.getParameter("apcontent");
		
		count = applyDAO.applyUserCount(user_uid, posting_pid);
		
		if ( count == 0) {
			applyDAO.postingApplyInsert(user_uid, posting_pid, posting_user_uid, aptitle, apcontent);
			redirectAttributes.addFlashAttribute("applyStatus", "신청이 완료되었습니다.");
			
		}
		
		if(count == 1){
			redirectAttributes.addFlashAttribute("applyStatus", "이미 신청한 내역이 있습니다.<br>신청은 한 번만 가능합니다.");
		}
		redirectAttributes.addFlashAttribute("pid",posting_pid);
	}

	@Override
	public void postingLikeClick(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		// TODO Auto-generated method stub
		
		UserDTO udto = (UserDTO)session.getAttribute("user");
		
		String user_uid = udto.getUid();
		int pid = Integer.parseInt(request.getParameter("pid"));
		int likeCheck = Integer.parseInt(request.getParameter("likeCheck"));
		int postingLike = showDAO.showLikeAllCount(pid);
		
		
		if(likeCheck == 1) {
			likeCheck = 0;
			showDAO.showInsetLike(pid, user_uid, likeCheck);
		}else {
			likeCheck = 1;
			showDAO.showInsetLike(pid, user_uid, likeCheck);
		}
		
		redirectAttributes.addFlashAttribute("likeCheck", likeCheck );
		redirectAttributes.addFlashAttribute("postingLike", postingLike );
		redirectAttributes.addFlashAttribute("pid", pid);
		redirectAttributes.addFlashAttribute("user_uid", user_uid );
		
	}

	@Override
	public void postingReplyInsert(HttpServletRequest request, Model model, HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		// TODO Auto-generated method stub
		
		UserDTO udto = (UserDTO)session.getAttribute("user");
		
		
		String user_uid = udto.getUid();
		String pid = request.getParameter("pid");
		String ureply = request.getParameter("ureply");
		int plevel = 2;//댓글
		
		postingDAO.postingRyplyWriteAction(pid, ureply, plevel, user_uid);
		
		redirectAttributes.addAttribute("pid", pid);
	}

	@Override
	public void postingInfo(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		int pid = Integer.parseInt(request.getParameter("pid"));

		PostingDTO dto = postingDAO.postingInfo(pid);
		
	
		
		
		request.setAttribute("postingInfo", dto);
	}

	@Override
	public void postingDelete(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) throws Exception {
		// TODO Auto-generated method stub
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pcategory = request.getParameter("pcategory");
		
		
		try {
			postingDAO.postingDelete(pid);
			redirectAttributes.addFlashAttribute("deleteMessege", "게시물이 정상적으로 삭제 되었습니다.");
			redirectAttributes.addAttribute("page", 1);
			redirectAttributes.addAttribute("pcategory", pcategory);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			redirectAttributes.addFlashAttribute("deleteMessege", "게시물이 삭제되지 않았습니다. 다시시도 부탁드립니다.");
		}
		
	}
}

package com.petmily.customer.contoroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.petmily.customer.service.PostingService;

@Controller
public class PostingContoroller {

	@Autowired
	PostingService service;
	
	@RequestMapping("/posting")
	public String posting (HttpServletRequest request,Model model) throws Exception{
		
		service.posting(request,model);
		
		return "board_list";
	}
	
	@RequestMapping("/posting_write")
	public String  posting_write(HttpServletRequest request, Model model) {
		
		
		return "board_write";
	}
	//게시판 작성에서 작성하기 클릭시
	@RequestMapping("posting_write_inesrt")
	public String posting_write_inesrt(MultipartHttpServletRequest request, Model model, List<MultipartFile> multipartFiles, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		
		int result = service.postingWriteInsert(request,model, multipartFiles,session, redirectAttributes);
		
		if(result == 1) {
			return "redirect:posting";
		}else {
			// 오류 표시
			return "posting_write";
		}
	}
	
	@RequestMapping("posting_click")
	public String posting_click(HttpServletRequest request, Model model,HttpSession session , RedirectAttributes redirectAttributes) throws Exception {
		
		service.postingClick(request, model,session , redirectAttributes);
		
		return "board_view";
	}
	
	@RequestMapping("posting_like_click")
	public String posting_like_click(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		
		service.postingLikeClick(request,model, session, redirectAttributes);
		
		return "redirect:posting_click";
	}
	
	//신청버튼 눌렀을 때
	@RequestMapping("posting_apply_insert")
	public String posting_apply_insert(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) throws Exception{
		
		service.postingApplyInsert(request,model,session, redirectAttributes);
		
		return "redirect:posting_click";
	}
	
	//댓글 입력시
	@RequestMapping("posting_reply_insert")
	public String posting_reply_insert(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) throws Exception{
		
		service.postingReplyInsert(request,model,session,redirectAttributes);
		
		return "redirect:posting_click";
	}
	
	//게시물에서 수정 클릭시
	@RequestMapping("posting_modify")
	public String posting_modify(HttpServletRequest request, Model model) throws Exception{
		
		service.postingInfo(request,model);
		
		return "board_modify";
	}
	
	@RequestMapping("posting_delete")
	public String posting_delete(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		service.postingDelete(request, model, redirectAttributes);
		
		return ("redirect:posting");
	}
	
	@RequestMapping("posting_midify_update")
	public String posting_midify_update(MultipartHttpServletRequest request, Model model, List<MultipartFile> multipartFiles, HttpSession session, RedirectAttributes redirectAttributes) throws Exception{
		
		service.postingUpdate(request,model,multipartFiles, session, redirectAttributes);
		
		return ("redirect:posting");
	}
	
}

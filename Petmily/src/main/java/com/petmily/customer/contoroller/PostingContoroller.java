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
	public String posting_write_inesrt(MultipartHttpServletRequest request, Model model, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		
		int result = service.postingWriteInsert(request,model, multipartFiles,session);
		
		if(result == 1) {
			return "redirect:posting";
		}else {
			// 오류 표시
			return "posting_write";
		}
	}
	
	
	
}

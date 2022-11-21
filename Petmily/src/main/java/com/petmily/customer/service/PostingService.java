package com.petmily.customer.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface PostingService {

	
	public void posting	(HttpServletRequest request, Model model) throws Exception;
	
	public int postingWriteInsert (MultipartHttpServletRequest request, Model model, List<MultipartFile> multipartFiles, HttpSession session) throws Exception;
	
}

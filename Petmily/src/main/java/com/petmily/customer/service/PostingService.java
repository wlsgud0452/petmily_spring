package com.petmily.customer.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface PostingService {

	
	public void posting	(HttpServletRequest request, Model model) throws Exception;
	
	public int postingWriteInsert (MultipartHttpServletRequest request, Model model, List<MultipartFile> multipartFiles, HttpSession session, RedirectAttributes redirectAttributes) throws Exception;
	
	public void postingClick (HttpServletRequest request, Model model, HttpSession session) throws Exception;
	
	public void postingApplyInsert (HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) throws Exception; 
	
}

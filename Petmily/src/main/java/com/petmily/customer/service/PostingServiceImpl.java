package com.petmily.customer.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.petmily.customer.dao.PostingDAO;
import com.petmily.customer.dto.PagingDTO;
import com.petmily.customer.dto.PostingDTO;

@Service
public class PostingServiceImpl implements PostingService {
	
	@Autowired
	PostingDAO postingDAO;
	
	@Override
	public void excute(HttpServletRequest request, Model model) throws Exception {
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
		
		query = "'%"+ query + "%'";
		
		totalRows = postingDAO.postingListRow(pcategory);
		PagingDTO dto = new PagingDTO(cPage, totalRows, pageLength);
		System.out.println("totalRows : "+totalRows);
		System.out.println("page : "+dto.getcPage()+"\ncurrentblcok : "+dto.getCurrentBlock());
		System.out.println("EndPage : "+dto.getEndPage()+"\nEndRow : "+dto.getEndRow());
		System.out.println("PageLength : "+dto.getPageLength()+"\nStartPage : "+dto.getStartPage());
		System.out.println("StartRow : "+dto.getStartRow()+"\nTotalPages : "+dto.getTotalPages());
		//PagingDTO dto =  postingDAO.postingListPaging(cPage, totalRows, pageLength);
		List<PostingDTO> dtos = postingDAO.postingGetList(cPage, rowLength, pcategory, option, query);
		
		model.addAttribute("paging", dto);
		model.addAttribute("postingList", dtos);
	}

}

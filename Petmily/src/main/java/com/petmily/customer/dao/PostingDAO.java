package com.petmily.customer.dao;

import java.util.List;

import com.petmily.customer.dto.PostingDTO;

public interface PostingDAO {

	public int postingListRow(String pcategory) throws Exception;
	
	public List<PostingDTO> postingGetList(int cPage, int rowLength, String pcategory, String option, String query,int start) throws Exception;
	
	public void postingInsertText(String ptitle,String pcategory,String pcontent,
			String plocation_basic,String plocation_detail,String user_uid)throws Exception;
	
	public int postingGetId(String user_uid) throws Exception;
	
	public void updateImages(String pimage1, String pimage2, String pimage3, int lastPostingId) throws Exception;
	public List<PostingDTO> acceptPostingList(String uid , int rowLength, int start) throws Exception;
}

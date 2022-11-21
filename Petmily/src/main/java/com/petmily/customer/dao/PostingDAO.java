package com.petmily.customer.dao;

import java.util.List;

import com.petmily.customer.dto.PagingDTO;
import com.petmily.customer.dto.PostingDTO;

public interface PostingDAO {

	public int postingListRow(String pcategory) throws Exception;
	
	public List<PostingDTO> postingGetList(int cPage, int rowLength, String pcategory, String option, String query,int start) throws Exception;
	
}

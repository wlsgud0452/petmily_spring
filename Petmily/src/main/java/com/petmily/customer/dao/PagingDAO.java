package com.petmily.customer.dao;

import com.petmily.customer.dto.PagingDTO;

public interface PagingDAO {

	
	public PagingDTO postingListPaging(int cPage, int totalRows, int pageLength) throws Exception;
}

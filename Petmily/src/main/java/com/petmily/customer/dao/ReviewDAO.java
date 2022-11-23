package com.petmily.customer.dao;

import java.util.List;

import com.petmily.customer.dto.ReviewDTO;

public interface ReviewDAO {
	public Integer selectRating(String uid) throws Exception;
		
	public void insert(String revtext, int revrating ,String from_uid ,String posting_pid ,String to_uid) throws Exception;

	public List<ReviewDTO> selectReview( List<Integer> pidList , String to_uid , int  start , int rowLength) throws Exception;
	
	public Integer selectCountReview( List<Integer> pidList , String to_uid ) throws Exception;
}

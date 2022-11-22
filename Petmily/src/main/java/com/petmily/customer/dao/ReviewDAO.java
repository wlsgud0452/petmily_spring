package com.petmily.customer.dao;

public interface ReviewDAO {
	public Integer selectRating(String uid) throws Exception;
	
	public void insert(String revtext, int revrating ,String from_uid ,String posting_pid ,String to_uid) throws Exception;
}

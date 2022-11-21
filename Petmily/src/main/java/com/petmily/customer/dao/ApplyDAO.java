package com.petmily.customer.dao;

public interface ApplyDAO {
	public int selectCategory(String uid, String pcategory) throws Exception;
	
	public int applyUserCount(String user_uid, int posting_pid) throws Exception;
	
	public void postingApplyInsert (String user_uid, int posting_pid, String posting_user_uid, String aptitle, String apcontent) throws Exception;
}

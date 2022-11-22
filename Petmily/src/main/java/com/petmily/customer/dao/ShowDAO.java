package com.petmily.customer.dao;

import java.util.List;
import java.util.Map;

public interface ShowDAO {
	public int showViewCount(int pid, String user_uid) throws Exception;
	
	public int showLikeCount(int pid, String user_uid) throws Exception;
	
	public void showInsertView(int pid, String user_uid) throws Exception;
	
	public int showViewAllCount(int pid) throws Exception;
	
	public int showLikeAllCount(int pid) throws Exception;
	
	public void showInsetLike(int pid, String user_uid, int likeCheck) throws Exception;
	
}

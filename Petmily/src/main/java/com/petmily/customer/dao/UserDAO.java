package com.petmily.customer.dao;

import com.petmily.customer.dto.UserDTO;

public interface UserDAO {
	public int userPwCheck(String uid, String upw) throws Exception;

	public UserDTO login(String uid, String upw) throws Exception;

	public void insert(String uid, String upw, String uname, String uphone, String uemail, String unickname,
			String uaddress_basic, String uaddress_detail, String utype) throws Exception;

	public int registerCheck(String uid) throws Exception;

	public UserDTO userInfo(String uid) throws Exception;

	public String selectUimage(String uid) throws Exception;

	public String selectImage(String postingUid) throws Exception;

	public void updateUser(String uid, String uname, String unickname, String uemail, String uphone, String uaddress_basic,
			String uaddress_detail) throws Exception;
	
	public void updateUimage(String uid, String uimage) throws Exception;

}

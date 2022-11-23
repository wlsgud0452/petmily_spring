package com.petmily.customer.dao;

import java.util.List;

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

	public int countId(String uname,String uemail) throws Exception;
	
	public List<String> selectId(String uname,String uemail) throws Exception;

	public int countIdPw(String uid,String uemail) throws Exception;
	
	public String selectPw(String uid,String uemail) throws Exception;
}

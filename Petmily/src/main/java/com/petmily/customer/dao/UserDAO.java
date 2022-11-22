package com.petmily.customer.dao;

import java.util.List;

import com.petmily.customer.dto.PostingDTO;
import com.petmily.customer.dto.UserDTO;

public interface UserDAO {
	public int userPwCheck(String uid, String upw) throws Exception;

	public UserDTO login(String uid, String upw) throws Exception;

	public void insert(String uid, String upw, String uname, String uphone, String uemail, String unickname,
			String uaddress_basic, String uaddress_detail , String utype, String uimage) throws Exception;
	
	public int registerCheck(String uid) throws Exception;
	
	public UserDTO userInfo(String uid) throws Exception;
	
	public String selectUimage(String uid) throws Exception;

	public String selectImage(String postingUid) throws Exception;

	
	public List<String> selectImageList (List<PostingDTO> commentList) throws Exception;
	
}

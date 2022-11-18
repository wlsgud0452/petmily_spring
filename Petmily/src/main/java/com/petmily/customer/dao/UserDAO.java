package com.petmily.customer.dao;

import com.petmily.customer.dto.UserDTO;

public interface UserDAO {
	public int userPwCheck(String uid, String  upw) throws Exception;
	public UserDTO login( String uid, String upw) throws Exception;
}

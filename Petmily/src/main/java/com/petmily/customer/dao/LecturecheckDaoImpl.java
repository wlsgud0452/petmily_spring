package com.petmily.customer.dao;

import org.apache.ibatis.session.SqlSession;

public class LecturecheckDaoImpl implements LecturecheckDAO {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.petmily.customer.dao.LecturecheckDAO";

	@Override
	public void insertLecture(String uid, String categoryNum) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(categoryNum);
		sqlSession.insert(nameSpace + ".insertLecture");
	}

}

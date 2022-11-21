package com.petmily.customer.dao;

import org.apache.ibatis.session.SqlSession;

public class ReviewDAOImpl implements ReviewDAO {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.petmily.customer.dao.ReviewDAO";
	
	@Override
	public int selectRating(String uid) throws Exception {
		
		return sqlSession.selectOne(nameSpace + ".selectRating");
	}

}

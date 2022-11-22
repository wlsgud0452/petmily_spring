package com.petmily.customer.dao;

import org.apache.ibatis.session.SqlSession;

public class ReviewDAOImpl implements ReviewDAO {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.petmily.customer.dao.ReviewDAO";
	
	@Override
	public Integer selectRating(String uid) throws Exception {
		
		return sqlSession.selectOne(nameSpace + ".selectRating");
	}
	
	@Override
	public void insert(String revtext, int revrating, String from_uid, String posting_pid, String to_uid)
			throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".insert");
	}

}

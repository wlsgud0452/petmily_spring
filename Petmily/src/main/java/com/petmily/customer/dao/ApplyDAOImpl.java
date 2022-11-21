package com.petmily.customer.dao;

import org.apache.ibatis.session.SqlSession;

public class ApplyDAOImpl implements ApplyDAO {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.petmily.customer.dao.ApplyDAO";
	
	@Override
	public int selectCategory(String uid, String pcategory) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".selectCategory");
	}

}

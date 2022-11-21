package com.petmily.customer.dao;

import org.apache.ibatis.session.SqlSession;

public class LecturecheckDaoImpl implements LecturecheckDAO {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.petmily.customer.dao.LecturecheckDAO";

	@Override
	public void insertLecture(String uid, String categoryNum) throws Exception {
		// TODO Auto-generated method stub
		
		sqlSession.insert(nameSpace + ".insertLecture");
	}
	
	@Override
	public int selectChapterOne(String uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".selectChapterOne");
	}
	
	@Override
	public int selectChapterTwo(String uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".selectChapterTwo");
	}
	
	@Override
	public int selectChapterThree(String uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".selectChapterThree");
	}
	
}

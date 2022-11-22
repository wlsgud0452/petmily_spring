package com.petmily.customer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class ShowDAOImpl implements ShowDAO {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.petmily.customer.dao.ShowDAO";

	@Override
	public int showViewCount(int pid, String user_uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".showViewCount");
	}

	@Override
	public int showLikeCount(int pid, String user_uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".showLikeCount");
	}

	@Override
	public void showInsertView(int pid, String user_uid) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int showViewAllCount(int pid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".showViewAllCount");
	}

	@Override
	public int showLikeAllCount(int pid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".showLikeAllCount");
	}

	@Override
	public void showInsetLike(int pid, String user_uid, int likeCheck) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}

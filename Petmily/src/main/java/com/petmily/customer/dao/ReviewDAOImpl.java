package com.petmily.customer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.petmily.customer.dto.ReviewDTO;

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
	
	@Override
	public List<ReviewDTO> selectReview(List<Integer> pidList, String to_uid , int  start , int rowLength) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".selectReview");
	}
	
	@Override
	public int selectCountReview(List<Integer> pidList, String to_uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".selectCountReview");
	}
}

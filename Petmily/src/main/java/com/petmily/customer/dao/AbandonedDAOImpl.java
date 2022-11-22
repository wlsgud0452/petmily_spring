package com.petmily.customer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class AbandonedDAOImpl implements AbandonedDAO {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.petmily.customer.dao.AbandonedDAO";

	@Override
	public List<Map<Integer, Integer>> chart() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".chart");
	}
	
	@Override
	public List<Map<Integer, Double>> ratio() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".ratio");
	}

}

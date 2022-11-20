package com.petmily.customer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.petmily.customer.dto.ChooseDTO;

public class ChooseDAOImpl implements ChooseDAO {
	
	SqlSession sqlSession;

	public static String nameSpace = "com.petmily.customer.dao.ChooseDAO";
	
	@Override
	public void insert(List<ChooseDTO> list) throws Exception {
		
		sqlSession.insert(nameSpace + ".insert");
	}

}

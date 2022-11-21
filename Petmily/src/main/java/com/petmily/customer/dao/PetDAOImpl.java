package com.petmily.customer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.petmily.customer.dto.PetDTO;

public class PetDAOImpl implements PetDAO {

	SqlSession sqlSession;

	public static String nameSpace = "com.petmily.customer.dao.PetDAO";

	@Override
	public void insert(List<PetDTO> list, String uid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".insert");
	}

	@Override
	public List<Integer> selectPetId(String uid) throws Exception {
		
		return sqlSession.selectList((nameSpace) + ".selectPetId");
	}
}

package com.petmily.customer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.petmily.customer.dto.PetspecDTO;

public class PetspecDAOImpl implements PetspecDAO {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.petmily.customer.dao.PetspecDAO";

	@Override
	public List<PetspecDTO> petSpecListFour(String pstype) throws Exception {
		
		return sqlSession.selectList(nameSpace + ".petSpecListFour");
	}

}

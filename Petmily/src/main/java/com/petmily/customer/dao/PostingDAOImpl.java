package com.petmily.customer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.petmily.customer.dto.PagingDTO;
import com.petmily.customer.dto.PostingDTO;

public class PostingDAOImpl implements PostingDAO{

	SqlSession sqlSession;
	
	public static String nameSpace = "com.petmily.customer.dao.PostingDAO";
	
	@Override
	public int postingListRow(String pcategory) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".postingListRow");
	}


	@Override
	public List<PostingDTO> postingGetList(int cPage, int rowLength, String pcategory, String option, String query, int start)
			throws Exception {
		
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".postingGetList");
	}

}

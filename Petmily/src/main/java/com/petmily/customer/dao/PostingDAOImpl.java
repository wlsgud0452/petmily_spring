package com.petmily.customer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

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
	
	@Override
	public List<PostingDTO> acceptPostingList(String uid, int rowLength, int start) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".acceptPostingList");
	}


	//포스팅의 텍스트 입력
	@Override
	public void postingInsertText(String ptitle, String pcategory, String pcontent, String plocation_basic,
			String plocation_detail,String user_uid) throws Exception {
		// TODO Auto-generated method stub
		
	}

	//이 아이디의 마지막 모스팅 받아오기
	@Override
	public int postingGetId(String user_uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".postingGetId");
	}


	@Override
	public void updateImages(String pimage1, String pimage2, String pimage3, int lastPostingId) throws Exception {
		// TODO Auto-generated method stub
	}


	@Override
	public PostingDTO postingGetDetail(int pid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".postingGetDetail");
	}


	@Override
	public List<PostingDTO> selectCommentList(int pid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".selectCommentList");
	}

}

package com.petmily.customer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.petmily.customer.dto.ApplyDTO;

public class ApplyDAOImpl implements ApplyDAO {

	SqlSession sqlSession;

	public static String nameSpace = "com.petmily.customer.dao.ApplyDAO";

	@Override
	public int selectCategory(String uid, String pcategory) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".selectCategory");
	}

	@Override
	public int applyListRow(String uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".applyListRow");
	}

	@Override
	public List<ApplyDTO> applyGetList(int rowLength, int start, String uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".applyGetList");
	}

	@Override
	public void updateByApId(int apid, String columnname) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".updateByApId");
	}

	@Override
	public void updateByPId(int pid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".updateByPId");
	}

	@Override
	public int acceptListRow(String uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".acceptListRow");
	}

	@Override
	public List<Integer> acceptApidList(String uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".acceptApidList");
	}
	
	@Override
	public int applyUserCount(String user_uid, int posting_pid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".applyUserCount");
	}

	@Override
	public void postingApplyInsert(String user_uid, int posting_pid, String posting_user_uid, String aptitle,
			String apcontent) throws Exception {
		// TODO Auto-generated method stub

	}
	
	@Override
	public int acceptedListRow(String uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".acceptedListRow");
	}
	
	@Override
	public List<ApplyDTO> acceptedGetList(int rowLength, int start, String uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".acceptedGetList");
	}
	
	@Override
	public List<Integer> completePId(String uid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".completePId");
	}
	
}

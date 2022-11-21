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
	public PagingDTO postingListPaging(int cPage, int totalRows, int pageLength) throws Exception {
		
		int currentBlock = 0;
		int startPage = 0;// 시작 페이지
		int endPage = 0;// 마지막 페이지
		int totalPages = 0;// 총 페이지수
		int startRow = 0;// 시작 로우
		int endRow = 0;// 마지막로우

		totalPages = totalRows % pageLength == 0 ? totalRows / pageLength : (totalRows / pageLength) + 1;

		currentBlock = cPage % pageLength == 0 ? cPage / pageLength : (cPage / pageLength) + 1;
		startPage = (currentBlock - 1) * pageLength + 1;
		endPage = startPage + pageLength - 1;

		startRow = (cPage - 1) * pageLength;
		endRow = totalRows - startRow;

		if (endPage > totalPages) {
			endPage = totalPages;
		}
		
		PagingDTO dto = new PagingDTO(cPage, currentBlock, pageLength, startPage, endPage, totalPages, startRow, endRow);
		
		return dto;
	}

	@Override
	public List<PostingDTO> postingGetList(int cPage, int rowLength, String pcategory, String option, String query)
			throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".postingGetList");
	}

}

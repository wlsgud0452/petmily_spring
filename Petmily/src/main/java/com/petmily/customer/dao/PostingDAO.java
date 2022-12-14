package com.petmily.customer.dao;

import java.util.List;

import com.petmily.customer.dto.PostingDTO;

public interface PostingDAO {

	public int postingListRow(String pcategory) throws Exception;
	
	public List<PostingDTO> postingGetList(int cPage, int rowLength, String pcategory, String option, String query,int start) throws Exception;
	
	public void postingInsertText(String ptitle,String pcategory,String pcontent,
			String plocation_basic,String plocation_detail,String user_uid)throws Exception;
	
	public int postingGetId(String user_uid) throws Exception;
	
	public void updateImages(String pimage1, String pimage2, String pimage3, int lastPostingId) throws Exception;
	
	public List<PostingDTO> acceptPostingList(String uid , int rowLength, int start) throws Exception;
	
	public PostingDTO postingGetDetail(int pid) throws Exception;
	
	public List<PostingDTO> selectCommentList (int pid) throws Exception;
	
	public void postingRyplyWriteAction (String pparentid, String ureply, int plevel, String user_uid ) throws Exception;
	
	public PostingDTO postingInfo(int posting_pid) throws Exception;
	
	public void postingDelete(int pid) throws Exception;
	
	public int postingWriteListRow(String uid , String pcategory) throws Exception;
	
	public List<PostingDTO> postingMypageWriteList(int start,int rowLength,String uid,String option,String pcategory, String query) throws Exception;

	public int postingParticipateListRow(String uid , String pcategory) throws Exception;
	
	public List<PostingDTO> postingMypageParticipateList(int start,int rowLength,String uid,String option,String pcategory, String query) throws Exception;

	public List<String> postingGetUid(int pid) throws Exception;
	
	public PostingDTO postingImagesId(int pid) throws Exception;
	
	public void postingUpdate(int pid,String ptitle,String pcontent,String plocation_basic,String plocation_detail,String pimage1,String pimage2,String pimage3)throws Exception;

}

package com.petmily.customer.dao;

import java.util.List;

import com.petmily.customer.dto.ApplyDTO;

public interface ApplyDAO {
	public int selectCategory(String uid, String pcategory) throws Exception;
	
	public int applyListRow(String uid) throws Exception;
	
	public List<ApplyDTO> applyGetList(int rowLength,int start ,String uid ) throws Exception;
	
	public void updateByApId(int apid, String columnname) throws Exception;
	
	public void updateByPId(int pid) throws Exception;
	
	public int acceptListRow(String uid) throws Exception;
	
	public List<Integer> acceptApidList(String uid) throws Exception; 
	
	
}

package com.petmily.customer.dao;

public interface LecturecheckDAO {
	public void insertLecture(String uid, String categoryNum) throws Exception;
	public int selectChapterOne(String uid) throws Exception;
	public int selectChapterTwo(String uid) throws Exception;
	public int selectChapterThree(String uid) throws Exception;
}

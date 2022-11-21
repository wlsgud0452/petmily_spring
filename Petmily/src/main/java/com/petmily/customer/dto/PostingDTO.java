package com.petmily.customer.dto;

import java.sql.Timestamp;

public class PostingDTO {
	
	int pid;
	String ptitle;
	String pcontent;
	String pimage1;
	String pimage2;
	String pimage3;
	String pcategory;
	String plocation_basic;
	String plocation_detail;
	int pulevel;
	int plevel;
	int pparentid;
	Timestamp pinitdate;
	Timestamp pupdatedate;
	Timestamp pdeletedate;
	String user_uid;
	
	public PostingDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public PostingDTO(int pid, String ptitle, String pcontent, String pimage1, String pimage2, String pimage3,
			String pcategory, String plocation_basic, String plocation_detail, int pulevel, int plevel, int pparentid,
			Timestamp pinitdate, Timestamp pupdatedate, Timestamp pdeletedate, String user_uid) {
		super();
		this.pid = pid;
		this.ptitle = ptitle;
		this.pcontent = pcontent;
		this.pimage1 = pimage1;
		this.pimage2 = pimage2;
		this.pimage3 = pimage3;
		this.pcategory = pcategory;
		this.plocation_basic = plocation_basic;
		this.plocation_detail = plocation_detail;
		this.pulevel = pulevel;
		this.plevel = plevel;
		this.pparentid = pparentid;
		this.pinitdate = pinitdate;
		this.pupdatedate = pupdatedate;
		this.pdeletedate = pdeletedate;
		this.user_uid = user_uid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public String getPimage1() {
		return pimage1;
	}

	public void setPimage1(String pimage1) {
		this.pimage1 = pimage1;
	}

	public String getPimage2() {
		return pimage2;
	}

	public void setPimage2(String pimage2) {
		this.pimage2 = pimage2;
	}

	public String getPimage3() {
		return pimage3;
	}

	public void setPimage3(String pimage3) {
		this.pimage3 = pimage3;
	}

	public String getPcategory() {
		return pcategory;
	}

	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}

	public String getPlocation_basic() {
		return plocation_basic;
	}

	public void setPlocation_basic(String plocation_basic) {
		this.plocation_basic = plocation_basic;
	}

	public String getPlocation_detail() {
		return plocation_detail;
	}

	public void setPlocation_detail(String plocation_detail) {
		this.plocation_detail = plocation_detail;
	}

	public int getPulevel() {
		return pulevel;
	}

	public void setPulevel(int pulevel) {
		this.pulevel = pulevel;
	}

	public int getPlevel() {
		return plevel;
	}

	public void setPlevel(int plevel) {
		this.plevel = plevel;
	}

	public int getPparentid() {
		return pparentid;
	}

	public void setPparentid(int pparentid) {
		this.pparentid = pparentid;
	}

	public Timestamp getPinitdate() {
		return pinitdate;
	}

	public void setPinitdate(Timestamp pinitdate) {
		this.pinitdate = pinitdate;
	}

	public Timestamp getPupdatedate() {
		return pupdatedate;
	}

	public void setPupdatedate(Timestamp pupdatedate) {
		this.pupdatedate = pupdatedate;
	}

	public Timestamp getPdeletedate() {
		return pdeletedate;
	}

	public void setPdeletedate(Timestamp pdeletedate) {
		this.pdeletedate = pdeletedate;
	}

	public String getUser_uid() {
		return user_uid;
	}

	public void setUser_uid(String user_uid) {
		this.user_uid = user_uid;
	}
	
	
}
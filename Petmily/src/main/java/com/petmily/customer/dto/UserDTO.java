package com.petmily.customer.dto;

public class UserDTO {
	
	
	String uid;
	String upw;
	String uname;
	String uemail;
	String uphone;
	String uaddress_basic;
	String uaddress_detail;
	String utype;
	String ulevel;
	String uinfo;
	String unickname;
	String uimage;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String uid, String upw, String uname, String uemail, String uphone, String uaddress_basic, String uaddress_detail, String utype,
			String ulevel, String uinfo, String unickname) {
		super();
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uemail = uemail;
		this.uphone = uphone;
		this.uaddress_basic = uaddress_basic;
		this.uaddress_detail = uaddress_detail;
		this.utype = utype;
		this.ulevel = ulevel;
		this.uinfo = uinfo;
		this.unickname = unickname;
	}
	
	// by eunbeen  -- myPageView
	public UserDTO(String uid, String upw, String uname, String uemail, String uphone, String uaddress_basic, String uaddress_detail , String unickname) {
		super();
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uemail = uemail;
		this.uphone = uphone;
		this.uaddress_basic = uaddress_basic;
		this.uaddress_detail = uaddress_detail;
		this.unickname = unickname;
	}
	
	
	
	public UserDTO(String uname, String uemail, String uphone, String uaddress_basic , String uaddress_detail, String unickname, String uimage) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		this.uphone = uphone;
		this.uaddress_basic = uaddress_basic;
		this.uaddress_detail = uaddress_detail;
		this.unickname = unickname;
		this.uimage = uimage;
	}

	public UserDTO(String uid, String uname, String utype , String uimage) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.utype = utype;
		this.uimage = uimage;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}


	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}

	public String getUlevel() {
		return ulevel;
	}

	public void setUlevel(String ulevel) {
		this.ulevel = ulevel;
	}

	public String getUinfo() {
		return uinfo;
	}

	public void setUinfo(String uinfo) {
		this.uinfo = uinfo;
	}

	public String getUnickname() {
		return unickname;
	}

	public void setUnickname(String unickname) {
		this.unickname = unickname;
	}

	public String getUimage() {
		return uimage;
	}

	public void setUimage(String uimage) {
		this.uimage = uimage;
	}

	public String getUaddress_basic() {
		return uaddress_basic;
	}

	public void setUaddress_basic(String uaddress_basic) {
		this.uaddress_basic = uaddress_basic;
	}

	public String getUaddress_detail() {
		return uaddress_detail;
	}

	public void setUaddress_detail(String uaddress_detail) {
		this.uaddress_detail = uaddress_detail;
	}
	
	
	
}

package com.petmily.admin.sevice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AdminService {
	public void execute(HttpServletRequest request, Model model);
	public int executeInt(HttpServletRequest request, Model model);
}

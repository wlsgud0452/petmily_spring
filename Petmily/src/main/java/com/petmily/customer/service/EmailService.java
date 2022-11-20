package com.petmily.customer.service;

import javax.servlet.http.HttpServletRequest;

public interface EmailService {
	public int sendEmail(HttpServletRequest request) throws Exception;
}

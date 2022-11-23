package com.petmily.customer.api;

import com.petmily.customer.dto.KakaoDTO;

public interface KakaoAPI {
	
	public String getToken(String code) throws Exception;
	
	public KakaoDTO getKakao(String access_token) throws Exception;
	
	public void unlink(long id, String access_token) throws Exception;
	
}

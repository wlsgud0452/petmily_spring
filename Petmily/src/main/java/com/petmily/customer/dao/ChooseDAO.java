package com.petmily.customer.dao;

import java.util.List;

import com.petmily.customer.dto.ChooseDTO;

public interface ChooseDAO {
	public void insert(List<ChooseDTO> list) throws Exception;
}

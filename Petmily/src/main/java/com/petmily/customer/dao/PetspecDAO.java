package com.petmily.customer.dao;

import java.util.List;

import com.petmily.customer.dto.PetspecDTO;

public interface PetspecDAO {
	
	public List<PetspecDTO> petSpecListFour(String pstype) throws Exception;
	
}

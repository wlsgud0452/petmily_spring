package com.petmily.customer.dao;

import java.util.List;

import com.petmily.customer.dto.PetDTO;

public interface PetDAO {
	
	public void insert(List<PetDTO> list ,String uid) throws Exception;
	public List<Integer> selectPetId(String uid) throws Exception;
}

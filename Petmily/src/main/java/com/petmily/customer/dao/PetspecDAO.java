package com.petmily.customer.dao;

import java.util.List;

import com.petmily.customer.dto.PetspecDTO;

public interface PetspecDAO {
	
	public List<PetspecDTO> petSpecListFour(String pstype) throws Exception;
	public List<Integer> selectPsId(List<String> pstype, List<String> psbreeds) throws Exception;
	public List<String> psbreedsList(String pstype) throws Exception;
	
}

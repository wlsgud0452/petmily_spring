package com.petmily.customer.dao;

import java.util.List;
import java.util.Map;

public interface AbandonedDAO {
	public List<Map<Integer,Integer>> chart() throws Exception;
	public List<Map<Integer,Double>> ratio() throws Exception;
}

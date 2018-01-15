package com.shubham.EcommerceBackend.dao;

import java.util.List;

import com.shubham.EcommerceBackend.dto.Category;

public interface CategoryDao {
	
	List<Category> list();
	boolean add(Category category);
	void data(Category category);

}

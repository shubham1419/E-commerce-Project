package com.shubham.EcommerceBackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.EcommerceBackend.dao.CategoryDao;
import com.shubham.EcommerceBackend.dto.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category cat = new Category();
		/*1 product*/
		cat.setId(1);
		cat.setName("Mobile");
		cat.setDescription("This is descrition for mobile");
		cat.setImage_url("mobile_1.png");
		
		categories.add(cat);
		
		/*2 product*/
		cat = new Category();
		cat.setId(1);
		cat.setName("Laptop");
		cat.setDescription("This is descrition for laptop");
		cat.setImage_url("laptop_1.png");
		
		categories.add(cat);
	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}


	@Override
	@Transactional
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

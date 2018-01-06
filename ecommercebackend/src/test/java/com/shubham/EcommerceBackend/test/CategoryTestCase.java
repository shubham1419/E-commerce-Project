package com.shubham.EcommerceBackend.test;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.shubham.EcommerceBackend.dao.CategoryDao;
import com.shubham.EcommerceBackend.dto.Category;

public class CategoryTestCase {
	
	@Autowired
	private static CategoryDao categoryDaoBean;
	
	/*private static CategoryDao categoryDao;
	
	private static AnnotationConfigApplicationContext context;*/
	
	private Category category;
	
	
	/*@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shubham.EcommecreBackend");
		context.refresh();
		categoryDao = (CategoryDao)context.getBean("categoryDaoBean");
		
	}*/

	@Test
	public void testAddCategory()
	{
		category = new Category();
		category.setName("Mobile");
		category.setDescription("This is descrition for mobile");
		category.setImage_url("mobile_1.png");
		
		assertEquals("Successfully inserted the category",true,categoryDaoBean.add(category));
	}
}

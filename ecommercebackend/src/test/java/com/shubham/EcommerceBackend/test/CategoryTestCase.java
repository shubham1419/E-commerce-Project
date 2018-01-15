package com.shubham.EcommerceBackend.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.EcommerceBackend.config.HibernateConfig;
import com.shubham.EcommerceBackend.dao.CategoryDao;
import com.shubham.EcommerceBackend.dto.Category;

public class CategoryTestCase {
	
	
	private static CategoryDao categoryDao;
	
	private static AnnotationConfigApplicationContext context;
	
	private Category category;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		
		categoryDao =  context.getBean(CategoryDao.class);
	}
	
	@Test
	public void testAddCategory()	{
		category = new Category();	
		category.setName("Mobile");
		category.setDescription("This is descrition for mobile");
		category.setImage_url("mobile_1.png");
		//categoryDao.data(category);
		
	assertEquals("Successfully inserted the category", true, categoryDao.add(category));
	}
		 
		    /*@BeforeClass
		    public static void onceExecutedBeforeAll() {
		        System.out.println("@BeforeClass: onceExecutedBeforeAll");
		    }
		 
		    @Before
		    public void executedBeforeEach() {
		        testList = new ArrayList();
		        System.out.println("@Before: executedBeforeEach");
		    }*/
	 
		   /* @Test
		    public void EmptyCollection() {
		        assertTrue(testList.isEmpty());
		        System.out.println("@Test: EmptyArrayList");
		 
		    }
		 
		    @Test
		    public void OneItemCollection() {
		        testList.add("oneItem");
	        assertEquals(1, testList.size());
		        System.out.println("@Test: OneItemArrayList");
		    }*/

}


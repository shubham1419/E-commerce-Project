package com.shubham.EcommerceBackend;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.EcommerceBackend.config.HibernateConfig;
import com.shubham.EcommerceBackend.dao.CategoryDao;
import com.shubham.EcommerceBackend.daoImpl.CategoryDaoImpl;
import com.shubham.EcommerceBackend.dto.Category;


/**
 * Hello world!
 *
 */


public class App 
{
	
    public static void main( String[] args ) throws SQLException
    {
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
    	CategoryDao dao = context.getBean(CategoryDao.class);
       /* String name= "laptop";
        String desc= "description";
        String img="image";*/
        
        Category cat = new Category();
       // CategoryDao dao =new CategoryDaoImpl();
        cat.setName("lap");
        cat.setDescription("description");
        cat.setImage_url("lap_1.png");
       
        dao.data(cat);
      //  cat.check();
        context.close();
    }
}



/*
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}*/

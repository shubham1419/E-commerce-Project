package com.shubham.ecommercefrontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shubham.ecommercebackend.dao.CategoryDao;
import com.shubham.ecommercebackend.dao.ProductDao;
import com.shubham.ecommercebackend.dto.Category;
import com.shubham.ecommercebackend.dto.Product;
import com.shubham.ecommercefrontend.exception.ProductNotFoundException;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired 
	private CategoryDao categoryDao;
	
	@Autowired 
	private ProductDao productDao;
	
	@RequestMapping(value={"/","home","index"})
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title","Home");
		/*for logger (used in msg)*/
		logger.info("Inside Main Controller index method -INFO");
		logger.debug("Inside Main Controller index method -DEBUG");
		/*for passing our list of categories*/
		mv.addObject("allCategories",categoryDao.list());
		mv.addObject("userClickHome",true);
		return mv;
	}
	@RequestMapping(value={"/about"})
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	@RequestMapping(value={"/contact"})
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	/*for products*/
	@RequestMapping(value={"/all/products"})
	public ModelAndView products()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title","All Products");
		/*for passing our list of categories*/
		mv.addObject("allCategories",categoryDao.list());
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	
	@RequestMapping(value={"/all/{id}/products"})
	public ModelAndView categoryProducts(@PathVariable("id") int id)
	{
		
		ModelAndView mv = new ModelAndView("index");
		/*get single category name by id */
		Category category = null;
		category = categoryDao.get(id);		
		mv.addObject("title",category.getName());
		/*for passing our list of categories*/
		mv.addObject("allCategories",categoryDao.list());
		/*for passing single category object*/
		mv.addObject("category",category);
		mv.addObject("userClickCategoryProducts",true);
		return mv;
	}
	
	@RequestMapping(value={"/show/{id}/products"})
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException
	{
		
		ModelAndView mv = new ModelAndView("index");		
		Product product = productDao.get(id);
		if(product==null) throw new ProductNotFoundException();
		/*update view count */
		product.setViews(product.getViews() + 1);
		productDao.update(product);
		
		/*title of product*/
		mv.addObject("title",product.getName());
		/*for passing single product object*/
		mv.addObject("product",product);
		mv.addObject("userClickShowProduct",true);
		return mv;
	}
	
	
	//difference in reqparam & pathvar
	//by using RequestParam
	/*@RequestMapping("/test")
	public ModelAndView test(@RequestParam(value= "greeting", required=false)String greets)
	{
		if(greets==null)
		{
			greets="Hii";
		}
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("greetings",greeting);
		return mv;
	}*/
	
	//By PathVariable
	/*@RequestMapping("/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting")String greets)
	{
		if(greets==null)
		{
			greets = "Hii";
		}
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("greetings",greets);
		return mv;
	}*/
}

package com.shubham.ecommercefrontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shubham.ecommercebackend.dao.CategoryDao;
import com.shubham.ecommercebackend.dto.Category;
import com.shubham.ecommercebackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping("/products")
	public ModelAndView showManageProducts()
	{
		ModelAndView mv= new ModelAndView("index");
		mv.addObject("userClickManageProduct", true);
		mv.addObject("title", "Manage Products");
		Product nProduct = new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product",nProduct);
		return mv;
		
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST )
	public String handleProductSubmission(@ModelAttribute("product") Product mProduct) {
		
		
		return "redirect:/manage/products";
	}
	
	/*for all method catgories*/
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDao.list();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

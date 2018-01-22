package com.shubham.ecommercefrontend;

import java.util.List;

//import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shubham.ecommercebackend.dao.CategoryDao;
import com.shubham.ecommercebackend.dao.ProductDao;
import com.shubham.ecommercebackend.dto.Category;
import com.shubham.ecommercebackend.dto.Product;
import com.shubham.ecommercefrontend.util.FileUploadUtility;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping("/products")
	public ModelAndView showManageProducts(@RequestParam(name="operation", required= false) String operation)
	{
		ModelAndView mv= new ModelAndView("index");
		mv.addObject("userClickManageProduct", true);
		mv.addObject("title", "Manage Products");
		Product nProduct = new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product",nProduct);
		
		if(operation!= null)
		{
			if(operation.equals("product"))
			{
				mv.addObject("message", "Product Added Successfully!..");
				mv.addObject("mclass", "success");
			}
		}
		return mv;
		
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST )
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model) {
		//if errors
		if(results.hasErrors())
		{
			model.addAttribute("userClickManageProduct", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Failed to create new Product!..");
			model.addAttribute("mclass", "danger");
			return "index";
		}
		
		logger.info(mProduct.toString());
		// to create new product
		productDao.add(mProduct);	
		
		/*if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}*/
		return "redirect:/manage/products?operation=product";
	}
	
	/*for all method catgories*/
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDao.list();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

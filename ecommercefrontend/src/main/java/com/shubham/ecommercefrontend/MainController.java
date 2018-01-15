package com.shubham.ecommercefrontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shubham.ecommercebackend.dao.CategoryDao;

@Controller
public class MainController {
	
	@Autowired 
	private CategoryDao categoryDao;
	
	@RequestMapping(value={"/","home","index"})
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title","Home");
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
	
	@RequestMapping(value={"/all/{name}/products"})
	public ModelAndView categoryProducts(@PathVariable("name") String name)
	{
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title",name);
		/*for passing our list of categories*/
		mv.addObject("allCategories",categoryDao.list());
		/*for passing single category object*/
		mv.addObject("category",name);
		mv.addObject("userClickCategoryProducts",true);
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

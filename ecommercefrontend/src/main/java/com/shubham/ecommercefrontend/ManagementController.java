package com.shubham.ecommercefrontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@RequestMapping("/products")
	public ModelAndView showManageProducts()
	{
		ModelAndView mv= new ModelAndView("index");
		mv.addObject("userClickManageProduct", true);
		mv.addObject("title", "Manage Products");
		return mv;
		
	}
	
}

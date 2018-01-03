package com.shubham.ecommercefrontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping(value={"/","home","index"})
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title","Home");
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

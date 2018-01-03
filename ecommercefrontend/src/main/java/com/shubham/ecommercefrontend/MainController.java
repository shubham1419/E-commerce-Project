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
		mv.addObject("greetings","Welcome to index page");
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

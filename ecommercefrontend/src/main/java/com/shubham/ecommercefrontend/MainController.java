package com.shubham.ecommercefrontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping(value={"/","home","index"})
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("grettings","Welcome to index page");
		return mv;
	}
}

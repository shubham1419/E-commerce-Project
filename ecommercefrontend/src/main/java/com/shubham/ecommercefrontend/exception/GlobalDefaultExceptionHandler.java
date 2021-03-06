package com.shubham.ecommercefrontend.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public  ModelAndView handlerNoHandlerFoundException()
	{
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","The page is not found");

		mv.addObject("errorDescription","Please check for any typo... ");

		mv.addObject("title","404 page not found");

		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public  ModelAndView handlerProductNotFoundException()
	{
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","Product not exist");

		mv.addObject("errorDescription","This product you are looking for does not exist...");

		mv.addObject("title","Product not available");

		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public  ModelAndView handlerException(Exception e)
	{
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","Page not Exist");
		
		/*for debugging purpose*/
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		e.printStackTrace(pw);
		/*end*/

		mv.addObject("errorDescription","Please check for any typo...");

		mv.addObject("title","404 Not Found");

		return mv;
	}
}

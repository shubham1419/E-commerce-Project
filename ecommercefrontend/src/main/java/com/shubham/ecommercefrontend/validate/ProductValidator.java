package com.shubham.ecommercefrontend.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.shubham.ecommercebackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//file is selected or not
		Product product = (Product) target;
		
		if(product.getFile()== null || 	product.getFile().getOriginalFilename().equals(""))
		{
			errors.reject("file",null,"Please select an image!..");
			return;
		}
		
		//only image
		if(! (product.getFile().getContentType().equals("image/jpeg") || 
			  product.getFile().getContentType().equals("image/png") ||
			  product.getFile().getContentType().equals("image/gif")
				))
		{
			errors.rejectValue("file", null, "Plsease use only image to upload");
			return;
		}
		
		
	}

}

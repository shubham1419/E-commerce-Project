package com.shubham.ecommercefrontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shubham.ecommercebackend.dao.ProductDao;
import com.shubham.ecommercebackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonController {

	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts()
	{
		return productDao.allActiveProducts();
	}
		
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductByCategory(@PathVariable int id)
	{
		return productDao.allActiveProductsByCategory(id);
	}
	
}

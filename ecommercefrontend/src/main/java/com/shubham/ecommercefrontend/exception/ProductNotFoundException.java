package com.shubham.ecommercefrontend.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {

	private static final long serialVersionUID = 1l;
	private String msg;
	
	public ProductNotFoundException() {
		this("Product Not Found!!");
	}
	
	public ProductNotFoundException(String msg) {
		this.msg = System.currentTimeMillis() + ": " +msg;
	}

	public String getMsg() {
		return msg;
	}
	
	
}

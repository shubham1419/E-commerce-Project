package com.shubham.ecommercefrontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.shubham.ecommercebackend.dao.UserDao;
import com.shubham.ecommercebackend.dto.Address;
import com.shubham.ecommercebackend.dto.Cart;
import com.shubham.ecommercebackend.dto.User;
import com.shubham.ecommercefrontend.model.RegisterModel;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public RegisterModel init()
	{
		return new RegisterModel();
	}
	public void addUser(RegisterModel registerModel ,User user)
	{
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel ,Address billing)
	{
		registerModel.setBilling(billing);
	}
	
	public String saveAll(RegisterModel model)
	{
		String state = "success";
		
		//fetch user
		
		User user = model.getUser();
		
		
		if(user.getRole().equals("USER"));
		{
			System.out.println("in user");
			 Cart cart = new Cart();
			 cart.setUser(user);
			 user.setCart(cart);
		}
		
		//encode password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		//save user
		userDao.addUser(user);
		
		//get address
		Address billing = model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		
		//save address
		userDao.addAddress(billing);
		
		return state;
	}
	
	public String validateUser(User user, MessageContext error)
	{
		String state = "success";
		
		//for confirm password
		if(!(user.getPassword().equals(user.getConfirmPassword())))
			{
				
			error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("Password does not matched!..").build());
			state = "failure";
			
			}
		
		//for unique email id
		
		if((userDao.getByEmail(user.getEmail())!=null))
		{
			
		error.addMessage(new MessageBuilder().error().source("email").defaultText("Email already exist!..").build());
		state = "failure";
		
		}
		
		return state;
	}
}

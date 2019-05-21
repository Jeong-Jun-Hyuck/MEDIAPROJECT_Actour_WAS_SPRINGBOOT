package com.actour.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.actour.api.bo.UserService;
import com.actour.api.dao.LoginResultModel;
import com.actour.api.dao.RegisterResultModel;
import com.actour.api.dao.User;
import com.actour.api.dao.UserForLogin;

@RestController
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping()
	public String test() {
		return "gg";
	}
	@PostMapping()
	public RegisterResultModel insertUser(@RequestBody User user)
	{
		System.out.println(user.getName());
		RegisterResultModel result;
		
		if(userService.insertUser(user))
			result=new RegisterResultModel(true, "success");
		else
			result= new RegisterResultModel(false, "conflict");
		return result;
	}
	@PostMapping(path="/login")
	public LoginResultModel login(@RequestBody UserForLogin userForLogin)
	{
		return  userService.login(userForLogin.getId(),userForLogin.getPassword());
	}
}

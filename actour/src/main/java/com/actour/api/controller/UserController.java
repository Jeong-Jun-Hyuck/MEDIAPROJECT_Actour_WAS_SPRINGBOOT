package com.actour.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.actour.api.bo.FileUploadService;
import com.actour.api.bo.RecommandService;
import com.actour.api.bo.UserService;
import com.actour.api.dao.LoginResultModel;
import com.actour.api.dao.ProductCourse;
import com.actour.api.dao.ProductModelForRecommand;
import com.actour.api.dao.ProductSet;
import com.actour.api.dao.RegisterResultModel;
import com.actour.api.dao.Result;
import com.actour.api.dao.User;
import com.actour.api.dao.UserForLogin;

@RestController
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	RecommandService recommandService;
	
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
	
	@PostMapping("/upload")
	public Result upload(@RequestPart MultipartFile file)
	{
		System.out.println("ddd");
		String url = fileUploadService.restore(file);
		Result re = new Result("success");
		return re;
	}
	@PostMapping("/uploadproductSet")
	public Result uploadProduct(@RequestBody ProductSet productSet)
	{
		userService.insertProductSet(productSet);
		ArrayList<ProductCourse> aa = productSet.getProductCourses();
		userService.insertCourses(aa);
		System.out.println(aa.get(0).getCourseName());
		System.out.println();
		Result re = new Result("success");
		return re;
	}
	@PostMapping("/makeProductID")
	public Integer makeProductID()
	{
		
		Integer result = userService.getNewProductId();
		return result;
		
	}
	
	@PostMapping("/getRecommand")
		public List<ProductModelForRecommand> getRecommand(){
		
		recommandService.getRecommandByContentBase(17);
			return null;
		
	}
}

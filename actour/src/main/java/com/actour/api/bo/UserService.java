package com.actour.api.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actour.api.dao.LoginResultModel;
import com.actour.api.dao.ProductCourse;
import com.actour.api.dao.ProductSet;
import com.actour.api.dao.User;
import com.actour.api.dao.productPrototype;
import com.actour.api.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	public boolean insertUser(User user)
	{
		System.out.println(user.getName()+"hh");
		//중복확인
		if(userMapper.isUserPossible(user.getId())==0){
			userMapper.insertUser(user);
			return true;
		}else
			return false;
		
	}

	
	public LoginResultModel login(String id, String password)
	{
		LoginResultModel loginResultModel = null;
		Integer systemId = userMapper.login(id,password);
		System.out.println(systemId);
		if(systemId!=null) {
			String userId = userMapper.loginForId(systemId.intValue());
			System.out.println("sucess login"+systemId);
			return loginResultModel = new LoginResultModel(true, "success", userId, systemId);
			
		}
		else {
			return loginResultModel = new LoginResultModel(false, "failue", null, 0);
		}
	}
	public void insertProductSet(ProductSet ps) {
		int productID = ps.getProductModel().getId();
		userMapper.updateProduct(ps.getProductModel());
		System.out.println(productID);
		
	}
	public void insertCourses(ArrayList<ProductCourse> cl ) {
		List<ProductCourse> dd = cl;
		for(int i = 0; i< dd.size();i++) {
			System.out.println(dd.get(i).getCourseName());
		}
		userMapper.insertCourses(dd);
	}
	public int getNewProductId() {
		productPrototype pd = new productPrototype();
		userMapper.getNewID(pd);
		return pd.getId();
	}
}

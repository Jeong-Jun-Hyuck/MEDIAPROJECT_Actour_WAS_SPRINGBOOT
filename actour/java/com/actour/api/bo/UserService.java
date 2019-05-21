package com.actour.api.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actour.api.dao.LoginResultModel;
import com.actour.api.dao.User;
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
			return loginResultModel = new LoginResultModel(true, "success", userId, systemId);
			
		}
		else {
			return loginResultModel = new LoginResultModel(false, "failue", null, 0);
		}
	}
}

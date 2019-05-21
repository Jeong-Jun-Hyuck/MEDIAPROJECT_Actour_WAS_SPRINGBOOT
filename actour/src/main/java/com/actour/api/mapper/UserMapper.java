package com.actour.api.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.actour.api.dao.User;

@Mapper
public interface UserMapper {
	
	void insertUser(User user);
	Integer login(String id, String password);
	String loginForId(int systemId);
	int isUserPossible(String userId);
}

package com.actour.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.actour.api.dao.ProductCourse;
import com.actour.api.dao.ProductModel;
import com.actour.api.dao.ProductModelForRecommand;
import com.actour.api.dao.User;
import com.actour.api.dao.UserForRecommand;
import com.actour.api.dao.productPrototype;

@Mapper
public interface UserMapper {
	
	void insertUser(User user);
	Integer login(String id, String password);
	String loginForId(int systemId);
	int isUserPossible(String userId);
	void getNewID(productPrototype pd);
	void insertCourses(List<ProductCourse> cl);
	void updateProduct(ProductModel productModel);
	UserForRecommand getUserForRecommand (int systemId);
	List<ProductModelForRecommand> getProductList (@Param("gerne")String gerne, @Param("point1")double point1,@Param("point2")double point2);
}

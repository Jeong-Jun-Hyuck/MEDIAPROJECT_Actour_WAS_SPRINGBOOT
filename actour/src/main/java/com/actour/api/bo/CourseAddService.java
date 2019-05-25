package com.actour.api.bo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actour.api.dao.ProductCourse;
import com.actour.api.mapper.UserMapper;

@Service
public class CourseAddService {

	
	@Autowired
	UserMapper userMapper;
	
	public boolean insertProduct() {
		return true;
	}
	
	public boolean insertCourses(List<ProductCourse> list) {
		return true;
	}
}

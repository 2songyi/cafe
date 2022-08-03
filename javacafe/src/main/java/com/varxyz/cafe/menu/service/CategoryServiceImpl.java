package com.varxyz.cafe.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.varxyz.cafe.menu.command.MainCategoryCommand;
import com.varxyz.cafe.menu.command.SubCategoryCommand;
import com.varxyz.cafe.menu.repository.CategorySpringJdbcImpl;

@Component
public class CategoryServiceImpl {
	
	@Autowired
	private CategorySpringJdbcImpl dao;
	
	// 카테고리 대분류 등록

	public void addMainCategory(String category) {
		// 중복검사
		
		dao.addMainCategory(category);
	}

	// 카테고리 소분류 등록
	public void addSubCategory(long mainId, String category) {
		dao.addSubCategory(mainId, category);
		
	}
	
	// 대분류 카테고리 조회
	public List<MainCategoryCommand> findAllMainCategory() {
		return dao.findAllMainCategory();
	}
	
	// 소분류 카테고리 조회
	public List<SubCategoryCommand> findAllSubCategory() {
		return dao.findAllSubCategory();
	}
	
	

	

}

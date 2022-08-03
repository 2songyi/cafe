package com.varxyz.cafe.menu.service;

import java.util.List;

import com.varxyz.cafe.menu.command.MainCategoryCommand;

public interface CategoryService {
	
	//카테고리 대분류 등록
	void addMainCategory(String category);
	
	//카테고리 소분류 등록
	void addSubCategory(long mainId, String category);
	
	//전체 메뉴 찾기
	List<MainCategoryCommand> findAllMainCategory();
}

package com.varxyz.cafe.menu.repository;

import java.util.List;

import com.varxyz.cafe.menu.command.MainCategoryCommand;
import com.varxyz.cafe.menu.domain.MenuCategory;

public interface CategoryRepository {
	
	void addMainCategory(String category);
	
	void addSubCategory(long mainId, String category);
	
	List<MainCategoryCommand> findAllMainCategory();

}

package com.varxyz.cafe.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.varxyz.cafe.menu.command.MenuListCommand;
import com.varxyz.cafe.menu.domain.MenuCategory;
import com.varxyz.cafe.menu.domain.MenuItem;
import com.varxyz.cafe.menu.domain.SubCategory;
import com.varxyz.cafe.menu.repository.MenuSpringJdbcImpl;

@Component
public class MenuServiceImpl {
	
	@Autowired
	private MenuSpringJdbcImpl dao;
	
	// 메뉴 등록
	public void addMenu(String category, String subCategory,
			String itemName, long itemPrice, String itemImage) {
		
		MenuItem menuItem = new MenuItem();
		MenuCategory mcategory = new MenuCategory();
		mcategory.setMainCategory(category);
		mcategory.setSubCategory(new SubCategory(subCategory));
		
		menuItem.setCategory(mcategory);
		menuItem.setItemCode(generateCode());
		menuItem.setItemName(itemName);
		menuItem.setItemPrice(itemPrice);
		
		dao.addMenu(menuItem);
	}
	
	// 카테고리별 메뉴 조회
	public List<MenuListCommand> findMenuListByCategory(String mainCategory, String subCategory) {
		return dao.findMenuListByCategory(mainCategory, subCategory);
	}
	// 전체 메뉴 조회
	public List<MenuListCommand> findAllMenu() {
		return dao.findAllMenu();
	}
	
	//바코드 생성기
	public String generateCode() {
		String codeNum = "";

		for (int i = 0; i < 3; i++) {
			codeNum += (int) (Math.random() * 10);
		}
		codeNum += "-";
		for (int i = 0; i < 2; i++) {
			codeNum += (int) (Math.random() * 10);
		}
		codeNum += "-";
		for (int i = 0; i < 4; i++) {
			codeNum += (int) (Math.random() * 10);
		}

		return codeNum;
	}
}

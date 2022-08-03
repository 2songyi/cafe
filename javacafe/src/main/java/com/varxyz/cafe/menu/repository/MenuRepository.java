package com.varxyz.cafe.menu.repository;

import java.util.List;

import com.varxyz.cafe.menu.domain.MenuItem;

public interface MenuRepository {
	
	// 메뉴 등록
	void addMenu(MenuItem menuItem);
	
	// 메뉴 수정
	void updateMenu();
	
	// 메뉴 삭제
	void deleteMenu();
	
	// 카테고리별 메뉴 조회
	List<MenuItem> findMenu();
	
	// 이름과 카테고리로 메뉴 조회
	MenuItem findMenuByName();
	
	// 메뉴코드로 상품 조회
	MenuItem findMenuByCode();
	
	
}

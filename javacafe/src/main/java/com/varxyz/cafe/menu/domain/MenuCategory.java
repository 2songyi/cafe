package com.varxyz.cafe.menu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuCategory {
	private long mainId;
	private String mainCategory;
	private SubCategory subCategory;
	
	
	// 카테고리 세분화
	// 메뉴 할인
	
	public MenuCategory() {
		
	}

	@Override
	public String toString() {
		return mainId + "," + mainCategory + "," + subCategory;
	}
	
}

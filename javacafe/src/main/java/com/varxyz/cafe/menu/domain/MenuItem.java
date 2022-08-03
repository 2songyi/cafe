package com.varxyz.cafe.menu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuItem {
	private long itemId;
	private MenuCategory category;
	private String itemCode; //상품바코드번호
	private String itemName;
	private long itemPrice;
	private String itemImage;
	
	public MenuItem() {
		
	}

	@Override
	public String toString() {
		return itemId + "," + category + "," + itemCode + ","
				+ itemName + "," + itemPrice + "," + itemImage;
	}
	
	
}

package com.varxyz.cafe.menu.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuItemCommand {
	private String mainCategory;
	private String subCategory;
	private String itemName;
	private long itemPrice;
	private String itemImage;
	
	public MenuItemCommand() {
		
	}

	@Override
	public String toString() {
		return mainCategory + "," + subCategory + "," + itemName + "," + itemPrice + "," + itemImage;
	}
	
	
}

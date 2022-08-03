package com.varxyz.cafe.menu.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuListCommand {
	private String mainCategory;
	private String subCategory;
	private String itemCode;
	private String itemName;
	private String itemPrice;
	private String itemImage;
}

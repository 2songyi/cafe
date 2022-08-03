package com.varxyz.cafe.purchase.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CartItemCommand {
	private String mainCategory;
	private String subCategory;
	private String itemCode;
	private String itemName;
	private long itemPrice;
	private int count;
	
	public CartItemCommand() {
		
	}

	@Override
	public String toString() {
		return mainCategory + "," + subCategory + ","
				+ itemCode + "," + itemName + "," + itemPrice + "," + count;
	}
	
	
}

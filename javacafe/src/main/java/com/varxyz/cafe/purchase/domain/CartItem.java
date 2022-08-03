package com.varxyz.cafe.purchase.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
	private String mainCategory;
	private String subCategory;
	private String itemCode;
	private String itemName;
	private long itemprice;
	private int count;
}

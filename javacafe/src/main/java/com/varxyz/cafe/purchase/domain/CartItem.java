package com.varxyz.cafe.purchase.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
	private String itemName;
	private String itemCode;
	private String totalPrice;
	private String count;
}

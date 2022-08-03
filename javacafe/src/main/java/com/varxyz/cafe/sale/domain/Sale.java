package com.varxyz.cafe.sale.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sale {
	private long sid;
	private String mainCategory;
	private String subCategory;
	private String itemCode;
	private String itemName;
	private long itemPrice;
	private int count;
	private Date regDate;
	
	@Override
	public String toString() {
		return sid + "," + mainCategory + "," + subCategory + ","
				+ itemCode + "," + itemName + "," + itemPrice + "," + count + ","
				+ regDate;
	}
	
	
}

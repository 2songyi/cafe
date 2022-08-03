package com.varxyz.cafe.menu.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SubCategoryCommand {
	private long subId;
	private long mainId;
	private String subCategory;
	
	public SubCategoryCommand() {
		
	}

	@Override
	public String toString() {
		return subId + "," + mainId + "," + subCategory;
	}
	
	
}

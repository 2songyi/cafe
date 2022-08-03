package com.varxyz.cafe.menu.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class MainCategoryCommand {
	private long mainId;
	private String mainCategory;
	@Override
	public String toString() {
		return mainId + "," + mainCategory;
	}
	
	
}

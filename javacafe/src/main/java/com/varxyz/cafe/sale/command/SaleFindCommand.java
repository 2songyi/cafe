package com.varxyz.cafe.sale.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SaleFindCommand {
	private String mainCategory;
	private String subCategory;
	private String year;
	private String month;
	private String day;
	
}

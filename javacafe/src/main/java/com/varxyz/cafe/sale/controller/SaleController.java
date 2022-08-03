package com.varxyz.cafe.sale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("cafe.saleController")
public class SaleController {
	
	@GetMapping("cafe/sale")
	public String sale(Model model) {
		
		return "sale/sale";
	}

}

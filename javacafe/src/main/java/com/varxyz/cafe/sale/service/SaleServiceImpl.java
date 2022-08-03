package com.varxyz.cafe.sale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.varxyz.cafe.purchase.command.CartItemCommand;
import com.varxyz.cafe.sale.respository.SaleSpringJdbcImpl;

@Component
public class SaleServiceImpl {
	
	@Autowired
	private SaleSpringJdbcImpl dao;
	
	// 매출등록
	public void addSale(CartItemCommand cartItem) {
		dao.addSale(cartItem);
	}
	
}

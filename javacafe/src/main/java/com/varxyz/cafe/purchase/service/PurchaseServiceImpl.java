package com.varxyz.cafe.purchase.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.cafe.purchase.repository.PurchaseSpringJdbcImpl;

public class PurchaseServiceImpl {
	@Autowired
	private PurchaseSpringJdbcImpl dao;
	
	
}

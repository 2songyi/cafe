package com.varxyz.cafe.sale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.varxyz.cafe.purchase.command.CartItemCommand;
import com.varxyz.cafe.sale.domain.Sale;
import com.varxyz.cafe.sale.respository.SaleSpringJdbcImpl;

@Component
public class SaleServiceImpl {
	
	@Autowired
	private SaleSpringJdbcImpl dao;
	
	// 매출등록
	public void addSale(CartItemCommand cartItem) {
		dao.addSale(cartItem);
	}
	
	// 매출 전체 조회
	public List<Sale> findSaleList() {
		return dao.findSaleList();
	}
	
	// 카테고리로 조회
	public List<Sale> findSaleByCategory(String mainCategory, String subCategory) {
		return dao.findSaleByCategory(mainCategory, subCategory);
	}
	
	// 메인카테고리로 조회
//	public List<Sale> 
	
	// 년도 조회
	public List<Sale> findSaleYear(String year) {
		return dao.findSaleYear(year);
	}
	
	// 년, 월별 조회
	public List<Sale> findSaleMonth(String year, String month) {
		return dao.findSaleMonth(year, month);
	}
	
	// 년,월,일로 조회
	public List<Sale> findSaleDate(String year, String month, String day) {
		return dao.findSaleDate(year, month, day);
	}
	
	
}

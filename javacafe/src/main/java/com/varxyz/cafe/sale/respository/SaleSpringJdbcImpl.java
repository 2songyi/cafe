package com.varxyz.cafe.sale.respository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.cafe.purchase.command.CartItemCommand;
import com.varxyz.cafe.sale.domain.Sale;

@Repository
public class SaleSpringJdbcImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public SaleSpringJdbcImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 매출등록
	public void addSale(CartItemCommand cartItem) {
		String sql = "INSERT INTO Sale(mainCategory, subCategory, itemCode, "
				+ " itemName, itemPrice, count) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, cartItem.getMainCategory(), cartItem.getSubCategory(), cartItem.getItemCode(),
				cartItem.getItemName(), cartItem.getItemPrice(), cartItem.getCount());
	}
	
	// 매출 전체 조회
	public List<Sale> findSaleList() {
		String sql = "SELECT * FROM Sale";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Sale>(Sale.class));
	}
	
	// 카테고리로 조회
	public List<Sale> findSaleByCategory(String mainCategory, String subCategory) {
		String sql = "SELECT * FROM Sale WHERE mainCategory = ?, subCategory = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Sale>(Sale.class),mainCategory, subCategory);
	}
	
	// 메인카테고리로 조회
	public List<Sale> findSaleByMainCate(String mainCategory) {
		
		return null;
	}
	
	
	// 년도 검색
	public List<Sale> findSaleYear(String year) {
		String sql = "SELECT * FROM Sale WHERE YEAR(regDate) = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Sale>(Sale.class), year);
	}
	
	// 해당 년도의 월별 검색
	public List<Sale> findSaleMonth(String year, String month) {
		String sql = "SELECT * FROM Sale WHERE YEAR(regDate) = ? AND MONTH(regDate) = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Sale>(Sale.class), year, month);
	}
	
	// 년,월,일로 검색
	public List<Sale> findSaleDate(String year, String month, String day) {
		String sql = "SELECT * FROM Sale WHERE YEAR(regDate) = ? AND "
				+ "MONTH(regDate) = ? AND DAY(regDate) = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Sale>(Sale.class),year, month, day);
	}

	

}

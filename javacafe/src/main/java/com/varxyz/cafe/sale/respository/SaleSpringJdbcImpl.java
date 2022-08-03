package com.varxyz.cafe.sale.respository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.cafe.purchase.command.CartItemCommand;
import com.varxyz.cafe.sale.command.SaleCommand;

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
	public List<SaleCommand> findSaleList() {
		String sql = "SELECT * FROM Sale";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<SaleCommand>(SaleCommand.class));
	}
	
	
}

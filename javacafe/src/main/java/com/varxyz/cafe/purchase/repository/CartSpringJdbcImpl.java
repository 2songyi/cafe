package com.varxyz.cafe.purchase.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.cafe.purchase.command.CartItemCommand;
import com.varxyz.cafe.purchase.domain.CartItem;

@Repository
public class CartSpringJdbcImpl {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CartSpringJdbcImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 장바구니에 아이템 담기
	public void addCartItem(CartItem cartItem) {
		String sql = "INSERT INTO CartItem(mainCategory, subCategory, itemCode, "
				+ " itemName, itemPrice ) VALUES (?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, cartItem.getMainCategory(), cartItem.getSubCategory(),
				cartItem.getItemCode(), cartItem.getItemName(), cartItem.getItemprice());
	}
	
	// 장바구니 아이템 수정하기
	public void updateCartItem(long itemPrice, int count, String itemName) {
		String sql = "UPDATE CartItem SET itemPrice = ?, count = ? WHERE itemName = ?";
		jdbcTemplate.update(sql, itemPrice, count, itemName);
	}
	
	// 장바구니 리스트 뽑기
	public List<CartItemCommand> findCartList() {
		String sql = "SELECT * FROM CartItem";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<CartItemCommand>(CartItemCommand.class));
	}
	
	// 장바구니 아이템 삭제하기
	public void deleteCartItem(String itemName) {
		String sql = "DELETE FROM CartItem WHERE itemName = ?";
		jdbcTemplate.update(sql, itemName);
	}
	
	// 장바구니 비우기
	public void emptyCart() {
		String sql = "DELETE FROM CartItem";
		jdbcTemplate.update(sql);
	}
	
	// 카트에 이미 해당 메뉴가 있는지 확인하기
	public boolean findMenuItemByName(String itemName) {
		
		try {
			String sql = "SELECT itemName FROM CartItem WHERE itemName = ?";
			jdbcTemplate.queryForObject(sql, String.class, itemName);
		} catch (Exception e) {
			return false;
		}
		
		//해당하는 메뉴가 있으면 true
		return true;
		
	}
	
	//카트에 들어있는 상품 이름으로 조회
	public CartItem findCartItem(String itemName) {
		String sql = "SELECT * FROM CartItem WHERE itemName = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<CartItem>(CartItem.class), itemName);
		
	}
	
	// 카트에 담긴 항목 가격 총 합계
	public long sumPriceByCartItem() {
		try {
			String sql = "SELECT sum(itemPrice) FROM CartItem";
			return jdbcTemplate.queryForObject(sql, Long.class);
		} catch (Exception e) {
			return 0;
		}
		
		
	}
	

}

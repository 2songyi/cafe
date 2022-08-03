package com.varxyz.cafe.menu.repository;

import static java.sql.Types.*;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.cafe.menu.command.MenuListCommand;
import com.varxyz.cafe.menu.domain.MenuItem;

@Repository
public class MenuSpringJdbcImpl {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public MenuSpringJdbcImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void addMenu(MenuItem menuItem) {
		String sql = "INSERT INTO MenuItem(mainCategory, subCategory, "
				+ " itemCode, itemName, itemPrice, itemImgae) "
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		//object를써서 연결되어있는 클래스의 값을 꺼내줘야한다.
		
		Object[] args = new Object[] {
				menuItem.getCategory().getMainCategory(), menuItem.getCategory().getSubCategory().getSubCategory(),
				menuItem.getItemCode(), menuItem.getItemName(), menuItem.getItemPrice(),
				menuItem.getItemImage()	
		};
		
		int[] types = new int[] {CHAR, CHAR, CHAR, CHAR, BIGINT, CHAR};
		jdbcTemplate.update(sql, args, types);
		
	}
	
	
	//카테고리별 상품 조회(대분류 소분류)
	public List<MenuListCommand> findMenuListByCategory(String mainCategory, String subCategory) {
		String sql = "SELECT * FROM MenuItem WHERE mainCategory = ? AND subCategory = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MenuListCommand>(MenuListCommand.class));
	}
	
	public List<MenuListCommand> findAllMenu() {
		String sql = "SELECT * FROM MenuItem";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MenuListCommand>(MenuListCommand.class));
	}

	public void updateMenu() {
		
	}

	public void deleteMenu() {
		
	}

	public List<MenuItem> findMenu() {
		return null;
	}

	public MenuItem findMenuByName() {
		return null;
	}

	public MenuItem findMenuByCode() {
		return null;
	}

}

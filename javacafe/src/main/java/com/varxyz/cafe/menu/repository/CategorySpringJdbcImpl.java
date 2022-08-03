package com.varxyz.cafe.menu.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.cafe.menu.command.MainCategoryCommand;
import com.varxyz.cafe.menu.command.SubCategoryCommand;

@Repository
public class CategorySpringJdbcImpl  {

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CategorySpringJdbcImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 대분류 카테고리
	public void addMainCategory(String category) {
		String sql = "INSERT INTO MainCategory(mainCategory) VALUES(?)";
		
		jdbcTemplate.update(sql, category);
		System.out.println("대분류 카테고리 등록");
		
	}
	
	// 소분류 카테고리 등록
	public void addSubCategory(long mainId, String category) {
		String sql = "INSERT INTO SubCategory(mainId, subCategory) VALUES(?, ?)";
		
		jdbcTemplate.update(sql, mainId, category);
		System.out.println("소분류 카테고리 등록");
	}

	//메인카테고리 전체 찾기
	public List<MainCategoryCommand> findAllMainCategory() {
		String sql = "SELECT * FROM MainCategory";
//		return jdbcTemplate.queryForList(sql, String.class);
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<MainCategoryCommand>(MainCategoryCommand.class));
	}
	
	// 서브카테고리 전체 찾기
	public List<SubCategoryCommand> findAllSubCategory() {
		String sql = "SELECT * FROM subCategory";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<SubCategoryCommand>(SubCategoryCommand.class));
	}
	
}

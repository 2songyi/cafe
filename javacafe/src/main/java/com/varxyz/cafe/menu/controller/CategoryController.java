package com.varxyz.cafe.menu.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.cafe.menu.command.MainCategoryCommand;
import com.varxyz.cafe.menu.domain.MenuCategory;
import com.varxyz.cafe.menu.domain.SubCategory;
import com.varxyz.cafe.menu.service.CategoryServiceImpl;

@Controller("cafe.categoryController")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl service;
	
	@GetMapping("cafe/add_category")
	public String addCategory(Model model) {
		List<MainCategoryCommand> mainCategoryList = service.findAllMainCategory();
		System.out.println(mainCategoryList);
		model.addAttribute("mainCategoryList", mainCategoryList);
		return "category/add_category";
	}
	
	// 메인 카테고리 등록
	@PostMapping("cafe/add_main_category")
	public String addMainCategory(@RequestParam String mainCategory, Model model) {
		
		//유효성검증
		System.out.println(mainCategory);
		service.addMainCategory(mainCategory);
		model.addAttribute("category", mainCategory);
		
		return "category/success_add_category";
	}
	
	// 서브 카테고리 등록
	@PostMapping("cafe/add_sub_category")
	public String addSubCategory(@RequestParam long mainCategory, @RequestParam String subCategory,
			Model model) {
		
		System.out.println(mainCategory);
		System.out.println(subCategory);
		service.addSubCategory(mainCategory, subCategory);
		model.addAttribute("category", subCategory);
		return "category/success_add_category";
	}
	
	

}

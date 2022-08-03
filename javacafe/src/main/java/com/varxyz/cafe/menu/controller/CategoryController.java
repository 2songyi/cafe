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
	
	
	
	/*
	// 메인 카테고리 등록
	@GetMapping("cafe/add_main_category")
	public String addMainCategoryForm(Model model) {
		model.addAttribute("category", new MenuCategory());	
		return "category/add_main_category";
	}
	
	@PostMapping("cafe/add_main_category")
	public String addCategory(Model model, @ModelAttribute("category") MenuCategory category) {
		
		// 입력값 유효성 검사
		
		String mainCategory = category.getMainCategory();
		service.addMainCategory(mainCategory);
		model.addAttribute("category", mainCategory);
		System.out.println("list" + service.findAllMainCategory());
		return "category/success_add_category";
	}
	
	// 서브카테고리 등록
	@GetMapping("cafe/add_sub_category")
	public String addSubCategoryForm(Model model) {
		model.addAttribute("category", new MenuCategory());
		// 메인카테고리 리스트 찾아서 addAttribute로 보내서 select박스로 출력하기
		model.addAttribute("mainCategoryList", service.findAllMainCategory());
		System.out.println(service.findAllMainCategory());
		return "category/add_sub_category";
	}
	
	@PostMapping("cafe/add_sub_category")
	public String addSubCategory(Model model, @ModelAttribute("category") MenuCategory category) {
		
			// main카테고리 id랑 카테고리 이름 등록
			// jsp에 select박스에 mainId를 value로 가져옴
			SubCategory scategory = category.getSubCategory();
			String subCategory = scategory.getSubCategory();
			System.out.println("main : " + category.getMainId());
			System.out.println("sub : " + scategory.getSubCategory());
			long mainId = category.getMainId();
			service.addSubCategory(mainId, subCategory);
			
			model.addAttribute("category", subCategory);
		
		return "category/success_add_category";
		
	}
	
	public  void main(String[] args) {
		System.out.println(service.findAllMainCategory());
	}

	*/
	

}

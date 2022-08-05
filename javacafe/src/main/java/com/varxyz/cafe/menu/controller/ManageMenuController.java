package com.varxyz.cafe.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.cafe.menu.service.CategoryServiceImpl;
import com.varxyz.cafe.menu.service.MenuServiceImpl;

@Controller("cafe.manageMenuController")
public class ManageMenuController {
	
	@Autowired
	private MenuServiceImpl mservice;
	
	@Autowired
	private CategoryServiceImpl cservice;
	
	@GetMapping("cafe/menu_list")
	public String ManageMenu(Model model) {
		model.addAttribute("mainCategoryList", cservice.findAllMainCategory());
		model.addAttribute("subCategoryList", cservice.findAllSubCategory());
		
		return "menu/menu_list";
	}
	
	// 상품 리스트 전체 조회
	@GetMapping("cafe/menu_list_all")
	public String MenuListAll(Model model) {
		model.addAttribute("mainCategoryList", cservice.findAllMainCategory());
		model.addAttribute("subCategoryList", cservice.findAllSubCategory());
		
		model.addAttribute("menuList", mservice.findAllMenu());
		return "menu/menu_list";
	}
	
	// 카테고리로 상품 리스트 조회
	@PostMapping("cafe/menu_list_category")
	public String MenuListByCategory(Model model, @RequestParam String mainCategory,
			@RequestParam String subCategory) {
		model.addAttribute("mainCategoryList", cservice.findAllMainCategory());
		model.addAttribute("subCategoryList", cservice.findAllSubCategory());
		
		// main이 all이거나 sub가 all일때
		if (mainCategory.equals("all")) {
			//전체조회
			model.addAttribute("menuList", mservice.findAllMenu());
			return "menu/menu_list";
		}
		
		if (subCategory.equals("all")) {
			// main으로만 조회
			model.addAttribute("menuList", mservice.findMenuListByMain(mainCategory));
			return "menu/menu_list";
		}
		
		// main이 선택되지 않고 sub가 선택될 수 없다.
		
		// 둘 다 조건이 들어온 경우
		
		model.addAttribute("menuList", mservice.findMenuListByCategory(mainCategory, subCategory));
		return "menu/menu_list";
		
		
	}
}

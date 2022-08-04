package com.varxyz.cafe.menu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.varxyz.cafe.menu.command.MenuItemCommand;
import com.varxyz.cafe.menu.service.CategoryServiceImpl;
import com.varxyz.cafe.menu.service.MenuServiceImpl;

@Controller("cafe.addMenuController")
@RequestMapping("/cafe/add_menu")
public class AddMenuController {
	
	@Autowired
	private MenuServiceImpl mservice;
	
	@Autowired
	private CategoryServiceImpl cservice;
	
	@GetMapping
	public String addMenuForm(Model model) {
//		model.addAttribute("menuItem", new MenuItemCommand());
		// 카테고리 리스트 뽑아서 model로 보내기
		model.addAttribute("mainCategoryList", cservice.findAllMainCategory());
		model.addAttribute("subCategoryList", cservice.findAllSubCategory());
		
		System.out.println(cservice.findAllSubCategory());
		return "menu/add_menu";
	}
	
	@PostMapping
	public String addMenu(Model model, HttpServletRequest request, MenuItemCommand menuItem) throws IOException  {
		request.setCharacterEncoding("UTF-8");
		
//			@RequestParam String mainCategory, @RequestParam String subCategory,
//			@RequestParam String itemName, @RequestParam long itemPrice, @RequestParam String itemImage
		// 카테고리정보는 해당 데이터의 id값을 받아와야하나, 이름을 가져와야하나

		// @RequestPart("files")
		// 업로드 하는거를 bean으로 만들어서 사용
		// 얼마나 자주 새로운 메뉴가 추가되고 , 카테고리가 바뀌는지
		// 이미지 받아오기
		
//		String path="/menu_img";
		String path="C:/Users/Administrator/git/cafe/javacafe/src/main/webapp/menu_img";
		int sizeLimit = 100 * 1024 * 1024;
		String encode = "UTF-8";
		System.out.println("directory : " + path);
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encode, new DefaultFileRenamePolicy());
		// 이미지가 만약에 굉장히 많아지면 톰캣에 올릴때 용량이 굉장히 많아져서 war이 무거워짐
		// 위치의 문제, db에 이미지 다 저장하거나 url만 저장하거나
		// 파라미터 값 가져오기
		String mainCategory = multi.getParameter("mainCategory");
		String subCategory = multi.getParameter("subCategory");
		String itemName = multi.getParameter("itemName");
		String itemPriceBefore = multi.getParameter("itemPrice");
		long itemPrice = Long.valueOf(itemPriceBefore);
		String itemImage = multi.getFilesystemName("image"); //파일이름
		
		System.out.println(itemImage);
		
		mservice.addMenu(mainCategory, subCategory, itemName, itemPrice, itemImage);
		
		// 비지니스 서비스 호출
		model.addAttribute("itemName", itemName);
		model.addAttribute("itemPrice", itemPrice);
		
		return "menu/success_add_menu";
	}
	

}

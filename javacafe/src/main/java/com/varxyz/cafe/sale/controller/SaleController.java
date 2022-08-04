package com.varxyz.cafe.sale.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.cafe.menu.service.CategoryServiceImpl;
import com.varxyz.cafe.sale.command.SaleFindCommand;
import com.varxyz.cafe.sale.service.SaleServiceImpl;

@Controller("cafe.saleController")
public class SaleController {
	
	@Autowired
	private CategoryServiceImpl cservice;
	
	@Autowired
	private SaleServiceImpl sservice;
	
	@GetMapping("cafe/sale")
	public String sale(Model model) {
		//카테고리 리스트 보내기
		model.addAttribute("mainCategory", cservice.findAllMainCategory());
		model.addAttribute("subCategory", cservice.findAllSubCategory());		
		model.addAttribute("yearList", getYearList());
		model.addAttribute("mondthList", getMonthList());
		model.addAttribute("dayList", getDayList());
		System.out.println(cservice.findAllMainCategory());
		System.out.println(cservice.findAllSubCategory());
		
		return "sale/sale";
	}
	
	
	//list 년도, 월, 일 리스트
	public List<String> getYearList() {
		List<String> list =  new ArrayList<String>();
		list.add("2019");
		list.add("2020");
		list.add("2021");
		list.add("2022");
		return list;
	}
	
	public List<String> getMonthList() {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 12; i++) {
			String month = String.valueOf(i); 
			list.add(month);
		}
		return list;
	}
	
	public List<String> getDayList() {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 31; i++) {
			String month = String.valueOf(i); 
			list.add(month);
		}
		return list;
	}
	
	//전체조회
	@GetMapping("cafe/all_sale_list")
	public String findAllSale(Model model) {
		model.addAttribute("mainCategory", cservice.findAllMainCategory());
		model.addAttribute("subCategory", cservice.findAllSubCategory());		
		model.addAttribute("yearList", getYearList());
		model.addAttribute("mondthList", getMonthList());
		model.addAttribute("dayList", getDayList());
		
		model.addAttribute("saleList", sservice.findSaleList());
		return "sale/sale";
	}
	
	//카테고리별조회
	@PostMapping("cafe/sale_list_category")
	public String findSaleByCategory(Model model,
			@RequestParam String mainCategory, @RequestParam String subCategory) {
		model.addAttribute("mainCategory", cservice.findAllMainCategory());
		model.addAttribute("subCategory", cservice.findAllSubCategory());		
		model.addAttribute("yearList", getYearList());
		model.addAttribute("mondthList", getMonthList());
		model.addAttribute("dayList", getDayList());
		
		// 카테고리로 리스트 찾기
//		if ()
		// all 들어오면 개별검색
		return "sale/sale";
	}
	
	//날짜조회
	@PostMapping("cafe/sale_list_date")
	public String findSaleByDate(Model model, @RequestParam String year,
			@RequestParam String month, @RequestParam String day) {
		model.addAttribute("mainCategory", cservice.findAllMainCategory());
		model.addAttribute("subCategory", cservice.findAllSubCategory());		
		model.addAttribute("yearList", getYearList());
		model.addAttribute("mondthList", getMonthList());
		model.addAttribute("dayList", getDayList());
		
		System.out.println(year + "," + month + "," + day);
		// all들어오면 개별검색
		// 전체로 선택한거보다 큰 범위의 검색조건은 all이 될 수 없다.
		
		if (year.equals("all")) {
			//전체 찾기
			model.addAttribute("saleList", sservice.findSaleList());
			return "sale/sale";
			//안에서 다 리턴하기
		}
		
		if (month.equals("all")) {
			// year선택되고 해당 년도의 전체 월 찾기
			model.addAttribute("saleList", sservice.findSaleYear(year));
			return "sale/sale";

		}
		
		if (day.equals("all")) {
			// 해당년, 월 의 전체 sale찾기
			model.addAttribute("saleList", sservice.findSaleMonth(year,month));
			return "sale/sale";
		}
		
		// all을 선택한게 없으면 3개 다 조건으로 넣기
		model.addAttribute("saleList", sservice.findSaleDate(year, month, day));
		
		
		return "sale/sale";
	}

}

package com.varxyz.cafe.purchase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.cafe.menu.service.CategoryServiceImpl;
import com.varxyz.cafe.menu.service.MenuServiceImpl;
import com.varxyz.cafe.purchase.command.CartItemCommand;
import com.varxyz.cafe.purchase.domain.CartItem;
import com.varxyz.cafe.purchase.service.CartServiceImpl;
import com.varxyz.cafe.sale.service.SaleServiceImpl;

@Controller("cafe.cartController")
public class CartController {
	
	@Autowired
	private CartServiceImpl cservice;
	
	@Autowired
	private MenuServiceImpl menuService;
	
	@Autowired
	private CategoryServiceImpl cateservice;
	
	@Autowired
	private SaleServiceImpl sservice;
	
	// destory로 서버가 내릴때 카트 비우기
	
	// 상품구매 첫 페이지
	@GetMapping("cafe/purchase_menu")
	public String MenuList(Model model) { 
		//대분류, 소분류 카테고리 뿌리기
		model.addAttribute("mainCategoryList", cateservice.findAllMainCategory());
		model.addAttribute("subCategoryList", cateservice.findAllSubCategory());
		
		// 카테고리별 메뉴리스트 가져와서 뿌리기. js로 카테고리 클릭시 나타나게
		
		// 전체메뉴 뿌리기
		menuService.findAllMenu();
		System.out.println(menuService.findAllMenu());
		model.addAttribute("menuList", menuService.findAllMenu());
		
		// 총 합계 뽑기
		model.addAttribute("sumPrice", cservice.sumPriceByCartItem());
		return "/purchase/menu";
	}
	
	// 장바구니에 아이템 담기
	@PostMapping("cafe/add_cart_item")
	public String addCartItem(CartItem cartItem, Model model) {
		model.addAttribute("mainCategoryList", cateservice.findAllMainCategory());
		model.addAttribute("subCategoryList", cateservice.findAllSubCategory());
		
		//상품명으로 cart를 뒤져서 만약 같은 이름의 상품 있으면 개수를 추가하는걸로
		// cart에서 이름과 같은 카트아이템이 있는지 찾는 dao
		
		// 있을경우 개수를 수정하는 service (개수+1)
		if (cservice.findMenuItemByName(cartItem.getItemName()) == true) {
			cservice.addCountPrice(cartItem);
		} else { // false라면 장바구니에 추가
			cservice.addCartItem(cartItem);
		}
		
		//리스트를 다시 불러와서 model로보내고 뿌리기
		cservice.findCartList();
		System.out.println("카트리스트 : " + cservice.findCartList());
		model.addAttribute("cartList", cservice.findCartList());
		model.addAttribute("menuList", menuService.findAllMenu());
		model.addAttribute("sumPrice", cservice.sumPriceByCartItem());
		return "/purchase/menu";
	}
	
	
	// 장바구니 수정
	@PostMapping("cafe/update_cart_item")
	public String updateCartItem(CartItem cartItem, Model model) {
		model.addAttribute("mainCategoryList", cateservice.findAllMainCategory());
		model.addAttribute("subCategoryList", cateservice.findAllSubCategory());
		model.addAttribute("sumPrice", cservice.sumPriceByCartItem());
		
		cservice.updateCartItem(cartItem);

		//리스트를 다시 불러와서 model로보내고 뿌리기
		model.addAttribute("cartList", cservice.findCartList());
		
		return "/purchase/menu";
	}
	
	// 장바구니에서 항목 삭제
	@PostMapping("cafe/delete_cart_item")
	public String deleteCartItem(CartItem cartItem, Model model) {
		model.addAttribute("mainCategoryList", cateservice.findAllMainCategory());
		model.addAttribute("subCategoryList", cateservice.findAllSubCategory());
		model.addAttribute("sumPrice", cservice.sumPriceByCartItem());
		
		cservice.deleteCartItem(cartItem.getItemName());
		
		model.addAttribute("cartList", cservice.findCartList());
		return "/purchase/menu";
	}
	
	
	// 결제하기 -> 총 매출액 등록, 재고 차감
	@GetMapping("cafe/purchase")
	public String purchase(Model model) {
		//cartItem을 리스트로 받은거를 for문을 돌려서 각 항목마다 sale에 등록하기
		List<CartItemCommand> cartList = cservice.findCartList();
		

		for (CartItemCommand c:cartList) {
			System.out.println(c);
			// sale테이블에 추가하기
			sservice.addSale(c);
		}
		
		//cartList를 보내고나서 cartList비우기
		model.addAttribute("cartList", cservice.findCartList());
		cservice.emptyCart();
		
		return "/purchase/success_purchase";
		
	}
	
	//장바구니 비우기
	@GetMapping("cafe/delete_cart")
	public String deleteCart(Model model) {
		model.addAttribute("mainCategoryList", cateservice.findAllMainCategory());
		model.addAttribute("subCategoryList", cateservice.findAllSubCategory());
		model.addAttribute("sumPrice", cservice.sumPriceByCartItem());
		model.addAttribute("menuList", menuService.findAllMenu());
		
		// cartList삭제하고 보내기
		cservice.emptyCart();
		model.addAttribute("cartList", cservice.findCartList());
		return "/purchase/menu";
	}
	
	
	

}

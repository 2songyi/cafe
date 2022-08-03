package com.varxyz.cafe.purchase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.varxyz.cafe.purchase.command.CartItemCommand;
import com.varxyz.cafe.purchase.domain.CartItem;
import com.varxyz.cafe.purchase.repository.CartSpringJdbcImpl;

@Component
public class CartServiceImpl {
	
	@Autowired
	private CartSpringJdbcImpl dao;
	
	// 장바구니에 상품 담기
	public void addCartItem(CartItem cartItem) {
		dao.addCartItem(cartItem);
	}
	
	// 장바구니 아이템 수정
	public void updateCartItem(CartItem cartItem) {
		
		long itemPrice = cartItem.getItemprice();
		int count = cartItem.getCount();
		String itemName = cartItem.getItemName();
	
		dao.updateCartItem(itemPrice, count, itemName);
	}
	
	// 장바구니 리스트 가져오기
	public List<CartItemCommand> findCartList() {
		return dao.findCartList();
	}
	
	//장바구니 아이템 삭제하기
	public void deleteCartItem(String itemName) {
		dao.deleteCartItem(itemName);
	}
	
	// 장바구니 비우기
	public void emptyCart() {
		dao.emptyCart();
	}
	
	// 카트에 같은 상품이 들었는지 확인
	public boolean findMenuItemByName(String itemName) {
		return dao.findMenuItemByName(itemName);
	}
	
	// 같은 상품이 들었을 때 개수, 가격 추가하기
	public void addCountPrice(CartItem cartItem) {
		CartItem item = findCartItem(cartItem.getItemName());
		// 현재 장바구니 가격에 1개가격 더하기, 수량에 1개 추가하기
		long beforePrice = item.getItemprice(); // 현재 카트에 저장되어 있는 가격
		int beforeCount = item.getCount(); // 현재 카트에 담겨있는 개수
		
		long afterPrice = beforePrice + cartItem.getItemprice();
		int afterCount = beforeCount + 1;
		
		// 수정된 내용으로 카트수정하기
		cartItem.setItemprice(afterPrice);
		cartItem.setCount(afterCount);
		updateCartItem(cartItem);

	}
	
	// 카트에 들어있는 상품 조회
	public CartItem findCartItem(String itemName) {
		return dao.findCartItem(itemName);
	}
	
	// 카트 총 합계 
	public long sumPriceByCartItem() {
		return dao.sumPriceByCartItem();
	}
	
	
}

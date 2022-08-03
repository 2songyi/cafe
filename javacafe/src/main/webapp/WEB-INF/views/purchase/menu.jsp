<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cafe</title>
<link rel="stylesheet" href="../resources/css/purchase/initial.min.css">
<link rel="stylesheet" href="../resources/css/purchase/purchase_menu.css">
</head>
<body>
  <div class="wrap">
    <div class="main">
      <div class="container">
        <!-- 왼쪽메뉴 영역 -->
        <section id="l-snb">
          <div class="logo">
            <p>SongCafe</p>
          </div>
          <nav class="l-nav">
            <div class="category">
              <ul class="l-menu">
                <c:forEach var="mainCategoryList" items="${mainCategoryList}">
                  <li><a href="#">${fn:split(mainCategoryList, ',')[1]}</a></li>
                </c:forEach>
              </ul>
            </div>


          </nav>
        </section>
        <div id="content">
          <div class="sub-category">
            서브타이틀영역
          </div>
          <!-- 메뉴아이템 영역 -->
          <div class="menu">
            
            <c:forEach var="menuList" items="${menuList}">
           	  <div class="menu-item">
           	  <div class="box">
            	<form action="add_cart_item" method="post">
            		<img src="../menu_img/${fn:split(menuList, ',')[5]}" alt="menu_item">
					<input type="hidden" name="mainCategory" value="${fn:split(menuList, ',')[0]}"/>
					<input type="hidden" name="subCategory" value="${fn:split(menuList, ',')[1]}"/>
					<input type="hidden" name="itemCode" value="${fn:split(menuList, ',')[2]}"/>
					
					<div class="card-body">
					<p class="card-text">상품명 : ${fn:split(menuList, ',')[3]}</p>
					<input type="hidden" name="itemName" value="${fn:split(menuList, ',')[3]}"/>
					<p class="card-text">상품가격 : ${fn:split(menuList, ',')[4]}</p>
					<input type="hidden" name="itemprice" value="${fn:split(menuList, ',')[4]}"/><br>
					<button type="submit">담기</button>
					</div>
            	</form>
              </div>
              </div>
            </c:forEach>
         
          </div>


        </div>
        <!-- 오른쪽 메뉴 영역 -->
        <section id="r-snb">
          <div class="cart">
            <p>카트영역</p>
            
            <c:forEach var="cartList" items="${cartList}">
           		 <form class="" action="update_cart_item" method="post">
           		 	<input type="hidden" name="mainCategory" value="${fn:split(cartList, ',')[0]}"/>
           		 	<input type="hidden" name="subCategory" value="${fn:split(cartList, ',')[1]}"/>
           		 	<input type="hidden" name="itemCode" value="${fn:split(cartList, ',')[2]}"/>
           		 	<label>상품명</label> : ${fn:split(cartList, ',')[3]}<br>
           		 	<input type="hidden" name="itemName" value="${fn:split(cartList, ',')[3]}"/>
           		 	<label>상품가격</label> : ${fn:split(cartList, ',')[4]}<br>
           		 	<input type="hidden" name="itemprice" value="${fn:split(cartList, ',')[4]}"/>
           		 	<label>개수</label> : ${fn:split(cartList, ',')[5]}
           		 	<input type="number" name="count" value="${fn:split(cartList, ',')[5]}"/>
           		 	<button type="submit">수정</button>
           		 </form>
            </c:forEach>
            
            
          </div>
          <div class="purchase">
            <p>구매영역</p>
            <p>총 금액 : ${sumPrice}</p>
            <button type="button" name="button" onclick="location.href='purchase'">결제하기</button>
	

          </div>
        </section>
      </div>
    </div>
  </div>
</body>
</html>
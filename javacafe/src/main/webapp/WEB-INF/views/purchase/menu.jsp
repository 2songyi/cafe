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
<script type="text/javascript" src="../resources/js/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/common.js"></script>

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
              	  <li class="mainc main-all on"><a href="#">전체보기</a></li>
               	  <c:forEach var="mainCategoryList" items="${mainCategoryList}">
                  	<li class="mainc"><a href="#">${fn:split(mainCategoryList, ',')[1]}</a></li>
               	  </c:forEach>
              </ul>
            </div>

          </nav>
        </section>
        <div id="content">
        <header>
          <div class="sub-category">
           <ul>
             <li>
               <!-- <div class="subc sub-all">
                 <p><a href="#">전체보기</a></p>
               </div> -->
             </li>
            <c:forEach var="subCategoryList" items="${subCategoryList}">
               <li>
                 <div class="subc ${fn:split(subCategoryList, ',')[1]}">
                  <p><a href="#">${fn:split(subCategoryList, ',')[2]}</a></p>
                 </div>
               </li>
            </c:forEach>
           </ul>
          </div>
        </header>   
          <!-- 메뉴아이템 영역 -->
          <div class="menu">
            <div class="product-container">
           	 <c:forEach var="menuList" items="${menuList}">
              <div class="product ${fn:split(menuList, ',')[0]} ${fn:split(menuList, ',')[1]}">
          	   <form action="add_cart_item" method="post">
                <div class="product-img"><img src="../menu_img/${fn:split(menuList, ',')[5]}" alt="menu_item"></div>
                <div class="product-title">${fn:split(menuList, ',')[3]}</div>
                <div class="product-mon">${fn:split(menuList, ',')[4]}원</div>
                <div class="product-btn"><button type="submit">담기</button></div>
                
                <input type="hidden" name="mainCategory" value="${fn:split(menuList, ',')[0]}"/>
				<input type="hidden" name="subCategory" value="${fn:split(menuList, ',')[1]}"/>
				<input type="hidden" name="itemCode" value="${fn:split(menuList, ',')[2]}"/>
				<input type="hidden" name="itemName" value="${fn:split(menuList, ',')[3]}"/>
				<input type="hidden" name="itemprice" value="${fn:split(menuList, ',')[4]}"/>
         	   </form>
              </div>
          	 </c:forEach>
            </div>
          </div>
          


        </div>
        <!-- 오른쪽 메뉴 영역 -->
        <section id="r-snb">
        	<div class="cart">
            <p id="cart">장바구니</p>
            <div class="cart-table">
              <table class="thead">
                <thead>
                  <tr>
                    <th class="t1">No</th>
                    <th class="t2">상품명</th>
                    <th class="t3">가격</th>
                    <th class="t4">수량</th>
                    <th class="t5">수정</th>
                  </tr>
                </thead>
              </table>
              <div class="tbl-content">
                  <table class="tbody">
                  <c:forEach var="cartList" items="${cartList}" varStatus="status">
                  	<form class="" action="update_cart_item" method="post">
                 		<tr>
                 	 	<input type="hidden" name="mainCategory" value="${fn:split(cartList, ',')[0]}"/>
           		 		<input type="hidden" name="subCategory" value="${fn:split(cartList, ',')[1]}"/>
           		 		<input type="hidden" name="itemCode" value="${fn:split(cartList, ',')[2]}"/>
           		 		<input type="hidden" name="itemName" value="${fn:split(cartList, ',')[3]}"/>
           		 		<input type="hidden" name="itemprice" value="${fn:split(cartList, ',')[4]}"/>
           		 		
         	          	<td class="t1">${status.index + 1}</td><!-- 인덱스번호 -->
            	        <td class="t2">${fn:split(cartList, ',')[3]}</td><!-- 상품명 -->
                	    <td class="t3">${fn:split(cartList, ',')[4]}원</td><!-- 가격 -->
                    	<td class="t4"><input type="number" name="count" value="${fn:split(cartList, ',')[5]}"/></td><!-- 수량 -->
                  	 	<td class="t5"><button type="submit">수정</button></td><!-- 수정버튼 -->
                  		 
               	   		</tr>
                  	</form>
                  </c:forEach>
                </table>
              </div>
            </div>

            <form class="" action="index.html" method="post">

            </form>
          </div>
        
          
          <div class="purchase">
            <div class="total">
              <p>총 금액 : ${sumPrice}원</p>
            </div>
            <div class="purchase-btn">
              <div class="cart-delete pbtn">
                <a href="delete_cart">장바구니 비우기</a>
              </div>
              <div class="pay pbtn">
                <a href="purchase">결제하기</a>
              </div>
          </div>
        </div>        
        </section>
      </div>
    </div>
  </div>
</body>
</html>
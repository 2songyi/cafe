<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/purchase/initial.min.css">
<link rel="stylesheet" href="../resources/css/purchase/success_pay.css">
</head>
<body>
  <div class="wrap">
    <p class="msg">구매가 완료되었습니다!</p>
    <p class="title">영수증</p>
    <div class="table">
      <table class="tg">
        <thead>
          <tr>
            <th class="tg-0lax">No</th>
            <th class="tg-0lax">상품명</th>
            <th class="tg-0lax">가격</th>
            <th class="tg-0lax">수량</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="cartList" items="${cartList}" varStatus="status">
          <tr>
            <td class="tg-0lax">${status.index + 1}</td>
            <td class="tg-0lax">${fn:split(cartList, ',')[3]}</td>
            <td class="tg-0lax">${fn:split(cartList, ',')[4]}원</td>
            <td class="tg-0lax">${fn:split(cartList, ',')[5]}</td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

    <button onclick="location.href='purchase_menu'">처음으로 돌아가기</button>
  </div>
</body>
</html>
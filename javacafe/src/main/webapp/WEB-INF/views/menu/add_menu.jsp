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
</head>
<body>

<h3>메뉴 등록하기</h3>
<form method="post" action="add_menu" enctype="multipart/form-data">
	<label>카테고리</label>
	<select name="mainCategory">
		<c:forEach var="mainCategoryList" items="${mainCategoryList}">
   	    	<option value="${fn:split(mainCategoryList, ',')[1]}">${fn:split(mainCategoryList, ',')[1]}</option>
		</c:forEach>
	</select>
	<select name="subCategory">
		<c:forEach var="subCategoryList" items="${subCategoryList}">
   	    	<option value="${fn:split(subCategoryList, ',')[2]}">${fn:split(subCategoryList, ',')[2]}</option>
		</c:forEach>
	</select><br>
	<label>이름</label>
	<input type="text" name="itemName"/><br>
	<label>가격</label>
	<input type="number" name="itemPrice"/><br>
	<label>이미지</label>
	<input type="file" name="image"/><br>
	<button type="submit">메뉴 등록</button>
</form>
</body>
</html>
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
</head>
<body>
<h3>대분류 카테고리 등록</h3>
<form action="add_main_category" method="post">
	<label>대분류</label>
	<input type="text" name="mainCategory"/>
	<button type="submit">카테고리 등록</button>
</form>

<h3>카테고리 소분류 등록</h3>
<form action="add_sub_category" method="post">
	<label>대분류</label>
	<!-- 메인카테고리는 select로 수정 -->
	<select name="mainCategory">
		<c:forEach var="mainCategoryList" items="${mainCategoryList}">
   	    	<option value="${fn:split(mainCategoryList, ',')[0]}">${fn:split(mainCategoryList, ',')[1]}</option>
		</c:forEach>
	</select><br>
	
	<label>소분류</label>
	<input type="text" name="subCategory"/><br>
	<button type="submit" name="submit">소분류 카테고리 등록</button>
</form>
</body>
</html>
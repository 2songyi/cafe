<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cafe</title>
<link rel="stylesheet" href="../resources/css/purchase/initial.min.css">
<link rel="stylesheet" href="../resources/css/manager/menu_list.css">
<script type="text/javascript" src="../resources/js/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/select.js"></script>
</head>
<body>

	<div class="wrap">
		<!-- header -->
		<header>
			<div class="headarea">
				<span class="logo"> <a
					href='<c:url value="/stock/FindAllStock"/>'>SongCafe</a>
				</span>
				<div class="gnb">
					<ul>
						<li>
							<!-- <p>OOO님</p> -->
						</li>
						<li class="mypage">
							<!-- <a href="#">MY PAGE</a> -->
						</li>
						<li class="logout">
							<!-- <a href="#">로그아웃</a> -->
						</li>
					</ul>

				</div>
			</div>
		</header>
		<!-- main -->
		<main>
			<div id="container">
				<!-- 왼쪽 메뉴 영역 -->
				<%@ include file="../incl/side_menu.jsp"%>
				<!-- content영역 -->
				<div id="content">
					<div class="content-info">
						<h2 class="title">상품조회</h2>
					</div>
					<div class="content-body">
						<div class="form-table">
							<table class="search-table">
								<tr>
									<th>전체보기</th>
									<td>
										<button class="findall"
											onclick="location.href='menu_list_all'">전체보기</button>
									</td>
								</tr>
								<tr>
									<th>카테고리</th>
									<td>
										<form class="searchform" action="menu_list_category"
											method="post">
											<!-- <option value="all">--전체--</option> -->
											<select name="mainCategory" class="mainselect">
												<c:forEach var="mainCategoryList"
													items="${mainCategoryList}">
													<option value="${fn:split(mainCategoryList, ',')[1]}">${fn:split(mainCategoryList, ',')[1]}</option>
												</c:forEach>
											</select> <select name="subCategory">
												<c:forEach var="subCategoryList" items="${subCategoryList}">
													<option value="${fn:split(subCategoryList, ',')[2]}"
														class="subselect show ${fn:split(subCategoryList, ',')[1]}">
														${fn:split(subCategoryList, ',')[2]}</option>
												</c:forEach>
											</select>



											<button type="submit" name="button" class="searchbtn">검색</button>
										</form>
									</td>
								</tr>
							</table>
						</div>
						<div class="content-table">
							<table class="thead">
								<thead>
									<tr>
										<th class="t0">No</th>
										<th class="t1">메인카테고리</th>
										<th class="t2">서브카테고리</th>
										<th class="t3">상품코드</th>
										<th class="t4">상품명</th>
										<th class="t5">가격</th>
										<th class="t6">이미지</th>
									</tr>
								</thead>
							</table>
							<div class="tbl-content">
								<table class="tbody">
									<tbody>
										<c:forEach var="menuList" items="${menuList}"
											varStatus="status">
											<tr>
												<td class="t0">${status.index + 1}</td>
												<td class="t1">${fn:split(menuList, ',')[0]}</td>
												<td class="t2">${fn:split(menuList, ',')[1]}</td>
												<td class="t3">${fn:split(menuList, ',')[2]}</td>
												<td class="t4">${fn:split(menuList, ',')[3]}</td>
												<td class="t5">${fn:split(menuList, ',')[4]}</td>
												<td class="t6">${fn:split(menuList, ',')[5]}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>

		</main>

		<!-- footer -->
		<%@ include file="../incl/footer.jsp"%>
</body>
</html>
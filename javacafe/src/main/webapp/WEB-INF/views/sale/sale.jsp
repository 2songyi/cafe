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
<link rel="stylesheet" href="../resources/css/manager/add_menu.css">
</head>
<body>

<div class="wrap">
    <!-- header -->
    <header>
      <div class="headarea">
        <span class="logo">
          <a href='<c:url value="/stock/FindAllStock"/>'>SongCafe</a>
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
        <section id="snb">
          <nav class="nav">
            <ul class="left-menu">
              <li><a href="#">카테고리등록</a></li>
              <li><a href="#">상품등록</a></li>
              <li><a href="#">상품조회</a></li>
              <li><a href="#">매출관리</a></li>
            </ul>
          </nav>
        </section>
        <!-- content영역 -->
		<div id="content">
			<div class="content-info">
				<h2 class="title">매출관리</h2>
			</div>
			<div class="content-body">
				<div class="form-table">
					<table class="search-table">
						<tr>
							<th>전체보기</th>
							<td>
								<button class="findall" onclick="location.href='all_sale_list'">전체보기</button>
							</td>
						</tr>
						<tr>
							<th>카테고리</th>
							<td>
								<form class="searchform" action="find_CategorySale.do" method="post">
									<select name="mainCategory" class="category">
										<c:forEach var="mainCategory" items="${mainCategory}" >
											<option value="${fn:split(mainCategory, ',')[1]}">${fn:split(mainCategory, ',')[1]}</option>										
										</c:forEach>
									</select>
									<select name="subCategory" class="category">
										<c:forEach var="subCategory" items="${subCategory}" >
											<option value="${fn:split(subCategory, ',')[2]}">${fn:split(subCategory, ',')[2]}</option>									
										</c:forEach>
									</select>
									<button type="submit" name="button" class="searchbtn">검색</button>
								</form>
							</td>
						</tr>
						<tr>
							<th>날짜</th>
							<td>
								<form action="sale_list_date" method="post" id="saDateForm">
									연도 :
									<select name="year" form="saDateForm">
										<option value="all">전체</option>
										<c:forEach var="yearList" items="${yearList}" >
											<option value="${yearList}">${yearList}</option>
										</c:forEach>
									</select>
									월 :
									<select name="month" form="saDateForm">
										<option value="all">전체</option>
										<c:forEach var="mondthList" items="${mondthList}" >
											<option value="${mondthList}">${mondthList}</option>
										</c:forEach>
									</select>
									일 :
									<select name="day" form="saDateForm">
										<<option value="all">전체</option>
										<c:forEach var="dayList" items="${dayList}" >
											<option value="${dayList}">${dayList}</option>
										</c:forEach>
									</select>
									<button type="submit" name="button" class="searchbtn">검색</button>
								</form>
							</td>
						</tr>
						<tr>
							<th>총 매출 금액</th>
							<td>0원</td>
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
								<th class="t6">수량</th>
								<th class="t7">총 가격</th>
								<th class="t8">날짜</th>
							</tr>
						</thead>
					</table>
					<div class="tbl-content">
					 <table class="tbody">
						<tbody>
							<c:forEach var="salelist" items="${saleList}" varStatus="status">
								<tr>
									<td class="t0">${status.index + 1}</td>
									<td class="t1">${fn:split(salelist, ',')[1]}</td>
									<td class="t2">${fn:split(salelist, ',')[2]}</td>
									<td class="t3">${fn:split(salelist, ',')[3]}</td>
									<td class="t4">${fn:split(salelist, ',')[4]}</td>
									<td class="t5">${fn:split(salelist, ',')[5]}</td>
									<td class="t6">${fn:split(salelist, ',')[6]}</td>
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
    <footer>
      <div class="inner">
        <span class="copyright">Copyright &copy;LeeSongYi</span>
      </div>
    </footer>

</body>
</html>
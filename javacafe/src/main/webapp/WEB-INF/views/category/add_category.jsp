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
            <h2 class="title">카테고리등록</h2>
          </div>
          <div class="content-body">
            <div class="form-table">
              

                <table class="search-table">
                  <tr>
                    <th>대분류 카테고리</th>
                    <td>
                      	<form action="add_main_category" method="post">
							<input type="text" name="mainCategory"/>
							<button type="submit" class="submit">등록</button>
						</form>		
                    </td>
                  </tr>
                  
                  <tr>
                    <th>소분류 카테고리</th>
                    <td>
                      <form action="add_sub_category" method="post">
                      	<select name="mainCategory">
							<c:forEach var="mainCategoryList" items="${mainCategoryList}">
   	    					<option value="${fn:split(mainCategoryList, ',')[0]}">${fn:split(mainCategoryList, ',')[1]}</option>
							</c:forEach>
						</select>
						<input type="text" name="subCategory"/>
                     	<button type="submit" name="submit" class="submit">등록</button>
                      </form>
                    </td>
                  </tr>
                  
                  
                </table>
          
            </div>

          </div>
        </div>
      </div>

    </main>

    <!-- footer -->
    <footer>
      <div class="inner">
        <span class="copyright">Copyright &copy;TeamBravo</span>
      </div>
    </footer>

</body>
</html>
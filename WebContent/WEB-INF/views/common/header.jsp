<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.*" %>
<%
	Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
	//System.out.println(memberLoggedIn);
	
	//클라이언트가 보낸 쿠키처리(쿠키관련)
	Cookie[] cookies = request.getCookies();
	boolean saveId = false;
	String userIdSaved = "";
	
	//최초접속시 cookie는 null임.
	if(cookies != null){
	//	System.out.println("------------------------------------");
	//	System.out.println("브라우져가 전송한 쿠키목록");
	//	System.out.println("------------------------------------");
		for(Cookie c : cookies){
			String key = c.getName();
			String value = c.getValue();
	//		System.out.println(key+" : "+value);
			//아이디저장 쿠키검사
			if("saveId".equals(key)){
				saveId = true;
				userIdSaved = value;
			}
		}
	//	System.out.println("------------------------------------");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />
<link href="https://fonts.googleapis.com/css?family=Gugi" rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<title>Book</title>
<script>
//메뉴상단에 고정하기.(스크롤 내려도)
$(document).ready(function() {
	var jbOffset = $( '.fixed-search1' ).offset();
	$( '.fixed-search1' ).removeClass( 'jbFixed').css("display","none");
	$( window ).scroll( function() {
		if ( $( document ).scrollTop() > jbOffset.top ) {
			$( '.fixed-search1' ).addClass( 'jbFixed' ).css("display","inline");
		}
		else {
			$( '.fixed-search1' ).removeClass( 'jbFixed').css("display","none");
		}
	});
});
function fn_loginValidate(){
	//아이디 검사
	if($("#userId1").val().trim().length==0){
		alert("아이디를 입력하세요.");
		$("#userId1").focus();
		return false;
	}
	//패스워드 검사
	if($("#password1").val().trim().length==0){
		alert("비밀번호를 입력하세요.");
		$("#password1").focus();
		return false;
	}
	return true;
}

$(function(){
	var cnt = 0;
	$("#user1").click(function(){
		cnt++;
		if(cnt%2==1){
			$("#bubble1").css("display","inline-block");
		}
		else{
			$("#bubble1").css("display","none");			
		}
	});
});
$(function(){
	   $("#basket1").click(function(){      
	      <%if( memberLoggedIn != null ) {%>
	         var memberNo = <%=memberLoggedIn.getMember_no()%>;
	      <%}%>
	         
	      location.href="<%=request.getContextPath()%>/basket/basketServlet?memberNo=" + memberNo;
	   });
	});
</script>
</head>
<body>
<div id="container1">
	<header>
		<div id="title1"><a href="<%=request.getContextPath()%>"><img src="<%=request.getContextPath()%>/images/logo.png" alt="logo" id="img-title1"></a></div>
			<!-- 검색바 -->
		<form action="<%=request.getContextPath()%>/search/searchBook" onsubmit="return fn_searchBook_byteCheck();">
			<div id="search-container1">
			<select name="searchType" id ="searchType1_1">
				<option value="all" class="all-search">통합검색</option>
				<option value="title" class="title-search">책제목</option>
				<option value="writer" class="writer-search">저자명</option>
				<option value="publisher" class="publisher-search">출판사명</option>
			</select>
			<input type="text" name="searchBook" id="search-book1_1" placeholder="검색명을 입력하세요." />
			<input type="submit" id="search1_1" value="검색">
		</div>
		</form>
		<script>
		function fn_searchBook_byteCheck() {
			if($("#search-book1_1").val().trim() == 0 && $("#search-book2_1").val().trim() == 0) {
				alert("검색어를 입력하세요");
				return false;
			}
			return true;
		}
		</script>
		<!-- 로그인 시작 -->
		<div class="login-container1">
		<% if(memberLoggedIn ==null){%>
			<form action="<%=request.getContextPath() %>/member/login" id="loginFrm1" method="post" onsubmit="return fn_loginValidate();">
				<table>
					<tr>
						<td><input type="text" name="id" id="userId1" placeholder="아이디" value="<%=saveId?userIdSaved:""%>"/> </td>
						<td></td>
					</tr>
					<tr>
						<td><input type="password" name="password" id="password1" placeholder="비밀번호"/></td>
						<td><input type="submit" value="로그인" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="checkbox" name="saveId" id="saveId1"<%=saveId?"checked":""%>/>
							<label id="saveId1" for="saveId">아이디저장</label>&nbsp;
							<input type="button" id="join1" value="회원가입" onclick="location.href='<%=request.getContextPath()%>/member/chooseEnroll'"/>     
						</td>
					</tr>
				</table>
			</form>
			<%}else{ %>
				<div id="logged-container1">
					<div id="logged1">
						<img id="user1" alt="user.png" src="<%=request.getContextPath()%>/images/user.png">
						<br />
						<span id="logged-name1"><%=memberLoggedIn.getMember_name() %>님</span>
					</div>
					<div id="bubble1" style="position:relative; dispaly:none;">
						<input id="mpage1" type="button" value="마이페이지"
						onclick="location.href='<%=request.getContextPath()%>/member/myPage';"/>
						<!-- ?member_id= <%=memberLoggedIn.getMember_id()%> -->
						&nbsp;
						<br />
						<input id="basket1"type="button" value="장바구니" />
						<br />
						<input id="seller1Enroll1" type="button" value="판매자가입"  onclick="location.href='<%=request.getContextPath()%>/seller/sellerEnroll?member_no=<%=memberLoggedIn.getMember_no()%>'"/>
						<br />
						<input id="log-out1" type="button" value="로그아웃" onclick="location.href='<%=request.getContextPath()%>/member/logout'"/>
					</div>
				</div>	
			<%} %>
		</div>
		<!-- 로그인 끝 -->
	
		<!-- 메인메뉴시작 -->
		<nav class="fix-nav1">
			<ul class="main-nav1">
	           <li class="book-list"><a class="menut1" href="#">도서</a>
		          <div class="dropdown_5columns">
		            <div class="col_6">
		            	<h3>* 도서 분야  *</h3>
		            </div>
		            <div class="col_1">
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=20세기한국소설">20세기 한국소설</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=선집·전집·전작" >선집·전집·전작</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=신나는책읽기" >신나는 책 읽기</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=이세상첫이야기" >이 세상 첫 이야기</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=역사이야기" >역사 이야기</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=옛날이야기" >옛날 이야기</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=인물이야기" >인물이야기</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=어린이문집" >어린이 문집</a></p>
		            </div>
		            <div class="col_2">
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=창비어린이" >창비어린이</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=여성과사회" >여성과사회</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=창작과비평" >창작과비평</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=동시·동요" >동시·동요</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=인물·평전" >인물·평전</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=과학·교양" >과학·교양</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=과학·환경" >과학·환경</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=선집·전집" >선집·전집</a></p>
		            </div>
		            <div class="col_3">
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=문화·예술" >문화·예술</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=정치·사회" >정치·사회</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=외국소설" >외국 소설</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=창비시선" >창비시선</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=문학이론" >문학이론</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=문학비평" >문학비평</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=창작동화" >창작동화</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=세계명작" >세계명작</a></p>
		            </div>
		            <div class="col_4">
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=장편소설" >장편소설</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=외국시" >외국 시</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=그림책" >그림책</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=소설집" >소설집</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=안과밖" >안과밖</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=산문" >산문</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=경제" >경제</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=철학" >철학</a></p>
		            </div>
		            <div class="col_5">
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=인문" >인문</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=과학" >과학</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=교양" >교양</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=환경" >환경</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=철학" >역사</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=문학" >문학</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=여성" >여성</a></p>
		           		<p><a class="ca1" href="<%=request.getContextPath()%>/search/searchCategory?category=기타" >기타</a></p>
		            </div>
      		  </div>
	           </li>
	           <li id="jiseojae"><a class="menut1" href="<%=request.getContextPath()%>/recommend/RecommenListServlet">지서재</a></li>
	           <li id="used-book"><a class="menut1" href="<%=request.getContextPath()%>/oldboard/OldBoardServlet">중고장터</a></li>
	           <li id="notice"><a class="menut1" href="<%=request.getContextPath()%>/notice/noticeListView">공지사항</a></li>
	           <%--관리자메뉴 --%>
	           <%if(memberLoggedIn != null && "admin".equals(memberLoggedIn.getMember_id())){ %>
	           <li id="ad-member3"><a class="menut1" href="<%=request.getContextPath()%>/admin/adminMemberListView">회원관리</a></li>
	             <li id="ad-seller3"><a class="menut1" href="<%=request.getContextPath()%>/admin/adminSellerListView">판매자관리</a></li>
	            <li id="ad-book3"><a class="menut1" href="<%=request.getContextPath()%>/book/bookListView">도서관리</a></li>
	           <%} %>
         	</ul>
		</nav>
		<!-- 메인메뉴 끝 -->
		<!-- 상단에 고정될 검색창  -->
		<form action="<%=request.getContextPath()%>/search/searchBook" onsubmit="return fn_searchBook_byteCheck();">
		<div id="fixed-search-container1" class="fixed-search1">
		<img id = "slogo1"src="<%=request.getContextPath()%>/images/small-logo.png" alt="logo" height="40" width="70"  style="vertical-align: middle">
			<select name="searchType" id ="searchType2_1" style="vertical-align: middle">
				<option value="all" class="all-search">통합검색</option>
				<option value="title" class="title-search">책제목</option>
				<option value="writer" class="writer-search">저자명</option>
				<option value="publisher" class="publisher-search">출판사명</option>
			</select>
			<input type="text" name="searchBook" id="search-book2_1" placeholder="검색명을 입력하세요." style="vertical-align: middle"/>
			<input type="submit" id="search2_1" value="검색">
		</div>
		</form>
	</header>
	<section id="content1">

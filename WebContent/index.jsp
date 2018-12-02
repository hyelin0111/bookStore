<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<style>
article {
	margin-bottom: 25px;
	min-height: 400px;
}

aside {
	width: 100%;
	display: inline-block;
	float: right;
	background: red;
}

#bestSeller {
	margin-top: 25px;
}

article h1 {
	padding-left: 5px;
	padding-top: 30px;
	padding-bottom: 30px;
}

.img-container {
	width: 100%;
	height: 230px;
	z-index: 1;
}

div#remoteUp {
	position: fixed;
	width: 50px;
	height: 25px;
	top: 700px;
	right: 421px;
	background: gray;
	border: 1px solid black;
	text-align: center;
}

div#remoteDown {
	position: fixed;
	width: 50px;
	height: 25px;
	top: 725px;
	right: 421px;
	background: gray;
	border: 1px solid black;
	text-align: center;
}
</style>

<script>
$(document).ready(function(){
	$("#remoteUp").click(function(){
		$('html').animate({scrollTop : 0}, 600);
	});
	
	$("#remoteDown").click(function(){
		$('html').animate({scrollTop : ($('footer').offset().top)}, 600);
	});
	
	$.ajax({
		url : "<%=request.getContextPath()%>/book/BestSellerServlet.do",
		type : "get",
		dataType : "html",
		success : function(data){
			$("#bestSellerDiv").html(data);
		},
		error : function(){
			
		}
	});
	$.ajax({
		url : "<%=request.getContextPath()%>/book/TodayBookServlet.do",
		type : "get",
		dataType : "html",
		success : function(data){
			$("#todayBookDiv").html(data);
		},
		error : function(){
			
		}
	});
	$.ajax({
		url : "<%=request.getContextPath() %>/book/WeeklyBookServlet.do",
		type : "get",
		dataType : "html",
		success : function(data){
			$("#weeklyBookDiv").html(data);
		},
		error : function(){
			
		}
	});
});
</script>
<!-- 베스트 셀러 -->
<article id="bestSeller">
	<h1>베스트 셀러</h1>

	<div id="bestSellerDiv" class="img-container"></div>
</article>

<!-- 오늘의 책 -->
<article id="todayBook">
	<h1>오늘의 책</h1>

	<div id="todayBookDiv" class="img-container"></div>
</article>

<!-- 이주의 책 -->
<article id="weeklyBook">
	<h1>이주의 책</h1>

	<div id="weeklyBookDiv" class="img-container"></div>
</article>

<div id="remoteUp">▲</div>
<div id="remoteDown">▼</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
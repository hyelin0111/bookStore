<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:800" rel="stylesheet">
<style>
#enrolltype1{
	text-align: center; 
	margin-top: 43px;
	font-family: 'Nanum Gothic', sans-serif;
	font-size: 40px;
}
#tip11{
    float: right; 
    margin-right: 10px;  
    color: red;
}
div #button-container3{
	width:500px;
	min-height:200px; 
	padding-left:50px;
	padding-top:50px;
	margin: auto;
}
.btn_submit1{
	display: inline;
}
#new-enroll, #seller-enroll{
	margin-left:20px;
	width: 150px;
	height:150px;
	border-radius: 20px;
	border:1px solid white;
	cursor:pointer;
	background-color:#303343; 
	color: lightgray;
	font-size:20px;
}
#new-enroll:hover, #seller-enroll:hover{
	 background: rgba(48, 51, 67, 0.9);
	 color: lightgray;
}
#seller-enroll{
	margin-left: 80px;
}
</style>
<title>회원가입 유형</title>
<h2 id="enrolltype1">회원가입 유형을 선택하여 주세요</h2>

	<div id="button-container3">
	<form action="" class="btn_submit1">
		<button type="button" id="new-enroll" onclick="location.href ='<%=request.getContextPath()%>/member/memberEnroll'">신규 <br> 회원가입</button>
	</form>
	&nbsp;
	<form action ="" class="btn_submit1">
		<button type="button" id="seller-enroll">기존회원 <br> 판매자 가입</button>
		<span id="tip11">회원가입을 하셔야 가입하실수 있습니다.</span>
	</form>
	</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
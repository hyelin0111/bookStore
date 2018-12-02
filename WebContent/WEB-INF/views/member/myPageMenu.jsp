<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	//System.out.println(memberLoggedIn.getMember_no());
%>

<style>
#loca-container1{
	margin-top: 5px;
	padding-left: 5px;
}
#loca1{
	font-size: 5px;
}
#line1{
	border: 0.3px dashed black;
}
#ddblueblockmenu1{
	margin-top:10px;
	text-align: center;
	border-bottom-width: 0;
	width: 185px;
	display: inline-block;
	float: left;
	
}
#ddblueblockmenu1 div.menutitle1{
	height:60px;
	color: white;
	border-bottom: 1px solid black;
	padding-top: 25px;
	padding-left: 5px;
	background-color: #303343;
	text-align: center;
	font-size: 25px;
}
#subtitle1{
	height: 30px;
	padding-top: 10px;
	padding-bottom:5px;
	font-size: 19px;
	border-left: 7px solid #303343;
	border-right: 1px solid #303343;
	border-bottom: 1px dashed #303343;
	background-color: lightgray;
}

#ddblueblockmenu1 ul{
	margin: 0;
	padding: 0;
	list-style-type: none;
}

#ddblueblockmenu1 li a{
	display: block;
	padding: 3px 0;
	padding-left: 9px;
	width: 168px; 
	height:20px;
	text-decoration: none;
	color: black;
	background-color: white;
	border-bottom: 1px dashed #303343;
	border-left: 7px solid #303343;
	border-right: 1px solid #303343;
}
#ddblueblockmenu1 li #lasta1{
	border-bottom: 1px solid #303343;
}
#lastline1{
	border-bottom: 3px solid #303343;
}

#ddblueblockmenu1 li a:hover {
	background-color: #303343;
	color:white;
	border-left-color: #303343;
}
</style>
<div id="loca-container1">
	<span id="loca1">마이룸</span>
</div>
<hr id="line1"/>
<div id="ddblueblockmenu1">
<div class="menutitle1">마이페이지</div>
<form action="">
	<input type="hidden" name="memNo" value="<%=memberLoggedIn.getMember_no() %>" />
	<ul>
      <li id="subtitle1">회원정보관리</li> 
      <li><a href="<%=request.getContextPath()%>/member/memberView?member_id=<%=memberLoggedIn.getMember_id()%>">회원정보수정</a></li>
      <li><a href="<%=request.getContextPath()%>/member/updatePassword?member_id=<%=memberLoggedIn.getMember_id()%>">비밀번호 변경</a></li>
      <li><a href="<%=request.getContextPath()%>/member/addAddress?member_id=<%=memberLoggedIn.getMember_id()%>&member_no=<%=memberLoggedIn.getMember_no()%>">주소록 관리</a></li>
      <li><a href="<%=request.getContextPath()%>/member/memberDelete?member_id=<%=memberLoggedIn.getMember_id()%>">회원탈퇴</a></li>
   </ul>
   <ul>
      <li id="subtitle1">일반상품관리</li>
      <li><a href="<%=request.getContextPath()%>/order/orderList?memberNo=<%=memberLoggedIn.getMember_no()%>">주문/배송조회</a></li>
      <li><a href="<%=request.getContextPath()%>/order/cancelorderList?memberNo=<%=memberLoggedIn.getMember_no()%>">취소내역 조회</a></li>
   </ul>
   <ul>
      <li id="subtitle1">중고상품관리</li>
      <li><a href="<%=request.getContextPath()%>/order/oldOrderList?memberNo=<%=memberLoggedIn.getMember_no()%>">주문/배송조회</a></li>
      <li><a id="lasta1" href="<%=request.getContextPath()%>/order/cancelOldorderList?memberNo=<%=memberLoggedIn.getMember_no()%>">취소내역 조회</a></li>
   </ul>
</form>
<div id="lastline1"></div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>  
<%@ page import="java.util.*, member.model.vo.*" %>
<%
	List<Member> list = (List<Member>)request.getAttribute("list");
%>  
<style>
#mt1{
	text-align: center;
	margin-top:25px; 
}
#h1line1{
	border: 1px dashed lightgray;
}
#adm-mem1{
	width:100%; 
	border:1px solid gray;
	border-collapse:collapse;
}
table#adm-mem1 th,table#adm-mem1 td{
	border:1px solid gray;
	padding: 3px;
	border-left:1px solid white;
	border-right:1px solid #b8bbc6;
	height: 30px;
}
table#adm-mem1 th{
	background-color:#dde3ff; 
	border-top:2px solid #9faef9; 
	border-bottom:2px solid #9faef9; 
	
}
table#adm-mem1 td{
	text-align: center;
}
table#adm-mem1 th#no-line1,table#adm-mem1 td#no-line1{
	border-right:1px solid white;
}
div#pageBar{text-align:center;margin-top:10px;}
div#pageBar span{margin:0 5px;}
.m-inter1{
	font-size: 10px;
}
	
</style>
<h2 id="mt1">회원관리</h2>
<hr id="h1line1"/>
<section>
	<div id="searchU-container1">
		<img src="<%= request.getContextPath() %>/images/search-u.png" alt="search-u" width="50px"/>
	</div>
	<table id="adm-mem1">
		<tr>
			<th>아이디</th>
			<th>상태</th>
			<th>이름</th>
			<th>성별</th>
			<th>생년월일</th>
			<th>휴대번호</th>
			<th>이메일</th>
			<th id="no-line1">흥미분야</th>
		</tr>
		<%if(list==null||list.isEmpty()){  %>
		<tr>
			<td colspan="8" align="center">데이터가 존재하지 않습니다.</td>
		</tr>
		<%} else{ 
			for(Member m: list){
		%>
		
		<tr>
			<td>
				<a href="<%=request.getContextPath()%>/admin/adminMemberView?member_id=<%=m.getMember_id()%>"><%= m.getMember_id()%></a>
			</td>
			<td><%= m.getMember_status() %></td>
			<td><%= m.getMember_name() %></td>
			<td><%= m.getMember_gender() %></td>
			<td><%= m.getMember_birthday()%></td>
			<td><%= m.getMember_phone() %></td>
			<td><%= m.getMember_email() %></td>
			<% if(m.getMember_interested()!=null){ %>
				<td id="no-line1" class="m-inter1"><%= m.getMember_interested() %></td>
			<%}else {  %>
				<td id="no-line1" class="m-inter1"></td>
			<%} %>
		</tr>
		<%}
		} %>
	</table>
	<div id="pageBar"><%=request.getAttribute("pageBar") %></div>
</section>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
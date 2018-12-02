<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>  
<%@ page import="java.util.*, seller.model.vo.*" %>
<%
	List<Seller> list = (List<Seller>)request.getAttribute("list");
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

	
</style>
<h2 id="mt1">판매자 회원 관리 </h2>
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
			<th>이메일</th>
			<th id="no-line1">휴대전화</th>
		</tr>
		<%if(list==null||list.isEmpty()){  %>
		<tr>
			<td colspan="8" align="center">데이터가 존재하지 않습니다.</td>
		</tr>
		<%} else{ 
			for(Seller s: list){
		%>
		
		<tr>
			<td>
				<a href="<%=request.getContextPath()%>/admin/adminSellerView?member_id=<%=s.getMember_id()%>"><%= s.getMember_id()%></a>
			</td>
			<td><%= s.getMember_status() %></td>
			<td><%= s.getMember_name() %></td>
			<td><%= s.getEmail_ok() %></td>
			<td id="no-line1" class="m-inter1"><%= s.getTell_ok() %></td>
		</tr>
		<%}
		} %>
	</table>
	<div id="pageBar"><%=request.getAttribute("pageBar") %></div>
</section>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
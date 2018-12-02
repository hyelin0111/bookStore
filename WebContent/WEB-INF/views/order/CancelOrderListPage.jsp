<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
				 order.model.vo.CancelOrder" %>
<%
	List<CancelOrder> list = (List<CancelOrder>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<style>
	#tbl-bookList{
		margin: 0 auto;
	}
</style>


</head>
<body>
	<table id="order_list">
		<tr>
			<th>주문번호</th>
			<th>주문일자</th>
			<th>상품정보</th>
			<th>수량</th>
			<!-- <th>주문취소</th> -->
		</tr>
		<%if(list.isEmpty() || list == null){ %>
		<tr>
			<td colspan="6">주문 내역이 없습니다.</td>
		</tr>
		<%}else{ %>
		<% for(CancelOrder b : list) {
				%>
			<tr>
				<td><%=b.getOrderNo() %></td>
				<td><%=b.getOrderDate() %></td>
				<td><%=b.getBookTitle() %></td>
				<td><%=b.getOrderQTY() %></td>
			</tr>
		<%} 
		}%>
	</table>
	
	<div id='pageBar' style=" margin-top: 10px; text-align: center;">
	<%=request.getAttribute("pageBar") %>
	</div>
</body>
</html>
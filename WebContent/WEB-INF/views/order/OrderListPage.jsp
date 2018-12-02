<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
				 order.model.vo.Order" %>
<%
	List<Order> list = (List<Order>)request.getAttribute("list");
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
			<th>주문상태</th>
			<th>주문취소</th>
		</tr>
		<%if(list.isEmpty() || list == null){ %>
		<tr>
			<td colspan="6">주문 내역이 없습니다.</td>
		</tr>
		<%}else{ %>
		<% for(Order b : list) {
				String del = "";
				if(b.getDeliveryStatus().equals("1")) del = "주문접수";
				else if(b.getDeliveryStatus().equals("2")) del = "결제완료";
				else if(b.getDeliveryStatus().equals("3")) del = "상품준비";
				else if(b.getDeliveryStatus().equals("4")) del = "출고작업";
				else if(b.getDeliveryStatus().equals("5")) del = "배송중";
				else if(b.getDeliveryStatus().equals("6")) del = "배송완료";%>
			<tr>
				<td><%=b.getOrderNo() %></td>
				<td><%=b.getOrderDate() %></td>
				<td><%=b.getBookTitle() %></td>
				<td><%=b.getOrderQty() %></td>
				<td><%=del %></td>
				<td><input type='button' value='삭제' onclick='fn_deleteOrder(<%=b.getOrderNo()%>);'/></td>
			</tr>
		<%} 
		}%>
	</table>
	
	<div id='pageBar' style=" margin-top: 10px; text-align: center;">
	<%=request.getAttribute("pageBar") %>
	</div>
</body>
</html>
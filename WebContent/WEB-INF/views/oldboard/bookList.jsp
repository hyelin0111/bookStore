<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
				 book.model.vo.Book" %>
<%
	List<Book> bookList = (List<Book>)request.getAttribute("bookList");
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
<script>
	$(document).ready(function(){
		$("#tbl-bookList tr:gt(0)").hover(function(){
			$(this).css("text-decoration", "underline");
		},
		function(){
			$(this).css("text-decoration", "none");
		});
	});
	
	$(function(){
		$("#tbl-bookList tr:gt(0)").click(function(){			
			var bookImg = $(this).find(".bookNo").val();
			
			$("#insertOldBook").attr( "src", "<%=request.getContextPath() %>/images/" + bookImg + ".jpg" );
			$("#oldBookNo").attr("value", bookImg);
			$("#imgCheck").attr("value", "true");
			
			$("#searchOldBookDiv").hide();
			$("#searchContent").val("");
			
			$.ajax({
				url : "<%=request.getContextPath()%>/oldbook/selectBookListServlet",
				type : "get",
				dataType : "html",
				success : function(data){
					$("#bookList").html(data);
				},
				error : function(){
					
				}
			});
		});
	});
</script>
</head>
<body>
	<table id="tbl-bookList">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작가</th>
			<th>출판사</th>
			<th>분야</th>
		</tr>
		
		<% for(Book b : bookList) {%>
			<tr>
				<td>
					<%=bookList.indexOf(b) + 1 %>
					<input class="bookNo" type="hidden" value="<%=b.getBookNo()%>"/>					
				</td>
				<td><%=b.getBookTitle() %></td>
				<td><%=b.getAuthorName() %></td>
				<td><%=b.getBookPublisher() %></td>
				<td><%=b.getCategory() %></td>
			</tr>
		<%} %>
	</table>
	
	<div id='pageBar'>
	<%=request.getAttribute("pageBar") %>
	</div>
</body>
</html>
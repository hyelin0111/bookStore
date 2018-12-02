<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="book.model.vo.Book,
				 review.model.vo.Review,
				 java.util.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp"%>    
 <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>

 <%
 	Book b = (Book)request.getAttribute("book");
 	List<Review> r = (List<Review>)request.getAttribute("review");
 	String str = "";
 %>
<style>
.btn_blue {margin-top:10px; margin-bottom:-60px; background-image: none;background-color: #5e6b9f !important;border: 1px solid #5e6b9f;color: #fff !important;box-shadow: none;}
.btn_blue2 { margin-bottom:-60px; background-image: none; background-color: #7b8ed1 !important;border: 1px solid #7b8ed1;color: #fff !important;box-shadow: none;}
table#tbl-board{
	width:500px;
	margin:0 auto;
	margin-top : 20px;
	border:1px solid;
	border-collapse:collapse;
}
table#tbl-board th{
	width:125px;
	border:1px solid;
	padding:5px 0;
	text-align:center;
}
table#tbl-board td{
	border:1px solid;
	padding:5px 0 5px 10px;
	text-align:left;
}
#bAOVTitle5{
	text-align: center;
	margin-top: 50px;
}
.book25{width: 190px; height: 250px;}
</style>

<h2 id="bAOVTitle5">도서 정보</h2>
<form action="<%=request.getContextPath()%>/admin/BookAdminUpdate">
<table id="tbl-board">
	<tr>
		<th>도서 제목</th>
		<td>
			<input type="text" name=bookTitle value="<%=b.getBookTitle() %>" readonly style="background: gray; color:white;"/>
			<input type="hidden" name="bookNo" value="<%=b.getBookNo() %>" />
		</td>
	</tr>
	<tr>
		<th>이미지</th>
		<td>
			<img class="book25" src="<%=request.getContextPath()%>/images/<%=b.getBookNo()%>.jpg" alt="book_image" onerror="javascript:this.src='<%=request.getContextPath()%>/images/blank.png'"/>
			<br />
			<!-- <input type="button" value="이미지 찾기" /> -->
		</td>
	</tr>	
	<tr>
		<th>지음</th>
		<td>
			<input type="text" name="bookWriter" value="<%=b.getAuthorName() %>" readonly style="background: gray; color:white;"/>
			<input type="hidden" name="bookAuno" value="<%=b.getAuthorNo()%>"/>
		</td>
	</tr>	
	<tr>
		<th>장르</th>
		<td>
			<input type="text" name="bookCategory" value="<%=b.getCategory() %>" />
		</td>
	</tr>	
	<tr>
		<th>출판사</th>
		<td>
			<input type="text" name="bookPublisher" value="<%=b.getBookPublisher() %>" />
		</td>
	</tr>	
	<tr>
		<th>가격</th>
		<td>
			<input type="number" name="bookPrice" value="<%=b.getBookPrice() %>" step="100"/>
		</td>
	</tr>	
	<tr>
		<th>출판일</th>
		<td>
			<input type="date" name="bookDate" value="<%=b.getIssueDate() %>" step="100"/>
		</td>
	</tr>	
	<tr>
		<th>페이지</th>
		<td>
			<input type="number" name="bookPage" value="<%=b.getBookPage() %>"/>
		</td>
	</tr>
	<tr>
		<th>재고</th>
		<td>
			<input type="number" name="bookQTY" value="<%=b.getBookSaleQty() %>"/>
		</td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="수정하기" onclick="fn_updateBook();" class="btn_blue" />
			<input type="button" value="삭제하기" onclick="return fn_deleteBook();" class="btn_blue2"/>
		</th>
	</tr>
</table>
</form>
<script>
function fn_deleteBook(){
	if(!confirm('정말로 삭제하시겠습니까?'))
		return false;
	location.href="<%=request.getContextPath()%>/admin/bookAdminDelete?bookNo=<%=b.getBookNo()%>";
	return true;	
}
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
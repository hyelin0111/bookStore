<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, book.model.vo.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
	List<Book> list = (List<Book>)request.getAttribute("list");
	String category = (String)request.getAttribute("category");
	System.out.println("156131515161 = "+category);
	String searchBook = request.getParameter("searchBook"); 
	int i = 1;
%>
<style>
* {
   user-select: none;    
}
img.book2 {
   width: 100px;
   height: 120px;
   border: 1px solid;
}
nav#search_nav2 {
   background: #eaeaea;
   width: 100%;
   height: 30px;
/*    border: 1px solid;
   border-bottom: 1px solid gray; */
   text-align: left;
   /* padding-left: 5px; */
}
nav#search_nav2 a {
   text-decoration: none;
   color: black;
   vertical-align: middle;
   padding: 5px;
   font-weight: normal;
}
span.sep2 {
   color: gray;
}
nav#search_nav2 a:hover, nav#search_nav2 a:focus {
   font-weight: bold;
   text-decoration: underline;
}
span#searchData2 {
   color: blue;
   font-weight: bold;
}
table#new_book2, table#old_book2 {
   border: 1px solid;
   border-collapse: collapse;
   width: 100%;
   /* margin-top: 10px; */
}
table#new_book2 td, table#old_book2 td {
   vertical-align: middle;
   padding: 10px;
} 
table td.book_name2 {
   text-align: left;
   width: 42%;
}
table td.book_img2 {
   width: 120px;
}
span.bookname2 {
   color: blue;
   font-weight: bold;
}
span.category2 {
   font-weight: bold;
}
span.etc2, span.seller2 {
   font-size: 13px;
}
input#count2 {
   width: 33px;
}
input[type=button].btn2 {
   margin: 2px;
   width: 100px;
   background: white;
   border-color: #899bdb;
   padding: 5px;
}
input[type=button].btn2:hover, input[type=button].btn2:focus {
   background: #899bdb;
   color: white;
}
a {
   text-decoration: none;
   color: black;
}
a:hover {
   text-decoration: underline;
   font-weight: bold;
}

img#review2 {
   width: 15px;
   height: 15px;
   border: 0px;
}
td.price2 {
   text-align: right;
}
span.origin2 {
   font-size: 14px;
   text-decoration: line-through;
}
span.discount2 {
   color: red;
   font-weight: bold;
   font-size: 16px;
}
span.grade2 {
   font-size: 12px;
}
div#pageBar2{ margin-top: 10px; text-align: center; background: #899bdb; }
div#pageBar2 span { margin: 0 5px; }
</style>
<div>
<%=category%> <span id="searchData2">'<%=category %>'</span> 검색결과  <br />
<hr /> <br />
<form>
<table id="new_book2">
   <tr>
      <th colspan="6">
         <nav id="search_nav2">
     <!--        <a href="#">판매량</a><span class="sep"> | </span>
            <a href="#">신상품</a><span class="sep"> | </span>
            <a href="#">낮은가격</a><span class="sep"> | </span>
            <a href="#">높은가격</a><span class="sep"> | </span>
            <a href="#">리뷰수</a>  -->
         </nav>
      </th>
   </tr>
   
   <%if(list == null || list.isEmpty()) { %>
   <tr>
   		<td colspan="6">데이터가 존재하지 않습니다.</td>
   </tr>
   <%} else { 
   		for(Book b : list) {
   %>
   <tr>
      <td class="book_img2">
         <img class="book2" src="<%=request.getContextPath()%>/images/<%=b.getBookNo()%>.jpg" alt="book_image" onerror="javascript:this.src='<%=request.getContextPath()%>/images/blank.png'"/>
      </td>
      <td id="bookname2">
         <span class="category2">[<%=b.getCategory()%>]</span> <span class="bookname2"><a href="<%=request.getContextPath()%>/book/bestSellerEnd?bookNo=<%=b.getBookNo()%>"><%=b.getBookTitle() %></a></span> <br /><br />
         <span class="etc2"><a href="#"><%=b.getAuthorName() %></a> | <a href="#"><%=b.getBookPublisher() %></a> | <%=b.getIssueDate() %></span>  
      </td>
      <td><img id="review2" src="<%=request.getContextPath() %>/images/review.png" alt="review" /> <a class="review2" href="#">리뷰</a></td>
      <td><%=b.getBookPrice()%>원</td>
      <td>
         수량 <input id="count2" type="number" min="1" value="1" name="orderQty"/>
      </td>
      <td>
         <% if(memberLoggedIn!=null) { %>
         <input type="hidden" value="<%=b.getBookNo()%>" name="bookNo"/>
		 <input type="hidden" value="<%=memberLoggedIn.getMember_no()%>" name="memberNo"/>
		 <%-- <input type="hidden" value="<%=b.getBookStatus()%>" name="bookStatus"/> --%>
         <input class="btn2 basket_btn" type="button" value="장바구니 담기" /> <br />
         <input class="btn2 order_btn" type="button" value="바로구매"  />
		 <%} %>
      </td>
   </tr>
   <%} 
   }%>
</table>
</form>
<br /><br /><br />
</div>

<script>
$(".order_btn").click(function() {
	$("#bookNoEnd").val($(this).parent().find("[name=bookNo]").val());
	$("#orderQtyEnd").val($(this).parent().parent().find("[name=orderQty]").val());
	console.log($(this).parent().find("#orderQty").val());
	$("#orderEndFrm").submit();
});

//장바구니 담기 버튼 클릭 시
$(".basket_btn").click(function() {
	$("#bookNoEnd").val($(this).parent().find("[name=bookNo]").val());
	$("#orderQtyEnd").val($(this).parent().parent().find("[name=orderQty]").val());
	//console.log($(this).parent().find("#orderQty").val());
	//$("#orderEndFrm").submit();
	fn_insertBasket(); 
});

function fn_insertBasket(){
	<%if (memberLoggedIn != null) {%>
	$.ajax({
		url : "<%=request.getContextPath()%>/basket/insertBasket",
		data : {
			memberNo : <%=memberLoggedIn==null?1:memberLoggedIn.getMember_no()%>,
			bookNo : $("#bookNoEnd").val(),
			orderCnt : $("#orderQtyEnd").val(),
			status : "N"
		},
		dataType : "html",
		success : function(data){
			var check = confirm("장바구니에 담겼습니다. 장바구니로 이동하시겠습니까?");
			
			if( check )
				location.href="<%=request.getContextPath()%>/basket/basketServlet?memberNo=" + <%=memberLoggedIn==null?1:memberLoggedIn.getMember_no()%>;
		},
		error : function(){
			
		}
	});
	 <%}%>
}
</script>

<form action="<%=request.getContextPath()%>/order/buyServlet" id="orderEndFrm">
	<input type="hidden" value="" name="bookNo" id="bookNoEnd"/>
	<% if(memberLoggedIn!=null) { %>
	<input type="hidden" value="<%=memberLoggedIn.getMember_no()%>" name="memberNo"/>
	<% } %>
	<input type="hidden" value="" name="orderQty" id="orderQtyEnd"/>
</form>


<div id="pageBar2"><%=request.getAttribute("pageBar")%></div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
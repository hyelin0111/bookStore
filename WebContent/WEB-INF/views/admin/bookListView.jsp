<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="book.model.vo.Book,
	 			review.model.vo.Review,
	 			java.util.*" %>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<style>
* {
   user-select: none;    
}
img.book2 {width: 100px;height: 120px;border: 1px solid;}
nav#search_nav2 {background: #eaeaea;width: 100%;height: 30px;
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
   font-size: 20px;
}
table#new_book2, table#old_book2 {
   border: 1px solid;
   border-collapse: collapse;
   width: 100%;
   /* margin-top: 10px; */
}
table td {
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
input[type=button].btn3 {
   margin: 2px;
   width: 100px;
   background: white;
   border-color: tomato;
   padding: 5px;
   float: right; 
   margin-right: 55px;
}
input[type=button].btn3:hover, input[type=button].btn3:focus {
   background: tomato;
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
header div#search-container5{
	position:relative;
	width: 650px;
	margin: 5px auto;
	margin-bottom: 15px;
}
#searchType1_5{
	width:75px;
	height:30px;
	padding-left: 2px;
	font-size: 12px;
	border: 1px solid black;
	border-radius: 6px;
	margin-top: 5px;
	margin-right: 5px;
	cursor:pointer;
}
#search-book1_5{
	width:500px;
	height:30px;
	border-radius: 6px;
   	border: 1px solid black;
   	padding-right: 0px;
   	display: inline;
}
#search1_5{
	display: inline;
	border: 1px;
	width:40px;
	height: 32px;
	border: 1px solid black;
	border-radius: 6px;
	background: #303343;
	color: white;
	cursor:pointer;
}
.search-container5{
	text-align: center;
}
</style>
<%
	List<Book> list = (List<Book>)request.getAttribute("booklist");
	//String type = (String)request.getAttribute("type");
	//String searchBook = request.getParameter("searchBook"); 
%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<span id="searchData2">도서 관리</span><br />
<form action="<%=request.getContextPath()%>/admin/searchBook" onsubmit="return fn_searchBook_byteCheck5();">
	<div class="search-container5">
		<div id="search-container5">
			<select name="searchType5" id ="searchType1_5">
				<option value="all" class="all-search5">통합검색</option>
				<option value="title" class="title-search5">책제목</option>
				<option value="writer" class="writer-search5">저자명</option>
				<option value="publisher" class="publisher-search5">출판사명</option>
			</select>
			<input type="text" name="searchBook5" id="search-book1_5" placeholder="등록 도서 검색 " />
			<input type="submit" id="search1_5" value="검색">
		</div>
	</div>
</form>
<hr /> <br />
<table id="new_book2">
   <tr>
      <th colspan="6">
         <nav id="search_nav2">
            <!-- <a href="#">정확도</a><span class="sep"> | </span> -->
            <a href="#">판매량</a><span class="sep"> | </span>
            <!-- <a href="#">신상품</a><span class="sep"> | </span> -->
            <a href="#">상품명</a><span class="sep"> | </span>
            <a href="#">낮은가격</a><span class="sep"> | </span>
            <a href="#">높은가격</a><span class="sep"> | </span>
            <!-- <a href="#">할인률</a><span class="sep"> | </span> -->
            <a href="#">리뷰수</a>
            <input type="button" value="도서 추가" onclick="fn_insertBook()" class="btn3"/> 
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
         <span class="category2">[<%=b.getCategory()%>]</span> <span class="bookname2"><a href="#"><%=b.getBookTitle() %></a></span> <br /><br />
         <span class="etc2"><a href="#"><%=b.getAuthorName() %></a> | <a href="#"><%=b.getBookPublisher() %></a> | <%=b.getIssueDate() %></span>  
      </td>
      <td><%=b.getBookSaleQty() %>권</td>
      <td><%=b.getBookPrice()%>원</td>
      <td>
         	<%=b.getBookGrade() %>점
      </td>
      <td>
         <input class="btn2" type="button" value="정보보기" onclick="fn_BookOneInfo('<%=b.getBookTitle() %>', '<%=b.getBookNo() %>')" />
      </td>
   </tr>
   <%} 
   }%>
</table>
<script>
function fn_BookOneInfo(title, bookNo){
	location.href="<%=request.getContextPath()%>/book/BookOneInfo?title="+title+"&bookNo="+bookNo+"";
}
function fn_insertBook(){
	location.href="<%=request.getContextPath()%>/admin/BookAdminInsert";
}
function fn_searchBook_byteCheck5(){
	if($("#search-book1_5").val().trim() == 0) {
		alert("검색어를 입력하세요");
		return false;
	}
	return true;
}
</script>

<br /><br /><br />


<div id="pageBar2"><%=request.getAttribute("pageBar5")%></div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
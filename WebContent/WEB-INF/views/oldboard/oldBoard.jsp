<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="oldboard.model.vo.OldBoard,
				 java.util.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
	List<OldBoard> oldBoardList = (List<OldBoard>)request.getAttribute("oldBoardList");
%>
<style>
div#board-container {
	/* width:600px; */
	margin:0 auto;
	text-align:center;
}
div#board-container h2{margin:10px 0;}
table#tbl-board{
	width:100%;
	margin:0 auto;
	border:1px solid black;
	border-collapse:collapse;
}
table#tbl-board th, table#tbl-board td {
	border:1px solid black;
	padding:5px 0;
	text-align:center;
} 
div#oldPageBar{
	margin-top:10px;
	text-align:center; 
	background-color:rgba(0, 188, 212, 0.3);
}
div#oldPageBar span.cPage{color: #0066ff;}

/*글쓰기버튼*/
input#btn-add{
   float:right; 
   margin:0 0 15px;
   border-color: #899bdb;
   background: white;
}

#btn-add:hover{
   background: #899bdb;
   color: white;
}
.adm-mem5{
	width:100%; 
	border:1px solid gray;
	border-collapse:collapse;
}
table.adm-mem5 th,table.adm-mem1 td{
	border:1px solid gray;
	padding: 3px;
	border-left:1px solid white;
	border-right:1px solid #b8bbc6;
	height: 30px;
}
table.adm-mem5 th{
	background-color:#dde3ff; 
	border-top:2px solid #9faef9; 
	border-bottom:2px solid #9faef9; 
	
}
table.adm-mem5 td{
	text-align: center;
}
table.adm-mem5 th#no-line1,table.adm-mem5 td#no-line1{
	border-right:1px solid white;
}
</style>
<script>
<% if(memberLoggedIn != null){ %>
   function fn_goBoardForm(){
      location.href="<%=request.getContextPath()%>/oldboard/writeOldBoard?memberNo=" + <%=memberLoggedIn.getMember_no()%>;
   }
<%}%>

$(document).ready(function(){
	$("#tbl-board tr:gt(0)").hover(function(){
		$(this).children().eq(1).css({
										"text-decoration": "underline",
										"font-weight": "bold"
								 });
	},function(){
		$(this).children().eq(1).css({
										"text-decoration": "none",
										"font-weight": "normal"
								});
	});
});
</script>
<section id="boardList-container">
	<div id="board-container">
		<h2>중고게시판 </h2>
		<%if(memberLoggedIn != null){ %>
			<input type="button" value="글쓰기" id="btn-add" onclick="fn_goBoardForm();" />
		<%} %>
		<table id="tbl-board" class="adm-mem5">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>		
			<%  if( oldBoardList != null ){			
				for(OldBoard b : oldBoardList){ %>
			<tr>
				<td><%= b.getOldBoardNo() %></td>
				<td>
					<a style="text-decoration: none; color: black;" href="<%=request.getContextPath()%>/oldboard/oldBoardView?oldBoardNo=<%=b.getOldBoardNo()%>"><%= b.getBookTitle() %></a>					
				</td>
				<td><%= b.getMemberName() %></td>
				<td><%= b.getOldBoardDate() %></td>
			</tr>
			<% } 
			}%>
		</table>
	</div>
	<div id="oldPageBar">
		<%=request.getAttribute("pageBar") %>
	</div>
</section>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
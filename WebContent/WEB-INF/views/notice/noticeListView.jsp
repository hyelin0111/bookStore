<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>  
<%@ page import="java.util.*, notice.model.vo.*" %>
<%
	List<Notice> list = (List<Notice>)request.getAttribute("list");
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
	background-color:#343343;
	color:white; 
	border-top:2px solid #575e82; 
	border-bottom:2px solid #575e82; 
	
}
table#adm-mem1 td{
	text-align: center;
}
table#adm-mem1 th#no-line1,table#adm-mem1 td#no-line1{
	border-right:1px solid white;
}
div#pageBar{text-align:center;margin-top:10px;}
div#pageBar span{margin:0 5px;}

#btn-write1{
	margin-bottom:10px;
	width: 100px;
	float: right;
}
#write11{
	width:80px; 
	height:40px; 
	color:white; 
	background:#303343;
	border-radius: 10px;
	border:1px solid black;
	cursor:pointer;
	font-size: 15px;
}
#write11:hover{
	border:1px solid black;
	background: white;
	color: #303343;
}
	
</style>
<h2 id="mt1">공지사항</h2>
<hr id="h1line1"/>
<section>
<div id="btn-write1">
	<% if(memberLoggedIn!=null && "admin".equals(memberLoggedIn.getMember_id())){ %>
	<input type="button" id="write11"value="글쓰기" onclick="fn_insertNotice();"/>
	<script>
	function fn_insertNotice(){
		location.href="<%=request.getContextPath()%>/notice/noticeForm";
	}
	</script>
	<%} %>
</div>
	<table id="adm-mem1">
		<tr>
			<th>공지번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th id="no-line1">작성일</th>
		</tr>
		<%if(list==null||list.isEmpty()){  %>
		<tr>
			<td colspan="8" align="center">데이터가 존재하지 않습니다.</td>
		</tr>
		<%} else{ 
			for(Notice n: list){
		%>
		<tr>
			<td><%=n.getNotice_no() %></td>
			<td>
				<a href="<%=request.getContextPath()%>/notice/noticeView?no=<%=n.getNotice_no()%>"><%= n.getTitle() %></a>
			</td>
			<%if(n.getMember_no()==1){ %>
			<td>관리자</td>
			<%} %>
			<%-- <td>
            <% if(n.getFilePath() != null){ %>
            <img alt="첨부파일" src="<%=request.getContextPath() %>/images/file.png">
            <% }%>
            </td> --%>
			<td id="no-line1" class="m-inter1"><%= n.getDate() %></td>
		</tr>
		<%}
		} %>
	</table>
	<div id="pageBar"><%=request.getAttribute("pageBar") %></div>
</section>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ page import="notice.model.vo.*" %>
<%
	Notice n = (Notice)request.getAttribute("notice");
%>
<style>
div#notice-container{
	width:600px; 
	margin:auto; 
	text-align:center;
	padding-top: 20px;
}
div#notice-container h2{margin:10px 0;}
table#tbl-notice{
	width:500px; 
	margin:0 auto; 
	border:1px solid black; 
	border-collapse:collapse;
}
table#tbl-notice th {
	width: 125px; 
	border:1px solid; 
	padding: 5px 0; 
	text-align:center;
	background: #343343;
	color: white;
} 
table#tbl-notice td {
	border:1px dashed lightgray;  
	padding: 5px 0 5px 10px; 
	text-align:left;
}
#line211{
	border: 1px dashed lightgray;
	margin-bottom: 25px; 
}
table#tbl-notice th#th-content{
	min-height:200px;
}
</style>
<script>
function fn_fileDownload(filePath){
	//ie는 자동으로 인코딩처리 하지 않음.
	filePath=encodeURIComponent(filePath);
	location.href="<%=request.getContextPath()%>/notice/noticeFileDownload?fname="+filePath;
	
}
</script>
<div id="notice-container">
	<h2>공지사항</h2>
	<hr id="line211"/>
	<table id="tbl-notice">
		<tr>
            <th>제 목</th>
            <td><%=n.getTitle() %></td>
        </tr>
        <tr>
            <th>작성자</th>
            <% if(n.getMember_no()==1) {%>
            <td>관리자</td>
            <% }%>
        </tr>

        <tr>
            <th id="th-content">내 용</th>
            <td><%=n.getContent() %></td>
        </tr>
        <%-- 관리자인 경우 공지사항 수정/삭제 가능 --%>
        <% if(memberLoggedIn!=null && "admin".equals(memberLoggedIn.getMember_id())){ %>
        <tr>
        	<th colspan="2">
        		<input type="button" value="수정" onclick="fn_updateNotice();"/>
        		<input type="button" value="삭제" onclick="fn_deleteNotice();"/>
        	</th>
        </tr>
        <%} %>
        
	</table>
</div>
<%-- 관리자인 경우 공지사항 수정/삭제 가능 --%>
<% if(memberLoggedIn!=null && "admin".equals(memberLoggedIn.getMember_id())){ %>
<script>
function fn_updateNotice(){
	location.href="<%=request.getContextPath()%>/notice/noticeUpdate?no=<%=n.getNotice_no()%>";
}
function fn_deleteNotice(){
	if(!confirm('이 공지사항을 정말 삭제하시겠습니까?')) return;
<%-- 	var f = encodeURIComponent("<%= n.getFilePath()!=null?n.getFilePath():""%>"); --%>
	location.href="<%=request.getContextPath()%>/notice/noticeDelete?no=<%=n.getNotice_no()%>";
}
</script>
<%} %>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>


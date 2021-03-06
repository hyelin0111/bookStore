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
	margin:0 auto; 
	text-align:center;
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
} 
table#tbl-notice td {
	border:1px solid; 
	padding: 5px 0 5px 10px; 
	text-align:left;
}
span#fname{
	position:absolute;
	left:86px;
	top:10px;
	width:285px;
	background:#f5f5f5;
}
</style>
<script>
function validate(){
	var content = $("[name=content]").val();
	if(content.trim().length==0){
		alert("내용을 입력하세요.");
		return false;
	}
	return true;
}
</script>
<div id="notice-container">
	<h2>공지사항 - 작성</h2>
	<form action="<%=request.getContextPath()%>/notice/noticeUpdateEnd" method="post">
		<table id="tbl-notice">
			<tr>
				<th>글번호</th>
				<td>
					<input type="text" name="no" value="<%=n.getNotice_no()%>" readonly required/>
				</td>
			</tr>
			<tr>
	            <th>제 목</th>
	            <td>
	            	<input type="text" name="title" value="<%=n.getTitle() %>" required/>
	            </td>
	        </tr>
	        <tr>
	            <th>작성자</th>
	            <td>
	            	<input type="text" name="w_no" value="<%=n.getMember_no() %>" readonly required/>
	            </td>
	        </tr>
	        <tr>
	            <th>내 용</th>
	            <td>
	            	<textarea name="content" cols="50" rows="5"><%=n.getContent() %></textarea>
	            </td>
	        </tr>
	        <tr>
	        	<th colspan="2">
	        		<input type="submit" value="수정" onclick="return validate()"/>
	        	</th>
	        </tr>
		</table>
	</form>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>








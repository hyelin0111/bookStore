<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String memId = (String)request.getAttribute("memId");
	boolean isUsable= (boolean)request.getAttribute("isUsable");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복검사</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<script>
function fn_checkId(){
	var memId = $("#memId3").val().trim();
	if(memId.length<4){
		alert('아이디는 4글자이상부터이 가능합니다.');
		return false;
	}
	$("#memId3").val(memId);
	return true;
}
function setUserId(memId){
	var frmH = opener.document.frm;
	frmH.memId.value=memId;
	frmH.idValid.value=0;
	frmH.memPwd3.focus();
	self.close();
}
</script>
<style>
div#checkId-area1{
	text-align: center;
	padding-top:50px;
}
#idOk11{
	color: blue;
}
#idNo11{
	color: red;
}
</style>
</head>
<body>
<div id="checkId-area1">
	<% if(isUsable == true){ %>
	<span id="idOk11"><%= memId %></span>는 사용가능합니다.
	<br /><br />
	<button type="button" onclick="setUserId('<%=memId%>')">닫기</button>
	<% }else{ %>
		<span id="idNo11"><%= memId %></span>는 이미 사용중입니다.
		<br /><br />
		<form action="<%=request.getContextPath()%>/member/checkId">
			<input type="text" name="memId" id="memId3" /> &nbsp;
			<input type="submit" value ="중복검사" onclick="return checkId();"/> &nbsp;
		</form>
	<% } %>
</div>
</body>
</html>
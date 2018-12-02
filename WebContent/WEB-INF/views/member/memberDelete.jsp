<%@page import="org.apache.tomcat.jni.Mmap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/member/myPageMenu.jsp" %>
<%
	String id = memberLoggedIn.getMember_id();
%>
<style>
#content1-container1{
	width: 760px;
	padding: 15px;
	float: left;
	margin:5px;
}
#title-container1{
	float: left;
}
#delete-h21{
	padding-left : 3px;
}
#h-line1{
	border: 0.8px dashed gray;
	width: 760px;
}
#ta-container1{
	padding-left:3px;
	float: left;
	width: 750px;
}
#sub1-title1{
	font-size: 18px;
}
#explain1{
	font-size: 11px;
	color: red;
}
#h1-line1{
	border: 0.4px dashed gray;
}
#p-table1, #p-cell1,#pwdTitle1,#pwdInput1{
	border-collapse: collapse;
	border-right: 1px dashed white;
	height:30px;
}

#pwdTitle1,#pwdTitle3{
	width: 150px;
	border-right: 1px solid #b8bbc6;
	border-left: 1px solid white;
	background-color: #dde3ff;
	padding-left:8px;
	font-size:16px;
}
#pwdTitle1,#pwdInput1,#pwdInput2{
	border-bottom:  1px solid #b8bbc6; 
}
#pwdInput1,#pwdInput3{
	width:600px;
	padding-left: 8px;
	padding-bottom: 3px;
}
#pwdTitle1, #pwdInput1{
	border-top: 2px solid #9faef9; 
}
#pwdTitle3, #pwdInput3{
	border-bottom: 2px solid #9faef9; 
}
#su-btn1{
	margin-top: 10px;
	float: right;
}
#del_member1{
	width:80px; 
	height:40px; 
	color:white; 
	background:#303343;
	border-radius: 10px;
	border:1px solid black;
	cursor:pointer;
	font-size: 15px;
	margin-right:15px; 
}
#del_member1:hover{
	border:1px solid black;
	background: white;
	color: #303343;
}
#back_index1{
	width:80px; 
	height:40px; 
	color:white; 
	background:#303343;
	border-radius: 10px;
	border:1px solid black;
	cursor:pointer;
	font-size: 15px;
}
#back_index1:hover{
	border:1px solid black;
	background: white;
	color: #303343;
}
</style>
<div id="content1-container1">
	<div id="title-container1">
		<h2 id="delete-h21">회원 정보 삭제</h2>
	</div>
	<hr id="h-line1" />
	<div id="ta-container1" >
		<span id="sub1-title1">비밀번호 입력</span><br />
		<span id="explain1">비밀번호를 입력하신후 확인을 누르시면 탈퇴가 됩니다.</span><br />
		<hr id="h1-line1"/>
		<br />
		<form action="<%=request.getContextPath()%>/member/memberDeleteEnd">
			<table id="p-table1">
				<tr id="p-cell1">
					<td id="pwdTitle1">아이디</td>
					<td id="pwdInput1" colspan="2"><input type="text" name="id1" value="<%=id%>" readonly/> </td>
				</tr>
				<tr id="p-cell1">
					<td id="pwdTitle3">비밀번호 확인</td>
					<td id="pwdInput3" colspan="2"><input type="password" name="password" /> </td>
				</tr>
			</table>
			<div id="su-btn1">
				<input id="del_member1" type="submit" value="탈퇴하기">
				<input type="button" id="back_index1" value="돌아가기" onclick="location.href='<%=request.getContextPath()%>/index.jsp';"/>
			</div>
		</form>
	</div>

</div>
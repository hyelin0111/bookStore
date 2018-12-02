<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/member/myPageMenu.jsp" %>
<style>
#content11-container11{
	width: 760px;
	padding: 15px;
	float: left;
	margin:5px;
}
#h-container11{
	float: left;
	margin-bottom:-10px;; 
}
#up_p1-container1{
	float :left;
	width:760px; 
	padding : 3px;
}
#p-table1, #p-cell1,#pwdTitle1,#pwdInput1{
	border-collapse: collapse;
	border-right: 1px dashed white;
	height:30px;
}

#pwdTitle1,#pwdTitle2,#pwdTitle3{
	width: 150px;
	border-right: 1px solid #b8bbc6;
	border-left: 1px solid white;
	background-color: #dde3ff;
	padding-left:8px;
	font-size:16px;
}
#pwdTitle1,#pwdTitle2,#pwdInput1,#pwdInput2{
	border-bottom:  1px solid #b8bbc6; 
}
#pwdInput1,#pwdInput2,#pwdInput3{
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
#pwd-description1{
	padding: 15px;
	float:left;
	border: 2px dashed #9faef9;
	width:95%;
	min-height:100px;
	border-radius: 30px;
	margin-bottom: 10px;
}
#desc-tip1{
	margin:auto;
	float: left;
}
#desc-tip21{
	float: left;
/* 	margin-top:2px; */

}
#tip1-img1{
	width:20px;
}
#pwd-description21{
	float: left;
	width:500px;
}
#donotpwd1{
	font-size:16px;
}
#donotpwd-desc1{
	font-size:14px;
}
#su-btn1{
	margin-top: 10px;
	float: right;
}
#upPwd_submit1{
	width:80px; 
	height:40px; 
	color:white; 
	background:#303343;
	border-radius: 10px;
	border:1px solid black;
	cursor:pointer;
	font-size: 15px;
}

</style>
<div id="content11-container11">
	<div id="h-container11">
		<h2>비밀번호 변경</h2>
	</div>
	<div id="up_p1-container1" >
			<div id="pwd-description1">
			<div id="desc-tip1">
				<img id="tip1-img1" src="<%=request.getContextPath() %>/images/icon.png" alt="icon" />&nbsp;
			</div>
			<div id="desc-tip21">
				<span id="tip1">TIP - 비밀번호 변경 관련 안내</span>
			</div>
			
			<div id="pwd-description21">
				<span id="donotpwd1">※ 비밀번호 사용이 불가한 경우는 아래와 같습니다.</span></br>
				<span id ="donotpwd-desc1">	
				&nbsp;&nbsp;1) 지금 사용하시는 비밀번호와 동일한 경우<br />
				&nbsp;&nbsp;2) 8자리 미만의 비밀번호일 경우<br />
				&nbsp;&nbsp;3) 15자리 초과의 비밀번호일 경우<br />
				&nbsp;&nbsp;4) 아이디와 같은 비밀번호의 경우<br />
				</span>			
			</div>
		</div>
	<form action="<%=request.getContextPath()%>/member/updatePasswordEnd?member_id=<%=memberLoggedIn.getMember_id()%>" method="get" >
		<input type="hidden" name="memId" value="<%=memberLoggedIn.getMember_id()%>" />
		<table id="p-table1">
			<tr id="p-cell1">
				<td id="pwdTitle1">현재 비밀번호</td>
				<td id="pwdInput1" colspan="2"><input type="password" name="password" id="original_password1"/> </td>
			</tr>
			<tr id="p-cell1">
				<td id="pwdTitle2">새 비밀번호</td>
				<td id="pwdInput2"><input type="password" name="pwd_n" id="up_password1"/> </td>
			</tr>
			<tr id="p-cell1">
				<td id="pwdTitle3">새 비밀번호 확인</td>
				<td id="pwdInput3" colspan="2"><input type="password" id="up_passwordC1"/> </td>
			</tr>
		</table>
		<div id="su-btn1">
			<input id="upPwd_submit1" type="submit" value="수정하기" />
		</div>
		</form>
	</div>
</div>
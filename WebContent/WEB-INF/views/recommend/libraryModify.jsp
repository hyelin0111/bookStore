<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ page import="java.util.*,
				 recommend.model.vo.Recommend" %>
				 
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>

 <%
	List<Recommend> recommendModify = (List<Recommend>)request.getAttribute("recommendModify");	

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
	/* margin-top: 50px; */
}
.book25{width: 430px; height: 230px;}
</style>

<h2 id="bAOVTitle5"> 지식인의 서재 지식인 추가/수정</h2>
<hr align="left"; style= "border: solid 2px black;" width: 30%; /> 

<table id="tbl-board">
<tr>
	<th>
		<img class="book25" src="WebContent/images/library/ss.jpg" alt="image" />
		<br />
		<input type="button" value="이미지 찾기" />
	</th>	
</tr>	
<tr>
	<th>
		<label for="userName">지식인 멘트 입력 : </label>
		<input type="text" id="userName" size="20" name="userName"> <br>
	</th>
</tr>
<tr>
	<th>
		<label for="userName">지식인 추천 도서 : </label>
		<input type="text" id="userName" size="20" name="userName" readonly> <br>
	</th>
</tr>
<tr>
	<th>
		지식인 설명:
    	<textarea name="board" id="board" cols="50" rows="10"></textarea>
	</th>
</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="수정하기" onclick="fn_updateBook();" class="btn_blue" />
			<input type="button" value="삭제하기" onclick="return fn_deleteBook();" class="btn_blue2"/>
		</th>
	</tr>
</table>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<style>
div#board-container{
	width:600px;
	margin:0 auto;
	text-align:center;
}
div#board-container h2{margin:10px 0;}
table#tbl-board{
	width:500px;
	margin:0 auto;
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

#searchOldBookDiv{
	position: absolute;
	right: 480px;
	width: 940px;
	height: 600px;
	border: 1px solid gray;
	background: white;
}
#bookList{
	margin: 0 auto;
	text-align: center;
}
#cancelDivBtn{
	float: right;
	margin-top: 5px;
	margin-right: 5px;
	width: 20px;
	height: 20px;
	border: 1px solid gray;
	font-weight: bold;
}
</style>
<script>
//유효성 검사
function fn_validate(){
	var imgCheck = $("#imgCheck").val();
	var priceCheck = $("#oldBookPrice").val();
	var bookCondition = $("#bookCondition").val();
	
	if( imgCheck != "true"){
		alert("책을 선택하세요");
		return false;
	}
	if( priceCheck == 0){
		alert("가격을 정해주세요");
		return false;
	}
	if( bookCondition == "" ){
		alert("책의 품질을 선택하세요");
		return false;
	}
	
	return true;
}

// 책검색
 $(document).ready(function(){
	$("#searchOldBookDiv").hide();	
}); 

function fn_movePage(pageNo){
	var searchKeyword = $("#searchContent").val();
	
	if( searchKeyword.trim().length != 0 ){
		$.ajax({
			data : {
						cPage : pageNo,
						searchKeyword : searchKeyword
					},
			url : "<%=request.getContextPath()%>/oldbook/selectBookSearchListServlet",
			type : "get",
			dataType : "html",
			success : function(data){
				$("#bookList").html(data);
			},
			error : function(){
				
			}
		});	
	}
	else{
		$.ajax({
			data : { cPage : pageNo },
			url : "<%=request.getContextPath()%>/oldbook/selectBookListServlet",
			type : "get",
			dataType : "html",
			success : function(data){
				$("#bookList").html(data);
			},
			error : function(){
				
			}
		});
	}
}

$(function(){
	$("#searchBtn").click(function(){
		var searchKeyword = $("#searchContent").val();
		
		console.log(searchKeyword);
		
		$.ajax({
			data : { searchKeyword : searchKeyword },
			url : "<%=request.getContextPath()%>/oldbook/selectBookSearchListServlet",
			type : "get",
			dataType : "html",
			success : function(data){
				$("#bookList").html(data);
			},
			error : function(){
				
			}
		});
	});
});

$(document).ready(function(){
	$.ajax({
		url : "<%=request.getContextPath()%>/oldbook/selectBookListServlet",
		type : "get",
		dataType : "html",
		success : function(data){
			$("#bookList").html(data);
		},
		error : function(){
			
		}
	});
});

$(function(){
	$("#searchBookBtn").click(function(){
		$("#searchOldBookDiv").css("display","block");
	});
});

$(function(){
	$("#cancelDivBtn").click(function(){
		$("#searchOldBookDiv").hide();
		$("#searchContent").val("");
		
		$.ajax({
			url : "<%=request.getContextPath()%>/oldbook/selectBookListServlet",
			type : "get",
			dataType : "html",
			success : function(data){
				$("#bookList").html(data);
			},
			error : function(){
				
			}
		});
	});
});
</script>
<div id="board-container">
	<h2>게시판 작성</h2>
	<form action="<%=request.getContextPath()%>/oldboard/writeOldBoardEnd" method="get" >
		<div id="searchOldBookDiv">
			<button type="button" id="cancelDivBtn">X</button>
			<h2>도서 검색</h2>
			도서명 : <input type="text" id="searchContent" value="" placeholder="검색할 도서를 입력하세요." />
			<button type="button" id="searchBtn">검색</button>			
			
			<br /><br /><br />
			
			<div id="bookList">
				
			</div>
		</div>
		<table id="tbl-board">
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="writer" value="<%=memberLoggedIn.getMember_name()%>" readonly/>
					<input type="hidden" name="memberNo" value="<%= memberLoggedIn.getMember_no() %>"/>
					
				</td>
			</tr>
			<tr>
				<th>등록할 도서</th>
				<td>
					<button type="button" id="searchBookBtn">검색</button>
				</td>
			</tr>	
			<tr>
				<th>도서 정보</th>
				<td>
					<img src="" id="insertOldBook" />
					<input type="hidden" id="oldBookNo" name="bookNo" />
					<input type="hidden" id="imgCheck" value="false" />
				</td>
			</tr>	
			<tr>
				<th>가격</th>
				<td>
					<input type="number" name="price" id="oldBookPrice" step="1000" min="0" placeholder="1000단위로 입력하세요"/>
				</td>
			</tr>	
			<tr>
				<th>품질</th>
				<td>
					<select name="condition" id="bookCondition">
						<option value="">보존 품질</option>
						<option value="상">상</option>
						<option value="중">중</option>
						<option value="하">하</option>
					</select>
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="등록하기" onclick="return fn_validate();" />
				</th>
			</tr>
		</table>
	</form>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
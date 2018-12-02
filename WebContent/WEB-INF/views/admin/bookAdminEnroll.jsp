<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="book.model.vo.Book,
				 review.model.vo.Review,
				 java.util.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp"%>    
 <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>

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
	margin-top: 50px;
}
.book25{width: 190px; height: 250px;}
</style>

<h2 id="bAOVTitle5">도서 추가</h2>
<form action="<%=request.getContextPath()%>/admin/bookAdminInsertEnd" onsubmit="return fn_bookChk()" method="POST" enctype="multipart/form-data">
<table id="tbl-board">
	<tr>
		<th>도서 제목</th>
		<td>
			<input type="text" name="bookTitle" value="" />
		</td>
	</tr>
	<tr>
		<th>이미지</th>
		<td>
		    <div>
		        <div class="img_wrap">
		            <img id="img" class="book25"/>
		        </div>
		    </div>
		   <div>
		        <input type="file" id="input_img" name="bookImg"/>
		    </div>
		</td>
	</tr>	
	<tr>
		<th>지음</th>
		<td>
			<input type="text" name="bookWriter" value="" />
		</td>
	</tr>	
	<tr>
		<th>장르</th>
		<td>
			<input type="text" name="bookCategory" value="" />
		</td>
	</tr>	
	<tr>
		<th>출판사</th>
		<td>
			<input type="text" name="bookPublisher" value="" />
		</td>
	</tr>	
	<tr>
		<th>가격</th>
		<td>
			<input type="number" name="bookPrice" value="" step="100"/>
		</td>
	</tr>	
	<tr>
		<th>출판일</th>
		<td>
			<input type="date" name="bookDate" value=""/>
		</td>
	</tr>	
	<tr>
		<th>페이지</th>
		<td>
			<input type="number" name="bookPage" value=""/>
		</td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="등록하기" class="btn_blue" />
		</th>
	</tr>
</table>
</form>
<script>
function fn_bookChk(){
	// 유효성검사
	return true;
}

var sel_file;

$(document).ready(function() {
    $("#input_img").on("change", handleImgFileSelect);
}); 

function handleImgFileSelect(e) {
    var files = e.target.files;
    var filesArr = Array.prototype.slice.call(files);

    filesArr.forEach(function(f) {
        if(!f.type.match("image.*")) {
            alert("확장자는 이미지 확장자만 가능합니다.");
            return;
        }

        sel_file = f;

        var reader = new FileReader();
        reader.onload = function(e) {
            $("#img").attr("src", e.target.result);
        }
        reader.readAsDataURL(f);
    });
}
</script>
     <style type="text/css">
        .img_wrap {
            width: 300px;
            margin-top: 50px;
        }
        .img_wrap img {
            max-width: 100%;
        }
 
    </style>
 
    <script type="text/javascript" src="./js/jquery-3.1.0.min.js" charset="utf-8"></script>
    <script type="text/javascript">
        
       
 
    </script>
</head>
 

 
 
 
 
 



<%@ include file="/WEB-INF/views/common/footer.jsp"%>
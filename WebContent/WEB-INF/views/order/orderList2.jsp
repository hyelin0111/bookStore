<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- datepicker 한국어로 -->
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />

<style>
* {
	font-family: "Malgun Gothic", "맑은 고딕", Dotum, "돋움", Arial, sans-serif;
}

ul.process_list>li>span {
	font-size: 15px;
	vertical-align: super;
}

ul.process_list {
	list-style-type: none;
	padding: 0;
	text-align: center;
}

ul.process_list>li {
	display: inline;
	padding-right: 10px;
}

img.arrow_img {
	padding-left: 8px;
	width: 20px;
} 

a#startDate, a#endDate {
	color: #555;
	text-decoration: none;
}

.clearfix {
	*zoom: 1;
}

.clearfix:after {
	content: "";
	display: block;
	clear: both;
	overflow: hidden;
}

/* Search */
.searchBox {
	border: none;
}

.searchBox tbody th {
	padding: 20px 10px 20px 35px;
	font-size: 14px;
	font-weight: bold;
	text-align: left;
	border: none;
	background: #e6e6e6;
}

.searchBox tbody td {
	padding: 12px 10px 12px 25px;
	border: none;
	background-color: #efefef;
}

.searchDate {
	overflow: hidden;
	margin-bottom: 10px;
	/* *zoom: 1; */
}

.searchDate:after {
	display: block;
	clear: both;
	content: '';
}

.searchDate li {
	position: relative;
	float: left;
	margin: 0 7px 0 0;
}

.searchDate li .chkbox2 {
	display: block;
	text-align: center;
}

.searchDate li .chkbox2 input {
	position: absolute;
	z-index: -1;
}

.searchDate li .chkbox2 label {
	display: block;
	width: 72px;
	height: 26px;
	font-size: 14px;
	font-weight: bold;
	color: #fff;
	text-align: center;
	line-height: 25px;
	text-decoration: none;
	cursor: pointer;
	background: #a5b0b6;
}

.searchDate li .chkbox2.on label {
	background: #899bdb;
}

.demi {
	display: inline-block;
	margin: 0 1px;
	vertical-align: middle;
	padding-right: 10px;
}

.inpType, #searchBookTitle {
	padding-left: 6px;
	height: 24px;
	line-height: 24px;
	border: 1px solid #dbdbdb;
}

#searchBookTitle {
	width: 345px;
}

.btncalendar {
	display: inline-block;
	width: 22px;
	height: 22px;
	background: url(images/calendar.png) center center no-repeat;
	text-indent: -999em;
}

table.searchBox {
	width: 100%;
	border-spacing: 0;
}

table.searchBox th {
	vertical-align: middle;
}

ul.searchDate {
	list-style: none;
	padding: 0;
	margin: 0;
	margin-bottom: 10px;
}

input[type=button].btn2 {
   margin: 5px;
   background: #899bdb;
   color: #fff;
   padding: 5px;
   width: 100px;
   height: 50px;
}

table#order_list th{
	background: #dee6fd;
	padding: 15px;
}

table#order_list td{
	padding: 10px;
}

table#order_list {
	border-spacing: 0;
	width: 800px;
	text-align: center;
	border: 1px solid #899bdb;
	float: left;
	margin-left: 10px;
}

div#searchContainer2 {
	margin-left: 10px;
	float: left;
	width: 800px;
}

div.order_tracking_section {
	float: left;
}
.pageBar5{ }
.pageBar5 span { margin: 0 5px; }

a.page_a {
	text-decoration: none;
	color: black;
}

a.page_a:hover, a.page_a:focus {
	font-weight: bold;
    text-decoration: underline;
    color: blue;
}
</style>
<div id="searchContainer2">
<h2>주문/배송 조회</h2>
<hr />
<div class="order_tracking_section">
	<ul class="process_list">
		<li><img src="<%=request.getContextPath()%>/images/contract.png" alt="" /><span> 주문접수</span><img class="arrow_img" src="<%=request.getContextPath()%>/images/arrow.png" alt="" /></li>
		<li><img src="<%=request.getContextPath()%>/images/card.png" alt="" /><span> 결제완료</span><img class="arrow_img" src="<%=request.getContextPath()%>/images/arrow.png" alt="" /></li>
		<li><img src="<%=request.getContextPath()%>/images/box.png" alt="" /><span> 상품준비</span><img class="arrow_img" src="<%=request.getContextPath()%>/images/arrow.png" alt="" /></li>
		<li><img src="<%=request.getContextPath()%>/images/gift.png" alt="" /><span> 출고작업</span><img class="arrow_img" src="<%=request.getContextPath()%>/images/arrow.png" alt="" /></li>
		<li><img src="<%=request.getContextPath()%>/images/truck.png" alt="" /><span> 배송중</span><img class="arrow_img" src="<%=request.getContextPath()%>/images/arrow.png" alt="" /></li>
		<li><img src="<%=request.getContextPath()%>/images/package.png" alt="" /><span> 배송완료</span></li>
	</ul>
</div>
<hr />

<script>
	$(document).ready(function() {

		//datepicker 한국어로 사용하기 위한 언어설정
		$.datepicker.setDefaults($.datepicker.regional['ko']);

		// Datepicker            
		$(".datepicker").datepicker({
			showButtonPanel : true,
			dateFormat : "yy-mm-dd",
			onClose : function(selectedDate) {

				var eleId = $(this).attr("id");
				var optionName = "";

				if (eleId.indexOf("StartDate") > 0) {
					eleId = eleId.replace("StartDate", "EndDate");
					optionName = "minDate";
				} else {
					eleId = eleId.replace("EndDate", "StartDate");
					optionName = "maxDate";
				}

				$("#" + eleId).datepicker("option", optionName, selectedDate);
				$(".searchDate").find(".chkbox2").removeClass("on");
			}
		});

		//시작일.
		/*$('#searchStartDate').datepicker("option","onClose", function( selectedDate ) {    
		    // 시작일 datepicker가 닫힐때
		    // 종료일의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
		    $("#searchEndDate").datepicker( "option", "minDate", selectedDate );
		    $(".searchDate").find(".chkbox2").removeClass("on");
		});
		 */

		//종료일.
		/*$('#searchEndDate').datepicker("option","onClose", function( selectedDate ) {    
		    // 종료일 datepicker가 닫힐때
		    // 시작일의 선택할수있는 최대 날짜(maxDate)를 선택한 종료일로 지정 
		    $("#searchStartDate").datepicker( "option", "maxDate", selectedDate );
		    $(".searchDate").find(".chkbox2").removeClass("on");
		});
		 */

		$(".dateclick").dateclick(); // DateClick
		$(".searchDate").schDate(); // searchDate

	});

	// Search Date
	jQuery.fn.schDate = function() {
		var $obj = $(this);
		var $chk = $obj.find("input[type=radio]");
		$chk.click(function() {
			$('input:not(:checked)').parent(".chkbox2").removeClass("on");
			$('input:checked').parent(".chkbox2").addClass("on");
		});
	};

	// DateClick
	jQuery.fn.dateclick = function() {
		var $obj = $(this);
		$obj.click(function() {
			$(this).parent().find("input").focus();
		});
	}

	function setSearchDate(start) {

		var num = start.substring(0, 1);
		var str = start.substring(1, 2);

		var today = new Date();

		//var year = today.getFullYear();
		//var month = today.getMonth() + 1;
		//var day = today.getDate();

		var endDate = $.datepicker.formatDate('yy-mm-dd', today);
		$('#searchEndDate').val(endDate);

		if (str == 'd') {
			today.setDate(today.getDate() - num);
		} else if (str == 'w') {
			today.setDate(today.getDate() - (num * 7));
		} else if (str == 'm') {
			today.setMonth(today.getMonth() - num);
			today.setDate(today.getDate() + 1);
		}

		var startDate = $.datepicker.formatDate('yy-mm-dd', today);
		$('#searchStartDate').val(startDate);

		// 종료일은 시작일 이전 날짜 선택하지 못하도록 비활성화
		$("#searchEndDate").datepicker("option", "minDate", startDate);

		// 시작일은 종료일 이후 날짜 선택하지 못하도록 비활성화
		$("#searchStartDate").datepicker("option", "maxDate", endDate);

	}
</script>
<br /><br />
	<form>
		<table class="searchBox">
	<!-- 		<caption>조회</caption> -->
			<colgroup>
				<col width="123px">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>조회기간</th>
					<td>
						<ul class="searchDate">
							<li>
								<span class="chkbox2"> 
								<input type="radio" name="dateType" id="dateType1" onclick="setSearchDate('0d')" />
								<label for="dateType1">당일</label>
								</span>
							</li>
							<li>
								<span class="chkbox2"> 
								<input type="radio" name="dateType" id="dateType3" onclick="setSearchDate('1w')" />
								<label for="dateType3">1주</label>
								</span>
							</li>
							<li>
								<span class="chkbox2"> 
								<input type="radio" name="dateType" id="dateType4" onclick="setSearchDate('2w')" />
								<label for="dateType4">2주</label>
								</span>
							</li>
							<li>
								<span class="chkbox2"> 
								<input type="radio" name="dateType" id="dateType5" onclick="setSearchDate('1m')" />
								<label for="dateType5">1개월</label>
								</span>
							</li>
							<li>
								<span class="chkbox2"> 
								<input type="radio" name="dateType" id="dateType6" onclick="setSearchDate('3m')" />
								<label for="dateType6">3개월</label>
								</span>
							</li>
							<li>
								<span class="chkbox2"> 
								<input type="radio" name="dateType" id="dateType7" onclick="setSearchDate('6m')" />
								<label for="dateType7">6개월</label>
								</span>
							</li>
						</ul>
	
						<div class="clearfix">
							<!-- 시작일 -->
							<span class="dset"> 
								<input type="text" class="datepicker inpType" name="searchStartDate" id="searchStartDate"> 
								<a id="startDate" href="#none" class="btncalendar dateclick">달력</a>
							</span> 
							<span class="demi">~</span>
							
							<!-- 종료일 -->
							<span class="dset"> 
								<input type="text" class="datepicker inpType" name="searchEndDate" id="searchEndDate"> 
								<a id="endDate" href="#none" class="btncalendar dateclick">달력</a>
							</span>
						</div>
					</td>
					<td rowspan="2"><input class="btn2" type="button" value="조회" id="search_btn"/></td>
				</tr>
				<tr>
					<th>상품조회</th>
					<td><input type="text" name="searchBookTitle" id="searchBookTitle"/></td>
				</tr>
			<tbody>
		</table>
	</form>
	<br /><br />
</div>
<div id="area1"></div>

<script>
$("#search_btn").click(function() {
	var memberNo = <%=memberLoggedIn.getMember_no()%>;
	var startDate = $("#searchStartDate").val();
	var endDate = $("#searchEndDate").val();
	var bookTitle = $("#searchBookTitle").val();
	
	var param = {
		memberNo:memberNo,
		startDate:startDate,
		endDate:endDate,
		bookTitle:bookTitle
	};
	
 	// 180519 페이지처리 김영중
	$.ajax({
		data : param,
		url : "<%=request.getContextPath()%>/order/orderListPageEnd",
		type : "get",
		dataType : "html",
		success : function(data){
			$("#area1").html(data);
		},
		error : function(jqxhr,textStatus,errorThrown){
           console.log("ajax에러");
           console.log(jqxhr);
           console.log(textStatus);
           console.log(errorThrown);
		}
	});	 
});

function fn_movePage5(pageNo){
	var memberNo = <%=memberLoggedIn.getMember_no()%>;
	var startDate = $("#searchStartDate").val();
	var endDate = $("#searchEndDate").val();
	var bookTitle = $("#searchBookTitle").val();
	
	var param = {
		memberNo:memberNo,
		startDate:startDate,
		endDate:endDate,
		bookTitle:bookTitle
	};
	
	/* if( searchKeyword.trim().length != 0 ){ */
		$.ajax({
			data : {
						cPage : pageNo,
						memberNo : memberNo,
						startDate : startDate,
						endDate : endDate,
						bookTitle : bookTitle
					},
			url : "<%=request.getContextPath()%>/order/orderListPageEnd",
			type : "get",
			dataType : "html",
			success : function(data){
				$("#area1").html(data);
			},
			error : function(){
				
			}
		});	
}

function fn_deleteOrder(orderNo){
	
	 var no = orderNo;
	 var param = {
			 no:no
	 }
	 if(confirm('삭제하시겠습니까')){ 
	$.ajax({
		url:"<%=request.getContextPath()%>/order/orderOneDeleteEnd",
		type:"get",
       data:param,
       dataType:"json",
       success:function(data){
       	$("#search_btn").trigger("click");
       	
       },error:function(jqxhr,textStatus,errorThrown){            
           console.log("ajax에러");
           console.log(jqxhr);
           console.log(textStatus);
           console.log(errorThrown);
        }
	});
	}
}
</script>
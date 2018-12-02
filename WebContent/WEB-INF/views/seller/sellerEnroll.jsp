<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<style>
  
.d-ta3 th,td{
	border: 1px solid black;
}
.d-ta3{ 
	border-collapse:collapse; 
	font-size:12pt; 
	border:1px solid black;
	margin:auto;
	width:760px;
}  
.d-ta31{
	border-collapse:collapse; 
	font-size:12pt; 
	border:1px solid black;
	margin:auto;
	width:760px;
}
.btn_area1{
	width: 230px;
	margin: auto;
	margin-top:10px;
}
#sel-submit1{
	width:100px; 
	height:50px; 
	color:white; 
	background:#303343;
	border-radius: 15px;
	border:1px solid black;
	cursor:pointer;
	font-size: 15px;
}
#sel-cancel1{
	width:100px; 
	height:50px;
	color:white; 
	background:#303343;
	border-radius: 15px;
	border:1px solid black;
	cursor:pointer;
	font-size: 15px;
	margin-left:20px
}
#sel-submit1:hover{
	border:1px solid black;
	background: white;
	color: #303343;
}
#sel-cancel1:hover{
	border:1px solid black;
	background: white;
	color: #303343;
}
#line3{
	border: 1px dashed #696a70;
}
.seller-nickname1{
	margin-top:0px;
	font-size: 12px;
}
#title3{
	background-color : #303343;
	color:white;
	padding-left: 15px; 
}
#t-content3{
	padding-left: 15px;
}
.btn2{
	width:110px; 
	height:25px;
	color:white; 
	background:#303343;
	border-radius: 5px;
	border:1px solid black;
	cursor:pointer;
	font-size: 15px;
	text-align: center;
	
}
#sellernick1{
	margin-top:15px;
}
</style> 

<h2 id= "th2_1">기본정보</h2>
<form action="<%=request.getContextPath() %>/seller/sellerEnrollEnd?member_no=<%=memberLoggedIn.getMember_no() %>" method="post" name="frm1" > 
<table class="d-ta31">
 	<tr height="60">
 		<td id="title3" >아이디</td>
		<td id="t-content3">  
	  		<input type="text" name="selId1" size="2" id="selId" value="<%=memberLoggedIn.getMember_id() %>" readonly/>
	 	</td>
	 	<td id="title3">회원명</td>
	 	<td id="t-content3">
	  		<input type="text" name="selName" size="4" id="selName" value="<%=memberLoggedIn.getMember_name() %>" readonly/>
	 	</td>
 	</tr>
 	<tr height="50">
 		<td id="title3">판매자 닉네임</td>
		<td id="t-content3">
			<input type="text" name="sellernick1" id="sellernick1" placeholder="닉네임을 입력하세요."/>
			<p class="seller-nickname1">한글, 영문, 숫자 10자 이내</p>
		</td>
		<td id="title3">휴대폰 번호</td>
		<td id="t-content3"><input type="tel" name="sel-phone1" id="sel-phone1" value="<%=memberLoggedIn.getMember_phone()%>"/></td>
 	</tr>
 	<tr height="50">
 		<td id="title3">이메일</td>
		<td colspan="3" id="t-content3">
			<input type="email" name="sel-email1" id="sel-email1" value="<%=memberLoggedIn.getMember_email()%>" />
		</td>
 	</tr>
</table>
<br>
<hr id="line3" />
<h2 class="h2_3">배송정보</h2>
<table class="d-ta3">
 	<tr height="60">
 		<td id="title3">배송방법</td>
		<td width="600" id="t-content3">  
	  		<input type="radio" name="pdel1" id="" value ="P"checked/><span>개인택배 이용 </span> <br />
	  		<input type="radio" name="" id="" disabled/><span>영중문고 계약택배 이용(현재 이용불가..)</span>
	 	</td>
 	</tr>
 	<tr height="50">
 		<td id="title3">계좌번호</td>
		<td id="t-content3">
			<select name ="bank1">
			  <option value="국민은행" selected>국민은행</option>
			  <option value="우리은행">우리은행</option>
			  <option value="신한은행">신한은행</option>
			  <option value="하나은행">하나은행</option>
			  <option value="기업은행">기업은행</option>
			  <option value="농협">농협</option>
			</select>
			<input type="text" name="sel-account1" id="sel-account1" />
		</td>
 	</tr>
 	<tr height="50">
 		<td id="title3">배송비</td>
		<td id="t-content3">
			<input type="number" name="del-price1" id="del-price1" value="0" placeholder="2500" max="9999"/>원
		</td>
 	</tr>
 	<tr height="50">
 		<td id="title3">도서지역 배송비</td>
		<td id="t-content3">
			<input type="number" name="del-iprice1" id="del-iprice1" value="0"/>원
		</td>
 	</tr>
	<tr height="40">
		<td id="title3">
			배송출고지
		<td id="t-content3">
			<input type="text" name="postnum" id="sample4_postcode" placeholder="우편번호"> 
            <input type="button" class="btn2" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
        	<input type="text" name="address1" id="sample4_roadAddress" placeholder="도로명주소" size="35px"> <br /> 
            <input type="text" name="address2" id="sample4_jibunAddress" placeholder="지번주소" size="35px">
            <span id="guide" style="color: #999"></span>
		</td>
	</tr>
</table>
<div class="btn_area1">
	<input id="sel-submit1" type="submit" value="가입" />
	<input id="sel-cancel1" type="button" value="취소"/>
</div>
</form>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script charset="UTF-8" type="text/javascript"
   src="http://t1.daumcdn.net/cssjs/postcode/1522037570977/180326.js"></script>
<script>
   //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
   function sample4_execDaumPostcode() {
      new daum.Postcode(
            {
               oncomplete : function(data) {
                  // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                  // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                  // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                  var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                  var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                  // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                  // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                  if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                     extraRoadAddr += data.bname;
                  }
                  // 건물명이 있고, 공동주택일 경우 추가한다.
                  if (data.buildingName !== '' && data.apartment === 'Y') {
                     extraRoadAddr += (extraRoadAddr !== '' ? ', '
                           + data.buildingName : data.buildingName);
                  }
                  // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                  if (extraRoadAddr !== '') {
                     extraRoadAddr = ' (' + extraRoadAddr + ')';
                  }
                  // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                  if (fullRoadAddr !== '') {
                     fullRoadAddr += extraRoadAddr;
                  }

                  // 우편번호와 주소 정보를 해당 필드에 넣는다.
                  document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                  document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                  document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                  // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                  if (data.autoRoadAddress) {
                     //예상되는 도로명 주소에 조합형 주소를 추가한다.
                     var expRoadAddr = data.autoRoadAddress
                           + extraRoadAddr;
                     document.getElementById('guide').innerHTML = '(예상 도로명 주소 : '
                           + expRoadAddr + ')';

                  } else if (data.autoJibunAddress) {
                     var expJibunAddr = data.autoJibunAddress;
                     document.getElementById('guide').innerHTML = '(예상 지번 주소 : '
                           + expJibunAddr + ')';

                  } else {
                     document.getElementById('guide').innerHTML = '';
                  }
               }
            }).open();
   }
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
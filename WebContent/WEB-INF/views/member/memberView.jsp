<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/member/myPageMenu.jsp" %>
<%@ page import="member.model.vo.*,java.sql.Date,  java.text.DateFormat,java.text.SimpleDateFormat" %>
<%
	Member member = (Member)request.getAttribute("member");
	int memNo = member.getMember_no();
    String phone = member.getMember_phone();
    String phone1 = phone.substring(0,3);
    String phone2 = phone.substring(3,7);
    String phone3= phone.substring(7,11);
	String birth = member.getMember_birthday();
    String email = member.getMember_email()!=null?member.getMember_email():"";
    
    String[] interested = null;
    String[] interCheck = new String[39];
    if(member.getMember_interested() !=null){
    	interested = member.getMember_interested().split(",");
		
    	for(int i=0; i<interested.length; i++){
    		switch(interested[i]){
    		case "20세기 한국소설":interCheck[0] = "checked";break;
    		case "경제":interCheck[1] = "checked";break;
    		case "과학":interCheck[2] = "checked";break;
    		case "과학·교양":interCheck[3] = "checked";break;
    		case "과학·환경":interCheck[4] = "checked";break;
    		case "교양":interCheck[5] = "checked";break;
    		case "그림책":interCheck[6] = "checked";break;
    		case "동시·동요":interCheck[7] = "checked";break;
    		case "문학":interCheck[8] = "checked";break;
    		case "문학비평":interCheck[9] = "checked";break;
    		case "문학이론":interCheck[10] = "checked";break;
    		case "산문":interCheck[11] = "checked";break;
    		case "선집·전집":interCheck[12] = "checked";break;
    		case "선집·전집·전작":interCheck[13] = "checked";break;
    		case "세계명작":interCheck[14] = "checked";break;
    		case "소설집":interCheck[15] = "checked";break;
    		case "신나는 책 읽기":interCheck[16] = "checked";break;
    		case "안과밖":interCheck[17] = "checked";break;
    		case "어린이 문집":interCheck[18] = "checked";break;
    		case "여성":interCheck[19] = "checked";break;
    		case "여성과 사회":interCheck[20] = "checked";break;
    		case "역사":interCheck[21] = "checked";break;
    		case "역사 이야기":interCheck[22] = "checked";break;
    		case "옛날 이야기":interCheck[23] = "checked";break;
    		case "외국 소설":interCheck[24] = "checked";break;
    		case "외국 시":interCheck[25] = "checked";break;
    		case "이 세상 첫 이야기":interCheck[26] = "checked";break;
    		case "인문":interCheck[27] = "checked";break;
    		case "인물 이야기":interCheck[28] = "checked";break;
    		case "인물·평전":interCheck[29] = "checked";break;
    		case "장편소설":interCheck[30] = "checked";break;
    		case "정치·사회":interCheck[31] = "checked";break;
    		case "창비시선":interCheck[32] = "checked";break;
    		case "창비어린이":interCheck[33] = "checked";break;
    		case "창작과비평":interCheck[34] = "checked";break;
    		case "창작동화":interCheck[35] = "checked";break;
    		case "철학":interCheck[36] = "checked";break;
    		case "환경":interCheck[37] = "checked";break;
    		case "기타":interCheck[38] = "checked";break;
    		}
    	}
    }
%>

<style>
#s3 {font-size:8pt}
#table-container1{
float: left;
width: 760px;
padding-left: 15px;
}
.ta3{ 
	border-collapse:collapse; 
	font-size:9pt; 
	border:1px solid black;
}  
.ta3 th, .ta3 td { border:1px solid black; }
.ta3 td{ padding-left: 10px; }

.h2_3 {
    height: 30px;
    margin-bottom: 10px;
    padding: 2px 0 10px;
    font-size: 25px;
    color: #333333;
    font-weight: bold;
}
#line3{
	border :1px dashed black; 
	margin-bottom: 35px;
}
#cap3{text-align: left;}
#essential3{
 color: red;
}
#title3{
	width:100px;
	text-align: right; 
	padding-right: 10px;
	font-size: 14px;
	color: lightgray;
	background-color: #333333;
}
#details3{
	font-size: 11px;
}

#h-container1{
	float: left;
	width: 770px;
	padding-left:5px;
}
.member_update1{
	margin-left: 10px;
}
.btn-area1{
	margin-top:10px;
	width: 200px;
	float: right;
	margin-right: 50px;
}
#btn-update1{
	width:80px; 
	height:40px; 
	color:white; 
	background:#303343;
	top:4px;
	right:10px;
	border-radius: 10px;
	border:1px solid black;
	cursor:pointer;
	font-size: 15px;
	margin-right:15px;
}
#btn-update1:hover{
	border:1px solid black;
	background: white;
	color: #303343;
}
#btn-cancel1{
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
#btn-cancel1:hover{
	border:1px solid black;
	background: white;
	color: #303343;
}
/* #memNo1{
display: none;
} */

</style>

<script>
function memChk(){ // 데이터 입력유무 확인 스크립트
	var memId = $("#memId3").val().trim();
	if(memId.length == 0){
   		alert("아이디를 입력하세요");
   		return;
  	}
	if(memId.length< 4){
		alert("아이디는 4글자 이상이여야 합니다.");
		return;
	}
	return true;

} 
</script>
<div id="h-container1">
	<h2 class="member_update1">회원 정보 수정</h2>
	<hr id="line3" />
</div>
<br />

<form action="#"id="memFrm" method="post" name="memFrm"  onsubmit="return fn_update_validate()"> 
<div id="table-container1">
		<input type="hidden" name="memNo"   value = "<%=memNo%>"/>	
	<table class="ta3">
 	<tr height="60">
 		<td id="title3" >
 			 아&nbsp;이&nbsp;디&nbsp;
  	    </td>
		<td width="600">  
			<input type="text" name="memId" id="memId3" size="16" value="<%= memberLoggedIn.getMember_id() %>" readonly>
			
	 	</td>
 	</tr>

 	<tr height="40">
  		<td id="title3">
			 이&nbsp;&nbsp;&nbsp;&nbsp;름
 		</td>
		<td>
			<span name="memName"><%= member.getMember_name() %></span>
		</td>
	</tr>
		<tr height="40">
		<td id="title3">
			 성&nbsp;&nbsp;&nbsp;&nbsp;별
		</td>
		<td>
		<%if("M".equals(member.getMember_gender())){  %>
			<input type="radio" name="gender" id="genderM" value="M" checked>
			<label for="genderM">남자</label>&nbsp;
			<input type="radio" name="gender" id="genderF"value="F">
			<label for="genderF">여자</label>
		<%}else{ %>
			<input type="radio" name="gender" id="genderM" value="M" >
			<label for="genderM">남자</label>&nbsp;
			<input type="radio" name="gender" id="genderF"value="F" checked>
			<label for="genderF">여자</label>
		<%} %>
		</td>
	</tr> 
	<tr height="40">
		<td id="title3">생년월일
		</td>
		<td>
		<span name="memBirth">
			<%= birth %>
		</span>
		</td>
	</tr> 
	<tr height="40">
		<td id="title3">E - mail</td>
		<td>
			<input type="email" name="memEmail" size="28" value="<%= email %>">
		</td>
	</tr>
	<tr height="40">
		<td id="title3"> 휴 대 폰</td>
		<td>
			<input type="text" name="memMobile01" size="1" maxlength="3" value="<%= phone1 %>">
			 - 
			<input type="text" name="memMobile02" size="2" maxlength="4" value="<%= phone2 %>">
			 -
			<input type="text" name="memMobile03" size="2" maxlength="4" value="<%= phone3 %>"> 
		</td>
	</tr>
<tr height="40">
  <td id="title3"> 관심 책 분야</td>
  <td>
	  	  <input type="checkbox" name="memHobby" id="inter1" value="20세기 한국 소설" <%=interCheck[0] %>>
		  <label for="inter1">20세기 한국소설</label>&nbsp;
		  <input type="checkbox" name="memHobby" id="inter2" value="경제" <%=interCheck[1] %>>
		  <label for="inter2">경제</label>&nbsp;
		  <input type="checkbox" name="memHobby" id="inter3" value="과학" <%=interCheck[2] %>>
		  <label for="inter3">과학</label>&nbsp;
		  <input type="checkbox" name="memHobby" id="inter4" value="과학·교양" <%=interCheck[3] %>>
		  <label for="inter4">과학·교양</label>&nbsp;
		  <input type="checkbox" name="memHobby" id="inter5" value="과학·환경" <%=interCheck[4] %>>
		  <label for="inter5">과학·환경</label>
		  <input type="checkbox" name="memHobby" id="inter6" value="교양" <%=interCheck[5] %>>
		  <label for="inter6">교양</label>
		  <input type="checkbox" name="memHobby" id="inter7" value="그림책" <%=interCheck[6] %>>
		  <label for="inter7">그림책</label>
		  <br />
		  <input type="checkbox" name="memHobby" id="inter8" value="동시·동요" <%=interCheck[7] %>>
		  <label for="inter8">동시·동요</label>
		  <input type="checkbox" name="memHobby" id="inter9" value="문학" <%=interCheck[8] %>>
		  <label for="inter9">문학</label>
		  <input type="checkbox" name="memHobby" id="inter10"value="문학비평" <%=interCheck[9] %>>
		  <label for="inter10">문학비평</label>
		  <input type="checkbox" name="memHobby" id="inter11"value="문학이론" <%=interCheck[10] %>>
		  <label for="inter11">문학이론</label>
		  <input type="checkbox" name="memHobby" id="inter12"value="산문" <%=interCheck[11] %>>
		  <label for="inter12">산문</label>
		  <input type="checkbox" name="memHobby" id="inter13"value="선집·전집" <%=interCheck[12] %>>
		  <label for="inter13">선집·전집</label>
		  <br />
		  <input type="checkbox" name="memHobby" id="inter14"value="선집·전집·전작" <%=interCheck[13] %>>
		  <label for="inter14">선집·전집·전작</label>
		  <input type="checkbox" name="memHobby" id="inter15"value="세계명작" <%=interCheck[14] %>>
		  <label for="inter15">세계명작</label>
		  <input type="checkbox" name="memHobby" id="inter16"value="소설집" <%=interCheck[15] %>>
		  <label for="inter16">소설집</label>
		  <input type="checkbox" name="memHobby" id="inter17"value="신나는 책 읽기" <%=interCheck[16] %>>
		  <label for="inter17">신나는 책 읽기</label>
		  <input type="checkbox" name="memHobby" id="inter18"value="안과밖" <%=interCheck[17] %>>
		  <label for="inter18">안과밖</label>
		  <input type="checkbox" name="memHobby" id="inter19"value="어린이 문집" <%=interCheck[18] %>>
		  <label for="inter19">어린이 문집</label>
		  <br />
		  <input type="checkbox" name="memHobby" id="inter20"value="여성" <%=interCheck[19] %>>
		  <label for="inter20">여성</label>
		  <input type="checkbox" name="memHobby" id="inter21"value="여성과사회" <%=interCheck[20] %>>
		  <label for="inter21">여성과사회</label>
		  <input type="checkbox" name="memHobby" id="inter22"value="역사" <%=interCheck[21] %>>
		  <label for="inter22">역사</label>
		  <input type="checkbox" name="memHobby" id="inter23"value="역사 이야기" <%=interCheck[22] %>>
		  <label for="inter23">역사 이야기</label>
		  <input type="checkbox" name="memHobby" id="inter24"value="옛날 이야기" <%=interCheck[23] %>>
		  <label for="inter24">옛날 이야기</label>
		  <input type="checkbox" name="memHobby" id="inter25"value="외국 소설" <%=interCheck[24] %>>
		  <label for="inter25">외국 소설</label>
		  <input type="checkbox" name="memHobby" id="inter26"value="외국 시" <%=interCheck[25] %>>
		  <label for="inter26">외국 시</label>
		  <br />
		  <input type="checkbox" name="memHobby" id="inter27"value="이 세상 첫 이야기" <%=interCheck[26] %>>
		  <label for="inter27">이 세상 첫 이야기</label>
		  <input type="checkbox" name="memHobby" id="inter28"value="인문" <%=interCheck[27] %>>
		  <label for="inter28">인문</label>
		  <input type="checkbox" name="memHobby" id="inter29"value="인물 이야기" <%=interCheck[28] %>>
		  <label for="inter29">인물 이야기</label>
		  <input type="checkbox" name="memHobby" id="inter30"value="인물·평전" <%=interCheck[29] %>>
		  <label for="inter30">인물·평전</label>
		  <input type="checkbox" name="memHobby" id="inter31"value="장편소설" <%=interCheck[30] %>>
		  <label for="inter31">장편소설</label>
		  <input type="checkbox" name="memHobby" id="inter32"value="정치·사회" <%=interCheck[31] %>>
		  <label for="inter32">정치·사회</label>
		  <input type="checkbox" name="memHobby" id="inter33"value="창비시선" <%=interCheck[32] %>>
		  <label for="inter33">창비시선</label>
		  <br />
		  <input type="checkbox" name="memHobby" id="inter34"value="창비어린이" <%=interCheck[33] %>>
		  <label for="inter34">창비어린이</label>
		  <input type="checkbox" name="memHobby" id="inter35"value="창작과비평" <%=interCheck[34] %>>
		  <label for="inter35">창작과비평</label>
		  <input type="checkbox" name="memHobby" id="inter36"value="창작동화" <%=interCheck[35] %>>
		  <label for="inter36">창작동화</label>
		  <input type="checkbox" name="memHobby" id="inter37"value="철학" <%=interCheck[36] %>>
		  <label for="inter37">철학</label>
		  <input type="checkbox" name="memHobby" id="inter38"value="환경" <%=interCheck[37] %>>
		  <label for="inter38">환경</label>
		  <input type="checkbox" name="memHobby" id="inter39"value="기타" <%=interCheck[38] %>>
		  <label for="inter39">기타</label>
	</tr>
</table>
	</div>
	<div class="btn-area1">
		 <input type="button" id="btn-update1" onclick="fn_update_member();" value="정보수정"/>
		<input type="button" id="btn-cancel1" onclick="location.href='<%=request.getContextPath()%>/index.jsp';" value="취소"/>
	</div>
</form>
<script>
function fn_update_validate(){
	
	return true;
}
function fn_update_member(){
	var frm = $("#memFrm");
	var url = "<%=request.getContextPath() %>/member/memberUpdate";
	frm.attr('action',url);
	//console.log($("#memberFrm").attr('action'));
	frm.submit();
	
}

</script>
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
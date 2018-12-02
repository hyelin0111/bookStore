<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<style>
#s3 {font-size:8pt}

.ta3{ 
   border-collapse:collapse; 
   font-size:9pt; 
   border:1px solid black;
   margin:auto;
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
   background-color: #303343;
}
#details3{
   font-size: 11px;
}
#btn-area1{
   margin: auto;
   margin-top : 10px;
   width: 200px;
   
}

#sub-btn1{
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
#sub-btn1:hover{
   border:1px solid black;
   background: white;
   color: #303343;
}
#cans-btn1{
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
#cans-btn1:hover{
   border:1px solid black;
   background: white;
   color: #303343;
}
#memId_chk3{
   width:100px; 
   height:20px; 
   color:white; 
   background:#303343;
   top:4px;
   right:10px;
   border-radius: 5px;
   border:1px solid black;
   cursor:pointer;
   font-size: 15px;
   margin-right:15px;
   vertical-align: middle;
   text-align: center;
}
#memId_chk3:hover{
   border:1px solid black;
   background: white;
   color: #303343;
}
.btn2{
   width:110px; 
   height:20px; 
   color:white; 
   background:#303343;
   top:4px;
   right:10px;
   border-radius: 5px;
   border:1px solid black;
   cursor:pointer;
   font-size: 15px;
   margin-right:15px;
   vertical-align: middle;
   text-align: center;
   margin-bottom: 2px;
   padding-bottom: 2px;
}
.btn2:hover{
   border:1px solid black;
   background: white;
   color: #303343;   
}

</style>
<script>
function checkId(){
   var memId = $("#memId3").val().trim();
   if(memId.length<4){
      alert('아이디는 4글자이상 가능합니다.');
      return;
   }
   
   var url = "<%=request.getContextPath()%>/member/checkId";
   var title = "checkId";
   var status = "left=350px, top=100px, width=300px, height=200px";
   var popup = window.open("",title,status);
   
   var checkIdFrm = document.checkIdFrm;
   checkIdFrm.memId.value = memId;
   
   checkIdFrm.target = title;
   checkIdFrm.action = url;
   checkIdFrm.submit();
}
 </script>

<script>
function memChk(){ // 데이터 입력유무 확인 스크립트
   var memId = $("#memId3").val().trim();
   if(memId.length == 0){
         alert("아이디를 입력하세요");
         return false;
     }
   if(memId.length< 4){
      alert("아이디는 4글자 이상이여야 합니다.");
      return false;
   }
  
 /*  if(document.frm.memPwd.value == ""){
   alert("비밀번호를 입력하세요")
   document.frm.memPwd.focus();
   return false;
  }
  if(document.frm.memPwdChk.value == ""){
   alert("비밀번호를 다시한번 입력해주세요")
   document.frm.memPwdChk.focus();
   return false;
  }
  if(document.frm.memPwd.value != frm.memPwdChk.value){
   alert("비밀번호가 다릅니다.");
   document.frm.memPwd.value = ""; 
   document.frm.memPwdChk.value = ""; 
   document.frm.memPwd.focus(); 
   return false;
  }
  if(document.frm.memName.value == "")
  {
   alert("이름이 없는건가..") 
   document.frm.memName.focus(); 
   return false;
  }
  if(document.frm.memBirth01.value == "" || frm.memBirth02.value == "" || frm.memBirth03.value == "")
  {
   alert("생년월일을 입력하세요.") 
   document.frm.memBirth01.focus(); 
   return false;
  }
  if(document.frm.memEmail.value == "")
  {
   alert("이메일을 입력하세요") 
   document.frm.memEmail.focus(); 
   return false;
  }
  // 메일 수신은 수신동의 selected
  if(document.frm.memZipCode01.value == "" || frm.memZipCode02.value == "")
  {
   alert("우편번호를 입력하세요") 
   document.frm.memZipCode01.focus(); 
   return false;
  }
  if(document.frm.memAddr1.value == "")
  {
   alert("주소를 입력하세요")
   document.frm.memAddr1.focus();
   return false;
  }
  if(document.frm.memAddr2.value == "")
  {
   alert("상세 주소를 입력하세요")
   document.frm.memAddr2.focus();
   return false;
  }
  if (document.frm.memTel01.value == "")
  {
   alert("전화번호를 선택하세요")
   return false;
  }
  if (document.frm.memTel02.value == "")
  {
   alert("전화번호를 입력하세요")
   document.frm.memTel02.focus();
   return false;
  }
  if (document.frm.memTel03.value == "")
  {
   alert("전화번호를 입력하세요")
   document.frm.memTel03.focus();
   return false;
  }
  if (document.frm.memMobile01.value == "Not")
  {
   alert("핸드폰번호를 선택하세요")
   return false;
  }
  if (document.frm.memMobile02.value == "")
  {
   alert("핸드폰번호를 입력하세요")
   document.frm.memMobile02.focus();
   return false;
  }
  if (document.frm.memMobile03.value == "")
  {
   alert("핸드폰번호를 입력하세요")
   document.frm.memMobile03.focus();
   return false;
  } */
  return true;
  /* document.frm.submit(); // 버튼으로 쓸 땐 return true; 대신 이걸 쓰고 form시작 구문에 onsubmit="return memChk()" 는 불필요하여 삭제 */

 } 
 </script>
<h2 class="h2_3">Join With Us</h2>
<hr id="line3" />
<form action="<%=request.getContextPath() %>/member/memberEnrollEnd" method="post" name="frm"  onsubmit="return memChk()"> 
   <table class="ta3">
   <caption id="cap3">
      <span id = "essential3">*</span><span id = "s3"> 항목은 필수 입력항목입니다.</span>
   </caption>
    <tr height="60">
       <td id="title3" >
          <span id = "essential3">*</span> 아&nbsp;이&nbsp;디&nbsp;
         </td>
      <td width="600">  
           <input type="text" name="memId" id="memId3" size="16">&nbsp;&nbsp;
            <input type="button" id="memId_chk3" value="ID중복검사" onClick="checkId()"><br> 
            <input type="hidden" name="idValid" value="0" /> 
            <span id = "details3">아이디는 영소문자,숫자 조합으로 하셔야 합니다.[4자리이상 12자리이하]</span><br>
       </td>
    </tr>
    <tr height="50">
       <td id="title3">
          <span id = "essential3">*</span> 암&nbsp;&nbsp;&nbsp;&nbsp;호
       </td>
     <td>
        <input type="password" name="memPwd" id= "memPwd3" size="16" required><br>
        <span id = "details3">비밀번호는 4자리이상 12자리이하로 입력해주세요.</span>
     </td>
    </tr>
   <tr height="40">
      <td id="title3">
         <span id = "essential3">*</span> 암호확인
      </td>
       <td>
            <input type="password" name="memPwdChk" id="memPwdChk" size="16">
       </td>
    </tr> 
    <tr height="40">
        <td id="title3">
           <span id = "essential3">*</span> 이&nbsp;&nbsp;&nbsp;&nbsp;름
       </td>
      <td>
         <input type="text" name="memName" size="16" maxlength="28" required>
      </td>
   </tr>
      <tr height="40">
      <td id="title3">
      <span id = "essential3">*</span> 성&nbsp;&nbsp;&nbsp;&nbsp;별
      </td>
      <td>
         <input type="radio" name="gender" value="M">남자&nbsp;
         <input type="radio" name="gender" value="F">여자
      </td>
   </tr>
   <tr height="40">
      <td id="title3">생년월일
      </td>
      <td>
         <input type="text" name="memBirth" size="12" maxlength="10"placeholder="ex)19960304" required>
      </td>
   </tr> 
   <tr height="40">
      <td id="title3">E - mail</td>
      <td>
         <input type="email" name="memEmail" size="28" required>
      </td>
   </tr>
   <tr height="40">
      <td id="title3">
      <span id = "essential3">*</span> 주&nbsp;&nbsp;&nbsp;&nbsp;소</td>
      <td>
         <input type="text" name="postnum" id="sample4_postcode" placeholder="우편번호" required> 
            <input type="button" class="btn2" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
            <input type="text" name="address1" id="sample4_roadAddress" placeholder="도로명주소" size="35px" required> <br /> 
            <input type="text" name="address2" id="sample4_jibunAddress" placeholder="지번주소" size="35px" required>
            <span id="guide" style="color: #999"></span>
      </td>
   </tr>
   <tr height="40">
      <td id="title3"> 휴 대 폰</td>
      <td>
         <input type="text" name="memMobile01" size="1" maxlength="3" required>
          - 
         <input type="text" name="memMobile02" size="2" maxlength="4" required>
          -
         <input type="text" name="memMobile03" size="2" maxlength="4" required> 
      </td> 
   </tr>
<tr height="40">
  <td id="title3"> 관심 책 분야</td>
  <td>
     <input type="checkbox" name="memHobby" id="inter1" value="20세기 한국 소설">
     <label for="inter1">20세기 한국소설</label>&nbsp;
     <input type="checkbox" name="memHobby" id="inter2" value="경제">
     <label for="inter2">경제</label>&nbsp;
     <input type="checkbox" name="memHobby" id="inter3" value="과학">
     <label for="inter3">과학</label>&nbsp;
     <input type="checkbox" name="memHobby" id="inter4" value="과학·교양">
     <label for="inter4">과학·교양</label>&nbsp;
     <input type="checkbox" name="memHobby" id="inter5" value="과학·환경">
     <label for="inter5">과학·환경</label>
     <input type="checkbox" name="memHobby" id="inter6" value="교양">
     <label for="inter6">교양</label>
     <input type="checkbox" name="memHobby" id="inter7" value="그림책">
     <label for="inter7">그림책</label>
     <br />
     <input type="checkbox" name="memHobby" id="inter8" value="동시·동요">
     <label for="inter8">동시·동요</label>
     <input type="checkbox" name="memHobby" id="inter9" value="문학">
     <label for="inter9">문학</label>
     <input type="checkbox" name="memHobby" id="inter10"value="문학비평">
     <label for="inter10">문학비평</label>
     <input type="checkbox" name="memHobby" id="inter11"value="문학이론">
     <label for="inter11">문학이론</label>
     <input type="checkbox" name="memHobby" id="inter12"value="산문">
     <label for="inter12">산문</label>
     <input type="checkbox" name="memHobby" id="inter13"value="선집·전집">
     <label for="inter13">선집·전집</label>
     <br />
     <input type="checkbox" name="memHobby" id="inter14"value="선집·전집·전작">
     <label for="inter14">선집·전집·전작</label>
     <input type="checkbox" name="memHobby" id="inter15"value="세계명작">
     <label for="inter15">세계명작</label>
     <input type="checkbox" name="memHobby" id="inter16"value="소설집">
     <label for="inter16">소설집</label>
     <input type="checkbox" name="memHobby" id="inter17"value="신나는 책 읽기">
     <label for="inter17">신나는 책 읽기</label>
     <input type="checkbox" name="memHobby" id="inter18"value="안과밖">
     <label for="inter18">안과밖</label>
     <input type="checkbox" name="memHobby" id="inter19"value="어린이 문집">
     <label for="inter19">어린이 문집</label>
     <br />
     <input type="checkbox" name="memHobby" id="inter20"value="여성">
     <label for="inter20">여성</label>
     <input type="checkbox" name="memHobby" id="inter21"value="여성과사회">
     <label for="inter21">여성과사회</label>
     <input type="checkbox" name="memHobby" id="inter22"value="역사">
     <label for="inter22">역사</label>
     <input type="checkbox" name="memHobby" id="inter23"value="역사 이야기">
     <label for="inter23">역사 이야기</label>
     <input type="checkbox" name="memHobby" id="inter24"value="옛날 이야기">
     <label for="inter24">옛날 이야기</label>
     <input type="checkbox" name="memHobby" id="inter25"value="외국 소설">
     <label for="inter26">외국 소설</label>
     <input type="checkbox" name="memHobby" id="inter26"value="외국 시">
     <label for="inter26">외국 시</label>
     <br />
     <input type="checkbox" name="memHobby" id="inter27"value="이 세상 첫 이야기">
     <label for="inter27">이 세상 첫 이야기</label>
     <input type="checkbox" name="memHobby" id="inter28"value="인문">
     <label for="inter28">인문</label>
     <input type="checkbox" name="memHobby" id="inter29"value="인물 이야기">
     <label for="inter29">인물 이야기</label>
     <input type="checkbox" name="memHobby" id="inter30"value="인물·평전">
     <label for="inter30">인물·평전</label>
     <input type="checkbox" name="memHobby" id="inter31"value="장편소설">
     <label for="inter31">장편소설</label>
     <input type="checkbox" name="memHobby" id="inter32"value="정치·사회">
     <label for="inter32">정치·사회</label>
     <input type="checkbox" name="memHobby" id="inter33"value="창비시선">
     <label for="inter33">창비시선</label>
     <br />
     <input type="checkbox" name="memHobby" id="inter34"value="창비어린이">
     <label for="inter34">창비어린이</label>
     <input type="checkbox" name="memHobby" id="inter35"value="창작과비평">
     <label for="inter35">창작과비평</label>
     <input type="checkbox" name="memHobby" id="inter36"value="창작동화">
     <label for="inter36">창작동화</label>
     <input type="checkbox" name="memHobby" id="inter37"value="철학">
     <label for="inter37">철학</label>
     <input type="checkbox" name="memHobby" id="inter38"value="환경">
     <label for="inter38">환경</label>
     <input type="checkbox" name="memHobby" id="inter39"value="기타">
     <label for="inter39">기타</label>
  </td>
</tr>
</table>
<div id = "btn-area1">
   <input type="submit" id="sub-btn1" value="가입" />
   <input type="button" id="cans-btn1" onclick="location.href='<%=request.getContextPath()%>/index.jsp';" value="취소"/>
</div>
</form>
<form name="checkIdFrm" method="post">
   <input type="hidden" name="memId"/>
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
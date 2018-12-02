<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/member/myPageMenu.jsp"%>
<%-- <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script> --%>

<style>
input[type=button].btn2 {
	margin: 5px;
	background: white;
	border-color: #899bdb;
	padding: 5px;
}
#adm-mem5{
	width:100%; 
	border:1px solid gray;
	border-collapse:collapse;
}
table#adm-mem5 th,table#adm-mem5 td{
	border:1px solid gray;
	padding: 3px;
	border-left:1px solid white;
	border-right:1px solid #b8bbc6;
	height: 50px;
}
table#adm-mem5 th{
	background-color:#dde3ff; 
	border-top:2px solid #9faef9; 
	border-bottom:2px solid #9faef9; 
	
}
table#adm-mem5 td{
	text-align: center;
}
table#adm-mem5 th#no-line1,table#adm-mem5 td#no-line1{
	border-right:1px solid white;
}
</style>
<%
	Address address = (Address) request.getAttribute("address");
	//System.out.println("addAddress@address="+address);
	int no = address.getMember_no();
	String[] addressMem = new String[4];
	addressMem[0] = address.getMember_address1();
	addressMem[1] = address.getMember_address2();
	addressMem[2] = address.getMember_address3();
	addressMem[3] = address.getMember_address4();

	String[][] memAddre = new String[4][3];
	for (int i = 0; i < memAddre.length; i++) {
		if (addressMem[i] != null)
			memAddre[i] = addressMem[i].split(",");
		else {
			memAddre[i][0] = null;
			memAddre[i][1] = null;
			memAddre[i][2] = null;
		}
	}

	int count = 1;
	System.out.println(addressMem[0]);
	System.out.println(addressMem[1]);
	System.out.println(addressMem[2]);
	System.out.println(addressMem[3]);
%>
<style>
#content11-container11 {
	width: 760px;
	padding: 15px;
	float: left;
	margin: 5px;
}

#h-container11 {
	float: left;
	margin-bottom: -10px;;
}

#up_p1-container1 {
	float: left;
	width: 760px;
	padding: 3px;
}

#p-table1, #p-cell1, #pwdTitle1, #pwdInput1 {
	border-collapse: collapse;
	border-right: 1px dashed white;
	height: 30px;
	text-align: center;
}

#p-table1 {
	width: 760px;
}

#p-cell1 th, td {
	border: 1px solid black;
}

#title-d21 {
	width: 40px;
}

#title-name1 {
	width: 50px;
}

#title-add1 {
	width: 2500px;
}

#title-choose1 {
	width: 60px;
}

#pwdTitle1, #pwdTitle2, #pwdTitle3 {
	width: 150px;
	border-right: 1px solid #b8bbc6;
	border-left: 1px solid white;
	background-color: #dde3ff;
	padding-left: 8px;
	font-size: 16px;
}

#pwdTitle1, #pwdTitle2, #pwdInput1, #pwdInput2 {
	border-bottom: 1px solid #b8bbc6;
}

#pwdInput1, #pwdInput2, #pwdInput3 {
	width: 600px;
	padding-left: 8px;
	padding-bottom: 3px;
}

#pwdTitle1, #pwdInput1 {
	border-top: 2px solid #9faef9;
}

#pwdTitle3, #pwdInput3 {
	border-bottom: 2px solid #9faef9;
}

#su-btn1 {
	margin-top: 10px;
	float: right;
}

#upPwd_submit1 {
	width: 110px;
	height: 40px;
	color: white;
	background: #303343;
	border-radius: 10px;
	border: 1px solid black;
	cursor: pointer;
	font-size: 15px;
}

.upPwd_submit1 {
	width: 40px;
	height: 40px;
	color: white;
	background: #303343;
	border-radius: 10px;
	border: 1px solid black;
	cursor: pointer;
	font-size: 15px;
	text-align: center;
}

#add1-btn1 {
	width: 100px;
	height: 40px;
	color: white;
	background: #303343;
	border-radius: 10px;
	border: 1px solid black;
	cursor: pointer;
	font-size: 15px;
	margin-bottom: 5px;
}

#h11-line1 {
	border: 1px dashed lightgray;
}

#add-address1 {
	text-align: left;
}

#add-address21 {
	text-align: left;
}

#add-address31 {
	text-align: left;
}

#title-default5 {
	width: 60px;
}

#addAddress5 {
	display: none;
}
.Addressbtn5{
margin: 5px;
	background: white;
	border-color: #899bdb;
	padding: 5px;
}
</style>
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

<div id="content11-container11">
	<div id="h-container11">
		<h2>주소록 관리</h2>
	</div>

	<div id="up_p1-container1">
		<hr id="h11-line1" />
		<input id="add1-btn1" type="button" value="주소록 추가"
			onclick="fn_addressInsert5()" />
		<form action="<%=request.getContextPath()%>/address/addressAddInsert"
			id="memAddressForm5">
			<div id="addAddress5">
				<input type="text" name="postnum" id="sample4_postcode"
					placeholder="우편번호"> <input type="button" class="btn2"
					onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" name="address1" id="sample4_roadAddress"
					placeholder="도로명주소" size="35px"> <br /> <input type="text"
					name="address2" id="sample4_jibunAddress" placeholder="지번주소"
					size="35px"> <input type="hidden" name="memberId"
					value="<%=memberLoggedIn.getMember_id()%>"> <input
					type="hidden" name="memberNo" value="<%=address.getMember_no()%>"><span id="guide" style="color: #999"></span>
				<input type="submit" class="Addressbtn5"value="추가" onclick="return fn_insertTF()" />
			</div>
		</form>
	</div>
	<form action="<%=request.getContextPath()%>/member/updateAddressAdd"
		class="form5">
		<input type="hidden" name="memId"
			value="<%=memberLoggedIn.getMember_id()%>" />
		<table id="adm-mem5" >
			<tr id="p-cell1">
				<th id="title-name1">번호</th>
				<th class="title-add1" style="width: 80px;">우편번호</th>
				<th class="title-add1">신주소</th>
				<th class="title-add1">구주소</th>
				<th id="title-default5" style="width: 40px;">기본</th>
				<th id="title-choose1" style="width: 40px;">선택</th>
			</tr>
			<%
				if (addressMem[0] == null && addressMem[1] == null && addressMem[2] == null && addressMem[3] == null) {
			%>
			<tr>
				<td colspan="6">저장된 주소가 없습니다.</td>
			</tr>
			<%
				} else {
					for (int i = 0; i < memAddre.length; i++) {
						if (addressMem[i] != null) {
			%>
			<tr>
				<td id="add-name<%=(i + 1)%>"><%=count++%></td>
				<td class="add-address"><%=memAddre[i][0]%></td>
				<td class="add-address"><%=memAddre[i][1]%></td>
				<td class="add-address"><%=memAddre[i][2]%></td>
				<td><%=address.getAddressStatus() == (i + 1) ? "기본" : ""%></td>
				<td id="r-select<%=(i + 1)%>"><input type="radio"
					name="add-choose1" value="<%=(i + 1)%>" id="add<%=(i + 1)%>"
					<%=address.getAddressStatus() == (i + 1) ? "checked" : ""%> /> 
					
				</td>

			</tr>
			<%
				}
					}
				}
			%>
			
			<%-- 			<tr id="p-cell1">
				<td id="add-name1"><%=no %></td>
				<td id= "add-address1"><%=address1 %></td>
				<td id="r-select1"><input type="radio" name="add-choose1" id="add1" checked /></td>
			</tr>
			<tr id="p-cell1">
				<td id="add-name21"><%=no %></td>
				<td id= "add-address21"><%=address2%></td>
				<td id="r-lselect21"><input type="radio" name="add-choose1" id="add2" /></td>
			</tr>
			<tr id="p-cell1">
				<td id="add-name31"><%=no %></td>
				<td id= "add-address31"> <%=address3%></td>
				<td id="r-select31"><input type="radio" name="add-choose1" id="add3" /></td>
			</tr>
			<tr id="p-cell1">
				<td id="add-name31"><%=no %></td>
				<td id= "add-address31"> <%=address4%></td>
				<td id="r-select31"><input type="radio" name="add-choose1" id="add4" /></td>
			</tr> --%>
		</table>
		<div id="su-btn1">
			<input type="hidden" name="memberNo" value="<%=address.getMember_no()%>" />
			<input type="hidden" name="memberId" value="<%=memberLoggedIn.getMember_id()%>" />
			<input id="upPwd_submit1" type="submit" value="기본주소 지정"
				onclick="fn_addressUpdate()" /> 
				<input class="upPwd_submit1" type="button" value="삭제" onclick="fn_addressDelete()" />
		</div>
	</form>
</div>
<script>
function fn_addressInsert5(){
	$("#addAddress5").css("display","inline");	
<%-- 	location.href="<%=request.getContextPath()%>/address/addressAddInsert?memberNo=<%=address.getMember_no()%>&memberId=<%=memberLoggedIn.getMember_id()%>"; --%>
}
function fn_addressDelete(){	
	var chckbox = $('#adm-mem5').find('input:radio');
	if(chckbox == null){
		alert('삭제할 주소가 없습니다.');
		return;
	}
	
	for(var i in chckbox){
		if(chckbox[i].checked){	
			location.href="<%=request.getContextPath()%>/address/addressAddDelete?memberNo=<%=address.getMember_no()%>&memberId=<%=memberLoggedIn.getMember_id()%>&deleteAddress="+chckbox[i].value+"&addchk=<%=address.getAddressStatus()%>";
		}
	}
}
function fn_addressUpdate(){
	<%if (addressMem[0] == null && addressMem[1] == null && addressMem[2] == null && addressMem[3] == null) {
				return;
			} else%>	
		$(".form5").submit();
}
function fn_insertTF(){
	
	<%if (count == 5) {%>
		$("#memAddressForm5").bind('submit',function(e){
			alert("주소는 최대 4개까지입니다.");
			e.preventDefault();
			e.stopPropagation();
		});
	<%}%>
}

</script>


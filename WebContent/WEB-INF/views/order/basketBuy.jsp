<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ page import="book.model.vo.*"%>
<%
	String[] bookNoArray = (String[])request.getAttribute("bookNoArray");
	String[] bookTitleArray = (String[])request.getAttribute("bookTitleArray");
	String bookStatus = (String)request.getAttribute("bookStatus");
	int[] amountArray = (int[])request.getAttribute("amountArray");
	int[] priceArray = (int[])request.getAttribute("priceArray");
	
	Address address = (Address)request.getAttribute("address");
	
	String[] ad = new String[3];
	
	String bookNoStr = "";
	String amountStr = "";
	
	int totalPrice = 0;
	for(int i=0; i<priceArray.length; i++) {
		totalPrice += priceArray[i] * amountArray[i];
		bookNoStr += bookNoArray[i] + "__";
		amountStr += amountArray[i] + "__";
	}
	
	if(address!=null) {
		ad[0] = address.getMember_address1().substring(0, address.getMember_address1().indexOf(","));
		ad[1] = address.getMember_address1().substring(address.getMember_address1().indexOf(",")+1, address.getMember_address1().lastIndexOf(","));
		ad[2] = address.getMember_address1().substring(address.getMember_address1().lastIndexOf(",")+1);
	}
	
	String phone1=memberLoggedIn.getMember_phone().substring(0, 3);
	String phone2="", phone3="";
	
	if(memberLoggedIn.getMember_phone().length()==11) {
		phone2 = memberLoggedIn.getMember_phone().substring(3, 7); 	
		phone3 = memberLoggedIn.getMember_phone().substring(7); 	
	} else if (memberLoggedIn.getMember_phone().length()==10) {
		phone2 = memberLoggedIn.getMember_phone().substring(3, 6); 	
		phone3 = memberLoggedIn.getMember_phone().substring(6); 	
	}
	
	
%>
<style>
* {
   user-select: none;    
}
span.index2 {
   color: #4374D9;
   font-size: 25px;
   font-weight: bold;
}

span.content2 {
   font-size: 25px;
   font-weight: bold;
}

table.order2 {
   border: 1px solid;
   border-collapse: collapse;
   margin: 10px;
   width: 940px;
}

td.float_right2 {
	text-align: center;
}

img.book2 {
   width: 100px;
   height: 120px;
   border: 1px solid;
   margin-left: 20px;
}

table.order2 td {
   vertical-align: middle;
   padding: 10px;
}

table td#bookname2 {
   text-align: left;
}

span.price2 {
   font-size: 25px;
   font-weight: bold;
}

span.won2 {
   font-size: 15px;
}

span.total2 {
   color: red;
}

table#order_list2 th {
   background: #EAEAEA;
   border-bottom: gray;
}

table#sum2 {
   border-color: #899bdb;
}

table#sum2 th {
   background: #dee6fd;
}

table#sum2 td {
   text-align: center;
}

img.price2 {
   border: 0px;
   width: 30px;
   height: 30px;
   float: right;
}

input[type=button].btn2 {
   margin: 5px;
   background: white;
   border-color: #899bdb;
   padding: 5px;
}

input[type=button].delivery2 {
   float: left;
}

input[type=button].btn2:hover, input[type=button].btn2:focus {
   background: #899bdb;
   color: white;
}

table#info2 {
   border: 0px;
   width: 90%;
}

table#info-container2 td {
   float: left;
}

th.info-container2 {
   background: #EAEAEA;
}

table#info2 th {
   font-weight: normal;
   width: 140px;
}

table#info2 td {
   float: left;
   width: 100%;
}

#sample4_jibunAddress {
   margin-top: 5px;
}

div#delivery_notice2, div#card_info2 {
   z-index: 1;
   visibility: hidden;
   margin: auto;
   position: absolute;
}

table#popup2 {
   width: 800px;
}

table#payment2 th, table.order_info2 th{
   width: 140px;
}

table#payment2 {
   background: #fbfbfb;
   border-bottom: 1px dashed gray;
   margin-bottom: 0px;
}

table.order_info2 {
   margin-top: 0px;
   border-top: 0px;
}

hr.hr_dotted2 {
   border-style: dashed;
   border-color: gray;
}

span.span_blue2 {
   color: #3a60df;
   font-weight: bold;
   font-size: 16px;
}

input#order_btn2 {
	background: #365fdd;
	color: white; 
	border: 0px;
	width: 200px;
	height: 50px;
	font-size: 20px;
	margin-right: 50px;
}

input#go_basket2 {
	background: #fff;
	color: gray; 
	border: 1px solid gray;
	width: 200px;
	height: 50px;
	font-size: 20px;
}
div#order_btn_div2 {
	text-align: center;
	margin-bottom: 10px;
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
	<form name="addrUpdateFrm">
   <span class="index2">01</span>
   <span class="content2">주문상품 목록</span>
   <table id="order_list2" class="order2">
      <tr>
         <th colspan="2">상품정보</th>
         <th>판매가</th>
         <th>수량</th>
         <th>합계</th>
      </tr>
      <% for(int i=0; i<bookTitleArray.length; i++) { %>
      <tr>
         <td><img class="book2" src="<%=request.getContextPath()%>/images/<%=bookNoArray[i]%>.jpg" alt="book_image" onerror="javascript:this.src='<%=request.getContextPath()%>/images/blank.png'"/></td>
         <td id="bookname2"><%=bookTitleArray[i]%></td>
         <td class="float_right2"><%=priceArray[i]%>원</td>
         <td class="float_right2"><%=amountArray[i]%></td>
         <td class="float_right2"><%=priceArray[i] * amountArray[i]%>원</td>
      </tr>
      <% } %>
   </table>
   상품 변경을 원하시면
   <input class="btn2" type="button" value="장바구니가기" onclick="fn_goBasket();"/>
   <table id="sum2" class="order2">
      <tr>
         <th>상품금액</th>
         <th>배송비</th>
         <th>결제 예정금액</th>
      </tr>
      <tr>
         <td>
            <span class="price2"><%=totalPrice%></span><span class="won">원</span> 
            <img class="price2" src="<%=request.getContextPath()%>/images/plus.png" alt="" />
         </td>

         <td>
            <span class="price2">2500</span><span class="won">원</span> 
            <img class="price2" src="<%=request.getContextPath()%>/images/equal.png" alt="" />
         </td>
         <td>
            <span class="price2 total2"><%=totalPrice + 2500%></span><span class="won2 total2">원</span>
         </td>
      </tr>
   </table>
   <br />

   <span class="index2">02</span>
   <span class="content2">배송지</span> 
  
   <div id="delivery_notice2"></div>
   <table id="info-container2" class="order2">
      <tr>
         <th class="info-container2">주문자 정보</th>
         
         <td>
         <% if(memberLoggedIn != null) { %> 
         	<%=memberLoggedIn.getMember_name()%> | <%=memberLoggedIn.getMember_email() %> | <%=phone1%>-<%=phone2%>-<%=phone3%>
         <% } %>
         </td>
      </tr>

	<script>
	function fn_goBasket() {
		location.href="<%=request.getContextPath()%>/basket/basketServlet?memberNo=" + <%=memberLoggedIn.getMember_no()%>;
	}
	
	$(function() {
		$("#user_info").click(function () {
			$("#userId").val("<%=memberLoggedIn.getMember_name()%>");
			
			<% if(memberLoggedIn.getMember_phone().length()==11) { %>
				$("#phone_num2").val("<%=memberLoggedIn.getMember_phone().substring(3,7)%>");
				$("#phone_num3").val("<%=memberLoggedIn.getMember_phone().substring(7)%>");
			<%} else if(memberLoggedIn.getMember_phone().length()==10) {%>
				$("#phone_num2").val("<%=memberLoggedIn.getMember_phone().substring(3,6)%>");
				$("#phone_num3").val("<%=memberLoggedIn.getMember_phone().substring(6)%>");
			<%} %>
			
			<% %>
			$("#sample4_postcode").val("<%=ad[0]%>");
			$("#sample4_roadAddress").val("<%=ad[1]%>");
			$("#sample4_jibunAddress").val("<%=ad[2]%>");
			
		});
		
		$("#new_info").click(function () {
			$("#userId").val("");
			$("#phone_num2").val("");
			$("#phone_num3").val("");
			$("#sample4_postcode").val("");
			$("#sample4_roadAddress").val("");
			$("#sample4_jibunAddress").val("");
		});
		
		/* $("#addr_list").click(function () {
			// 팝업창 열리게 함.
		}); */
	});
	
	</script>
      <tr>
         <th class="info-container2">배송지 정보</th>
         <td>
            <!-- <input class="delivery" type="button" value="최근 배송지" /> --> 
            <input class="btn2 delivery2" id="user_info" type="button" value="회원정보 동일"/> 
            <input class="btn2 delivery2" id="addr_list" type="button" value="주소록" onclick="popup_addrList();"/>
            <input class="btn2 delivery2" id="new_info" type="button" value="신규입력"/> <br />
			
            <table id="info2">
               <tr>
                  <th>받으시는 분</th>
                  <td colspan="3">
                     <input type="text" name="userId" id="userId" title="받으시는분" value="" style="width: 100px;" required>
                    <!-- <span>(10자 내외 입력)</span> -->
                  </td>
               </tr>
               <tr>
                  <th>휴대폰 번호</th>
                  <td>
                     <select name="phone_num1" id="phone_num1" title="휴대폰 앞자리">
                           <option value="010">010</option>
                           <option value="011">011</option>
                           <option value="016">016</option>
                           <option value="017">017</option>
                           <option value="018">018</option>
                           <option value="019">019</option>
                     </select> - 
                     <input name="phone_num2" id="phone_num2" type="text" title="중간자리" style="width: 40px;" maxlength="4"> - 
                     <input name="phone_num3" id="phone_num3" type="text" title="뒷자리" style="width: 40px;" maxlength="4">
                  </td>
               </tr>
               <tr>
                  <th>배송 주소</th>
                  <td colspan="3">
                     <input type="text" id="sample4_postcode" placeholder="우편번호" required> 
                     <input type="button" class="btn2" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" size="35px"><br>
                     <input type="text" id="sample4_roadAddress" placeholder="도로명주소" size="50px" required> <br /> 
                     <input type="text" id="sample4_jibunAddress" placeholder="지번주소" size="50px" required>
                     <span id="guide" style="color: #999"></span>
                  </td>
               </tr>
            </table>
         </td>
      </tr>
      <tr>
         <th class="info-container2">배송 메세지</th>
         <td>
            <input type="text" name="msg" list="msg" size="40px" placeholder="직접입력"> 
            <!-- datalist id값과 위에 input의 list 속성 값이 일치해야 함. -->
            <datalist id="msg">
            <option value="부재시 경비실에 맡겨주세요.">
            <option value="부재시 휴대폰으로 연락바랍니다.">
            <option value="집 앞에 놓아주세요.">
            <option value="택배함에 넣어주세요.">
            </datalist>
         </td>
      </tr>
   </table>
   <br />
   </form>

   <span class="index2">03</span>
   <span class="content2">결제정보</span>
   <div id="card_info2"></div>
   <table id="payment2" class="order2">
      <tr>
         <th>신용카드</th>
         <td><input type="radio" name="pay" id="card" checked/><label for="card">신용카드(일반)</label></td>
         <td><input type="radio" name="pay" id="card2" /><label for="card2">해외발급신용카드</label></td>
         <td></td>
      </tr>
      <tr>
         <th>간편결제</th>
         <td><input type="radio" name="pay" id="kakao" /><label for="kakao">카카오페이</label></td>
         <td><input type="radio" name="pay" id="payco" /><label for="payco">PAYCO</label></td>
         <td><input type="radio" name="pay" id="samsung" /><label for="samsung">삼성페이</label></td>
      </tr>
      <tr>
         <th>현금결제</th>
         <td><input type="radio" name="pay" id="account" /><label for="account">실시간 계좌이체</label></td>
         <td><input type="radio" name="pay" id="remit" /><label for="remit">온라인(무통장) 송금</label></td>
         <td></td>
      </tr>
      <tr>
         <th>기타결제</th>
         <td><input type="radio" name="pay" id="phone" /><label for="phone">휴대폰 결제</label></td>
         <td></td>
         <td></td>
      </tr>
      </table>
      
      <table id="payment_info2" class="order2 order_info2">
      <tr>
         <div id="payment-container2">
            <th>신용카드</th>
            <td>
            <div id="card2">
               <select id="selectCard1" name="default_card" title="카드선택">
                  <option value="">결제하실 카드를 선택해주세요</option>
                  <option value="SH">신한카드(구LG)</option>
                  <option value="KB">KB국민카드</option>
                  <option value="BC">BC카드</option>
                  <option value="HD">현대카드</option>
                  <option value="LT">롯데카드</option>
                  <option value="WH">외환카드</option>
                  <option value="SS">삼성카드</option>
                  <option value="UR">우리카드</option>
                  <option value="HN">하나카드</option>
                  <option value="CT">씨티카드</option>
                  <option value="JC">저축은행카드</option>
                  <option value="UC">우체국카드</option>
                  <option value="SM">MG새마을체크카드</option>
                  <option value="SUH">수협카드</option>
                  <option value="JB">전북JB카드</option>
                  <option value="KJ">광주은행카드</option>
                  <option value="NH">NH카드</option>
                  <option value="SIH">신협카드</option>
                  <option value="JJ">제주카드</option>
                  <option value="SU">KDB산업은행카드</option>
               </select>
            </div>
            </td>
         </div>
      </tr>
      <tr>
         <th>카드구분</th>
         <td>
            <input type="radio" name="card" id="personal_card2" /><label for="personal_card2">개인카드</label>
            <input type="radio" name="card" id="business_card2" /><label for="business_card2">법인카드</label>
         </td>
      </tr>
      <tr>
         <th>결제안내</th>
         <td>
            <input class="btn2" type="button" value="결제오류안내" onMouseOver="fn_popup();" onMouseOut="fn_hide(); return true;"/>
         </td>
      </tr>
   </table>
   
<!--    <table id="abr_card_info2" class="order2 order_info2">
      <tr>
         <div id="payment-container2">
            <th>신용카드</th>
            <td>
            <div id="card2">
               <select id="selectCard1" name="default_card" title="카드선택">
                  <option value="">결제하실 카드를 선택해주세요</option>
                  <option value="VS">해외VISA</option>
                  <option value="MS">해외MASTER</option>
                  <option value="JC">해외JCB</option>
               </select>
            </div>
            </td>
         </div>
      </tr>
      <tr>
         <th>결제안내</th>
         <td>
            <input class="btn2" type="button" value="결제오류안내" onMouseOver="fn_popup();" onMouseOut="fn_hide(); return true;"/>
         </td>
      </tr>
   </table> -->
   <form action="<%=request.getContextPath()%>/buy/basketBuyFinal" onsubmit="return chk();">
  	   <div id="order_btn_div2">
	   		<input type="submit" value="결제하기" id="order_btn2"/>
	   		<input type="button" value="장바구니 가기" id="go_basket2" onclick="fn_goBasket();"/>
	   		<input type="hidden" value="<%=address.getMember_no()%>" name="memberNo"/>
	   		<input type="hidden" value="<%=bookNoStr%>" name="bookNo"/>
	   		<input type="hidden" value="<%=amountStr%>" name="amount"/>
	   		<input type="hidden" value="<%=bookStatus%>" name="bookStatus"/>	   			   		
	   </div>
   </form>
   
   <script>
	function chk() {
		if($("#userId").val().trim()==0 || $("#sample4_postcode").val().trim()==0 || $("#sample4_roadAddress").val().trim()==0 || $("#sample4_jibunAddress").val().trim()==0) {
			alert("배송지 정보를 입력하세요.");
			return false;			
		}
		return true;
	}
   function fn_popup() {
      var content = "<span class='span_blue2'>■ 주문/결제페이지에서 [결제하기] 누른 후 주문중으로 계속 표시되고 주문완료가 되지 않을 경우</span><br />"
               + "고객님의 카드번호 혹은 유효기간 입력 등이 잘못되거나 카드에 문제가 발생할 경우 결제 승인이 정상적으로 되지 않을 수 있습니다.<br /> 각 카드 발급사에 문의 부탁드립니다. "
               + "<hr class='hr_dotted2'/>"
               + "<span class='span_blue2'>■ '보안된 컨텐츠만 표시됩니다'라는 보안경고가 계속 뜨는 경우</span><br /> "
               + "암호화할 필요가 없는 이미지나 사진 같은 요소가 포함된 경우 보안경고가 생성될 수 있습니다. 아래와 같이 설정을 변경하세요. <br /><br /> "
               + "1. IE 메뉴에서 [도구] -> [인터넷옵션] -> [보안]탭 <br />2. [도구] -> [인터넷옵션] -> [보안] 탭 -> [사용자지정수준] <br />"
               + "3. 하단 [기타] 메뉴에서 [혼합된 콘텐츠 표시]라는 항목을 '사용'이나 '사용안함'으로 설정";
      var text; 
        text = '<table id="popup2" cellpadding="5" bgcolor="#ffffff" style="font-size:9pt; filter:alpha(opacity=90); border-width:1; border-color:#3291BD; border-style:solid;">'; 
        text += '<tr><td>' + content + '</td></tr></table>'; 
        document.getElementById('card_info2').innerHTML = text; 
        document.getElementById('card_info2').style.visibility = 'visible'; 
   }
   function fn_hide() {
      document.getElementById('card_info2').innerHTML = ''; 
       document.getElementById('card_info2').style.visibility = 'hidden'; 
   }
   function popup_addrList() {
	    var url = "<%=request.getContextPath()%>/member/addressList?memberNo="+<%=memberLoggedIn.getMember_no()%>;
	   <%--  +"&memberName="+'<%=memberLoggedIn.getMember_name()%>' --%>
		var title = "addrList";
		var status = "left=500px, top=200px, width=700px, height=300px";
		
		var popup = window.open(url, title, status);
		// 비어있는 폼 열고
		
 		// 92번째 줄에 선언한 memberUpdateFrm 폼
		var addrUpdateFrm = document.addrUpdateFrm;
		addrUpdateFrm.userId.value = '<%=memberLoggedIn.getMember_name()%>';
		addrUpdateFrm.phone_num1.value = '<%=phone1%>';
		addrUpdateFrm.phone_num2.value = '<%=phone2%>';
		addrUpdateFrm.phone_num3.value = '<%=phone3%>';
		
		addrUpdateFrm.target = title;
		addrUpdateFrm.action = url;
		//addrUpdateFrm.submit(); 
		// memberUpdateFrm submit해서 action으로 위에 선언한 url로 넘어감.
		// updatePassword.jsp에서 선언한 form으로 팝업창 열림 
   }
   </script>
   <%@ include file="/WEB-INF/views/common/footer.jsp"%>
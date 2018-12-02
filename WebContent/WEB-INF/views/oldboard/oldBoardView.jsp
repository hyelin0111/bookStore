<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ page import="oldboard.model.vo.OldBoard, book.model.vo.*"%>
<%
	OldBoard ob = (OldBoard)request.getAttribute("ob");
	Book b = (Book)request.getAttribute("book");
%>
<style>
td.padd {
	padding-left: 20px;
}

table#tab_detail_content5{
	width: 100%;
}

.book_info_text5 {
	color: black;
	text-decoration: none;
}

.book_info_p {
	margin: 1px 20px 20px 20px;
}

.tab_detail_content5_td3 {
	border: 1px solid #d7d7d7;
	font-size: 13px;
}

.tab_detail_content5_td2 {
	width: 150px;
	height: 70px;
}

table#oldBoardView2 {
	border-bottom: 1px solid gray;
	border-top: 1px solid gray;
	border-collapse: collapse;
	width: 100%;
}
img.oldBoardBook2 {
	width: 200px;
	height: 240px;
	margin-left: 10px;
	padding: 10px 0 10px 0;
}
div.origin_info2 {
	background: lightgray;
	padding: 10px;
	height: 100px;
	margin: 10px;
	margin-top: 0;
}
div.discount_info2 {
	padding: 10px;
}

div.btn_info2 {
	padding-left: 10px;
	padding-bottom: 10px;
}
td#img_box2 {
	width: 210px;
}
span#origin_price2 {
	text-decoration: line-through;
}
span#discount_price2 {
	color: red;
	font-size: 20px;
}
.tab_detail_content5_td {
	border: 1px solid #d7d7d7;
	width: 120px;
	text-align: center;
}

.tab_detail_content5 {
	margin: auto;
	margin-top: 30px;
/* 	width: 700px; */
	height: 36px;
	background-color: #fff;
	/* border: 1px solid #d7d7d7; */
	border-spacing: 0px;
}

table.tab_detail_content5 button.btn-delete {
	background: red;
	color: white;
	display: none;
	float: right;
}

table.tab_detail_content5 tr:hover button.btn-delete {
	display: inline;
}

.btn_blue {margin-top:10px; margin-bottom:-60px; background-image: none;background-color: #5e6b9f !important;border: 1px solid #5e6b9f;color: #fff !important;box-shadow: none; padding: 5px;}
.btn_blue2 {margin-bottom:-60px; background-image: none; background-color: #7b8ed1 !important;border: 1px solid #7b8ed1;color: #fff !important;box-shadow: none; padding: 5px;}
</style>
<script>
function fn_insertBasket(){	
	<%if (memberLoggedIn != null) {%>
	$.ajax({
		url : "<%=request.getContextPath()%>/basket/insertBasket",
		data : {
			memberNo : <%=memberLoggedIn.getMember_no()%>,
			bookNo : <%=b.getBookNo() %>,
			orderCnt : 1,
			status : "Y"
		},
		dataType : "html",
		success : function(data){
			var check = confirm("장바구니에 담겼습니다. 장바구니로 이동하시겠습니까?");
			
			if( check )
				location.href="<%=request.getContextPath()%>/basket/basketServlet?memberNo=" + <%=memberLoggedIn.getMember_no()%>;
		},
		error : function(){
			
		}
	});
	
}
$(function(){
	   $("#deleteOldBoard").click(function(){
	      var check = confirm("정말 삭제하시겠습니까?");
	      
	      if(check)
	         location.href="<%=request.getContextPath()%>/oldboard/deleteOldBoard?boardNo=" + <%=ob.getOldBoardNo()%> + "&memberNo=" + <%=memberLoggedIn.getMember_no()%>;
	   });
	}); 
<%}%>
</script>

<form action="<%=request.getContextPath()%>/order/oldBuyServlet">
	<table id="oldBoardView2">
		<tr>
			<td id="img_box2">
				<img class="oldBoardBook2" src="<%=request.getContextPath()%>/images/<%=ob.getOldBookNo()%>.jpg" alt="book_image" onerror="javascript:this.src='<%=request.getContextPath()%>/images/blank.png'"/>
			</td>
			<td>
				<div class="origin_info2">
					<h1><strong><%=b.getBookTitle() %></strong></h1>
					<span><%= b.getAuthorName() %> 지음 | </span> 
					<span><%= b.getBookPublisher() %> | </span> 
					<span><%= b.getIssueDate() %> 출간</span> <br /><br />
				</div>
				<div class="discount_info2">
					<span id="origin_price2"><%=b.getBookPrice() %> 원</span> → 
					<span id="discount_price2"><%=ob.getOldBookPrice() %> 원</span>
					<span>[<%=100-(int)((double)ob.getOldBookPrice()/b.getBookPrice()*100)%>%↓]</span> <br />
					<span>판매자 : <%=ob.getMemberName() %></span> | 
					<span>상태 : <%=ob.getBookCondition() %></span> |
					<span>등록일 : <%=ob.getOldBoardDate() %></span>
				</div>
				<div class="btn_info2">
				 <% if(memberLoggedIn!=null) { %> 				
					<input type="button" value="장바구니 담기" class=" btn_blue" onclick="fn_insertBasket();"/>
					<input type="submit" id="orderBtn" value="바로구매" class=" btn_blue2" />
					<% if( ob.getMemberNo() == memberLoggedIn.getMember_no() || memberLoggedIn.getMember_no() == 1){ %>
                  		<input style="float:right; height: 30px; color: white; border-color: hotpink; background: hotpink; margin-top: 15px;" type="button" id="deleteOldBoard" value="글 삭제" />
              		<%}%>
					<input type="hidden" value="<%=ob.getOldBoardNo()%>" name="oldBoardNo"/>
					<input type="hidden" value="<%=memberLoggedIn.getMember_no()%>" name="memberNo"/>
					<input type="hidden" value="<%=ob.getBookStatus()%>" name="bookStatus"/>
				<%} else { %>
					<p style="font-size: 12px;">비회원은 구매할수 없습니다.</p>
				<%}%>
				</div>
			</td>
		</tr>
	</table>
</form>
<br />

<table class="tab_detail_content5" id="tab_detail_content5">
	<tr>
		<td class="tab_detail_content5_td"><a href="#book_info5"
			class="book_info_text5">상품정보</a></td>
		<td class="tab_detail_content5_td"><a href="#book_info_guide"
			class="book_info_text5">교환/반품/품절</a></td>
	</tr>
</table>
<br />

<table class="tab_detail_content5">
		<div class="book_info_product5">
			<tr>
				<td class="tab_detail_content5_td" >도서번호</td>
				<td colspan="2" class="tab_detail_content5_td"><%=ob.getOldBookNo()%></td>						
			</tr>
			<tr>
				<td  class="tab_detail_content5_td">쪽수</td>
				<td colspan="2"  class="tab_detail_content5_td"><%=b.getBookPage() %> 쪽</td>						
			</tr>
			<tr>
				<td colspan="2" id="book_info5" class="book_info_table_td5">
				<h3>책소개</h3>
				<div class="book_info_intro_div">
					<hr />
					이 책의 장르 <br /><br />
					<%=b.getCategory() %> <br /><br />
					<p class="book_info_p" style="font-size: 14px;">

						사랑에 빠지는 순간은 예고 없이 찾아온다! <br /><br />
						남궁현 장편소설 『더 원(The One)』 제1권. 2013년 출간된 후 로맨스 독자들의 관심과 입소문으로 사랑을 받은 작품으로, 더 많은 에피소드를 추가하고 수정하여 새롭게 독자들과 만난다. 인물 관계의 밀도와 긴장감을 높이고 외전을 대폭 늘려 결말 이후의 이야기를 새롭게 만들어 냈다. 저자의 강점인 섬세하고 촘촘한 심리 묘사가 빛을 발하는 작품이다. <br /> 								
						작품을 할 때마다 열애설에 휘말려 스캔들 메이커로 낙인찍힌 배우 성현. 마지막 기회로 다가온 드라마 '온리 원'의 여주인공 선우진으로 캐스팅된다. 상대역은 뛰어난 외모와 매력으로 많은 팬을 거느린 탑스타 서재유! 그는 비주얼만 훌륭한 가수출신 연기자라는 꼬리표를 떼기 위해 '온리 원'의 김재현 역에 도전한다.  <br />
						진짜 선우진과 김재현처럼 서로를 알아갈수록 낯선 설렘을 경험하는 두 사람. 하지만 더 이상 스캔들의 주인공이 되고 싶지 않은 성현은 그 마음을 부정하며 재유의 눈빛을 외면한다. 그리고 그들 사이에 나타난 또 다른 서재유. 늘 그림자처럼 숨어 있던 그가 모습을 드러내고, 성현은 똑같은 얼굴의 두 사람을 보고 충격에 빠지는데…. <br />
					</p>
					<hr /><br />
				</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<h3>저자소개</h3>
				<div class="book_info_intro_div">
					<hr />
					이 책의 저자 <br /><br />
					<%=b.getAuthorName() %> <br /><br />
					<p class="book_info_p" style="font-size: 14px;">
						저자 아담 J. 잭슨 Adam J. Jackson은 영국 사우스햄턴대학교 법학과를 졸업하고 런던에서 법무관으로 사회에 첫발을 딛은 그는 법조계에 입문한 지 3년 만에 탄탄대로였던 법무관을 그만두고 건강, 자연의학 분야를 공부, 《너싱 타임즈》 《헬스 가디언》 등에서 저명한 칼럼니스트로 활동했다. <br /><br /> 
						
						자기 변화와 인간관계, 스트레스 극복에 관한 많은 글을 써서 세계 출판계에도 큰 반향을 일으켰으며, 변화의 동기를 유발하는 명강사로도 유명한 그는 인간 심리에 대한 분석적이고 치밀한 논리와 종합적이고 포용력 있는 동양적 사고방식을 결합한 독특한 인생론을 설파하였다. 현재 그는 런던과 토론토에서 클리닉센터를 운영하면서 영국과 미국의 대학에서 강의하고 있다. <br /><br /> 
						
						대표적인 저서로 돈, 사랑, 행복, 건강이라는 주제를 현대의 우화 형식으로 쓴 4권(The 10 Secrets of Abundant Wealth, The 10 Secrets of Abundant Love, The 10 Secrets of Abundant Happiness, The 10 Secrets of Abundant Health)이 있다. <br /><br /> 
						
						이번에 새롭게 출간한 이 『내가 만난 1%의 사람들』은 아담 J. 잭슨의 대표 저서(The 10 Secrets of Abundant Wealth, Love & Happiness) 3권을 한 권으로 모은 것이다. 아담 J. 잭슨의 이 책은 영국에서 처음 발행된 이후 미국, 독일, 프랑스, 이탈리아, 스페인, 일본, 중국 등 전 세계 30여 개국에서 번역되어 1천만 명 이상의 독자들로부터 열광적인 호응을 받고 있다. <br /><br /> 
					</p>
					<hr /><br />
				</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<h3>책 속으로</h3>
				<div class="book_info_intro_div">
					<hr />
					<br />
					<p class="book_info_p" style="font-size: 14px;">
						포기하지 말라! <br /> 
						일이 잘못되어 갈 때 <br /> 
						걷는 길이 계속 오르막길처럼 보일 때<br /> 
						저금은 줄어들고 채무만 늘어날 때 <br />
						그리하여 미소를 짓고 싶어도 한숨만 나올 때 <br />
						걱정이 그대를 내리누를 때 <br />
						필요하다면 휴식하라. 하지만 절대로 포기하지 말라!<br /> 
						<br />
						인생은 변수와 의외로 가득하니 <br />
						누구나 수많은 실패를 통해서 배운다. <br />
						조금만 더 버티면 성공할지도 모르니 <br />
						포기하지 말라! 비록 발걸음은 늦춰질지라도 <br />
						일거에 당신은 성공할 수도 있다. <br />
						<br />
						성공은 실패를 뒤집은 것이다.  <br />
					</p>
					<hr /><br />
				</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<h3>출판사 서평</h3>
				<div class="book_info_intro_div">
					<hr />
					<br />
					<p class="book_info_p" style="font-size: 14px;">
						30여 개국에서 번역되어 1천만 명의 독자들에게 풍요로운 삶을 안겨준 책  <br />
						세계적인 심리학자 아담 J. 잭슨의 명강의를 바탕으로 쓴 삶의 비밀 시리즈  <br />
						풍요로운 삶에 필요한 돈, 사랑, 행복의 비밀을 찾아 떠나는 우화  <br />
						한 편의 소설을 읽듯이 만나는 실존 인물들의 이야기 <br />
						
						1% 사람들만이 남몰래 간직한 비밀스러운 이야기  <br />
						“조르바는 한몫 단단히 잡고 날개가 넉넉하게 커져 날아갈 날을 기다렸다. 그는 돈을 날개라고 불렀다. <br />
					</p>
					<hr /><br />
				</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" id="book_info_guide" class="book_info_table_td5">

					<br />
					<h3>교환/반품/품절 안내</h3> 
					<div class="book_info_intro_div">
						<p class="book_info_p" style="font-size: 12px;">
							※ 상품 설명에 반품/교환 관련한 안내가 있는 경우 그 내용을 우선으로 합니다. (업체 사정에 따라 달라질 수 있습니다.)
						</p>
						<hr />
						<div class="book_info_intro_div">
						</div>
						<br />
					</div>
				</td>
			</tr>
			<tr>
				<td class="tab_detail_content5_td tab_detail_content5_td2">반품/교환방법</td>
				<td class="tab_detail_content5_td3 padd">
				<p> 
				[1:1상담>반품/교환/환불] 또는 고객센터 (ㅁㅇㅁㅇ-ㅇㅇㅇㅇ) <br />
				※ 오픈마켓, 해외배송주문, 기프트 주문시 [1:1상담>반품/교환/환불] <br />
				    또는 고객센터 (ㅇㅇㅇㅇ-ㅇㅇㅇㅇ)		
				</p>
				</td>
			</tr>						
			<tr>
				<td class="tab_detail_content5_td tab_detail_content5_td2">반품/교환가능 기간</td>
				<td class="tab_detail_content5_td3 padd">
				<p>
					변심반품의 경우 수령 후 7일 이내, <br />
					상품의 결함 및 계약내용과 다를 경우 문제점 발견 후 30일 이내
				</p>
				</td>
			</tr>						
			<tr>
				<td class="tab_detail_content5_td tab_detail_content5_td2">반품/교환비용</td>
				<td class="tab_detail_content5_td3 padd">
				<p>
					변심 혹은 구매착오로 인한 반품/교환은 반송료 고객 부담
				</p>
				</td>
			</tr>						
			<tr>
				<td class="tab_detail_content5_td tab_detail_content5_td2">반품/교환 불가 사유</td>
				<td class="tab_detail_content5_td3 padd">
				<ul>
					<li>소비자의 책임 있는 사유로 상품 등이 손실 또는 훼손된 경우 <br />
						(단지 확인을 위한 포장 훼손은 제외)</li>
					<li>소비자의 사용, 포장 개봉에 의해 상품 등의 가치가 현저히 감소한 경우 <br />
						예) 화장품, 식품, 가전제품(악세서리 포함) 등</li>
					<li>복제가 가능한 상품 등의 포장을 훼손한 경우 <br />
						예) 음반/DVD/비디오, 소프트웨어, 만화책, 잡지, 영상 화보집</li>
					<li> 소비자의 요청에 따라 개별적으로 주문 제작되는 상품의 경우 ((1)해외주문도서)</li>
					<li> 디지털 컨텐츠인 eBook, 오디오북 등을 1회 이상 다운로드를 받았을 경우</li>
					<li>시간의 경과에 의해 재판매가 곤란한 정도로 가치가 현저히 감소한 경우</li>
					<li>전자상거래 등에서의 소비자보호에 관한 법률이 정하는 소비자 청약철회 제한 내용에 <br />
							해당되는 경우</li>
				</ul>
				</td>
			</tr>						
			<tr>
				<td class="tab_detail_content5_td tab_detail_content5_td2">상품 품절</td>
				<td class="tab_detail_content5_td3 padd">
				<p>
					공급사(출판사) 재고 사정에 의해 품절/지연될 수 있으며, 품절 시 관련 사항에 대해서는 <br />
					이메일과 문자로 안내드리겠습니다. 
				</p>
				</td>
			</tr>						
			<tr>
				<td class="tab_detail_content5_td tab_detail_content5_td2">소비자 피해보상 환불지연에 따른 배상</td>
				<td class="tab_detail_content5_td3">
				<ul>
				<li>상품의 불량에 의한 교환, A/S, 환불, 품질보증 및 피해보상 등에 관한 사항은 <br />
					소비자분쟁해결 기준 (공정거래위원회 고시)에 준하여 처리됨
				</li>
				<li>
					대금 환불 및 환불지연에 따른 배상금 지급 조건, 절차 등은 전자상거래 등에서의 <br />
					소비자 보호에 관한 법률에 따라 처리함</li>
				</ul>
				
				</td>
			</tr>						
		</div>
</table>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
             basket.model.vo.Basket" %>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
   List<Basket> basketList = (List<Basket>)request.getAttribute("basketList");
   int cnt = 0;
   int oldCnt = 0;
%>
<script>
   $(function(){   
      // 탭변경
      $('ul.basketTab li').click(function() {
         var activeTab = $(this).attr('data-tab');
         $('ul.basketTab li').removeClass('current');
         $('.tabcontent').removeClass('current');
         $(this).addClass('current');
         $('#' + activeTab).addClass('current');
      });
      
      // 수량에 따라 가격변경
      $(".bookAmount").change(function(){
         var sum = 0;
         var amount = $(this).val();
         var index = $(this).parent().parent().index();
         var price = $(this).parent().parent().find(".bookPrice").val();         
         
         var bAmount = $(this).parent().parent().find(".bAmount").val(amount);
         
         if( index == 1 )
            $(this).parent().parent().find("label").text(price * amount);
         else if( index == 2 )
            $(this).parent().parent().find("label").text(price * amount);
         else
            $(this).parent().parent().find("label").text(price * amount);
         
         
         $(".checkBook:checked").each(function(){
            sum += Number($(this).parent().parent().find("label").text());
         });
         $(".checkOldBook:checked").each(function(){
            sum += Number($(this).parent().parent().find("label").text());
         });
         
         $("#sumBookPrice4").text(sum);

         if( sum == 0 )
            del = 0;
         else
            del = 2500;
         
         $("#sumTotalPrice4").text( sum + del );
      });
      // 수량에 따라 가격변경(중고)
      $(".oldBookAmount").change(function(){
         var amount = $(this).val();
         var index = $(this).parent().parent().index();
         var price = $(this).parent().parent().find(".oldBookPrice").val();
         var sum = 0;
         
         var oBAmount = $(this).parent().parent().find(".oBAmount").val(amount);
         
         if( index == 1 )
            $(this).parent().parent().find("label").text( price * amount);
         else if( index == 2 )
            $(this).parent().parent().find("label").text( price * amount);
         else
            $(this).parent().parent().find("label").text(price * amount);
         
         $(".checkBook:checked").each(function(){
            sum += Number($(this).parent().parent().find("label").text());
         });
         $(".checkOldBook:checked").each(function(){
            sum += Number($(this).parent().parent().find("label").text());
         });
         
         $("#sumBookPrice4").text(sum);

         if( sum == 0 )
            del = 0;
         else
            del = 2500;
         
         $("#sumTotalPrice4").text( sum + del );
      });
      
      // 서점책 전체 선택/해제
      $("#allCheckBtn").click(function(){
         var bool = $(this).is(":checked");
         var sum = 0;

         $(".checkBook").prop("checked", bool);
         
         $(".checkOldBook:checked").each(function(){
            sum += Number($(this).parent().parent().find("label").text());
         });
         $(".checkBook:checked").each(function(){
            sum += Number($(this).parent().parent().find("label").text());
         });
         
         $("#sumBookPrice4").text(sum);

         if( sum == 0 )
            del = 0;
         else
            del = 2500;
         
         $("#sumTotalPrice4").text( sum + del );
      });
      
      // 중고책 전체 선택/해제
      $("#allOldCheckBtn").click(function(){
         var bool = $(this).is(":checked");
         var sum = 0;
         
         $(".checkOldBook").prop("checked", bool);
         
         $(".checkOldBook:checked").each(function(){
            sum += Number($(this).parent().parent().find("label").text());
         });
         $(".checkBook:checked").each(function(){
            sum += Number($(this).parent().parent().find("label").text());
         });
         
         $("#sumBookPrice4").text(sum);

         if( sum == 0 )
            del = 0;
         else
            del = 2500;
         
         $("#sumTotalPrice4").text( sum + del );
      });
      
      // 가격 바뀌는 거
      $(".checkBook").click(function(){
         var sum = 0;
         
         // 서점책 쪽
         $(".checkBook:checked").each(function(){
            sum += Number($(this).parent().parent().find("label").text());
         });
         
         // 중고 쪽 
         $(".checkOldBook:checked").each(function(){
            sum += Number($(this).parent().parent().find("label").text());
         });
         
         $("#sumBookPrice4").text(sum);

         if( sum == 0 )
            del = 0;
         else
            del = 2500;
         
         $("#sumTotalPrice4").text( sum + del );
      });
      
      // 중고바구니 쪽
      $(".checkOldBook").click(function(){
         var sum = 0;
         var del= 2500;
         
         $(".checkOldBook:checked").each(function(){
            sum += Number($(this).parent().parent().find("label").text());
         });
         $(".checkBook:checked").each(function(){
            sum += Number($(this).parent().parent().find("label").text());
         });
         
         $("#sumBookPrice4").text(sum);
         
         if( sum == 0 )
            del = 0;
         else
            del = 2500;
         
         $("#sumTotalPrice4").text( sum + del );
      });
      
      // 서점책 삭제
      $(".deleteBookBtn").click(function(){
         var memberNo = <%=memberLoggedIn.getMember_no()%>;
         var bookNo = $(this).parent().parent().find(".bookNo").val();
         var bookStatus = $(this).parent().parent().find(".bookStatus").val();
         
         location.href="<%=request.getContextPath() %>/basket/deleteBookToBasket?memberNo=" + memberNo + "&bookNo=" + bookNo + "&bookStatus=" + bookStatus;
      });
      
      // 중고책 삭제
      $(".deleteOldBookBtn").click(function(){
         var memberNo = <%=memberLoggedIn.getMember_no()%>;
         var bookNo = $(this).parent().parent().find(".bookNo").val();
         var bookStatus = $(this).parent().parent().find(".bookStatus").val();
         
         location.href="<%=request.getContextPath() %>/basket/deleteBookToBasket?memberNo=" + memberNo + "&bookNo=" + bookNo + "&bookStatus=" + bookStatus;
      });
      
      // 구매버튼!
      $("#allBuyBtn").click(function(){
         var memberNo = <%=memberLoggedIn.getMember_no()%>;
         
         // 서점책
         var bookNoArray = new Array();
         var amountArray = new Array();   
         var bookStatusArray = new Array();
         var bookPriceArray = new Array();
         
         $(".checkBook:checked").each(function(){
            var bookNo = $(this).parent().parent().find(".bookNo").val();
            var amount = $(this).parent().parent().find(".bAmount").val();      
            var price = $(this).parent().parent().find(".bookPrice").val();      
            var status = "N";
            
            bookNoArray.push(bookNo);
            amountArray.push(amount);
            bookStatusArray.push(status);
            bookPriceArray.push(price);
         });
         
         // 중고책         
         $(".checkOldBook:checked").each(function(){
            var bookNo = $(this).parent().parent().find(".bookNo").val();
            var amount = $(this).parent().parent().find(".oBAmount").val();
            var price = $(this).parent().parent().find(".oldBookPrice").val(); 
            var status = "Y";
            
            bookNoArray.push(bookNo);
            amountArray.push(amount);
            bookStatusArray.push(status);
            bookPriceArray.push(price);
         });   
         
         var data = {
               "memberNo" : memberNo,
               "bookNoArray" : bookNoArray,
               "amountArray" : amountArray,
               "memberNo" : memberNo,
               "bookPriceArray" : bookPriceArray,
               "bookStatusArray" : bookStatusArray
         }
         
         // 배열을 넘기기 위해서 써주는 코드.
         $.ajaxSettings.traditional = true;
         
         $.ajax({
             url : "<%=request.getContextPath()%>/buy/basketBuy",
             type : "get",
             dataType : "json",
             data : data,
             success : function(data){
            	var bookNoStr = "";
            	var amountStr = "";
            	var priceStr = "";
            	var bookStatusStr = "";
            	var cnt = 0;
            	 
            	for(var index in data) {
            		cnt++;
            		bookNoStr += data[index][0].bookNo + "__";
            		amountStr += data[index][0].amount + "__";
            		priceStr += data[index][0].price + "__";
            		bookStatusStr += data[index][0].bookStatus + "__";
            	}
				location.href="<%=request.getContextPath()%>/buy/basketBuyEnd?memberNo="+ data[index][0].memberNo +"&cnt=" + cnt + "&bookNo=" + bookNoStr + "&amount=" + amountStr + "&price=" + priceStr + "&bookStatus=" + bookStatusStr;                  
             },
            error : function(){
            	console.log("ajax 에러");
            } 
         });
      });   
   });

</script>
<style>
*{
   margin: 0;
   padding: 0;
}
#container {
   margin: 0 auto;
   text-align: center;
}

.basketTab {
   list-style: none;
   margin: 0;
   padding: 0;
   overflow: hidden;
}

.basketTab li {
   float: left;
}

.basketTab li a {
   display: inline-block;
   color: black;
   text-align: center;
   text-decoration: none;
   padding: 14px 16px;
   font-size: 17px;
   transition: 0.3s;
}

.tabcontent {
   display: none;
   padding: 6px 12px;
}

li.current a {
   color: white;
}

.current {
   color: white;
   background: #303343;
}

.tabcontent.current {
   display: block;
}

input[type=checkbox] {
   width: 20px;
   height: 20px;
   margin: 25px 25px;
}

.bookImg, .oldBookImg {
   width: 100px;
   height: 160px;
}

#basketTab1 table, #basketTab2 table {
   border: 2px solid black;
   border-collapse: collapse;
}

#basketTab1 table th, #basketTab2 table th {
   border: 2px solid black;
}

#basketTab1 table td, #basketTab2 table td {
   border: 1px solid black;
}

table tr td:nth-child(4), table tr td:nth-child(5){
   width: 150px;
}

#basketTab1 table td:nth-child(2), #basketTab2 table td:nth-child(2){
   padding-left: 200px;
   padding-right: 200px;
}

.bookAmount, .oldBookAmount{
   text-align:center; 
   width: 51px; 
   background: #303343; 
   color: white;
   border: 0px;
}

#buyBasketBook {
   margin-left: -10px;
   margin-top: 50px;
   margin-bottom: 50px;
   
}

table.order4 {
   border: 1px solid;
   border-collapse: collapse;
   margin: 10px;
   width: 1000px;
}

table#orderTable {
   color: #303343;
   background: white;
   border-color: #899bdb;
}

table#orderTable th {
   background: #dee6fd;
   width: 33%;
}

table#orderTable td {
   text-align: center;
}

span.price4 {
   font-size: 25px;
   font-weight: bold;
}

span.won4 {
   font-size: 15px;
}

img.price4 {
   border: 0px;
   width: 30px;
   height: 30px;
   float: right;
}

span.total4 {
   color: red;
}

.deleteBookBtn, .deleteOldBookBtn{
   border-color: silver;
   color: white;
   width: 80px;
   height: 30px;
   background: silver;
}
</style>
<div id="container">
      <h2>장바구니</h2>
      
      <%  if( !basketList.isEmpty() ) { %>
      
      <ul class="basketTab">
         <li class="current" data-tab="basketTab1"><a href="#">주문 도서</a></li>
         <li data-tab="basketTab2"><a href="#">중고 주문 도서</a></li>
      </ul>

      <div id="basketTab1" class="tabcontent current">
         <table>
            <tr>
               <th>
                  <input type="checkbox" name="" id="allCheckBtn" />
               </th>
               <th style="min-width:507px;">제목</th>
               <th style="min-width:52px;">수량</th>
               <th style="min-width:151px;">가격</th>
               <th style="min-width:151px;">비고</th>
            </tr>
            <% for( Basket b : basketList) { %>
               <% if( b.getUsedStatus().equals("N") && cnt < 3 ) { cnt++;%>
                  <tr>
                     <td>
                        <input class="checkBook" type="checkbox" name=""/>
                     </td>
                     <td>
                        <img src="<%=request.getContextPath() %>/images/<%=b.getBookNo() %>.jpg" alt="" class="bookImg" onerror="javascript:this.src='<%=request.getContextPath()%>/images/blank.png'"/> <br />
                        <strong><%= b.getBookTitle() %></strong>
                        <input type="hidden" class="bookNo" value="<%=b.getBookNo() %>"/>
                        <input type="hidden" class="bookStatus" value="N"/>
                     </td>
                     <td>
                        <input type="number" style="text-align:center; width: 51px;" name="" class="bookAmount" min="0" value="<%=b.getAmount()%>"/>
                        <input type="hidden" class="bAmount" value="<%=b.getAmount()%>"/>
                     </td>
                     <td>                     
                        <label class="bPrice4" for=""><%=b.getPrice() * b.getAmount() %> </label>
                        <span>원</span>
                        <input type="hidden" name="" class="bookPrice" value="<%=b.getPrice()%>"/>
                     </td>
                     <td>
                        <input type="button" value="삭제" class="deleteBookBtn"/>
                     </td>
                  </tr>
            <%}
            }%>
         </table>
      </div>

      <div id="basketTab2" class="tabcontent">
         <table>
            <tr>
               <th>
                  <input type="checkbox" name="" id="allOldCheckBtn" />
               </th>
               <th style="min-width:507px;">제목</th>
               <th style="min-width:52px;">수량</th>
               <th style="min-width:151px;">가격</th>
               <th style="min-width:151px;">비고</th>
            </tr>
            <% for( Basket b : basketList) {%>
               <% if( b.getUsedStatus().equals("Y") && oldCnt < 3) { oldCnt++;%>
            <tr>
               <td>
                  <input class="checkOldBook" type="checkbox" name=""/>
               </td>
               <td>
                  <img src="<%=request.getContextPath() %>/images/<%=b.getBookNo() %>.jpg" alt="" class="oldBookImg"/> <br />
                  <strong><%= b.getBookTitle() %></strong>
                  <input type="hidden" class="bookNo" value="<%=b.getBookNo() %>"/>
                  <input type="hidden" class="bookStatus" value="Y"/>
               </td>
               <td>
                  <input type="number" name="" class="oldBookAmount" min="0" max="1" value="<%=b.getAmount()%>"/>
                  <input type="hidden" name="" class="oBAmount" value="<%=b.getAmount()%>" />
               </td>               
               <td>
                  <label for=""><%=b.getPrice() * b.getAmount() %></label>
                  <span>원</span>
                  <input type="hidden" name="" class="oldBookPrice" value="<%=b.getPrice()%>"/>
               </td>
                  <td>
                     <input type="button" value="삭제" class="deleteOldBookBtn"/>
                  </td>               
            </tr>
            <%}
            }%>
         </table>
      </div>
      
      <div id="buyBasketBook">         
         <table id="orderTable" class="order4">
            <tr>
               <th>상품금액</th>
               <th>배송비</th>
               <th>결제 예정금액</th>
            </tr>
            <tr>
               <td>
                  <span class="price4" id="sumBookPrice4">0</span>
                  <span class="won">원</span> 
                  <img class="price4" src="<%=request.getContextPath()%>/images/plus.png" alt="" />
               </td>      
               <td>
                  <span class="price4" id="delPrice4">2500</span>
                  <span class="won">원</span> 
                  <img class="price4" src="<%=request.getContextPath()%>/images/equal.png" alt="" />
               </td>
               <td>
                  <span class="price4 total4" id="sumTotalPrice4">0</span>
                  <span class="won4 total4">원</span>
               </td>
            </tr>            
         </table>
         
         <input style="float: right; width: 80px; height: 40px; background: red; color: white; border-color: red;" type="button" value="구매" id="allBuyBtn"/>
      </div>
      
      <%} else { %>
         <h1>장바구니에 담긴 책이 없습니다.</h1>
      <%} %>
   </div>
	<form action="<%=request.getContextPath()%>/buy/basketBuyEnd" id="basketBuyEnd">
		<input type="hidden" value="<%=request.getParameter("msg")%>" name="resultCnt"/>
	</form>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
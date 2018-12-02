<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ page import="java.util.*,
				 recommend.model.vo.Recommend" %>
				 
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>

<%
	List<Recommend> list = (List<Recommend>)request.getAttribute("recommendList");	
%>
<style>
#new_book2, input, textarea, select, button, table {
    font-size: 13px;
    font-family: '나눔고딕',NanumGothic,'맑은 고딕',malgun gothic,'돋움',Dotum,'Apple SD Gothic Neo',Helvetica,sans-serif !important;
}

span#searchData2 {
   color: blue;
   font-weight: bold;
   font-size: 30px;
}

img.imgm {
	width: 430px;
	height: 230px;
	border-radius: 50px;
}

table#new_book2 {
   border: 2px solid;
   border-collapse: collapse;
   background-color: lightgray;
   width: 100%;
}
#write11 {
	width: 80px;
    height: 40px;
    color: white;
    background: #303343;
    border-radius: 10px;
    border: 1px solid black;
    cursor: pointer;
    font-size: 15px;
    float: right;
}
</style>

<span id="searchData2">*지식인의 서재</span> 
<% if(memberLoggedIn!=null && "admin".equals(memberLoggedIn.getMember_id())){ %>
   <input type="button" id="write11"value="글 수정" onclick="fn_insertNotice();"/>
   <%} %>
<br />
<hr align="left"; style= "border: solid 4px black;" width: 100%; /> 

<br />
<table id="new_book2">
	<%if(!list.isEmpty())
		for(int i = 0; i<list.size(); i++){ %>
		<tr>
			<th>
			<div class="list_wrap">
				<div class="thumb_area">
					<div class="thumb id5147549">
							<img onerror="this.className='listThumbnail'" data-id="id5147549" class="imgm" src="<%=request.getContextPath()%>/images/library/<%="a"+(i+1)+".jpg" %>"  alt="최규석">
							<span class="mask"></span>
					</div>
				</div>
				<div class="info_area">
					<div class="subject">
						<strong class="title">
						<p> <%= list.get(i).getRecommendTitle()%> </p>
							<a href="http://localhost:9090/book/book/bestSellerEnd?bookNo=<%=list.get(i).getRecommendBookNo() %>" onclick="nclk(this, 'tml.termlist', '', '');">추천도서 - '<%=list.get(i).getRecommendBookTitle() %>'</a>
						</strong>
					</div>
					<p class="" style="overflow: hidden; max-height: 66px; word-wrap: break-word;">
						<%=list.get(i).getRecommendContent() %>
					</p>
				</div>
				<hr>
			</th>
		</tr>
	<%} %>

</table>
<br>
<!-- <div id="btn-write1"> -->
   <% if(memberLoggedIn!=null && "admin".equals(memberLoggedIn.getMember_id())){ %>
 <!--   <input type="button" id="write11"value="글 수정" onclick="fn_insertNotice();"/> -->
   <script>
   function fn_insertNotice(){
      location.href="<%=request.getContextPath()%>/recommend/RecommendModifyServlet";
   }
   </script>
   <%} %>
<!-- </div> -->
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
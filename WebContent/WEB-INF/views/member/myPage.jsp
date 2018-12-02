<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/member/myPageMenu.jsp" %>
<style>
#maincontent1{
	margin-left: 10px;
	margin-top: 10px;
	width:780px; 
	padding-left: 10px;
	display: inline-block;
	/* border: 1px solid red; */
	float: left;
}
#img-container1{
	width: 80px;
	display: inline-block;
	float: left;
}
#myUser1{
	width:60px;
	margin: 10px;
}
#user-container1{
	width: 230px;
	float: left;	
	margin-top: 28px;
}
#delivery-state1{
	border: 1px solid blue;
	display: inline-block;
	float: left;
}
</style>
<%-- <div id="maincontent1">
	<div id="img-container1">
		<img id="myUser1" src="<%=request.getContextPath()%>/images/user.png" alt="" />
	</div>
	<div id="user-container1">
		<span><%=memberLoggedIn.getMember_name() %>님</span>
	</div>
	<br /><br /><br /><br />
	<div id="delivery-state1">
	</div>
</div> --%>
<%@ include file="/WEB-INF/views/order/orderList2.jsp" %>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
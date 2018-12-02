<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.*"%>
<%
	Address address = (Address)request.getAttribute("address");
	//String name = (String)request.getAttribute("memberName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록</title>
<style>
table#popup_addr2 {
	border: 1px solid;
	border-color: #899bdb;
	border-spacing: 0;
	width: 680px;
}

table#popup_addr2 th {
	background: #dee6fd;
	padding: 10px;
}

table#popup_addr2 td {
	text-align: center;
	padding: 5px;
}
div#popup_btn2 {
	text-align: center;
	margin: 10px;
}
div#popup_btn2>input {
	background: #899bdb;
	color: white;
	padding: 5px;
	width: 60px;
	border: 0px;
}
div#popup_btn2>button {
	background: #fff;
	padding: 5px;
	width: 60px;
	border: 1px solid gray;
}
</style>
<script>
function transferValue() {
	var addr = "";
	
	if(document.getElementById("addr1").checked == true)
		addr = document.getElementById("addr1").value;
	else if(document.getElementById("addr2").checked == true)
		addr = document.getElementById("addr2").value;
	else if(document.getElementById("addr3").checked == true)
		addr = document.getElementById("addr3").value;
	else if(document.getElementById("addr4").checked == true)
		addr = document.getElementById("addr4").value;
	
	opener.document.getElementById("sample4_postcode").value=addr.substring(0, addr.indexOf(",")); 
 	opener.document.getElementById("sample4_roadAddress").value=addr.substring(addr.indexOf(",")+1, addr.lastIndexOf(",")); 
 	opener.document.getElementById("sample4_jibunAddress").value=addr.substring(addr.lastIndexOf(",")+1); 
}
</script>
</head>

<body>
	<form action="<%=request.getContextPath()%>/member/addressListEnd">
		<table id="popup_addr2">
			<tr>
				<th>번호</th>
				<th>주소</th>
				<th>선택</th>
			</tr>
			<% if(address.getMember_address1() != null) { %>
			<tr>
				<td>1</td>
				<td><%=address.getMember_address1()%></td>
				<td><input type="radio" name="addr" id="addr1" value="<%=address.getMember_address1()%>" checked/></td>
			</tr>
			
			<% } if(address.getMember_address2() != null) { %>	
			<tr>
				<td>2</td>
				<td><%=address.getMember_address2()%></td>
				<td><input type="radio" name="addr" id="addr2" value="<%=address.getMember_address2()%>"/></td>
			</tr>		
			<% } if(address.getMember_address3() != null) { %>
			<tr>
				<td>3</td>
				<td><%=address.getMember_address3()%></td>
				<td><input type="radio" name="addr" id="addr3" value="<%=address.getMember_address3()%>"/></td>
			</tr>		
			<% } if(address.getMember_address4() != null) { %>
			<tr>
				<td>4</td>
				<td><%=address.getMember_address4()%></td>
				<td><input type="radio" name="addr" id="addr4" value="<%=address.getMember_address4()%>"/></td>
			</tr>		
			<% } %>
		</table>
		<div id="popup_btn2">
			<input type="submit" value="선택" onclick="transferValue(); self.close();"/> 
	        <button type="button" onclick="self.close();">닫기</button>
        </div>
	</form>
</body>
</html>
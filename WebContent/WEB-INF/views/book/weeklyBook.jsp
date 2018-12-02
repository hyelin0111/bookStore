<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
             book.model.vo.Book"%>
<%
   List<Book> weeklyBookList = (List<Book>) request.getAttribute("weeklyBookList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>BestSeller</title>

<style>
* {
   margin: 0;
   padding: 0;
}

ul.wUl, li.wLi {
   list-style: none;
}

#slide {
   width: 100%;
   height: 100%;
   background: gray;
   position: relative;
   overflow: hidden;
}

#slide ul {
   width: 400%;
   height: 100%;
   transition: 1s;
}

#slide ul:after {
   content: "";
   display: block;
   clear: both;
}

#slide li {
   float: left;
   width: 25%;
   height: 100%;
}

#slide li {
   background: white;
}

#slide input {
   display: none;
}

#slide label {
   display: inline-block;
   vertical-align: middle;
   width: 10px;
   height: 10px;
   border: 2px solid #666;
   background: #fff;
   transition: 0.3s;
   border-radius: 50%;
   cursor: pointer;
}

#slide .wPage {
   text-align: center;
   position: absolute;
   bottom: 0px;
   left: 0;
   width: 100%;
   text-align: center;
}

#wPage1:checked ~ul {
   margin-left: 0%;
}

#wPage2:checked ~ul {
   margin-left: -100%;
}

#wPage3:checked ~ul {
   margin-left: -200%;
}

#wPage4:checked ~ul {
   margin-left: -300%;
}

#wPage1:checked ~.wPage>label:nth-child(1) {
   background: #666;
}

#wPage2:checked ~.wPage>label:nth-child(2) {
   background: #666;
}

#wPage3:checked ~.wPage>label:nth-child(3) {
   background: #666;
}

#wPage4:checked ~.wPage>label:nth-child(4) {
   background: #666;
}

.weeklyBooks {
   width: 172px;
   height: 190px;
   border: 1px solid gray;
   margin-top: 20px;
   margin-left: 21px;
   float: left;
   display: inline-block;
   text-align: center;
   background-size: cover;
}

.weeklyBooks:hover {
   box-shadow: 1px 1px 10px gray;
   transform: rotateY(30deg);
}

.weeklyBookFrm {
   width: 100%;
   height: 190px;
}

.wImg4 {
   width: 100px;
   height: 80px;
}
</style>
<script>
   $(document).ready(function() {
      $(".weeklyBookFrm").click(function() {
         $(this).submit();
         console.log(this);
      });
   });
</script>
</head>
<body>
   <div id="slide">
      <input type="radio" name="wPage" id="wPage1" checked> <input
         type="radio" name="wPage" id="wPage2"> <input type="radio"
         name="wPage" id="wPage3"> <input type="radio" name="wPage"
         id="wPage4">

      <ul class="wUl">
         <%
            if (weeklyBookList != null) {
               for (int i = 0; i < weeklyBookList.size(); i++) {
         %>
         <%
            if (i % 5 == 0) {
         %>
         <li class="wLi">
            <%
               }
            %>
            <div class="weeklyBooks"
               style="background-image: url('<%=request.getContextPath()%>/images/<%=weeklyBookList.get(i).getBookNo()%>.jpg');">
               <form class="weeklyBookFrm"
                  action="<%=request.getContextPath()%>/book/weeklyBookEnd"
                  method="get">
                  <input type="text" name="bookNo"
                     value="<%=weeklyBookList.get(i).getBookNo()%>" />
               </form>
            </div> <%
    if (i % 5 == 4) {
 %>
         </li>
         <%
            }
               }
            }
         %>
      </ul>

      <p class="wPage">
         <label for="wPage1"></label> <label for="wPage2"></label> <label
            for="wPage3"></label> <label for="wPage4"></label>
      </p>
   </div>
</html>
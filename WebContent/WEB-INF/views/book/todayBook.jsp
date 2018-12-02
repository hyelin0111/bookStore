<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
             book.model.vo.Book"%>
<%
   List<Book> todayBookList = (List<Book>) request.getAttribute("todayBookList");
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

ul.tUl, li.tLi {
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

#slide .tPage {
   text-align: center;
   position: absolute;
   bottom: 0px;
   left: 0;
   width: 100%;
   text-align: center;
}

#tPage1:checked ~ul {
   margin-left: 0%;
}

#tPage2:checked ~ul {
   margin-left: -100%;
}

#tPage3:checked ~ul {
   margin-left: -200%;
}

#tPage4:checked ~ul {
   margin-left: -300%;
}

#tPage1:checked ~.tPage>label:nth-child(1) {
   background: #666;
}

#tPage2:checked ~.tPage>label:nth-child(2) {
   background: #666;
}

#tPage3:checked ~.tPage>label:nth-child(3) {
   background: #666;
}

#tPage4:checked ~.tPage>label:nth-child(4) {
   background: #666;
}

.todayBooks {
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

.todayBooks:hover {
   box-shadow: 1px 1px 10px gray;
   transform: rotateY(30deg);
}

.todayBookFrm {
   width: 100%;
   height: 190px;
}

.tImg4 {
   width: 100px;
   height: 80px;
}
</style>
<script>
   $(document).ready(function() {
      $(".todayBookFrm").click(function() {
         $(this).submit();
         console.log(this);
      });
   });
</script>
</head>
<body>
   <div id="slide">
      <input type="radio" name="tPage" id="tPage1" checked> <input
         type="radio" name="tPage" id="tPage2"> <input type="radio"
         name="tPage" id="tPage3"> <input type="radio" name="tPage"
         id="tPage4">

      <ul class="tUl">
         <%
            if (todayBookList != null) {
               for (int i = 0; i < todayBookList.size(); i++) {
         %>
         <%
            if (i % 5 == 0) {
         %>
         <li class="tLi">
            <%
               }
            %>
            <div class="todayBooks"
               style="background-image: url('<%=request.getContextPath()%>/images/<%=todayBookList.get(i).getBookNo()%>.jpg');">
               <form class="todayBookFrm"
                  action="<%=request.getContextPath()%>/book/todayBookEnd"
                  method="get">
                  <input type="text" name="bookNo"
                     value="<%=todayBookList.get(i).getBookNo()%>" />
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

      <p class="tPage">
         <label for="tPage1"></label> <label for="tPage2"></label> <label
            for="tPage3"></label> <label for="tPage4"></label>
      </p>
   </div>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
             book.model.vo.Book"%>
<%
   List<Book> bestSellerList = (List<Book>) request.getAttribute("bestSellerList");
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

ul.bUl, li.bLi {
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

#slide .bPage {
   text-align: center;
   position: absolute;
   bottom: 0px;
   left: 0;
   width: 100%;
   text-align: center;
}

#bPage1:checked ~ul{
   margin-left: 0%;
}

#bPage2:checked ~ul{
   margin-left: -100%;
}

#bPage3:checked ~ul{
   margin-left: -200%;
}

#bPage4:checked ~ul{
   margin-left: -300%;
}

#bPage1:checked ~.bPage>label:nth-child(1) {
   background: #666;
}

#bPage2:checked ~.bPage>label:nth-child(2) {
   background: #666;
}

#bPage3:checked ~.bPage>label:nth-child(3) {
   background: #666;
}

#bPage4:checked ~.bPage>label:nth-child(4) {
   background: #666;
}

.bestBooks {
   width: 172px;
   height: 190px;
   border: 1px solid gray;
   margin-top: 20px;
   margin-left: 21px;
   float: left;
   display: inline-block;
   color: white;
   text-align: center;
   background-size: cover;
}

.bestBooks:hover {
   box-shadow: 1px 1px 10px gray;
   transform: rotateY(30deg);
}

.bestBookFrm {
   width: 100%;
   height: 190px;
}
</style>
<script>
   $(document).ready(function() {
      $(".bestBookFrm").click(function() {
         $(this).submit();
         console.log(this);
      });
   });
</script>
</head>
<body>
   <div id="slide">
      <input type="radio" name="bPage" id="bPage1" checked> <input
         type="radio" name="bPage" id="bPage2"> <input type="radio"
         name="bPage" id="bPage3"> <input type="radio" name="bPage"
         id="bPage4">

      <ul class="bUl">
         <%
            if (bestSellerList != null) {
               for (int i = 0; i < bestSellerList.size(); i++) {
         %>
         <%
            if (i % 5 == 0) {
         %>
         <li class="bLi">
            <%
               }
            %>
            <div class="bestBooks"
               style="background-image: url('<%=request.getContextPath()%>/images/<%=bestSellerList.get(i).getBookNo()%>.jpg');">
               <form class="bestBookFrm"
                  action="<%=request.getContextPath()%>/book/bestSellerEnd"
                  method="get">
                  <input type="text" name="bookNo"
                     value="<%=bestSellerList.get(i).getBookNo()%>" />
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

      <p class="bPage">
         <label for="bPage1"></label> <label for="bPage2"></label> <label
            for="bPage3"></label> <label for="bPage4"></label>
      </p>
   </div>
</html>
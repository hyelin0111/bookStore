/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2018-05-16 04:54:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import book.model.vo.Book;
import review.model.vo.Review;
import java.util.*;
import member.model.vo.*;

public final class bookListView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1526343536000L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1525827172000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("member.model.vo");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("book.model.vo.Book");
    _jspx_imports_classes.add("review.model.vo.Review");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write(" \r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-3.3.1.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("* {\r\n");
      out.write("   user-select: none;    \r\n");
      out.write("}\r\n");
      out.write("img.book2 {width: 100px;height: 120px;border: 1px solid;}\r\n");
      out.write("nav#search_nav2 {background: #eaeaea;width: 100%;height: 30px;\r\n");
      out.write("/*    border: 1px solid;\r\n");
      out.write("   border-bottom: 1px solid gray; */\r\n");
      out.write("   text-align: left;\r\n");
      out.write("   /* padding-left: 5px; */\r\n");
      out.write("}\r\n");
      out.write("nav#search_nav2 a {\r\n");
      out.write("   text-decoration: none;\r\n");
      out.write("   color: black;\r\n");
      out.write("   vertical-align: middle;\r\n");
      out.write("   padding: 5px;\r\n");
      out.write("   font-weight: normal;\r\n");
      out.write("}\r\n");
      out.write("span.sep2 {\r\n");
      out.write("   color: gray;\r\n");
      out.write("}\r\n");
      out.write("nav#search_nav2 a:hover, nav#search_nav2 a:focus {\r\n");
      out.write("   font-weight: bold;\r\n");
      out.write("   text-decoration: underline;\r\n");
      out.write("}\r\n");
      out.write("span#searchData2 {\r\n");
      out.write("   color: blue;\r\n");
      out.write("   font-weight: bold;\r\n");
      out.write("   font-size: 20px;\r\n");
      out.write("}\r\n");
      out.write("table#new_book2, table#old_book2 {\r\n");
      out.write("   border: 1px solid;\r\n");
      out.write("   border-collapse: collapse;\r\n");
      out.write("   width: 100%;\r\n");
      out.write("   /* margin-top: 10px; */\r\n");
      out.write("}\r\n");
      out.write("table td {\r\n");
      out.write("   vertical-align: middle;\r\n");
      out.write("   padding: 10px;\r\n");
      out.write("}\r\n");
      out.write("table td.book_name2 {\r\n");
      out.write("   text-align: left;\r\n");
      out.write("   width: 42%;\r\n");
      out.write("}\r\n");
      out.write("table td.book_img2 {\r\n");
      out.write("   width: 120px;\r\n");
      out.write("}\r\n");
      out.write("span.bookname2 {\r\n");
      out.write("   color: blue;\r\n");
      out.write("   font-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("span.category2 {\r\n");
      out.write("   font-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("span.etc2, span.seller2 {\r\n");
      out.write("   font-size: 13px;\r\n");
      out.write("}\r\n");
      out.write("input#count2 {\r\n");
      out.write("   width: 33px;\r\n");
      out.write("}\r\n");
      out.write("input[type=button].btn2 {\r\n");
      out.write("   margin: 2px;\r\n");
      out.write("   width: 100px;\r\n");
      out.write("   background: white;\r\n");
      out.write("   border-color: #899bdb;\r\n");
      out.write("   padding: 5px;\r\n");
      out.write("}\r\n");
      out.write("input[type=button].btn2:hover, input[type=button].btn2:focus {\r\n");
      out.write("   background: #899bdb;\r\n");
      out.write("   color: white;\r\n");
      out.write("}\r\n");
      out.write("input[type=button].btn3 {\r\n");
      out.write("   margin: 2px;\r\n");
      out.write("   width: 100px;\r\n");
      out.write("   background: white;\r\n");
      out.write("   border-color: tomato;\r\n");
      out.write("   padding: 5px;\r\n");
      out.write("   float: right; \r\n");
      out.write("   margin-right: 55px;\r\n");
      out.write("}\r\n");
      out.write("input[type=button].btn3:hover, input[type=button].btn3:focus {\r\n");
      out.write("   background: tomato;\r\n");
      out.write("   color: white;\r\n");
      out.write("}\r\n");
      out.write("a {\r\n");
      out.write("   text-decoration: none;\r\n");
      out.write("   color: black;\r\n");
      out.write("}\r\n");
      out.write("a:hover {\r\n");
      out.write("   text-decoration: underline;\r\n");
      out.write("   font-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("img#review2 {\r\n");
      out.write("   width: 15px;\r\n");
      out.write("   height: 15px;\r\n");
      out.write("   border: 0px;\r\n");
      out.write("}\r\n");
      out.write("td.price2 {\r\n");
      out.write("   text-align: right;\r\n");
      out.write("}\r\n");
      out.write("span.origin2 {\r\n");
      out.write("   font-size: 14px;\r\n");
      out.write("   text-decoration: line-through;\r\n");
      out.write("}\r\n");
      out.write("span.discount2 {\r\n");
      out.write("   color: red;\r\n");
      out.write("   font-weight: bold;\r\n");
      out.write("   font-size: 16px;\r\n");
      out.write("}\r\n");
      out.write("span.grade2 {\r\n");
      out.write("   font-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("div#pageBar2{ margin-top: 10px; text-align: center; background: #899bdb; }\r\n");
      out.write("div#pageBar2 span { margin: 0 5px; }\r\n");
      out.write("header div#search-container5{\r\n");
      out.write("\tposition:relative;\r\n");
      out.write("\twidth: 650px;\r\n");
      out.write("\tmargin: 5px auto;\r\n");
      out.write("\tmargin-bottom: 15px;\r\n");
      out.write("}\r\n");
      out.write("#searchType1_5{\r\n");
      out.write("\twidth:75px;\r\n");
      out.write("\theight:30px;\r\n");
      out.write("\tpadding-left: 2px;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("\tborder-radius: 6px;\r\n");
      out.write("\tmargin-top: 5px;\r\n");
      out.write("\tmargin-right: 5px;\r\n");
      out.write("\tcursor:pointer;\r\n");
      out.write("}\r\n");
      out.write("#search-book1_5{\r\n");
      out.write("\twidth:500px;\r\n");
      out.write("\theight:30px;\r\n");
      out.write("\tborder-radius: 6px;\r\n");
      out.write("   \tborder: 1px solid black;\r\n");
      out.write("   \tpadding-right: 0px;\r\n");
      out.write("   \tdisplay: inline;\r\n");
      out.write("}\r\n");
      out.write("#search1_5{\r\n");
      out.write("\tdisplay: inline;\r\n");
      out.write("\tborder: 1px;\r\n");
      out.write("\twidth:40px;\r\n");
      out.write("\theight: 32px;\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("\tborder-radius: 6px;\r\n");
      out.write("\tbackground: #303343;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tcursor:pointer;\r\n");
      out.write("}\r\n");
      out.write(".search-container5{\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");

	List<Book> list = (List<Book>)request.getAttribute("booklist");
	//String type = (String)request.getAttribute("type");
	//String searchBook = request.getParameter("searchBook"); 

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
	//System.out.println(memberLoggedIn);
	
	//클라이언트가 보낸 쿠키처리(쿠키관련)
	Cookie[] cookies = request.getCookies();
	boolean saveId = false;
	String userIdSaved = "";
	
	//최초접속시 cookie는 null임.
	if(cookies != null){
	//	System.out.println("------------------------------------");
	//	System.out.println("브라우져가 전송한 쿠키목록");
	//	System.out.println("------------------------------------");
		for(Cookie c : cookies){
			String key = c.getName();
			String value = c.getValue();
	//		System.out.println(key+" : "+value);
			//아이디저장 쿠키검사
			if("saveId".equals(key)){
				saveId = true;
				userIdSaved = value;
			}
		}
	//	System.out.println("------------------------------------");
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/style.css\" />\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Gugi\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-3.3.1.js\"></script>\r\n");
      out.write("<title>Book</title>\r\n");
      out.write("<script>\r\n");
      out.write("//메뉴상단에 고정하기.(스크롤 내려도)\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("\tvar jbOffset = $( '.fixed-search1' ).offset();\r\n");
      out.write("\t$( '.fixed-search1' ).removeClass( 'jbFixed').css(\"display\",\"none\");\r\n");
      out.write("\t$( window ).scroll( function() {\r\n");
      out.write("\t\tif ( $( document ).scrollTop() > jbOffset.top ) {\r\n");
      out.write("\t\t\t$( '.fixed-search1' ).addClass( 'jbFixed' ).css(\"display\",\"inline\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse {\r\n");
      out.write("\t\t\t$( '.fixed-search1' ).removeClass( 'jbFixed').css(\"display\",\"none\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("function fn_loginValidate(){\r\n");
      out.write("\t//아이디 검사\r\n");
      out.write("\tif($(\"#userId1\").val().trim().length==0){\r\n");
      out.write("\t\talert(\"아이디를 입력하세요.\");\r\n");
      out.write("\t\t$(\"#userId1\").focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t//패스워드 검사\r\n");
      out.write("\tif($(\"#password1\").val().trim().length==0){\r\n");
      out.write("\t\talert(\"비밀번호를 입력하세요.\");\r\n");
      out.write("\t\t$(\"#password1\").focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\tvar cnt = 0;\r\n");
      out.write("\t$(\"#user1\").click(function(){\r\n");
      out.write("\t\tcnt++;\r\n");
      out.write("\t\tif(cnt%2==1){\r\n");
      out.write("\t\t\t$(\"#bubble1\").css(\"display\",\"inline-block\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse{\r\n");
      out.write("\t\t\t$(\"#bubble1\").css(\"display\",\"none\");\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"container1\">\r\n");
      out.write("\t<header>\r\n");
      out.write("\t\t<div id=\"title1\"><a href=\"");
      out.print(request.getContextPath());
      out.write("\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/images/logo.png\" alt=\"logo\" id=\"img-title1\"></a></div>\r\n");
      out.write("\t\t\t<!-- 검색바 -->\r\n");
      out.write("\t\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/search/searchBook\" onsubmit=\"return fn_searchBook_byteCheck();\">\r\n");
      out.write("\t\t\t<div id=\"search-container1\">\r\n");
      out.write("\t\t\t<select name=\"searchType\" id =\"searchType1_1\">\r\n");
      out.write("\t\t\t\t<option value=\"all\" class=\"all-search\">통합검색</option>\r\n");
      out.write("\t\t\t\t<option value=\"title\" class=\"title-search\">책제목</option>\r\n");
      out.write("\t\t\t\t<option value=\"writer\" class=\"writer-search\">저자명</option>\r\n");
      out.write("\t\t\t\t<option value=\"publisher\" class=\"publisher-search\">출판사명</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"searchBook\" id=\"search-book1_1\" placeholder=\"검색명을 입력하세요.\" />\r\n");
      out.write("\t\t\t<input type=\"submit\" id=\"search1_1\" value=\"검색\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\tfunction fn_searchBook_byteCheck() {\r\n");
      out.write("\t\t\tif($(\"#search-book1_1\").val().trim() == 0) {\r\n");
      out.write("\t\t\t\talert(\"검색어를 입력하세요\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<!-- 로그인 시작 -->\r\n");
      out.write("\t\t<div class=\"login-container1\">\r\n");
      out.write("\t\t");
 if(memberLoggedIn ==null){
      out.write("\r\n");
      out.write("\t\t\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/member/login\" id=\"loginFrm1\" method=\"post\" onsubmit=\"return fn_loginValidate();\">\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"id\" id=\"userId1\" placeholder=\"아이디\" value=\"");
      out.print(saveId?userIdSaved:"");
      out.write("\"/> </td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"password\" name=\"password\" id=\"password1\" placeholder=\"비밀번호\"/></td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"submit\" value=\"로그인\" /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"saveId\" id=\"saveId1\"");
      out.print(saveId?"checked":"");
      out.write("/>\r\n");
      out.write("\t\t\t\t\t\t\t<label id=\"saveId1\" for=\"saveId\">아이디저장</label>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" id=\"join1\" value=\"회원가입\" onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/member/chooseEnroll'\"/>     \r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"logged-container1\">\r\n");
      out.write("\t\t\t\t\t<div id=\"logged1\">\r\n");
      out.write("\t\t\t\t\t\t<img id=\"user1\" alt=\"user.png\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/user.png\">\r\n");
      out.write("\t\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t\t<span id=\"logged-name1\">");
      out.print(memberLoggedIn.getMember_name() );
      out.write("님</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"bubble1\" style=\"position:relative; dispaly:none;\">\r\n");
      out.write("\t\t\t\t\t\t<input id=\"mpage1\" type=\"button\" value=\"마이페이지\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/member/myPage';\"/>\r\n");
      out.write("\t\t\t\t\t\t<!-- ?member_id= ");
      out.print(memberLoggedIn.getMember_id());
      out.write(" -->\r\n");
      out.write("\t\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t\t<input id=\"basket1\"type=\"button\" value=\"장바구니\" />\r\n");
      out.write("\t\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t\t<input id=\"log-out1\" type=\"button\" value=\"로그아웃\" onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/member/logout'\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 로그인 끝 -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!-- 메인메뉴시작 -->\r\n");
      out.write("\t\t<nav class=\"fix-nav1\">\r\n");
      out.write("\t\t\t<ul class=\"main-nav1\">\r\n");
      out.write("\t           <li class=\"book-list\"><a href=\"#\">도서</a></li>\r\n");
      out.write("\t           <li id=\"jiseojae\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/recommend/RecommenListServlet\">지서재</a></li>\r\n");
      out.write("\t           <li id=\"used-book\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/oldboard/OldBoardServlet\">중고장터</a></li>\r\n");
      out.write("\t           <li id=\"notice\"><a href=\"#\">공지사항</a></li>\r\n");
      out.write("\t           ");
      out.write("\r\n");
      out.write("\t           ");
if(memberLoggedIn != null && "admin".equals(memberLoggedIn.getMember_id())){ 
      out.write("\r\n");
      out.write("\t           <li id=\"ad-member3\"><a href=\"#\">회원관리</a></li>\r\n");
      out.write("\t            <li id=\"ad-book3\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/book/bookListView\">도서관리</a></li>\r\n");
      out.write("\t           ");
} 
      out.write("\r\n");
      out.write("         \t</ul>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t\t<!-- 메인메뉴 끝 -->\r\n");
      out.write("\t\t<!-- 상단에 고정될 검색창  -->\r\n");
      out.write("\t\t<div id=\"fixed-search-container1\" class=\"fixed-search1\">\r\n");
      out.write("\t\t<img id = \"slogo1\"src=\"");
      out.print(request.getContextPath());
      out.write("/images/small-logo.png\" alt=\"logo\" height=\"40\" width=\"70\"  style=\"vertical-align: middle\">\r\n");
      out.write("\t\t\t<select name=\"searchType1\" id =\"searchType2_1\" style=\"vertical-align: middle\">\r\n");
      out.write("\t\t\t\t<option value=\"search-all1\" >통합검색</option>\r\n");
      out.write("\t\t\t\t<option value=\"title1\" >책제목</option>\r\n");
      out.write("\t\t\t\t<option value=\"writer1\">저자명</option>\r\n");
      out.write("\t\t\t\t<option value=\"publisher1\">출판사명</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t<input type=\"text\" id=\"search-book2_1\" placeholder=\"검색명을 입력하세요.\" style=\"vertical-align: middle\"/>\r\n");
      out.write("\t\t\t<input type=\"submit\" id=\"search2_1\" value=\"검색\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<section id=\"content1\">\r\n");
      out.write("\r\n");
      out.write("<span id=\"searchData2\">도서 관리</span><br />\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath());
      out.write("/admin/searchBook\" onsubmit=\"return fn_searchBook_byteCheck5();\">\r\n");
      out.write("\t<div class=\"search-container5\">\r\n");
      out.write("\t\t<div id=\"search-container5\">\r\n");
      out.write("\t\t\t<select name=\"searchType5\" id =\"searchType1_5\">\r\n");
      out.write("\t\t\t\t<option value=\"all\" class=\"all-search5\">통합검색</option>\r\n");
      out.write("\t\t\t\t<option value=\"title\" class=\"title-search5\">책제목</option>\r\n");
      out.write("\t\t\t\t<option value=\"writer\" class=\"writer-search5\">저자명</option>\r\n");
      out.write("\t\t\t\t<option value=\"publisher\" class=\"publisher-search5\">출판사명</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"searchBook5\" id=\"search-book1_5\" placeholder=\"등록 도서 검색 \" />\r\n");
      out.write("\t\t\t<input type=\"submit\" id=\"search1_5\" value=\"검색\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</form>\r\n");
      out.write("<hr /> <br />\r\n");
      out.write("<table id=\"new_book2\">\r\n");
      out.write("   <tr>\r\n");
      out.write("      <th colspan=\"6\">\r\n");
      out.write("         <nav id=\"search_nav2\">\r\n");
      out.write("            <!-- <a href=\"#\">정확도</a><span class=\"sep\"> | </span> -->\r\n");
      out.write("            <a href=\"#\">판매량</a><span class=\"sep\"> | </span>\r\n");
      out.write("            <!-- <a href=\"#\">신상품</a><span class=\"sep\"> | </span> -->\r\n");
      out.write("            <a href=\"#\">상품명</a><span class=\"sep\"> | </span>\r\n");
      out.write("            <a href=\"#\">낮은가격</a><span class=\"sep\"> | </span>\r\n");
      out.write("            <a href=\"#\">높은가격</a><span class=\"sep\"> | </span>\r\n");
      out.write("            <!-- <a href=\"#\">할인률</a><span class=\"sep\"> | </span> -->\r\n");
      out.write("            <a href=\"#\">리뷰수</a>\r\n");
      out.write("            <input type=\"button\" value=\"도서 추가\" onclick=\"fn_insertBook()\" class=\"btn3\"/> \r\n");
      out.write("         </nav>\r\n");
      out.write("      </th>\r\n");
      out.write("   </tr>\r\n");
      out.write("   \r\n");
      out.write("   ");
if(list == null || list.isEmpty()) { 
      out.write("\r\n");
      out.write("   <tr>\r\n");
      out.write("   \t\t<td colspan=\"6\">데이터가 존재하지 않습니다.</td>\r\n");
      out.write("   </tr>\r\n");
      out.write("   ");
} else { 
   		for(Book b : list) {
   
      out.write("\r\n");
      out.write("   <tr>\r\n");
      out.write("      <td class=\"book_img2\">\r\n");
      out.write("         <img class=\"book2\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/");
      out.print(b.getBookNo());
      out.write(".jpg\" alt=\"book_image\" onerror=\"javascript:this.src='");
      out.print(request.getContextPath());
      out.write("/images/blank.png'\"/>\r\n");
      out.write("      </td>\r\n");
      out.write("      <td id=\"bookname2\">\r\n");
      out.write("         <span class=\"category2\">[");
      out.print(b.getCategory());
      out.write("]</span> <span class=\"bookname2\"><a href=\"#\">");
      out.print(b.getBookTitle() );
      out.write("</a></span> <br /><br />\r\n");
      out.write("         <span class=\"etc2\"><a href=\"#\">");
      out.print(b.getAuthorName() );
      out.write("</a> | <a href=\"#\">");
      out.print(b.getBookPublisher() );
      out.write("</a> | ");
      out.print(b.getIssueDate() );
      out.write("</span>  \r\n");
      out.write("      </td>\r\n");
      out.write("      <td>");
      out.print(b.getBookSaleQty() );
      out.write("권</td>\r\n");
      out.write("      <td>");
      out.print(b.getBookPrice());
      out.write("원</td>\r\n");
      out.write("      <td>\r\n");
      out.write("         \t");
      out.print(b.getBookGrade() );
      out.write("점\r\n");
      out.write("      </td>\r\n");
      out.write("      <td>\r\n");
      out.write("         <input class=\"btn2\" type=\"button\" value=\"정보보기\" onclick=\"fn_BookOneInfo('");
      out.print(b.getBookTitle() );
      out.write("', '");
      out.print(b.getBookNo() );
      out.write("')\" />\r\n");
      out.write("      </td>\r\n");
      out.write("   </tr>\r\n");
      out.write("   ");
} 
   }
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("<script>\r\n");
      out.write("function fn_BookOneInfo(title, bookNo){\r\n");
      out.write("\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/book/BookOneInfo?title=\"+title+\"&bookNo=\"+bookNo+\"\";\r\n");
      out.write("}\r\n");
      out.write("function fn_insertBook(){\r\n");
      out.write("\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/admin/BookAdminInsert\";\r\n");
      out.write("}\r\n");
      out.write("function fn_searchBook_byteCheck5(){\r\n");
      out.write("\tif($(\"#search-book1_5\").val().trim() == 0) {\r\n");
      out.write("\t\talert(\"검색어를 입력하세요\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<br /><br /><br />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"pageBar2\">");
      out.print(request.getAttribute("pageBar5"));
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</section>\r\n");
      out.write("\t\t<footer>\r\n");
      out.write("\t\t\t<p>&lt;Copyright 2018. <strong>영중문고</strong>. All rights reserved.&gt;</p>\r\n");
      out.write("\t\t\t<p>주소 : 서울특별시 강남구 테헤란로14길 6 남도빌딩 2F, 3F</p>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

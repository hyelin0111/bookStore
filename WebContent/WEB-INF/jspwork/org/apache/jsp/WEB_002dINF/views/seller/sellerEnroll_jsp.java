/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2018-05-17 06:35:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.seller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.*;

public final class sellerEnroll_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1526538809053L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1525827172000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("member.model.vo");
    _jspx_imports_classes = null;
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

      out.write('\r');
      out.write('\n');
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
      out.write("$(function(){\r\n");
      out.write("\t   $(\"#basket1\").click(function(){      \r\n");
      out.write("\t      ");
if( memberLoggedIn != null ) {
      out.write("\r\n");
      out.write("\t         var memberNo = ");
      out.print(memberLoggedIn.getMember_no());
      out.write(";\r\n");
      out.write("\t      ");
}
      out.write("\r\n");
      out.write("\t         \r\n");
      out.write("\t      location.href=\"");
      out.print(request.getContextPath());
      out.write("/basket/basketServlet?memberNo=\" + memberNo;\r\n");
      out.write("\t   });\r\n");
      out.write("\t});\r\n");
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
      out.write("\t\t\t\t\t\t<input id=\"seller1Enroll1\" type=\"button\" value=\"판매자가입\"  onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/seller/sellerEnroll?member_no=");
      out.print(memberLoggedIn.getMember_no());
      out.write("'\"/>\r\n");
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
      out.write("\t\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/search/searchBook\" onsubmit=\"return fn_searchBook_byteCheck();\">\r\n");
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
      out.write("\t\t</form>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<section id=\"content1\">\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("  \r\n");
      out.write(".d-ta3 th,td{\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("}\r\n");
      out.write(".d-ta3{ \r\n");
      out.write("\tborder-collapse:collapse; \r\n");
      out.write("\tfont-size:12pt; \r\n");
      out.write("\tborder:1px solid black;\r\n");
      out.write("\tmargin:auto;\r\n");
      out.write("\twidth:760px;\r\n");
      out.write("}  \r\n");
      out.write(".d-ta31{\r\n");
      out.write("\tborder-collapse:collapse; \r\n");
      out.write("\tfont-size:12pt; \r\n");
      out.write("\tborder:1px solid black;\r\n");
      out.write("\tmargin:auto;\r\n");
      out.write("\twidth:760px;\r\n");
      out.write("}\r\n");
      out.write(".btn_area1{\r\n");
      out.write("\twidth: 230px;\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("\tmargin-top:10px;\r\n");
      out.write("}\r\n");
      out.write("#sel-submit1{\r\n");
      out.write("\twidth:100px; \r\n");
      out.write("\theight:50px; \r\n");
      out.write("\tcolor:white; \r\n");
      out.write("\tbackground:#303343;\r\n");
      out.write("\tborder-radius: 15px;\r\n");
      out.write("\tborder:1px solid black;\r\n");
      out.write("\tcursor:pointer;\r\n");
      out.write("\tfont-size: 15px;\r\n");
      out.write("}\r\n");
      out.write("#sel-cancel1{\r\n");
      out.write("\twidth:100px; \r\n");
      out.write("\theight:50px;\r\n");
      out.write("\tcolor:white; \r\n");
      out.write("\tbackground:#303343;\r\n");
      out.write("\tborder-radius: 15px;\r\n");
      out.write("\tborder:1px solid black;\r\n");
      out.write("\tcursor:pointer;\r\n");
      out.write("\tfont-size: 15px;\r\n");
      out.write("\tmargin-left:20px\r\n");
      out.write("}\r\n");
      out.write("#sel-submit1:hover{\r\n");
      out.write("\tborder:1px solid black;\r\n");
      out.write("\tbackground: white;\r\n");
      out.write("\tcolor: #303343;\r\n");
      out.write("}\r\n");
      out.write("#sel-cancel1:hover{\r\n");
      out.write("\tborder:1px solid black;\r\n");
      out.write("\tbackground: white;\r\n");
      out.write("\tcolor: #303343;\r\n");
      out.write("}\r\n");
      out.write("#line3{\r\n");
      out.write("\tborder: 1px dashed #696a70;\r\n");
      out.write("}\r\n");
      out.write(".seller-nickname1{\r\n");
      out.write("\tmargin-top:0px;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("#title3{\r\n");
      out.write("\tbackground-color : #303343;\r\n");
      out.write("\tcolor:white;\r\n");
      out.write("\tpadding-left: 15px; \r\n");
      out.write("}\r\n");
      out.write("#t-content3{\r\n");
      out.write("\tpadding-left: 15px;\r\n");
      out.write("}\r\n");
      out.write(".btn2{\r\n");
      out.write("\twidth:110px; \r\n");
      out.write("\theight:25px;\r\n");
      out.write("\tcolor:white; \r\n");
      out.write("\tbackground:#303343;\r\n");
      out.write("\tborder-radius: 5px;\r\n");
      out.write("\tborder:1px solid black;\r\n");
      out.write("\tcursor:pointer;\r\n");
      out.write("\tfont-size: 15px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("#sellernick1{\r\n");
      out.write("\tmargin-top:15px;\r\n");
      out.write("}\r\n");
      out.write("</style> \r\n");
      out.write("\r\n");
      out.write("<h2 id= \"th2_1\">기본정보</h2>\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath() );
      out.write("/seller/sellerEnrollEnd?member_no=");
      out.print(memberLoggedIn.getMember_no() );
      out.write("\" method=\"post\" name=\"frm1\" > \r\n");
      out.write("<table class=\"d-ta31\">\r\n");
      out.write(" \t<tr height=\"60\">\r\n");
      out.write(" \t\t<td id=\"title3\" >아이디</td>\r\n");
      out.write("\t\t<td id=\"t-content3\">  \r\n");
      out.write("\t  \t\t<input type=\"text\" name=\"selId1\" size=\"2\" id=\"selId\" value=\"");
      out.print(memberLoggedIn.getMember_id() );
      out.write("\" readonly/>\r\n");
      out.write("\t \t</td>\r\n");
      out.write("\t \t<td id=\"title3\">회원명</td>\r\n");
      out.write("\t \t<td id=\"t-content3\">\r\n");
      out.write("\t  \t\t<input type=\"text\" name=\"selName\" size=\"4\" id=\"selName\" value=\"");
      out.print(memberLoggedIn.getMember_name() );
      out.write("\" readonly/>\r\n");
      out.write("\t \t</td>\r\n");
      out.write(" \t</tr>\r\n");
      out.write(" \t<tr height=\"50\">\r\n");
      out.write(" \t\t<td id=\"title3\">판매자 닉네임</td>\r\n");
      out.write("\t\t<td id=\"t-content3\">\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"sellernick1\" id=\"sellernick1\" placeholder=\"닉네임을 입력하세요.\"/>\r\n");
      out.write("\t\t\t<p class=\"seller-nickname1\">한글, 영문, 숫자 10자 이내</p>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td id=\"title3\">휴대폰 번호</td>\r\n");
      out.write("\t\t<td id=\"t-content3\"><input type=\"tel\" name=\"sel-phone1\" id=\"sel-phone1\" value=\"");
      out.print(memberLoggedIn.getMember_phone());
      out.write("\"/></td>\r\n");
      out.write(" \t</tr>\r\n");
      out.write(" \t<tr height=\"50\">\r\n");
      out.write(" \t\t<td id=\"title3\">이메일</td>\r\n");
      out.write("\t\t<td colspan=\"3\" id=\"t-content3\">\r\n");
      out.write("\t\t\t<input type=\"email\" name=\"sel-email1\" id=\"sel-email1\" value=\"");
      out.print(memberLoggedIn.getMember_email());
      out.write("\" />\r\n");
      out.write("\t\t</td>\r\n");
      out.write(" \t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<br>\r\n");
      out.write("<hr id=\"line3\" />\r\n");
      out.write("<h2 class=\"h2_3\">배송정보</h2>\r\n");
      out.write("<table class=\"d-ta3\">\r\n");
      out.write(" \t<tr height=\"60\">\r\n");
      out.write(" \t\t<td id=\"title3\">배송방법</td>\r\n");
      out.write("\t\t<td width=\"600\" id=\"t-content3\">  \r\n");
      out.write("\t  \t\t<input type=\"radio\" name=\"pdel1\" id=\"\" value =\"P\"checked/><span>개인택배 이용 </span> <br />\r\n");
      out.write("\t  \t\t<input type=\"radio\" name=\"\" id=\"\" disabled/><span>영중문고 계약택배 이용(현재 이용불가..)</span>\r\n");
      out.write("\t \t</td>\r\n");
      out.write(" \t</tr>\r\n");
      out.write(" \t<tr height=\"50\">\r\n");
      out.write(" \t\t<td id=\"title3\">계좌번호</td>\r\n");
      out.write("\t\t<td id=\"t-content3\">\r\n");
      out.write("\t\t\t<select name =\"bank1\">\r\n");
      out.write("\t\t\t  <option value=\"국민은행\" selected>국민은행</option>\r\n");
      out.write("\t\t\t  <option value=\"우리은행\">우리은행</option>\r\n");
      out.write("\t\t\t  <option value=\"신한은행\">신한은행</option>\r\n");
      out.write("\t\t\t  <option value=\"하나은행\">하나은행</option>\r\n");
      out.write("\t\t\t  <option value=\"기업은행\">기업은행</option>\r\n");
      out.write("\t\t\t  <option value=\"농협\">농협</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"sel-account1\" id=\"sel-account1\" />\r\n");
      out.write("\t\t</td>\r\n");
      out.write(" \t</tr>\r\n");
      out.write(" \t<tr height=\"50\">\r\n");
      out.write(" \t\t<td id=\"title3\">배송비</td>\r\n");
      out.write("\t\t<td id=\"t-content3\">\r\n");
      out.write("\t\t\t<input type=\"number\" name=\"del-price1\" id=\"del-price1\" value=\"0\" placeholder=\"2500\" max=\"9999\"/>원\r\n");
      out.write("\t\t</td>\r\n");
      out.write(" \t</tr>\r\n");
      out.write(" \t<tr height=\"50\">\r\n");
      out.write(" \t\t<td id=\"title3\">도서지역 배송비</td>\r\n");
      out.write("\t\t<td id=\"t-content3\">\r\n");
      out.write("\t\t\t<input type=\"number\" name=\"del-iprice1\" id=\"del-iprice1\" value=\"0\"/>원\r\n");
      out.write("\t\t</td>\r\n");
      out.write(" \t</tr>\r\n");
      out.write("\t<tr height=\"40\">\r\n");
      out.write("\t\t<td id=\"title3\">\r\n");
      out.write("\t\t\t배송출고지\r\n");
      out.write("\t\t<td id=\"t-content3\">\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"postnum\" id=\"sample4_postcode\" placeholder=\"우편번호\"> \r\n");
      out.write("            <input type=\"button\" class=\"btn2\" onclick=\"sample4_execDaumPostcode()\" value=\"우편번호 찾기\"><br>\r\n");
      out.write("        \t<input type=\"text\" name=\"address1\" id=\"sample4_roadAddress\" placeholder=\"도로명주소\" size=\"35px\"> <br /> \r\n");
      out.write("            <input type=\"text\" name=\"address2\" id=\"sample4_jibunAddress\" placeholder=\"지번주소\" size=\"35px\">\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<div class=\"btn_area1\">\r\n");
      out.write("\t<input id=\"sel-submit1\" type=\"submit\" value=\"가입\" />\r\n");
      out.write("\t<input id=\"sel-cancel1\" type=\"button\" value=\"취소\"/>\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("<script src=\"http://dmaps.daum.net/map_js_init/postcode.v2.js\"></script>\r\n");
      out.write("<script charset=\"UTF-8\" type=\"text/javascript\"\r\n");
      out.write("   src=\"http://t1.daumcdn.net/cssjs/postcode/1522037570977/180326.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("   //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.\r\n");
      out.write("   function sample4_execDaumPostcode() {\r\n");
      out.write("      new daum.Postcode(\r\n");
      out.write("            {\r\n");
      out.write("               oncomplete : function(data) {\r\n");
      out.write("                  // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.\r\n");
      out.write("\r\n");
      out.write("                  // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.\r\n");
      out.write("                  // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.\r\n");
      out.write("                  var fullRoadAddr = data.roadAddress; // 도로명 주소 변수\r\n");
      out.write("                  var extraRoadAddr = ''; // 도로명 조합형 주소 변수\r\n");
      out.write("\r\n");
      out.write("                  // 법정동명이 있을 경우 추가한다. (법정리는 제외)\r\n");
      out.write("                  // 법정동의 경우 마지막 문자가 \"동/로/가\"로 끝난다.\r\n");
      out.write("                  if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {\r\n");
      out.write("                     extraRoadAddr += data.bname;\r\n");
      out.write("                  }\r\n");
      out.write("                  // 건물명이 있고, 공동주택일 경우 추가한다.\r\n");
      out.write("                  if (data.buildingName !== '' && data.apartment === 'Y') {\r\n");
      out.write("                     extraRoadAddr += (extraRoadAddr !== '' ? ', '\r\n");
      out.write("                           + data.buildingName : data.buildingName);\r\n");
      out.write("                  }\r\n");
      out.write("                  // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.\r\n");
      out.write("                  if (extraRoadAddr !== '') {\r\n");
      out.write("                     extraRoadAddr = ' (' + extraRoadAddr + ')';\r\n");
      out.write("                  }\r\n");
      out.write("                  // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.\r\n");
      out.write("                  if (fullRoadAddr !== '') {\r\n");
      out.write("                     fullRoadAddr += extraRoadAddr;\r\n");
      out.write("                  }\r\n");
      out.write("\r\n");
      out.write("                  // 우편번호와 주소 정보를 해당 필드에 넣는다.\r\n");
      out.write("                  document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용\r\n");
      out.write("                  document.getElementById('sample4_roadAddress').value = fullRoadAddr;\r\n");
      out.write("                  document.getElementById('sample4_jibunAddress').value = data.jibunAddress;\r\n");
      out.write("\r\n");
      out.write("                  // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.\r\n");
      out.write("                  if (data.autoRoadAddress) {\r\n");
      out.write("                     //예상되는 도로명 주소에 조합형 주소를 추가한다.\r\n");
      out.write("                     var expRoadAddr = data.autoRoadAddress\r\n");
      out.write("                           + extraRoadAddr;\r\n");
      out.write("                     document.getElementById('guide').innerHTML = '(예상 도로명 주소 : '\r\n");
      out.write("                           + expRoadAddr + ')';\r\n");
      out.write("\r\n");
      out.write("                  } else if (data.autoJibunAddress) {\r\n");
      out.write("                     var expJibunAddr = data.autoJibunAddress;\r\n");
      out.write("                     document.getElementById('guide').innerHTML = '(예상 지번 주소 : '\r\n");
      out.write("                           + expJibunAddr + ')';\r\n");
      out.write("\r\n");
      out.write("                  } else {\r\n");
      out.write("                     document.getElementById('guide').innerHTML = '';\r\n");
      out.write("                  }\r\n");
      out.write("               }\r\n");
      out.write("            }).open();\r\n");
      out.write("   }\r\n");
      out.write("</script>\r\n");
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

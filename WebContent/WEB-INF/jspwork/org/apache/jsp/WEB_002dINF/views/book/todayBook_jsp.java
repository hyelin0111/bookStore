/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2018-05-19 08:26:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import book.model.vo.Book;

public final class todayBook_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("book.model.vo.Book");
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
      out.write("\r\n");

   List<Book> todayBookList = (List<Book>) request.getAttribute("todayBookList");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=UTF-8\">\r\n");
      out.write("<title>BestSeller</title>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("* {\r\n");
      out.write("   margin: 0;\r\n");
      out.write("   padding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.tUl, li.tLi {\r\n");
      out.write("   list-style: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#slide {\r\n");
      out.write("   width: 100%;\r\n");
      out.write("   height: 100%;\r\n");
      out.write("   background: gray;\r\n");
      out.write("   position: relative;\r\n");
      out.write("   overflow: hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#slide ul {\r\n");
      out.write("   width: 400%;\r\n");
      out.write("   height: 100%;\r\n");
      out.write("   transition: 1s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#slide ul:after {\r\n");
      out.write("   content: \"\";\r\n");
      out.write("   display: block;\r\n");
      out.write("   clear: both;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#slide li {\r\n");
      out.write("   float: left;\r\n");
      out.write("   width: 25%;\r\n");
      out.write("   height: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#slide li {\r\n");
      out.write("   background: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#slide input {\r\n");
      out.write("   display: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#slide label {\r\n");
      out.write("   display: inline-block;\r\n");
      out.write("   vertical-align: middle;\r\n");
      out.write("   width: 10px;\r\n");
      out.write("   height: 10px;\r\n");
      out.write("   border: 2px solid #666;\r\n");
      out.write("   background: #fff;\r\n");
      out.write("   transition: 0.3s;\r\n");
      out.write("   border-radius: 50%;\r\n");
      out.write("   cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#slide .tPage {\r\n");
      out.write("   text-align: center;\r\n");
      out.write("   position: absolute;\r\n");
      out.write("   bottom: 0px;\r\n");
      out.write("   left: 0;\r\n");
      out.write("   width: 100%;\r\n");
      out.write("   text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tPage1:checked ~ul {\r\n");
      out.write("   margin-left: 0%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tPage2:checked ~ul {\r\n");
      out.write("   margin-left: -100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tPage3:checked ~ul {\r\n");
      out.write("   margin-left: -200%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tPage4:checked ~ul {\r\n");
      out.write("   margin-left: -300%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tPage1:checked ~.tPage>label:nth-child(1) {\r\n");
      out.write("   background: #666;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tPage2:checked ~.tPage>label:nth-child(2) {\r\n");
      out.write("   background: #666;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tPage3:checked ~.tPage>label:nth-child(3) {\r\n");
      out.write("   background: #666;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tPage4:checked ~.tPage>label:nth-child(4) {\r\n");
      out.write("   background: #666;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".todayBooks {\r\n");
      out.write("   width: 172px;\r\n");
      out.write("   height: 190px;\r\n");
      out.write("   border: 1px solid gray;\r\n");
      out.write("   margin-top: 20px;\r\n");
      out.write("   margin-left: 21px;\r\n");
      out.write("   float: left;\r\n");
      out.write("   display: inline-block;\r\n");
      out.write("   text-align: center;\r\n");
      out.write("   background-size: cover;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".todayBooks:hover {\r\n");
      out.write("   box-shadow: 1px 1px 10px gray;\r\n");
      out.write("   transform: rotateY(30deg);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".todayBookFrm {\r\n");
      out.write("   width: 100%;\r\n");
      out.write("   height: 190px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".tImg4 {\r\n");
      out.write("   width: 100px;\r\n");
      out.write("   height: 80px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("   $(document).ready(function() {\r\n");
      out.write("      $(\".todayBookFrm\").click(function() {\r\n");
      out.write("         $(this).submit();\r\n");
      out.write("         console.log(this);\r\n");
      out.write("      });\r\n");
      out.write("   });\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <div id=\"slide\">\r\n");
      out.write("      <input type=\"radio\" name=\"tPage\" id=\"tPage1\" checked> <input\r\n");
      out.write("         type=\"radio\" name=\"tPage\" id=\"tPage2\"> <input type=\"radio\"\r\n");
      out.write("         name=\"tPage\" id=\"tPage3\"> <input type=\"radio\" name=\"tPage\"\r\n");
      out.write("         id=\"tPage4\">\r\n");
      out.write("\r\n");
      out.write("      <ul class=\"tUl\">\r\n");
      out.write("         ");

            if (todayBookList != null) {
               for (int i = 0; i < todayBookList.size(); i++) {
         
      out.write("\r\n");
      out.write("         ");

            if (i % 5 == 0) {
         
      out.write("\r\n");
      out.write("         <li class=\"tLi\">\r\n");
      out.write("            ");

               }
            
      out.write("\r\n");
      out.write("            <div class=\"todayBooks\"\r\n");
      out.write("               style=\"background-image: url('");
      out.print(request.getContextPath());
      out.write("/images/");
      out.print(todayBookList.get(i).getBookNo());
      out.write(".jpg');\">\r\n");
      out.write("               <form class=\"todayBookFrm\"\r\n");
      out.write("                  action=\"");
      out.print(request.getContextPath());
      out.write("/book/todayBookEnd\"\r\n");
      out.write("                  method=\"get\">\r\n");
      out.write("                  <input type=\"text\" name=\"bookNo\"\r\n");
      out.write("                     value=\"");
      out.print(todayBookList.get(i).getBookNo());
      out.write("\" />\r\n");
      out.write("               </form>\r\n");
      out.write("            </div> ");

    if (i % 5 == 4) {
 
      out.write("\r\n");
      out.write("         </li>\r\n");
      out.write("         ");

            }
               }
            }
         
      out.write("\r\n");
      out.write("      </ul>\r\n");
      out.write("\r\n");
      out.write("      <p class=\"tPage\">\r\n");
      out.write("         <label for=\"tPage1\"></label> <label for=\"tPage2\"></label> <label\r\n");
      out.write("            for=\"tPage3\"></label> <label for=\"tPage4\"></label>\r\n");
      out.write("      </p>\r\n");
      out.write("   </div>\r\n");
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
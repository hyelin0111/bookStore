package search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.service.BookService;
import book.model.vo.Book;

/**
 * Servlet implementation class SortByHighPriceServlet
 */
@WebServlet("/sort/highPrice")
public class SortByHighPriceServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortByHighPriceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String searchBook = request.getParameter("searchBook");
      String type = request.getParameter("type");

      String searchType = "";

      switch (type) {
      case "전체":
         searchType = "all";
         break;
      case "책제목":
         searchType = "title";
         break;
      case "저자명":
         searchType = "writer";
         break;
      case "출판사명":
         searchType = "publisher";
         break;
      }

      List<Book> list = null;

      int cPage;
      int numPerPage = 5;
      int totalBoard = 0;

      try {
         cPage = Integer.parseInt(request.getParameter("cPage"));
      } catch (NumberFormatException e) {
         cPage = 1;
      }

      switch (searchType) {
      case "all":
         list = new BookService().selectBookByAllOrderByHighPrice(cPage, numPerPage, searchBook);
         type = "전체";
         totalBoard = new BookService().selectBookByAllCount(searchBook);
         break;
      case "title":
         list = new BookService().selectBookByTitleOrderByHighPrice(cPage, numPerPage, searchBook);
         type = "책제목";
         totalBoard = new BookService().selectBookByTitleCount(searchBook);
         break;
      case "writer":
         list = new BookService().selectBookByWriterOrderByHighPrice(cPage, numPerPage, searchBook);
         type = "저자명";
         totalBoard = new BookService().selectBookByWriterCount(searchBook);
         break;
      case "publisher":
         list = new BookService().selectBookByPublisherOrderByHighPrice(cPage, numPerPage, searchBook);
         type = "출판사명";
         totalBoard = new BookService().selectBookByPublisherCount(searchBook);
         break;
      }

      int totalPage = (int) Math.ceil((double) totalBoard / numPerPage);

      String pageBar = "";
      int pageBarSize = 5;
      int pageNo = (cPage - 1) / pageBarSize * pageBarSize + 1;
      int pageEnd = pageNo + pageBarSize - 1;

      // [이전]
      if (pageNo == 1) {
         // pageBar = "<span>[이전]</span>";
      } else {
         pageBar += "<a href= '" + request.getContextPath() + "/sort/highPrice?type=" + type
               + "&searchBook=" + searchBook + "&cPage=" + (pageNo - 1) + "'><span>[이전]</span></a>";
      }

      // [pageNo]
      while (pageNo <= pageEnd && pageNo <= totalPage) {
         if (pageNo == cPage) {
            pageBar += "<span>" + pageNo + "</span>";
         } else {
            pageBar += "<a href=" + request.getContextPath() + "/sort/highPrice?type=" + type
                  + "&searchBook=" + searchBook + "&cPage=" + pageNo + "><span>" + pageNo + "</span></a>";
         }
         pageNo++;
      }

      // [다음]
      if (pageNo > totalPage) {

      } else {
         pageBar += "<a href= '" + request.getContextPath() + "/sort/highPrice?type=" + type
               + "&searchBook=" + searchBook + "&cPage=" + pageNo + "'><span>[다음]</span></a>";
      }

      request.setAttribute("list", list);
      request.setAttribute("type", type);
      request.setAttribute("searchBook", searchBook);
      request.setAttribute("pageBar", pageBar);
      request.setAttribute("cPage", cPage);

      request.getRequestDispatcher("/WEB-INF/views/search/search.jsp").forward(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
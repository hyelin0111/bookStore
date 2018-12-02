package oldboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oldboard.model.service.OldBoardService;

/**
 * Servlet implementation class DeleteOldBoard
 */
@WebServlet("/oldboard/deleteOldBoard")
public class DeleteOldBoard extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOldBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int boardNo = Integer.parseInt(request.getParameter("boardNo"));
      int memberNo = Integer.parseInt(request.getParameter("memberNo"));
      
      int result = new OldBoardService().deleteOldBoard(boardNo);
      
      String msg = "";
      String loc = "/oldboard/OldBoardServlet?memberNo=" + memberNo;
      String view = "/WEB-INF/views/common/msg.jsp";
      
      if( result > 0 ) 
         msg = "글이 삭제되었습니다.";
      else
         msg = "오류가 발생했습니다.";
      
      request.setAttribute("msg", msg);
      request.setAttribute("loc", loc);
      request.getRequestDispatcher(view).forward(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
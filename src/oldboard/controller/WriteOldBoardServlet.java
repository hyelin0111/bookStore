package oldboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seller.model.service.SellerService;

/**
 * Servlet implementation class WriteOldBoardFormServlet
 */
@WebServlet("/oldboard/writeOldBoard")
public class WriteOldBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteOldBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int result = 0;
	      int memberNo = Integer.parseInt(request.getParameter("memberNo"));   
	      
	      result = new SellerService().sellerCheck(memberNo);
	      
	      String msg = "";
	      String loc = "";
	      String view = "";
	      
	      if( result > 0 ) {
	         view = "/WEB-INF/views/oldboard/writeOldBoard.jsp";
	      } else {
	         msg = "판매자 등록을 먼저 해주세요.";
	         loc ="/seller/sellerEnroll?member_no=" + memberNo;
	         view = "/WEB-INF/views/common/msg.jsp";
	         
	         request.setAttribute("msg", msg);
	         request.setAttribute("loc", loc);
	      }      
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

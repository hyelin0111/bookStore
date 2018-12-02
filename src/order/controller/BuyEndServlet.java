package order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oldboard.model.service.OldBoardService;
import order.model.service.OrderService;

/**
 * Servlet implementation class OrderBuyEndServlet
 */
@WebServlet("/order/orderBookEnd")
public class BuyEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String bookNo = request.getParameter("bookNo");
		int bookCnt = Integer.parseInt(request.getParameter("bookCnt"));
		String bookStatus = request.getParameter("bookStatus");
		
		
		/*System.out.println("----------sdfsdf--------"+request.getParameter("oldBoardNo"));*/
		int result = new OrderService().insertOrder(memberNo, bookNo, bookCnt, bookStatus);
		
		if(request.getParameter("oldBoardNo") != null) {
			int boardNo = Integer.parseInt(request.getParameter("oldBoardNo"));
			new OldBoardService().deleteOldBoard(boardNo);
		}
		
		String msg = "";
		String loc = "";
		
		if(result>0)
			msg = "결제가 완료되었습니다.";
		else
			msg = "결제가 실패되었습니다.";
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

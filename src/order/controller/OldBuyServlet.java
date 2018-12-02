package order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Address;
import oldboard.model.service.OldBoardService;
import oldboard.model.vo.OldBoard;

/**
 * Servlet implementation class OldBuyServlet
 */
@WebServlet("/order/oldBuyServlet")
public class OldBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OldBuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int oldBoardNo = Integer.parseInt(request.getParameter("oldBoardNo"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String bookStatus = request.getParameter("bookStatus");
		
		OldBoard ob = new OldBoardService().selectOnebyOldBoardNo(oldBoardNo);
		Address address = new MemberService().selectAdd(memberNo);
		
		request.setAttribute("ob", ob);
		request.setAttribute("address", address);
		request.setAttribute("bookStatus", bookStatus);
		
		request.getRequestDispatcher("/WEB-INF/views/order/oldBuy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

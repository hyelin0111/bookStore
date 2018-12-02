package order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.service.BookService;
import book.model.vo.Book;
import member.model.service.MemberService;
import member.model.vo.Address;
import oldboard.model.service.OldBoardService;
import oldboard.model.vo.OldBoard;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/order/buyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderQty = Integer.parseInt(request.getParameter("orderQty"));
		String bookNo = request.getParameter("bookNo");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		//String bookStatus = request.getParameter("bookStatus");
		
		Address address = new MemberService().selectAdd(memberNo);
		Book book = new BookService().selectBookOneList(bookNo);
		
		request.setAttribute("book", book);
		request.setAttribute("address", address);
		request.setAttribute("orderQty", orderQty);
		
		//request.setAttribute("bookStatus", bookStatus);

		request.getRequestDispatcher("/WEB-INF/views/order/buy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

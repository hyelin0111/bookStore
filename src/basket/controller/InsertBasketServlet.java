package basket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basket.model.service.BasketService;
import basket.model.vo.Basket;

/**
 * Servlet implementation class InsertBasketServlet
 */
@WebServlet("/basket/insertBasket")
public class InsertBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertBasketServlet() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String bookNo = request.getParameter("bookNo");
		int orderCnt = Integer.parseInt(request.getParameter("orderCnt"));
		String status = request.getParameter("status");

		Basket b = new Basket(memberNo, bookNo, orderCnt, status);

		int result = new BasketService().insertBasket(b);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

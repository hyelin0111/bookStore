package order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import order.model.service.OrderService;
import order.model.vo.Order;

/**
 * Servlet implementation class OrderListEndServlet
 */
@WebServlet("/order/orderListEnd")
public class OrderListEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String bookTitle = request.getParameter("bookTitle");
		
		if(startDate.equals("") || endDate.equals("")) {
			startDate = "1900-01-01";
			endDate = "2100-01-01";
		}
			
		List<Order> list = new OrderService().selectOrderByDate(memberNo, startDate, endDate, bookTitle);
		new Gson().toJson(list,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

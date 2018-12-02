package order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basket.model.service.BasketService;
import order.model.service.OrderService;

/**
 * Servlet implementation class BasketBuyFinalServlet
 */
@WebServlet("/buy/basketBuyFinal")
public class BasketBuyFinalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketBuyFinalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:9090/book/buy/basketBuyFinal?userId=%EA%B9%80%ED%9A%A8%EC%A0%95&phone_num1=010&phone_num2=1564&phone_num3=9521
		// &msg=&pay=on&default_card=&memberNo=94
		// &bookNo=1994090601__1986032501__&bookCnt=1__1__&bookStatus=N__N__
		String bookNo = request.getParameter("bookNo");
		String amount = request.getParameter("amount");
		String bookStatus = request.getParameter("bookStatus");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		String[] bookNoArray = bookNo.split("__");
		String[] amountTmpArray = amount.split("__");
		String[] bookStatusArray = bookStatus.split("__");
		int[] amountArray = new int[amount.length()];
		
		int orderNo = new OrderService().selectOrderNo(); 
	    int result = 0;
		int resultCnt = 0, resultCnt2 = 0;
		String msg = "";
		String loc = "";
		
		for(int i=0; i<amountTmpArray.length; i++) {
			amountArray[i] = Integer.parseInt(amountTmpArray[i]);
			result = new OrderService().insertBasketOrder(orderNo, memberNo, bookNoArray[i], amountArray[i], bookStatusArray[i]);
			if(result>0) resultCnt++;
		}
		
		if(resultCnt == bookNoArray.length) {
			for(int i=0; i<amountTmpArray.length; i++) {
				result = new BasketService().deleteBookToBasket(memberNo, bookNoArray[i], bookStatusArray[i]);
				if(result>0) resultCnt2++;
			}
		}
		
		if (resultCnt == bookNoArray.length && resultCnt2 == bookNoArray.length) {
			msg = "결제가 완료되었습니다.";
		} else {
			msg = "결제가 실패되었습니다.";
		}
		
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

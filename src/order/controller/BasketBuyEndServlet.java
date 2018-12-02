package order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.service.BookService;
import member.model.service.MemberService;
import member.model.vo.Address;

/**
 * Servlet implementation class BasketBuyEndServlet
 */
@WebServlet("/buy/basketBuyEnd")
public class BasketBuyEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketBuyEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int cnt = Integer.parseInt(request.getParameter("cnt"));

		String bookNo = request.getParameter("bookNo");
		String amount = request.getParameter("amount");
		String price = request.getParameter("price");
		String bookStatus = request.getParameter("bookStatus");
		
		String[] bookNoArray = bookNo.split("__");
		String[] amountTmpArray = amount.split("__");
		String[] priceTmpArray = price.split("__");
		//String[] bookStatusArray = bookStatus.split("__");
		
		String[] bookTitleArray = new String[cnt];  
		int[] amountArray = new int[cnt];  
		int[] priceArray = new int[cnt];  
				
		for(int i=0; i<cnt; i++) {
			amountArray[i] = Integer.parseInt(amountTmpArray[i]);
			priceArray[i] = Integer.parseInt(priceTmpArray[i]);
			bookTitleArray[i] = new BookService().selectBookTitleByBookNo(bookNoArray[i]);
			//System.out.println(bookStatusArray[i]);
		}

		Address address = new MemberService().selectAdd(memberNo);
		
		request.setAttribute("bookNoArray", bookNoArray);
	    request.setAttribute("bookTitleArray", bookTitleArray);
	    request.setAttribute("bookStatus", bookStatus);
	    request.setAttribute("amountArray", amountArray);
	    request.setAttribute("priceArray", priceArray);
	    request.setAttribute("address", address);
		
		request.getRequestDispatcher("/WEB-INF/views/order/basketBuy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

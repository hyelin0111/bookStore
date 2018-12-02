package seller.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seller.model.service.SellerService;
import seller.model.vo.Seller;

/**
 * Servlet implementation class SellerEnrollEndServlet
 */
@WebServlet("/seller/sellerEnrollEnd")
public class SellerEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerEnrollEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("member_no"));
		String selId = request.getParameter("selId1");
		String selName = request.getParameter("selName");
		String sellernick1 = request.getParameter("sellernick1");
		String selPhone1 = request.getParameter("sel-phone1");
		String selEmail = request.getParameter("sel-email1");
		String pdel1 = request.getParameter("pdel1");
		int delPrice1 = Integer.parseInt(request.getParameter("del-price1"));
		int delIPrice1 = Integer.parseInt(request.getParameter("del-iprice1"));
		String postnum = request.getParameter("postnum");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address = String.join(",", postnum,address1,address2);
		String bank = request.getParameter("bank1");
		String account = request.getParameter("sel-account1");
		
		Seller seller = new Seller(no,selPhone1,selEmail,account,pdel1,delIPrice1,delPrice1,sellernick1,address,bank);
		
		
		
		int result = new SellerService().insertSeller(seller);
		
		String msg = "";
		String loc = "/";
		String view = "/WEB-INF/views/common/msg.jsp";
		if(result>0) {
			msg = "판매자 가입이에 성공하셨습니다.";
		}else {
			msg = "회원등록 실패..! 관리자 문의 바람.";
		}
		request.setAttribute("msg",msg);
		request.setAttribute("loc",loc);
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
		reqDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

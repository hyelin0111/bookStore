package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import seller.model.vo.Seller;

/**
 * Servlet implementation class AdminMemberUpdateServlet
 */
@WebServlet("/admin/adminSellerUpdate")
public class AdminSellerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSellerUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String bank = request.getParameter("bank1");
		String account = request.getParameter("sel-account1");
		String email = request.getParameter("memEmail");
		String postnum = request.getParameter("pNum");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address = String.join(",", postnum,address1,address2);
		int delPrice1 = Integer.parseInt(request.getParameter("del-price1"));
		int delIPrice1 = Integer.parseInt(request.getParameter("del-iprice1"));
		
		Seller seller = new Seller(no,bank,account,email,address,delPrice1,delIPrice1);
		int result = new AdminService().AdminUpdateSeller(seller);
		
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/";

		if(result>0) {
			msg = "ADMIN - 성공적으로 회원정보를 수정했습니다.";
			loc = "/admin/adminSellerListView";
		}
		else { 
			msg = "ADMIN - 회원정보수정에 실패했습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
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

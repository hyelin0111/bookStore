package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import member.model.service.MemberService;
import member.model.vo.Address;
import seller.model.vo.Seller;

/**
 * Servlet implementation class MemberViewServlet
 */
@WebServlet("/admin/adminSellerView")
public class AdminSellerViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSellerViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String member_id = request.getParameter("member_id");
	
		
		Seller seller= new AdminService().selectOne(member_id);
		
		
		
		String view = "";
		String loc = "";
		String msg = "";
		if(seller != null){
			//RequestDispatcher javax.servlet.ServletRequest.getRequestDispatcher(String arg0)
			view = "/WEB-INF/views/admin/adminSellerView.jsp";
		}
		else {
			view = "/WEB-INF/views/common/msg.jsp";
			msg = "?????";
		}
		RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
		request.setAttribute("seller", seller);
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
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

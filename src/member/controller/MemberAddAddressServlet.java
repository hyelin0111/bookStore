package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Address;

/**
 * Servlet implementation class MemberAddAddressServlet
 */
@WebServlet("/member/addAddress")
public class MemberAddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAddAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String member_id = request.getParameter("member_id");
		int member_no =Integer.parseInt( request.getParameter("member_no"));
		//System.out.println("나는MEmberADDADDRESS다~!!"+member_id+member_no);
		
		Address address = new MemberService().selectAdd(member_no);
		//System.out.println(address);
		
		String view = "";
		String loc = "";
		String msg = "";
		
		if(address != null) {
			view ="/WEB-INF/views/member/addAddress.jsp";
		}
		else {
			view = "/WEB-INF/views/common/msg.jsp";
			msg = "뭐라고쓸까나";
		}
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
		request.setAttribute("address", address);
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

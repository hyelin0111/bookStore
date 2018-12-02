package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberUpdateServlet
 */
@WebServlet(name="AdminMemberUpdateServlet", urlPatterns="/admin/adminMemberUpdate")
public class AdminMemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ms = request.getParameter("status");
		String id = request.getParameter("memId");
		String password = request.getParameter("password");
		String email = request.getParameter("memEmail");
		String phone1 = request.getParameter("memMobile01");
		String phone2 = request.getParameter("memMobile02");
		String phone3 = request.getParameter("memMobile03");
		String phone = phone1 + phone2 + phone3;
		String[] interested = request.getParameterValues("memHobby");
		String inter ="";
		if(interested!=null) {
			inter=String.join(",", interested);
		}
		
		Member member = new Member(id,password,email,phone,inter.toString(),ms);
		int result = new AdminService().AdminUpdateMember(member);
		
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/";

		if(result>0) {
			msg = "ADMIN - 성공적으로 회원정보를 수정했습니다.";
			loc = "/admin/adminMemberListView";
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

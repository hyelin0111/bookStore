package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberDeleteEndServlet
 */
//@WebServlet("/member/memberDeleteEnd")
@WebServlet(name="MemberDeleteEndServlet", urlPatterns="/member/memberDeleteEnd")
public class MemberDeleteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id1");
//		System.out.println("ddddddddd0    "+id);
		String password = request.getParameter("password");
//		System.out.println("###########3    "+password);
		int result = new MemberService().deleteCheck(id,password);
//		System.out.println("deleteeeeee"+ result);
		String view = "";
		String msg = "";
		String loc = "/";
		
		if(result==MemberService.DELETE_OK) {
			Member member = new Member();
			member.setMember_id(id);
			int del = new MemberService().deleteMember(member);
			msg="그동안 이용해주셔서 감사합니다.^^ ";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			HttpSession session = request.getSession(false);
			
			if(session != null) {
				//세션반납
				session.invalidate();
			}
			view="/WEB-INF/views/common/msg.jsp";
			RequestDispatcher reqDispatcher 
			= request.getRequestDispatcher(view);
			reqDispatcher.forward(request, response);
			
		}else if(result==MemberService.WRONG_PWD) {
			view="/WEB-INF/views/common/msg.jsp";
			
			msg="패스워드를 잘못 입력하셨습니다.";
			
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			
			RequestDispatcher reqDispatcher 
			= request.getRequestDispatcher(view);
			reqDispatcher.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

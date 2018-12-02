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
 * Servlet implementation class UpdatePasswordEnd
 */
@WebServlet(name="UpdatePasswordEndServlet", urlPatterns="/member/updatePasswordEnd")
public class UpdatePasswordEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("memId");
		String password = request.getParameter("password");
		String password_n = request.getParameter("pwd_n");
	
		Member member = new Member();
		member.setMember_id(id);
		member.setMember_password(password);
		
		int result = new MemberService().loginCk(id,password);
//		System.out.println(result);
		String msg = "";
		String loc = "";
		HttpSession session = request.getSession(false);
		String view = "/WEB-INF/views/common/msg.jsp";
		if(result == MemberService.LOGIN_OK) {
			member.setMember_password(password_n);
			result = new MemberService().updatePassword(member);
			if(result>0) {
				msg = "비밀번호가 성공적으로 변경되었습니다. \\n 변경된 비밀번호로 로그인해주세요";
				if(session != null) {
					//세션반납
					session.invalidate();
				}
			}
		}
		else {
			msg = "패스워드를 잘못 입력하셨습니다.";
			loc = "/member/updatePassword?member_id="+id;
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

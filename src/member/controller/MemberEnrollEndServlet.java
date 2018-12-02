package member.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Address;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberEnrollEndServlet
 */
@WebServlet(name="MemberEnrollEndServlet", urlPatterns="/member/memberEnrollEnd")
public class MemberEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEnrollEndServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("memId");
		String password = request.getParameter("memPwd");
		String name = request.getParameter("memName");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("memBirth");
		String phone1 = request.getParameter("memMobile01");
		String phone2 = request.getParameter("memMobile02");
		String phone3 = request.getParameter("memMobile03");
		String phone = phone1 + phone2 + phone3;
		String email = request.getParameter("memEmail");
		String postnum = request.getParameter("postnum");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address = String.join(",", postnum,address1,address2);
		
		
		String[] interestedes = request.getParameterValues("memHobby");
		String interested = "";
		if(interestedes != null ) interested = String.join(",", interestedes);
		Member member = new Member(id,password,name,gender,birth, email,phone,interested.toString());
		int result = new MemberService().inserMember(member);	
		
		
		Address add = new Address(result,address);
		
		String msg = "";
		
		if(member!= null) {
            int resultadd = new MemberService().insertAddress(add);
        }
		
		
		
		String view = "/WEB-INF/views/common/msg.jsp";
		
		String loc = "/";
		if(result<0) {
			msg = "회원등록에 실패했습니다."; 
		}else {
			msg = "회원등록에 성공했습니다."; 
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

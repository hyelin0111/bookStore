package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class UpdateAddressEndServlet
 */
@WebServlet("/member/updateAddressAdd")
public class UpdateAddressEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAddressEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String memberId = request.getParameter("memberId");	
		String chk = request.getParameter("add-choose1");
		int member_no =Integer.parseInt( request.getParameter("memberNo"));

		System.out.println("chk= " + chk + "\t" + "no="+member_no);
		
		int result = new MemberService().updateAddressStatus(chk,member_no);
		
		
		/*String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/member/addAddress";
		
		if(result > 0) {
			msg = "주소 수정 성공!";
		} else {
			msg = "주소 수정 실패!";
		}
		request.setAttribute("member_id", memberId);
		request.setAttribute("member_no", no);
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);*/
		
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/member/addAddress";
		
		if(result > 0) {
			msg = "주소 추가 성공!";
		} else {
			msg = "주소 추가 실패!";
		}
		
		String referer = request.getHeader("Referer");
		String origin = request.getHeader("Origin");
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		
		if(origin == null) {
			origin = url.replace(uri, "");
		}
		loc = referer.replace(origin+request.getContextPath(), "");
		
		System.out.println(loc);
		request.setAttribute("member_id", memberId);
		request.setAttribute("member_no", member_no);
		System.out.println("AddressAddInset@memberId="+memberId + "\t memberNo="+member_no);
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

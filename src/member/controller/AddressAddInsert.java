package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Address;

/**
 * Servlet implementation class AddressAddInsert
 */
@WebServlet("/address/addressAddInsert")
public class AddressAddInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressAddInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String postnum = request.getParameter("postnum");
		String address1 = request.getParameter("address1"); // 도로명
		String address2 = request.getParameter("address2"); // 지번
		String memberId = request.getParameter("memberId");		
		int member_no = Integer.parseInt(request.getParameter("memberNo"));
		
		String memAddress = postnum+","+address1+","+address2;
//		System.out.println("AddressAddInsert@postnum="+postnum +"\t address1="+address1 +"\t address2="+address2 +"\t memberId="+memberId +"\t member_no="+member_no);
		int result = new MemberService().insertAddress(member_no, memAddress);

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

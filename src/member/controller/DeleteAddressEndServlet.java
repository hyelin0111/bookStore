package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class DeleteAddressEndServlet
 */
@WebServlet("/address/addressAddDelete")
public class DeleteAddressEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAddressEndServlet() {
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
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int deleteNo =Integer.parseInt( request.getParameter("deleteAddress"));
		int addchk =Integer.parseInt( request.getParameter("addchk"));

		
		int result = 0;
		
		System.out.println("deleteNo= " + deleteNo + "\t" + "addchk="+addchk);
		if(deleteNo == addchk)
			result = 10;
		else {
			result = new MemberService().deleteAddressStatus(memberNo, deleteNo);
			System.out.println("실행하니 else");
		}
		System.out.println("result="+result);
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/member/addAddress?member_id="+memberId+"&member_no="+memberNo+"";
		
		
		if(result == 10){
			msg = "기본주소는 삭제할수 없습니다.";
		}else if(result > 0) {
			msg = "주소 삭제 성공!";
		} else {
			msg = "주소 삭제 실패!";
		}
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

package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import member.model.vo.Member;
import seller.model.vo.Seller;

/**
 * Servlet implementation class AdminMemberListViewServlet
 */
@WebServlet("/admin/adminSellerListView")
public class AdminSellerListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSellerListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member memberLoggedIn = ((Member)request.getSession(true).getAttribute("memberLoggedIn"));
		
		//로그인이 admin이 아닐경우
		if(memberLoggedIn ==null || !"admin".equals(memberLoggedIn.getMember_id())) {
			request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common.jsp").forward(request, response);
			return;
		}
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage = 1;
		}
		int numPerPage = 5;
		int totalSeller = new AdminService().selectSellerCount();
		int totalPage = (int)Math.ceil((double)totalSeller/numPerPage);
		
		List<Seller> list = new AdminService().selectSellerList(cPage,numPerPage);
		
		String pageBar ="";
		int pageBarSize = 5;
		
		int pageNo =(cPage -1)/pageBarSize*pageBarSize+1;
		
		int pageEnd = pageNo + pageBarSize-1;
		
		//[이전]
		if(pageNo == 1) {
			
		}
		else {
			pageBar += "<a href="+request.getContextPath()+"/admin/adminSellerListView?cPage="+(pageNo-1)+"><span><img src="+request.getContextPath()+"/images/larrow.png width=16px></span></a>";
		}
		
		//[pageNo]
		while(pageNo<=pageEnd && pageNo<=totalPage) {
			if(pageNo==cPage) {
				pageBar += "<span>"+pageNo+"</span>";				
			}
			else {
				pageBar += "<a href="+request.getContextPath()+"/admin/adminSellerListView?cPage="+pageNo+"><span>"+pageNo+"</span></a>";
			}
			
			pageNo++;
		}
		//[다음]
		if(pageNo > totalPage) {
			
		}
		else {
			pageBar += "<a href="+request.getContextPath()+"/admin/adminSellerListView?cPage="+(pageNo)+"><span><img src="+request.getContextPath()+"/images/rarrow.png width=16px></span></a>";
		}
		
		//2. view단 처리위임
		RequestDispatcher reqDispatcher 
				= request.getRequestDispatcher("/WEB-INF/views/admin/adminSellerListView.jsp");
		request.setAttribute("list", list);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("cPage", cPage);
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

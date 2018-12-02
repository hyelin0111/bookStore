package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListViewServlet
 */
@WebServlet("/notice/noticeListView" )
public class NoticeListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage = 1;
		}
		int numPerPage = 5;
		int totalNotice = new NoticeService().selectNoticeCount();
		int totalPage = (int)Math.ceil((double)totalNotice/numPerPage);
		
		List<Notice> list = new NoticeService().selectNoticeList(cPage,numPerPage);
		
		String pageBar ="";
		int pageBarSize = 5;
		
		int pageNo =(cPage -1)/pageBarSize*pageBarSize+1;
		
		int pageEnd = pageNo + pageBarSize-1;
		
		//[이전]
		if(pageNo == 1) {
			
		}
		else {
			pageBar += "<a href="+request.getContextPath()+"/notice/noticeListView?cPage="+(pageNo-1)+"><span><img src="+request.getContextPath()+"/images/larrow.png width=16px></span></a>";
		}
		
		//[pageNo]
		while(pageNo<=pageEnd && pageNo<=totalPage) {
			if(pageNo==cPage) {
				pageBar += "<span>"+pageNo+"</span>";				
			}
			else {
				pageBar += "<a href="+request.getContextPath()+"/notice/noticeListView?cPage="+pageNo+"><span>"+pageNo+"</span></a>";
			}
			
			pageNo++;
		}
		//[다음]
		if(pageNo > totalPage) {
			
		}
		else {
			pageBar += "<a href="+request.getContextPath()+"/notice/noticeListView?cPage="+(pageNo)+"><span><img src="+request.getContextPath()+"/images/rarrow.png width=16px></span></a>";
		}
		
		//2. view단 처리위임
		RequestDispatcher reqDispatcher 
				= request.getRequestDispatcher("/WEB-INF/views/notice/noticeListView.jsp");
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

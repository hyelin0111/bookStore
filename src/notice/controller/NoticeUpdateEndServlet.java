package notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeFormEndServlet
 */
@WebServlet("/notice/noticeUpdateEnd")
public class NoticeUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 전송값 담기
		int notice_no = Integer.parseInt(request.getParameter("no"));
		int member_no = Integer.parseInt(request.getParameter("w_no"));
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    

	    
	    
	    //2. 비지니스로직 호출
	    Notice n = new Notice(notice_no, member_no,  title, content,null);
	    int result = new NoticeService().updateNotice(n);
	    
	    //3. 처리결과에 따른 view단에 처리위임.
	    String view = "/WEB-INF/views/common/msg.jsp";
	    String msg = "";
	    //javascript/html에서 사용할 url은 contextPath를 포함한다.
	    String loc = "/notice/noticeListView";

	    if(result>0)
	        msg = "공지사항 수정 성공!";
	    else 
	        msg = "공지사항 수정 실패!";	
	    
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

package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeFormEndServlet
 */
@WebServlet("/notice/noticeFormEnd")
public class NoticeFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFormEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 전송값 담기
		//int notice_no = Integer.parseInt(request.getParameter("no"));
		int member_no = Integer.parseInt(request.getParameter("w-no"));
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    //시스템에 중복된 이름이 있다면, 새로부여된 파일명을 리턴함.
	    
	    
	    //insert용 Notice의 생성자를 새로 추가함.
	    Notice n = new Notice(0,member_no, title,  content, null);
	    //Notice n = new Notice(noticeTitle, noticeWriter, noticeContent, filePath);
	    
	    
	    //2. 비지니스로직 호출
	    int result = new NoticeService().insertNotice(n);
	    
	    //3. 처리결과에 따른 view단에 처리위임.
	    String view = "/WEB-INF/views/common/msg.jsp";
	    String msg = "";
	    String loc = "/notice/noticeListView";

	    if(result>0)
	        msg = "공지사항 등록 성공!";
	    else 
	        msg = "공지사항 등록 실패!";	
	    
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

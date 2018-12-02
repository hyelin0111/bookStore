package admin.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import admin.model.service.AdminService;
import book.model.vo.Book;
import common.MyFileRenamePolicy;

/**
 * Servlet implementation class BookAdminInsertEnd
 */
@WebServlet("/admin/bookAdminInsertEnd")
public class BookAdminInsertEnd extends HttpServlet {
	String str; 
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAdminInsertEnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//String type = null;
		
//		String title = request.getParameter("bookTitle");
//		String writer = request.getParameter("bookWriter");
//		String category = request.getParameter("bookCategory");
//		String publisher = request.getParameter("bookPublisher");
//		int price= Integer.parseInt(request.getParameter("bookPrice"));
//		int page= Integer.parseInt(request.getParameter("bookPage"));
////		String date = request.getParameter("bookDate");
//		String bookDate = request.getParameter("bookDate");
//		String bookNo = bookDate.substring(0, 4) + bookDate.substring(5, 7)+bookDate.substring(8,10);
//		Date date = Date.valueOf(bookDate);
		//Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sdate);

		// 이미지 파일 업로드 
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "게시판 작성 오류[form:enctype]");
			request.setAttribute("loc", "/book/bookListView");
			
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
		}
		
		

		// 1.b saveDirectory
		String saveDirectory = getServletContext().getRealPath("/images");
		int maxPostSize = 1024 * 1024 * 10;
		MultipartRequest multiReq = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", new common.MyFileRenamePolicy());

		String title = multiReq.getParameter("bookTitle");
		String writer = multiReq.getParameter("bookWriter");
		String category = multiReq.getParameter("bookCategory");
		String publisher = multiReq.getParameter("bookPublisher");
		int price= Integer.parseInt(multiReq.getParameter("bookPrice"));
		int page= Integer.parseInt(multiReq.getParameter("bookPage"));
//		String date = request.getParameter("bookDate");
		String bookDate = multiReq.getParameter("bookDate");
		String bookNo = bookDate.substring(0, 4) + bookDate.substring(5, 7)+bookDate.substring(8,10);
		Date date = Date.valueOf(bookDate);

		Book b = new Book(bookNo,0, writer,title,publisher,date,price,page,category,0,0.0,"N");
		
		int result = new AdminService().insertBookAdminOne(b);
		
		String bookFileName = new AdminService().selectBookAdminOne(b);
		
		String renamedFileName = multiReq.getFilesystemName("bookImg");		// 실제 시스템에 저장된 파일명(rename된 파일명)
		String originalFileName = multiReq.getOriginalFileName("bookImg");	// 사용자가 업로드한 파일명
		
		System.out.println("BookAdminInsertEnd@bookFileName="+bookFileName);
		System.out.println("BookAdminInsertEnd@renamedFileName="+renamedFileName);
		System.out.println("BookAdminInsertEnd@originalFileName ="+originalFileName );
			
		File file1 = new File("C:/Workspaces/webserver_workspace/SemiProject/WebContent/images/"+renamedFileName);
		File file2 = new File("C:/Workspaces/webserver_workspace/SemiProject/WebContent/images/"+bookFileName+".jpg");
		
		if(!file1.renameTo(file2)) {
		      System.err.println("이름 변경 에러 : " + file1);
	    }
		
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/book/bookListView";
		if(result > 0) {
			msg = "도서 추가 성공!";
		} else {
			msg = "도서 추가 실패!";
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

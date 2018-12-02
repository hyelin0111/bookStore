package admin.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import book.model.vo.Book;

/**
 * Servlet implementation class BookAdminUpdate
 */
@WebServlet("/admin/BookAdminUpdate")
public class BookAdminUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAdminUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String title = request.getParameter("bookTitle");
		String writer = request.getParameter("bookWriter");
		String category = request.getParameter("bookCategory");
		String publisher = request.getParameter("bookPublisher");
		int price= Integer.parseInt(request.getParameter("bookPrice"));
		int page= Integer.parseInt(request.getParameter("bookPage"));
//		String date = request.getParameter("bookDate");
		String bookDate = request.getParameter("bookDate");
		String bookNo = request.getParameter("bookNo");
		Date date = Date.valueOf(bookDate);
		int qty = Integer.parseInt(request.getParameter("bookQTY"));
		int bookAuno = Integer.parseInt(request.getParameter("bookAuno"));
		//Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
		
		Book b = new Book(bookNo,bookAuno, writer,title,publisher,date,price,page,category,qty,0.0,"N");
		//System.out.println(b);
		
		int result = new AdminService().updateAdminBook(b);
		
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/book/bookListView";
		if(result > 0) {
			msg = "도서 수정 성공!";
		} else {
			msg = "도서 수정 실패!";
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

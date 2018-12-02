package oldboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.vo.Book;
import oldboard.model.service.OldBoardService;
import oldboard.model.vo.OldBoard;

/**
 * Servlet implementation class OldBoardViewServlet
 */
@WebServlet("/oldboard/oldBoardView")
public class OldBoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OldBoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int oldBoardNo = 0;
		
		try {
			oldBoardNo = Integer.parseInt(request.getParameter("oldBoardNo"));
		} catch(NumberFormatException e) {
			request.setAttribute("msg", "판매글이 존재하지 않습니다.");
			request.setAttribute("loc", "/oldboard/OldBoardServlet");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		} 
		
		OldBoard ob = new OldBoardService().selectOneOldBoard(oldBoardNo); 
		String bookNo = ob.getOldBookNo();
		Book book = new OldBoardService().selectOneBook(bookNo);
		
		request.setAttribute("ob", ob);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/WEB-INF/views/oldboard/oldBoardView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

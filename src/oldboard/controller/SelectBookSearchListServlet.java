package oldboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.service.BookService;
import book.model.vo.Book;

/**
 * Servlet implementation class SelectBookSearchListServlet
 */
@WebServlet("/oldbook/selectBookSearchListServlet")
public class SelectBookSearchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBookSearchListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numPerPage = 10;
		int cPage;
		String searchKeyword = request.getParameter("searchKeyword");
		
		try{
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e){
			cPage = 1;
		}
		
		List<Book> bookList = new BookService().selectSearchBookList(cPage, numPerPage, searchKeyword);
		
		int totalBookCount = new BookService().selectSearchBookCount(searchKeyword);
		int totalPage = (int)Math.ceil((double)totalBookCount/numPerPage);
		
		// 페이지바구성
		String pageBar = "";	
		int pageBarSize = 5;
		
		//시작페이지 번호 세팅
		int pageNo = ((cPage - 1)/pageBarSize) * pageBarSize +1;
		//종료페이지 번호 세팅
		int pageEnd = pageNo+pageBarSize-1;
		
		//[이전] section
		if(pageNo == 1 ){
			//pageBar += "<span>[이전]</span>"; 
		}
		else {
			pageBar += "<a href='javascript:void(0);' onclick='fn_movePage("+ ( pageNo -1 ) + ");'>[이전]</a> ";
		}
			
		// pageNo section
		// 보통 !(빠져나가는 조건식)으로 많이 쓴다.
//				while(pageNo<=pageEnd && pageNo<=totalPage){
		while(!(pageNo>pageEnd || pageNo > totalPage)){
			
			if(cPage == pageNo ){
				pageBar += "<span class='cPage'>"+pageNo+"</span> ";
			} 
			else {
				pageBar += "<a href='javascript:void(0);' onclick='fn_movePage("+ pageNo + ");'>" + pageNo +"</a> ";
			}
			pageNo++;
		}
		
		//[다음] section
		if(pageNo > totalPage){
			//pageBar += "<span>[다음]</span>";
		} else {
			pageBar += "<a href='javascript:void(0);' onclick='fn_movePage("+ pageNo + ");'>[다음]</a>";
		}
			
		request.setAttribute("bookList",bookList);
		request.setAttribute("pageBar",pageBar);	
		request.getRequestDispatcher("/WEB-INF/views/oldboard/bookList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package search.controller;

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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search/searchBook")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType");	// all, title, writer, publisher
		String searchBook = request.getParameter("searchBook");
		
		List<Book> list = null;
		
		String type = "";

		int cPage;
		int numPerPage = 5;
		int totalBoard = 0;
		
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e) {
			cPage = 1;
		}
		
		switch(searchType) {
		case "all" :
			list = new BookService().selectBookByAll(cPage, numPerPage, searchBook);
			type = "전체";
			totalBoard = new BookService().selectBookByAllCount(searchBook);
			break;
		case "title" :
			list = new BookService().selectBookByTitle(cPage, numPerPage, searchBook);
			type = "책제목";
			totalBoard = new BookService().selectBookByTitleCount(searchBook);
			break;
		case "writer" :
			list = new BookService().selectBookByWriter(cPage, numPerPage, searchBook);
			type = "저자명";
			totalBoard = new BookService().selectBookByWriterCount(searchBook);
			break;
		case "publisher" :
			list = new BookService().selectBookByPublisher(cPage, numPerPage, searchBook);
			type = "출판사명";
			totalBoard = new BookService().selectBookByPublisherCount(searchBook);
			break;
		}
		
		
		int totalPage = (int) Math.ceil((double)totalBoard/numPerPage);		
		
		String pageBar = "";
		int pageBarSize = 5;
		int pageNo = (cPage-1)/pageBarSize*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;	
		
		// [이전]
		if(pageNo == 1) { 
			// pageBar = "<span>[이전]</span>";
		} else {
			pageBar += "<a href= '"+request.getContextPath()+"/search/searchBook?searchType="+searchType+"&searchBook="+searchBook+"&cPage="+(pageNo-1)+"'><span>[이전]</span></a>";
		}
		
		// [pageNo]
		while(pageNo<=pageEnd && pageNo<=totalPage) {
			if(pageNo == cPage) {
				pageBar += "<span>" + pageNo + "</span>";				
			} else {
				pageBar += "<a href="+request.getContextPath()+"/search/searchBook?searchType="+searchType+"&searchBook="+searchBook+"&cPage="+pageNo+"><span>"+pageNo+"</span></a>";
			}
			pageNo++;
		}
		
		// [다음]
		if(pageNo > totalPage) {
			
		} else {
			pageBar += "<a href= '"+request.getContextPath()+"/search/searchBook?searchType="+searchType+"&searchBook="+searchBook+"&cPage="+pageNo+"'><span>[다음]</span></a>";
		}	
		
		request.setAttribute("list", list);
		request.setAttribute("type", type);
		request.setAttribute("searchBook", searchBook);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("cPage", cPage);
		
		request.getRequestDispatcher("/WEB-INF/views/search/search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

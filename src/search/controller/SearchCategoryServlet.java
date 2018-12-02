package search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.service.BookService;
import book.model.vo.Book;

/**
 * Servlet implementation class SearchCategoryServlet
 */
@WebServlet("/search/searchCategory")
public class SearchCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage = 1;
		}
		int numPerPage = 5;
		int totalBook = new BookService().selectBookCategoryCount(category);
		
		int totalPage = (int)Math.ceil((double)totalBook/numPerPage);
		System.out.println(totalBook +", "+totalPage);
		List<Book> list = new BookService().selectBookCategoryList(category, cPage,numPerPage);
		
		
		
		String pageBar = "";
		int pageBarSize = 5;
		int pageNo = (cPage-1)/pageBarSize*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;	
		
		// [이전]
		if(pageNo == 1) { 
			// pageBar = "<span>[이전]</span>";
		} else {
			pageBar += "<a href= '"+request.getContextPath()+"/search/searchCategory?category="+category+"&cPage="+(pageNo-1)+"'><span>[이전]</span></a>";
		}
		
		// [pageNo]
		while(pageNo<=pageEnd && pageNo<=totalPage) {
			if(pageNo == cPage) {
				pageBar += "<span>" + pageNo + "</span>";				
			} else {
				pageBar += "<a href="+request.getContextPath()+"/search/searchCategory?category="+category+"&cPage="+pageNo+"><span>"+pageNo+"</span></a>";
			}
			pageNo++;
		}
		
		// [다음]
		if(pageNo > totalPage) {
			
		} else {
			pageBar += "<a href= '"+request.getContextPath()+"/search/searchCategory?category="+category+"&cPage="+pageNo+"'><span>[다음]</span></a>";
		}	
		
		//2. view단 처리위임
		request.setAttribute("list", list);
		request.setAttribute("category", category);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("cPage", cPage);
		request.getRequestDispatcher("/WEB-INF/views/book/bookList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

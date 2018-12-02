package admin.controller;

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
 * Servlet implementation class BookAdminSearch
 */
@WebServlet("/admin/searchBook")
public class BookAdminSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAdminSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String searchType5 = request.getParameter("searchType5");	// all, title, writer, publisher
	String searchBook5 = request.getParameter("searchBook5");
	
	List<Book> list5 = null;
	
	String type5 = "";

	int cPage5;
	int numPerPage5 = 5;
	int totalBoard5 = 0;
	
	try {
		cPage5 = Integer.parseInt(request.getParameter("cPage5"));
	} catch(NumberFormatException e) {
		cPage5 = 1;
	}
	
	switch(searchType5) {
	case "all" :
		list5 = new BookService().selectBookByAll(cPage5, numPerPage5, searchBook5);
		type5 = "전체";
		totalBoard5 = new BookService().selectBookByAllCount(searchBook5);
		break;
	case "title" :
		list5 = new BookService().selectBookByTitle(cPage5, numPerPage5, searchBook5);
		type5 = "책제목";
		totalBoard5 = new BookService().selectBookByTitleCount(searchBook5);
		break;
	case "writer" :
		list5 = new BookService().selectBookByWriter(cPage5, numPerPage5, searchBook5);
		type5 = "저자명";
		totalBoard5 = new BookService().selectBookByWriterCount(searchBook5);
		break;
	case "publisher" :
		list5 = new BookService().selectBookByPublisher(cPage5, numPerPage5, searchBook5);
		type5 = "출판사명";
		totalBoard5 = new BookService().selectBookByPublisherCount(searchBook5);
		break;
	}
	
	
	int totalPage = (int) Math.ceil((double)totalBoard5/numPerPage5);		
	
	String pageBar5 = "";
	int pageBarSize5 = 5;
	int pageNo5 = (cPage5-1)/pageBarSize5*pageBarSize5+1;
	int pageEnd5 = pageNo5+pageBarSize5-1;	
	
	// [이전]
	if(pageNo5 == 1) { 
		// pageBar = "<span>[이전]</span>";
	} else {
		pageBar5 += "<a href= '"+request.getContextPath()+"/admin/searchBook?searchType5="+searchType5+"&searchBook5="+searchBook5+"&cPage5="+(pageNo5-1)+"'><span>[이전]</span></a>";
	}
	
	// [pageNo]
	while(pageNo5<=pageEnd5 && pageNo5<=totalPage) {
		if(pageNo5 == cPage5) {
			pageBar5 += "<span>" + pageNo5 + "</span>";				
		} else {
			pageBar5 += "<a href="+request.getContextPath()+"/admin/searchBook?searchType5="+searchType5+"&searchBook5="+searchBook5+"&cPage5="+pageNo5+"><span>"+pageNo5+"</span></a>";
		}
		pageNo5++;
	}
	
	// [다음]
	if(pageNo5 > totalPage) {
		
	} else {
		pageBar5 += "<a href= '"+request.getContextPath()+"/admin/searchBook?searchType5="+searchType5+"&searchBook5="+searchBook5+"&cPage5="+pageNo5+"'><span>[다음]</span></a>";
	}	
	
	request.setAttribute("booklist", list5);
	request.setAttribute("type5", type5);
	request.setAttribute("searchBook5", searchBook5);
	request.setAttribute("pageBar5", pageBar5);
	request.setAttribute("cPage5", cPage5);
	
	request.getRequestDispatcher("/WEB-INF/views/admin/bookListView.jsp").forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

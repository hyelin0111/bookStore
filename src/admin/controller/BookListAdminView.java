package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import book.model.vo.Book;

/**
 * Servlet implementation class BookListAdminView
 */
@WebServlet("/book/bookListView")
public class BookListAdminView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookListAdminView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		List<Book> booklist = null;

		int cPage;
		int numPerPage = 5;
		int totalBoard = 0;

		try {
			cPage = Integer.parseInt(request.getParameter("cPage5"));
		} catch (NumberFormatException e) {
			cPage = 1;
		}

		booklist = new AdminService().selectBookListAll(cPage, numPerPage);
		totalBoard = new AdminService().selectBookByAllCount();

		int totalPage = (int) Math.ceil((double) totalBoard / numPerPage);

		String pageBar = "";
		int pageBarSize = 5;
		int pageNo = (cPage - 1) / pageBarSize * pageBarSize + 1;
		int pageEnd = pageNo + pageBarSize - 1;

		// [이전]
		if (pageNo == 1) {
			// pageBar = "<span>[이전]</span>";
		} else {
			pageBar += "<a href= '" + request.getContextPath() + "/book/bookListView?searchBook="
					+ "&cPage5=" + (pageNo - 1) + "'><span>[이전]</span></a>";
		}

		// [pageNo]
		while (pageNo <= pageEnd && pageNo <= totalPage) {
			if (pageNo == cPage) {
				pageBar += "<span>" + pageNo + "</span>";
			} else {
				pageBar += "<a href=" + request.getContextPath() + "/book/bookListView?searchBook="
						+ "&cPage5=" + pageNo + "><span>" + pageNo + "</span></a>";
			}
			pageNo++;
		}

		// [다음]
		if (pageNo > totalPage) {

		} else {
			pageBar += "<a href= '" + request.getContextPath() + "/book/bookListView?searchBook="
					+ "&cPage5=" + pageNo + "'><span>[다음]</span></a>";
		}

		request.setAttribute("booklist", booklist);
		request.setAttribute("pageBar5", pageBar);
		request.setAttribute("cPage5", cPage);

		request.getRequestDispatcher("/WEB-INF/views/admin/bookListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

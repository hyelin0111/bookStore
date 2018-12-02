package order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.model.service.OrderService;
import order.model.vo.CancelOrder;

/**
 * Servlet implementation class CancelOrderListPageEnd
 */
@WebServlet("/order/cancelorderListPageEnd")
public class CancelOrderListPageEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderListPageEnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int numPerPage = 7;
		int cPage;
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String bookTitle = request.getParameter("bookTitle");
		
		if(startDate.equals("") || endDate.equals("")) {
			startDate = "1900-01-01";
			endDate = "2100-01-01";
		}
		

		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage = 1;
		}
//		System.out.println("memberNo="+memberNo+"\t "+startDate+"\t "+endDate+"\t "+"\t "+bookTitle);
		List<CancelOrder> list = new OrderService().selectCancelOrderByDate(memberNo, startDate, endDate, bookTitle, cPage, numPerPage);
		
//		List<Book> bookList = new BookService().selectSearchBookList(cPage, numPerPage, searchKeyword);
//		int totalBookCount = new BookService().selectSearchBookCount(searchKeyword);
//		int totalPage = (int) Math.ceil((double) totalBookCount / numPerPage);

		int totalBookCount = new OrderService().selectCancelOrderByDateCount(memberNo, startDate, endDate, bookTitle);
		int totalPage = (int) Math.ceil((double) totalBookCount / numPerPage);


		// 페이지바구성
		String pageBar = "";
		int pageBarSize = 5;

		// 시작페이지 번호 세팅
		int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
		// 종료페이지 번호 세팅
		int pageEnd = pageNo + pageBarSize - 1;
		
//		System.out.println("totalBookCount="+ totalBookCount+"\t totalPage="+ totalPage+"pageNo="+pageNo + "\t pageEnd" + pageEnd);
		
		// [이전] section
		if (pageNo == 1) {
			// pageBar += "<span>[이전]</span>";
		} else {
			pageBar += "<a class='page_a' href='javascript:void(0);' onclick='fn_movePage5(" + (pageNo - 1) + ");'>[이전]</a> ";
		}

		// pageNo section
		// 보통 !(빠져나가는 조건식)으로 많이 쓴다.
		// while(pageNo<=pageEnd && pageNo<=totalPage){
		while (!(pageNo > pageEnd || pageNo > totalPage)) {

			if (cPage == pageNo) {
				pageBar += "<span class='cPage'>" + pageNo + "</span> ";
			} else {
				pageBar += "<a class='page_a' href='javascript:void(0);' onclick='fn_movePage5(" + pageNo + ");'>" + pageNo + "</a> ";
			}
			pageNo++;
		}

		// [다음] section
		if (pageNo > totalPage) {
			// pageBar += "<span>[다음]</span>";
		} else {
			pageBar += "<a class='page_a' href='javascript:void(0);' onclick='fn_movePage5(" + pageNo + ");'>[다음]</a>";
		}
//		System.out.println("OrderListPageEnd@list"+list);
		
		request.setAttribute("list", list);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/WEB-INF/views/order/CancelOrderListPage.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

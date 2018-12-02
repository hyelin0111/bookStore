package oldboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oldboard.model.dao.OldBoardDAO;
import oldboard.model.service.OldBoardService;
import oldboard.model.vo.OldBoard;

/**
 * Servlet implementation class OldBoardServlet
 */
@WebServlet("/oldboard/OldBoardServlet")
public class OldBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OldBoardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int numPerPage = 10;// 한페이지당 수
		int cPage;// 요청페이지

		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage = 1;
		}

		List<OldBoard> oldBoardList = new OldBoardService().OldBoardList(cPage, numPerPage);

		// 페이지바
		int totalBoardCount = new OldBoardService().selectOldBoardCount();
		int totalPage = (int) Math.ceil((double) totalBoardCount / numPerPage);
		String pageBar = "";
		int pageBarSize = 5;
		int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;// 시작번호
		int pageEnd = pageNo + pageBarSize - 1;// 끝번호

		// [이전] section
		if (pageNo == 1) {
			// pageBar += "<span>[이전]</span>";
		} else {
			pageBar += "<a href='" + request.getContextPath() + "/oldboard/OldBoardServlet?cPage=" + (pageNo - 1)
					+ "'>[이전]</a> ";
		}

		// pageNo section
		// 보통 !(빠져나가는 조건식)으로 많이 쓴다.
		// while(pageNo<=pageEnd && pageNo<=totalPage){
		while (!(pageNo > pageEnd || pageNo > totalPage)) {

			if (cPage == pageNo) {
				pageBar += "<span class='cPage'>" + pageNo + "</span> ";
			} else {
				pageBar += "<a href='" + request.getContextPath() + "/oldboard/OldBoardServlet?cPage=" + pageNo
						+ "'>" + pageNo + "</a> ";
			}
			pageNo++;
		}

		// [다음] section
		if (pageNo > totalPage) {
			// pageBar += "<span>[다음]</span>";
		} else {
			pageBar += "<a href='" + request.getContextPath() + "/oldboard/OldBoardServlet?cPage=" + pageNo
					+ "'>[다음]</a>";
		}

		request.setAttribute("oldBoardList", oldBoardList);
		request.setAttribute("pageBar",pageBar);
		request.getRequestDispatcher("/WEB-INF/views/oldboard/oldBoard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

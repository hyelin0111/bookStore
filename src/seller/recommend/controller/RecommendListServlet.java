package recommend.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oldboard.model.service.OldBoardService;
import recommend.model.service.RecommendService;
import recommend.model.vo.Recommend;

/**
 * Servlet implementation class RecommendListServlet
 */
@WebServlet("/recommend/RecommenListServlet")
public class RecommendListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numPerPage = 10;// 한페이지당 수
		int cPage;// 요청페이지
		
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage = 1;
		}
		
		List<Recommend> recommendList = new RecommendService().selectRecommendList(cPage, numPerPage);
		
		// 페이지바
		int totalRecommendCount = new RecommendService().selectRecommendCount();
		int totalPage = (int) Math.ceil((double) totalRecommendCount / numPerPage);
		String pageBar = "";
		int pageBarSize = 5;
		int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;// 시작번호
		int pageEnd = pageNo + pageBarSize - 1;// 끝번호
		
		if (pageNo == 1) {
			// pageBar += "<span>[이전]</span>";
		} else {
			pageBar += "<a href='" + request.getContextPath() + "/recommend/RecommenListServlet?cPage=" + (pageNo - 1)
					+ "'>[이전]</a> ";
		}

		// pageNo section
		// 보통 !(빠져나가는 조건식)으로 많이 쓴다.
		// while(pageNo<=pageEnd && pageNo<=totalPage){
		while (!(pageNo > pageEnd || pageNo > totalPage)) {

			if (cPage == pageNo) {
				pageBar += "<span class='cPage'>" + pageNo + "</span> ";
			} else {
				pageBar += "<a href='" + request.getContextPath() + "/recommend/RecommenListServlet?cPage=" + pageNo
						+ "'>" + pageNo + "</a> ";
			}
			pageNo++;
		}

		// [다음] section
		if (pageNo > totalPage) {
			// pageBar += "<span>[다음]</span>";
		} else {
			pageBar += "<a href='" + request.getContextPath() + "/recommend/RecommenListServlet?cPage=" + pageNo
					+ "'>[다음]</a>";
		}

		request.setAttribute("recommendList", recommendList);
		request.setAttribute("pageBar",pageBar);
		request.getRequestDispatcher("/WEB-INF/views/recommend/library.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
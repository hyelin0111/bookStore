package oldboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oldboard.model.service.OldBoardService;
import oldboard.model.vo.OldBoard;

/**
 * Servlet implementation class WriteOldBoardEndServlet
 */
@WebServlet("/oldboard/writeOldBoardEnd")
public class WriteOldBoardEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteOldBoardEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String bookNo = request.getParameter("bookNo");
		int price = Integer.parseInt(request.getParameter("price"));
		String condition = request.getParameter("condition");
		
		OldBoard ob = new OldBoard(price, bookNo, condition);
		
		//결과
		int result = new OldBoardService().insertOldBoard(ob, memberNo);
		
		String loc = "/oldboard/OldBoardServlet";
		String msg = "";
		if(result > 0) {
			msg = "판매 등록 완료";
		} else {
			msg = "판매 등록 실패";			
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

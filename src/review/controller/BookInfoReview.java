package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.Review;

/*
import review.model.vo.Review;*
 * Servlet implementation class BookInfoReview
 */
@WebServlet("/review/bookInfoReviewInsert")
public class BookInfoReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInfoReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=uft-8");
		
		String reviewWriter = request.getParameter("reviewWriter");
		String reviewbookNo = request.getParameter("reviewbookNo");
		String reviewText = request.getParameter("reviewText");
		
		Review r = new Review(0, reviewbookNo, reviewText, reviewWriter, null, "Y");
		int result = new ReviewService().insertBookReview(r);
		
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc ="/book/bestSellerEnd?bookNo=" + reviewbookNo;
		
		if(result > 0) 
			msg = "댓글 등록 성공!";
		else
			msg = "댓글 등록 실패";
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

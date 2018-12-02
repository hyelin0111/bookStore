package review.model.service;

import java.sql.Connection;
import java.util.List;

import static common.JDBCTemplate.*;

import review.model.dao.ReviewDAO;
import review.model.vo.Review;

public class ReviewService {



	public List<Review> selectReviewOne(String bookNo) {
		Connection conn = getConnection();
		List<Review> review = new ReviewDAO().selectReviewOne(conn, bookNo);
		close(conn);
		return review;
	}

	public int insertBookReview(Review r) {
		Connection conn = getConnection();
		int result= new ReviewDAO().insertBookReview(conn, r);
		close(conn);
		return result;
	}

	public int bookReviewDelete(String bno, String rno) {
		Connection conn = getConnection();
		int result= new ReviewDAO().bookReviewDelete(conn, bno, rno);
		close(conn);
		return result;
	}

}

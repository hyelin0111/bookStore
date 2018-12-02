package review.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import book.model.vo.Book;
import review.model.vo.Review;

public class ReviewDAO {
	private Properties prop = new Properties();
	
	public ReviewDAO() {try {
		String fileName = Review.class.getResource("/sql/review/review-query.properties").getPath();
		prop.load( new FileReader(fileName));			
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}}

	public List<Review> selectReviewOne(Connection conn, String bookNo) {
		List<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query = prop.getProperty("selectBookReviewList");
		
		try {
			pstmt = conn.prepareStatement(query);			
			pstmt.setString(1, bookNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Review review = new Review();
				review.setReviewNo(rset.getInt("review_no"));
				review.setBookNo(rset.getString("book_no"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewWriter(rset.getString("review_writer"));
				review.setReviewDate(rset.getDate("review_date"));
				review.setBookStatus(rset.getString("book_status"));
				list.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		return list;
	}

	public int insertBookReview(Connection conn, Review r) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertBookReview");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, r.getBookNo());
			pstmt.setString(2, r.getReviewContent());
			pstmt.setString(3, r.getReviewWriter());
			
			result = pstmt.executeUpdate();
			System.out.println("result@ReviewDAO = " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int bookReviewDelete(Connection conn, String bno, String rno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("bookReviewDelete");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, rno);
			pstmt.setString(2, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}

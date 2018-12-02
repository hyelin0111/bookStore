package oldboard.model.dao;

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
import oldboard.model.vo.OldBoard;

public class OldBoardDAO {
	private Properties prop = new Properties();

	public OldBoardDAO() {
		try {
			String fileName = OldBoardDAO.class.getResource("/sql/oldboard/oldboard-query.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int selectOldBoardCount(Connection conn) {
		PreparedStatement pstmt = null;
		int totalOldBoard = 0;
		ResultSet rset = null;
		String query = prop.getProperty("selectOldBoardCount");

		try {
			// 미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);

			// 쿼리문실행
			rset = pstmt.executeQuery();

			while (rset.next()) {
				totalOldBoard = rset.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return totalOldBoard;
	}

	public List<OldBoard> selectOldBoardList(Connection conn, int cPage, int numPerPage) {
		List<OldBoard> oldBoardList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectOldBoardList");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, (cPage - 1) * numPerPage + 1);
			pstmt.setInt(2, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				OldBoard ob = new OldBoard();

				ob.setOldBoardNo(rset.getInt("old_board_no"));
				ob.setBookTitle(rset.getString("book_title"));
				ob.setMemberName(rset.getString("member_name"));
				ob.setOldBoardDate(rset.getDate("old_board_date"));
				ob.setOldBookPrice(rset.getInt("old_price"));

				oldBoardList.add(ob);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return oldBoardList;
	}

	public int insertOldBoard(Connection conn, OldBoard ob, int memberNo) {
		PreparedStatement pstmt = null;

		int result = 0;
		String query = prop.getProperty("insertOldBoard");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, ob.getOldBookNo());
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, ob.getOldBookPrice());
			pstmt.setString(4, ob.getBookCondition());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public OldBoard selectOneOldBoard(Connection conn, int oldBoardNo) {
		OldBoard ob = new OldBoard();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectOneOldBoard");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, oldBoardNo);

			rset = pstmt.executeQuery();

			rset.next();

			ob.setOldBoardNo(rset.getInt("old_board_no"));
			ob.setMemberName(rset.getString("member_name"));
			ob.setOldBookNo(rset.getString("book_no"));
			ob.setOldBookPrice(rset.getInt("old_price"));
			ob.setOldBoardDate(rset.getDate("old_board_date"));
			ob.setOldBookCount(rset.getInt("old_count"));
			ob.setBookCondition(rset.getString("book_condition"));
			ob.setBookStatus(rset.getString("book_status"));
			ob.setMemberNo(rset.getInt("member_no"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return ob;
	}

	public Book selectOneBook(Connection conn, String bookNo) {
		Book b = new Book();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectOneBook");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookNo);

			rset = pstmt.executeQuery();

			rset.next();

			b.setAuthorName(rset.getString("author_name"));
			b.setBookTitle(rset.getString("book_title"));
			b.setBookPublisher(rset.getString("book_publisher"));
			b.setIssueDate(rset.getDate("book_issue_date"));
			b.setBookPage(rset.getInt("book_page"));
			b.setBookPrice(rset.getInt("book_price"));
			b.setCategory(rset.getString("book_category"));
			b.setBookNo(rset.getString("book_no"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return b;
	}

	public OldBoard selectOnebyOldBoardNo(Connection conn, int oldBoardNo) {
		OldBoard ob = new OldBoard();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectOnebyOldBoardNo");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, oldBoardNo);

			rset = pstmt.executeQuery();

			rset.next();

			ob.setOldBoardNo(rset.getInt("old_board_no"));
			ob.setOldBookNo(rset.getString("book_no"));
			ob.setMemberNo(rset.getInt("member_no"));
			ob.setOldBoardDate(rset.getDate("old_board_date"));
			ob.setOldBookPrice(rset.getInt("old_price"));
			ob.setOldBookCount(rset.getInt("old_count"));
			ob.setBookCondition(rset.getString("book_condition"));
			ob.setBookTitle(rset.getString("book_title"));
			ob.setBookStatus(rset.getString("book_status"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return ob;
	}
	
	public int deleteOldBoard(Connection conn, int boardNo) {
	      int result = 0;
	      PreparedStatement pstmt = null;
	      
	      String query = prop.getProperty("deleteOldBoard");      
	      
	      try {
	         pstmt  = conn.prepareStatement(query);
	         pstmt.setInt(1, boardNo);
	         
	         result = pstmt.executeUpdate();         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      
	      return result;
	   }
}

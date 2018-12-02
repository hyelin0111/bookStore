package book.model.dao;

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
import order.model.vo.Order;

public class BookDAO {
	private Properties prop = new Properties();

	public BookDAO() {
		try {
			String fileName = BookDAO.class.getResource("/sql/book/book-query.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Book> selectWeeklyBookList(Connection conn) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectWeeklyBookList");

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));

				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Book> selectBestList(Connection conn) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBestSellerList");

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));

				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public Book selectBookOneList(Connection conn, String bookno) {
		Book b = new Book();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookOneList");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookno);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPage(rset.getInt("book_page"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				b.setBookBookStatus(rset.getString("book_status"));
				b.setBookSaleQty(rset.getInt("book_sale_qty"));
				b.setBookGrade(rset.getDouble("book_grade"));
				b.setAuthorNo(Integer.parseInt(rset.getString("writer_no")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return b;
	}

	public List<Book> selectBookByTitle(Connection conn, String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByTitle");

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));

				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Book> selectBookByWriter(Connection conn, int cPage, int numPerPage, String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByWriter");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setInt(2, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(3, cPage * numPerPage);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int selectBookByWriterCount(Connection conn, String searchBook) {
		int totalBoard = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByWriterCount");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchBook + "%");

			rset = pstmt.executeQuery();

			rset.next();
			totalBoard = rset.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return totalBoard;
	}

	public List<Book> selectBookByTitle(Connection conn, int cPage, int numPerPage, String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByTitle");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setInt(2, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(3, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int selectBookByTitleCount(Connection conn, String searchBook) {
		int totalBoard = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByTitleCount");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchBook + "%");

			rset = pstmt.executeQuery();

			rset.next();
			totalBoard = rset.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return totalBoard;
	}

	public List<Book> selectBookByPublisher(Connection conn, int cPage, int numPerPage, String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByPublisher");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setInt(2, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(3, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int selectBookByPublisherCount(Connection conn, String searchBook) {
		int totalBoard = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByPublisherCount");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchBook + "%");

			rset = pstmt.executeQuery();

			rset.next();
			totalBoard = rset.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return totalBoard;
	}

	public List<Book> selectBookByAll(Connection conn, int cPage, int numPerPage, String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByAll");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setString(2, "%" + searchBook + "%");
			pstmt.setString(3, "%" + searchBook + "%");
			pstmt.setInt(4, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(5, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int selectBookByAllCount(Connection conn, String searchBook) {
		int totalBoard = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByAllCount");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setString(2, "%" + searchBook + "%");
			pstmt.setString(3, "%" + searchBook + "%");

			rset = pstmt.executeQuery();

			rset.next();
			totalBoard = rset.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return totalBoard;
	}

	public List<Book> selectTodayBookList(Connection conn) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectTodayBookList");

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));

				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public List<Book> selectBookList(Connection conn, int cPage, int numPerPage) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookList");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, (cPage - 1) * numPerPage + 1);
			pstmt.setInt(2, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setCategory(rset.getString("book_category"));
				b.setBookNo(rset.getString("book_no"));

				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int selectBookCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int totalBook = 0;
		String query = prop.getProperty("selectBookCount");

		try {
			// 미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);

			// 쿼리문실행
			rset = pstmt.executeQuery();

			while (rset.next()) {
				totalBook = rset.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return totalBook;
	}

	public List<Book> selectSearchBookList(Connection conn, int cPage, int numPerPage, String searchKeyword) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectSearchBookList");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchKeyword + "%");
			pstmt.setInt(2, (cPage - 1) * numPerPage + 1);
			pstmt.setInt(3, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setCategory(rset.getString("book_category"));
				b.setBookNo(rset.getString("book_no"));

				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int selectSearchBookCount(Connection conn, String searchKeyword) {
		int totalSearchCnt = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectSearchBookCount");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + searchKeyword + "%");

			rset = pstmt.executeQuery();

			rset.next();
			totalSearchCnt = rset.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return totalSearchCnt;
	}

	public List<Book> selectBookByAllOrderBySellAmount(Connection conn, int cPage, int numPerPage, String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByAllOrderBySellAmount");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setString(2, "%" + searchBook + "%");
			pstmt.setString(3, "%" + searchBook + "%");
			pstmt.setInt(4, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(5, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;

	}

	public List<Book> selectBookByTitleOrderBySellAmount(Connection conn, int cPage, int numPerPage,
			String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByTitleOrderBySellAmount");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setInt(2, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(3, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Book> selectBookByWriterOrderBySellAmount(Connection conn, int cPage, int numPerPage,
			String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByWriterOrderBySellAmount");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setInt(2, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(3, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Book> selectBookByPublisherOrderBySellAmount(Connection conn, int cPage, int numPerPage,
			String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByPublisherOrderBySellAmount");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setInt(2, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(3, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Book> selectBookByAllOrderByHighPrice(Connection conn, int cPage, int numPerPage, String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByAllOrderByHighPrice");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setString(2, "%" + searchBook + "%");
			pstmt.setString(3, "%" + searchBook + "%");
			pstmt.setInt(4, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(5, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Book> selectBookByTitleOrderByHighPrice(Connection conn, int cPage, int numPerPage, String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByTitleOrderByHighPrice");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setInt(2, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(3, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Book> selectBookByWriterOrderByHighPrice(Connection conn, int cPage, int numPerPage,
			String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByWriterOrderByHighPrice");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setInt(2, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(3, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Book> selectBookByPublisherOrderByHighPrice(Connection conn, int cPage, int numPerPage,
			String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByPublisherOrderByHighPrice");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setInt(2, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(3, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Book> selectBookByAllOrderByRowPrice(Connection conn, int cPage, int numPerPage, String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByAllOrderByRowPrice");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setString(2, "%" + searchBook + "%");
			pstmt.setString(3, "%" + searchBook + "%");
			pstmt.setInt(4, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(5, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Book> selectBookByTitleOrderByRowPrice(Connection conn, int cPage, int numPerPage, String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByTitleOrderByRowPrice");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setInt(2, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(3, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Book> selectBookByWriterOrderByRowPrice(Connection conn, int cPage, int numPerPage, String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByWriterOrderByRowPrice");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setInt(2, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(3, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public List<Book> selectBookByPublisherOrderByRowPrice(Connection conn, int cPage, int numPerPage,
			String searchBook) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookByPublisherOrderByRowPrice");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + searchBook + "%");
			pstmt.setInt(2, ((cPage - 1) * numPerPage) + 1);
			pstmt.setInt(3, cPage * numPerPage);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public String selectBookTitleByBookNo(Connection conn, String bookNo) {
		String BookTitle = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBookTitleByBookNo");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookNo);

			rset = pstmt.executeQuery();

			rset.next();
			BookTitle = rset.getString("title");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return BookTitle;
	}
	public int selelctBookCategoryCount(Connection conn, String category) {
		int totalBook = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selelctBookCategoryCount");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category	);
			rset = pstmt.executeQuery();
			rset.next();
			totalBook = rset.getInt("cnt");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return totalBook;
	}

	public List<Book> selectBookCategoryList(Connection conn, String category,int cPage, int numPerPage) {
		List<Book> list =null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectBookCategoryListByPaging");
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, category);
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);
			
			rset= pstmt.executeQuery();
			list = new ArrayList<>();
			while(rset.next()) {
				Book b = new Book();
				b.setBookNo(rset.getString("book_no"));
				b.setAuthorNo(rset.getInt("writer_no"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setBookPage(rset.getInt("book_page"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("cate"));
				b.setBookStatus(rset.getString("book_status"));
				b.setBookSaleQty(rset.getInt("book_sale_qty"));
				b.setBookGrade(rset.getDouble("book_grade"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setAuthorName(rset.getString("author_name"));
				
				list.add(b);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
}

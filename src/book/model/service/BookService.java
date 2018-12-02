package book.model.service;

import java.sql.Connection;
import java.util.List;

import book.model.dao.BookDAO;
import book.model.vo.Book;
import order.model.vo.Order;

import static common.JDBCTemplate.*;

public class BookService {

	public List<Book> selectBestList() {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBestList(conn);
		close(conn);
		return list;
	}

	public Book selectBookOneList(String bookNo) {
		Connection conn = getConnection();
		Book book = new BookDAO().selectBookOneList(conn, bookNo);
		close(conn);
		return book;
	}

	public List<Book> weeklyBookList() {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectWeeklyBookList(conn);
		close(conn);
		return list;
	}

	public List<Book> selectBookByTitle(String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByTitle(conn, searchBook);
		close(conn);
		return list;
	}

	public List<Book> selectBookByWriter(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByWriter(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public int selectBookByWriterCount(String searchBook) {
		Connection conn = getConnection();
		int totalBoard = new BookDAO().selectBookByWriterCount(conn, searchBook);
		close(conn);
		return totalBoard;
	}

	public int selectBookByTitleCount(String searchBook) {
		Connection conn = getConnection();
		int totalBoard = new BookDAO().selectBookByTitleCount(conn, searchBook);
		close(conn);
		return totalBoard;
	}

	public List<Book> selectBookByTitle(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByTitle(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public List<Book> selectBookByPublisher(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByPublisher(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public int selectBookByPublisherCount(String searchBook) {
		Connection conn = getConnection();
		int totalBoard = new BookDAO().selectBookByPublisherCount(conn, searchBook);
		close(conn);
		return totalBoard;
	}

	public List<Book> selectBookByAll(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByAll(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public int selectBookByAllCount(String searchBook) {
		Connection conn = getConnection();
		int totalBoard = new BookDAO().selectBookByAllCount(conn, searchBook);
		close(conn);
		return totalBoard;
	}

	public List<Book> todayBookList() {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectTodayBookList(conn);
		close(conn);
		return list;
	}

	public List<Book> selectBookList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Book> bookList = new BookDAO().selectBookList(conn, cPage, numPerPage);

		close(conn);

		return bookList;
	}

	public int selectBookCount() {
		Connection conn = getConnection();
		int totalBookCount = new BookDAO().selectBookCount(conn);

		close(conn);

		return totalBookCount;
	}

	public List<Book> selectSearchBookList(int cPage, int numPerPage, String searchKeyword) {
		Connection conn = getConnection();
		List<Book> searchList = new BookDAO().selectSearchBookList(conn, cPage, numPerPage, searchKeyword);

		close(conn);

		return searchList;
	}

	public int selectSearchBookCount(String searchKeyword) {
		Connection conn = getConnection();
		int totalBookCount = new BookDAO().selectSearchBookCount(conn, searchKeyword);

		close(conn);

		return totalBookCount;
	}

	public List<Book> selectBookByAllOrderBySellAmount(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByAllOrderBySellAmount(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public List<Book> selectBookByTitleOrderBySellAmount(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByTitleOrderBySellAmount(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public List<Book> selectBookByWriterOrderBySellAmount(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByWriterOrderBySellAmount(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public List<Book> selectBookByPublisherOrderBySellAmount(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByPublisherOrderBySellAmount(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public List<Book> selectBookByAllOrderByHighPrice(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByAllOrderByHighPrice(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public List<Book> selectBookByTitleOrderByHighPrice(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByTitleOrderByHighPrice(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public List<Book> selectBookByWriterOrderByHighPrice(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByWriterOrderByHighPrice(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public List<Book> selectBookByPublisherOrderByHighPrice(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByPublisherOrderByHighPrice(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public List<Book> selectBookByAllOrderByRowPrice(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByAllOrderByRowPrice(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public List<Book> selectBookByTitleOrderByRowPrice(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByTitleOrderByRowPrice(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public List<Book> selectBookByWriterOrderByRowPrice(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByWriterOrderByRowPrice(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public List<Book> selectBookByPublisherOrderByRowPrice(int cPage, int numPerPage, String searchBook) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookByPublisherOrderByRowPrice(conn, cPage, numPerPage, searchBook);
		close(conn);
		return list;
	}

	public String selectBookTitleByBookNo(String BookNo) {
		Connection conn = getConnection();
		String BookTitle = new BookDAO().selectBookTitleByBookNo(conn, BookNo);
		close(conn);
		return BookTitle;
	}
	
	public int selectBookCategoryCount(String category) {
		Connection conn = getConnection();
		int totalBook = new BookDAO().selelctBookCategoryCount(conn,category);
		close(conn);
		return totalBook;
	}

	public List<Book> selectBookCategoryList(String category,int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Book> list = new BookDAO().selectBookCategoryList(conn, category, cPage,numPerPage);
		close(conn);
		return list;
	}

}

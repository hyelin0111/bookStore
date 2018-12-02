package order.model.service;


import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import order.model.dao.OrderDAO;
import order.model.vo.CancelOrder;
import order.model.vo.Order;

public class OrderService {

	public int insertOrder(int memberNo, String bookNo, int bookCnt, String bookStatus) {
		Connection conn = getConnection();
		
		int result = new OrderDAO().insertOrder(conn, memberNo, bookNo, bookCnt, bookStatus);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public List<Order> selectOrderByDate(int memberNo, String startDate, String endDate, String bookTitle) {
		Connection conn = getConnection();
		List<Order> searchList = new OrderDAO().selectOrderByDate(conn, memberNo, startDate, endDate, bookTitle);
		
		close(conn);
		
		return searchList;
	}

	public List<Order> selectOldOrderByDate(int memberNo, String startDate, String endDate, String bookTitle) {
		Connection conn = getConnection();
		List<Order> searchList = new OrderDAO().selectOldOrderByDate(conn, memberNo, startDate, endDate, bookTitle);
		
		close(conn);
		
		return searchList;
	}

	public int selectOrderNo() {
		Connection conn = getConnection();
		
		int orderNo = new OrderDAO().selectOrderNo(conn);
		close(conn);
		
		return orderNo;
	}

	public int insertBasketOrder(int orderNo, int memberNo, String bookNo, int amount, String bookStatus) {
		Connection conn = getConnection();
		
		int result = new OrderDAO().insertBasketOrder(conn, orderNo, memberNo, bookNo, amount, bookStatus);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	public int deleteOneOrder(int orderNo) {
		Connection conn = getConnection();
		int result = new OrderDAO().deleteOneOrder(conn,orderNo);
		close(conn);
		return result;
	}
	
	public List<Order> selectOldOrderByDate(int memberNo, String startDate, String endDate, String bookTitle, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Order> searchList = new OrderDAO().selectOldOrderByDate(conn, memberNo, startDate, endDate, bookTitle, cPage, numPerPage);
		
		close(conn);
		
		return searchList;
	}
	
	public int selectOldOrderByDateCount(int memberNo, String startDate, String endDate, String bookTitle) {
		Connection conn = getConnection();
		int totalOrderCount = new OrderDAO().selectOldOrderByDateCount(conn, memberNo, startDate, endDate, bookTitle);
		
		close(conn);
		
		return totalOrderCount;
	}

	public List<Order> selectOrderByDate(int memberNo, String startDate, String endDate, String bookTitle, int cPage,
			int numPerPage) {
		Connection conn = getConnection();
		List<Order> searchList = new OrderDAO().selectOrderByDate(conn, memberNo, startDate, endDate, bookTitle, cPage, numPerPage);
		
		close(conn);
		
		return searchList;
	}

	public int selectOrderByDateCount(int memberNo, String startDate, String endDate, String bookTitle) {
		Connection conn = getConnection();
		int totalOrderCount = new OrderDAO().selectOrderByDateCount(conn, memberNo, startDate, endDate, bookTitle);
		
		close(conn);
		
		return totalOrderCount;
	}

	public List<CancelOrder> selectCancelOldOrderByDate(int memberNo, String startDate, String endDate, String bookTitle, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<CancelOrder> searchList = new OrderDAO().selectCancelOldOrderByDate(conn, memberNo, startDate, endDate, bookTitle, cPage, numPerPage);
		
		close(conn);
		
		return searchList;
	}
	
	public int selectCancelOldOrderByDateCount(int memberNo, String startDate, String endDate, String bookTitle) {
		Connection conn = getConnection();
		int totalOrderCount = new OrderDAO().selectCancelOldOrderByDateCount(conn, memberNo, startDate, endDate, bookTitle);
		
		close(conn);
		
		return totalOrderCount;
	}
	
	public List<CancelOrder> selectCancelOrderByDate(int memberNo, String startDate, String endDate, String bookTitle, int cPage,
			int numPerPage) {
		Connection conn = getConnection();
		List<CancelOrder> searchList = new OrderDAO().selectCancelOrderByDate(conn, memberNo, startDate, endDate, bookTitle, cPage, numPerPage);
		
		close(conn);
		
		return searchList;
	}
	
	public int selectCancelOrderByDateCount(int memberNo, String startDate, String endDate, String bookTitle) {
		Connection conn = getConnection();
		int totalOrderCount = new OrderDAO().selectCancelOrderByDateCount(conn, memberNo, startDate, endDate, bookTitle);
		
		close(conn);
		
		return totalOrderCount;
	}
}

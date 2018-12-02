package order.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import order.model.vo.CancelOrder;
import order.model.vo.Order;

public class OrderDAO {
	private Properties prop = new Properties();
	public OrderDAO() {
		URL fileUrl = OrderDAO.class.getResource("/sql/order/order-query.properties");
		String fileName = fileUrl.getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int insertOrder(Connection conn, int memberNo, String bookNo, int bookCnt, String bookStatus) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertOrder");
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, bookNo);
			pstmt.setInt(3, bookCnt);
			pstmt.setString(4, bookStatus);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Order> selectOrderByDate(Connection conn, int memberNo, String startDate, String endDate, String bookTitle) {
		List<Order> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query = prop.getProperty("selectOrderByDate");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setInt(3, memberNo);
			pstmt.setString(4, "%" + bookTitle + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Order o = new Order();
				
				o.setMemberNo(rset.getInt("member_no"));
				o.setOrderNo(rset.getInt("order_no"));
				o.setBookNo(rset.getString("book_no"));
				o.setOrderQty(rset.getInt("order_qty"));
				o.setPayment(rset.getString("payment"));
				o.setDeliveryStatus(rset.getString("delivery_status"));
				o.setBookStatus(rset.getString("book_status"));
				o.setOrderDate(rset.getDate("order_date"));
				o.setBookTitle(rset.getString("book_title"));
				list.add(o);
			}
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		return list;
	}
	
	public List<Order> selectOldOrderByDate(Connection conn, int memberNo, String startDate, String endDate, String bookTitle) {
		List<Order> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query = prop.getProperty("selectOldOrderByDate");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setInt(3, memberNo);
			pstmt.setString(4, "%" + bookTitle + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Order o = new Order();
				
				o.setMemberNo(rset.getInt("member_no"));
				o.setOrderNo(rset.getInt("order_no"));
				o.setBookNo(rset.getString("book_no"));
				o.setOrderQty(rset.getInt("order_qty"));
				o.setPayment(rset.getString("payment"));
				o.setDeliveryStatus(rset.getString("delivery_status"));
				o.setBookStatus(rset.getString("book_status"));
				o.setOrderDate(rset.getDate("order_date"));
				o.setBookTitle(rset.getString("book_title"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		return list;
	}
	
	public int selectOrderNo(Connection conn) {
		int orderNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOrderNo");
		try {
			pstmt = conn.prepareStatement(query);
			rset= pstmt.executeQuery();
			rset.next();
			orderNo = rset.getInt("cnt");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return orderNo;
	}
	public int insertBasketOrder(Connection conn, int orderNo, int memberNo, String bookNo, int amount,
			String bookStatus) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertBasketOrder");
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, orderNo);
			pstmt.setString(3, bookNo);
			pstmt.setInt(4, amount);
			pstmt.setString(5, bookStatus);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int deleteOneOrder(Connection conn, int orderNo) {
		int result = 0;
		PreparedStatement pstmt =null;
		String query = prop.getProperty("deleteOneOrder");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, orderNo);
			
			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<Order> selectOldOrderByDate(Connection conn, int memberNo, String startDate, String endDate, String bookTitle, int cPage, int numPerPage) {
		List<Order> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query = prop.getProperty("selectOldOrderByDate");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setInt(3, memberNo);
			pstmt.setString(4, "%" + bookTitle + "%");
			// 추가
			pstmt.setInt(5, (cPage-1)*numPerPage+1);
			pstmt.setInt(6, cPage*numPerPage);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Order o = new Order();
				
				o.setMemberNo(rset.getInt("member_no"));
				o.setOrderNo(rset.getInt("order_no"));
				o.setBookNo(rset.getString("book_no"));
				o.setOrderQty(rset.getInt("order_qty"));
				o.setPayment(rset.getString("payment"));
				o.setDeliveryStatus(rset.getString("delivery_status"));
				o.setBookStatus(rset.getString("book_status"));
				o.setOrderDate(rset.getDate("order_date"));
				o.setBookTitle(rset.getString("book_title"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		return list;
	}
	public int selectOldOrderByDateCount(Connection conn, int memberNo, String startDate, String endDate,
			String bookTitle) {
		int totalSearchCnt = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query = prop.getProperty("selectOldOrderByDateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setInt(3, memberNo);
			pstmt.setString(4, "%" + bookTitle + "%");
			
			
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
	public List<Order> selectOrderByDate(Connection conn, int memberNo, String startDate, String endDate,
			String bookTitle, int cPage, int numPerPage) {
		List<Order> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query = prop.getProperty("selectOrderByDate");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setInt(3, memberNo);
			pstmt.setString(4, "%" + bookTitle + "%");
			// 추가
			pstmt.setInt(5, (cPage-1)*numPerPage+1);
			pstmt.setInt(6, cPage*numPerPage);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Order o = new Order();
				
				o.setMemberNo(rset.getInt("member_no"));
				o.setOrderNo(rset.getInt("order_no"));
				o.setBookNo(rset.getString("book_no"));
				o.setOrderQty(rset.getInt("order_qty"));
				o.setPayment(rset.getString("payment"));
				o.setDeliveryStatus(rset.getString("delivery_status"));
				o.setBookStatus(rset.getString("book_status"));
				o.setOrderDate(rset.getDate("order_date"));
				o.setBookTitle(rset.getString("book_title"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		return list;
	}
	public int selectOrderByDateCount(Connection conn, int memberNo, String startDate, String endDate,
			String bookTitle) {
		int totalSearchCnt = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query = prop.getProperty("selectOrderByDateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setInt(3, memberNo);
			pstmt.setString(4, "%" + bookTitle + "%");
			
			
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
	public List<CancelOrder> selectCancelOldOrderByDate(Connection conn, int memberNo, String startDate, String endDate,
			String bookTitle, int cPage, int numPerPage) {
		List<CancelOrder> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query = prop.getProperty("selectCancelOldOrderByDate");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setInt(3, memberNo);
			pstmt.setString(4, "%" + bookTitle + "%");
			// 추가
			pstmt.setInt(5, (cPage-1)*numPerPage+1);
			pstmt.setInt(6, cPage*numPerPage);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				CancelOrder o = new CancelOrder();
				
				o.setMemberNo(rset.getInt("member_no"));
				o.setOrderNo(rset.getInt("order_no"));
				o.setBookNo(rset.getString("book_no"));
				o.setOrderQTY(rset.getInt("order_qty"));
				o.setOrderDate(rset.getDate("order_date"));
				o.setOrderPayment(rset.getString("ORDER_PAYMENT"));
				o.setDelivertStatus(rset.getString("delivery_status"));
				o.setBookStatus(rset.getString("book_status"));
				o.setBookTitle(rset.getString("book_title"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		return list;
	}
	public int selectCancelOldOrderByDateCount(Connection conn, int memberNo, String startDate, String endDate,
			String bookTitle) {
		int totalSearchCnt = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query = prop.getProperty("selectCancelOldOrderByDateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setInt(3, memberNo);
			pstmt.setString(4, "%" + bookTitle + "%");
			
			
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
	public List<CancelOrder> selectCancelOrderByDate(Connection conn, int memberNo, String startDate, String endDate,
			String bookTitle, int cPage, int numPerPage) {
		List<CancelOrder> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query = prop.getProperty("selectCancelOrderByDate");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setInt(3, memberNo);
			pstmt.setString(4, "%" + bookTitle + "%");
			// 추가
			pstmt.setInt(5, (cPage-1)*numPerPage+1);
			pstmt.setInt(6, cPage*numPerPage);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				CancelOrder o = new CancelOrder();
				
				o.setMemberNo(rset.getInt("member_no"));
				o.setOrderNo(rset.getInt("order_no"));
				o.setBookNo(rset.getString("book_no"));
				o.setOrderQTY(rset.getInt("order_qty"));
				o.setOrderDate(rset.getDate("order_date"));
				o.setOrderPayment(rset.getString("ORDER_PAYMENT"));
				o.setDelivertStatus(rset.getString("delivery_status"));
				o.setBookStatus(rset.getString("book_status"));
				o.setBookTitle(rset.getString("book_title"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		return list;
	}
	public int selectCancelOrderByDateCount(Connection conn, int memberNo, String startDate, String endDate,
			String bookTitle) {
		int totalSearchCnt = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query = prop.getProperty("selectCancelOrderByDateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setInt(3, memberNo);
			pstmt.setString(4, "%" + bookTitle + "%");
			
			
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
}

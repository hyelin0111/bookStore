package seller.model.dao;

import static common.JDBCTemplate.*;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.dao.MemberDAO;
import seller.model.vo.Seller;

public class SellerDAO {
	private Properties prop = new Properties();
	public SellerDAO() {
		URL fileUrl = MemberDAO.class.getResource("/sql/seller/seller-query.properties");
		String fileName = fileUrl.getPath();//절대주소를 String타입으로 리턴
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertSeller(Connection conn, Seller seller) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertSeller");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, seller.getMember_no());
			pstmt.setString(2, seller.getTell_ok());
			pstmt.setString(3, seller.getEmail_ok());
			pstmt.setString(4, seller.getAccount_ok());
			pstmt.setString(5, seller.getDelivery_way());
			pstmt.setInt(6, seller.getDelivery_island_price());
			pstmt.setInt(7, seller.getDelivery_price());
			pstmt.setString(8, seller.getSeller_nickname());
			pstmt.setString(9, seller.getDelivery_chul());
			pstmt.setString(10,seller.getAccount_bank());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int insertCheck(Connection conn, int no) {
		int result = 1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("insertCheck");
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("insert_check");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int sellerCheck(Connection conn, int memberNo) {
		int result = 0;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String query = prop.getProperty("sellerCheck");
	      
	      
	      try {
	         pstmt = conn.prepareStatement(query);         
	         pstmt.setInt(1, memberNo);
	         
	         rset = pstmt.executeQuery();
	         
	         rset.next();
	         
	         result = rset.getInt("cnt");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      return result;
	}
}

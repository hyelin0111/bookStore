package basket.model.dao;

import static common.JDBCTemplate.*;

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

import basket.model.vo.Basket;

public class BasketDAO {
	private Properties prop = new Properties();

	public BasketDAO() {
		try {
			String fileName = BasketDAO.class.getResource("/sql/basket/basket-query.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Basket> selectBasketList(Connection conn, int memberNo) {
		List<Basket> basketList = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectBasketList");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Basket b = new Basket();

				b.setMemberNo(rset.getInt("member_no"));
				b.setMemberName(rset.getString("member_name"));
				b.setBookNo(rset.getString("book_no"));
				b.setBookTitle(rset.getString("book_title"));
				b.setAmount(rset.getInt("amount"));
				b.setUsedStatus(rset.getString("used_status"));
				b.setPrice(rset.getInt("price"));

				basketList.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return basketList;
	}

	public int insertBasket(Connection conn, Basket b) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("insertBasket");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getMemberNo());
			pstmt.setString(2, b.getBookNo());
			pstmt.setInt(3, b.getAmount());
			pstmt.setString(4, b.getUsedStatus());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteBookToBasket(Connection conn, int memberNo, String bookNo, String bookStatus) {
		PreparedStatement pstmt = null;

		int result = 0;
		String query = prop.getProperty("deleteBookToBasket");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, bookNo);
			pstmt.setString(3, bookStatus);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}

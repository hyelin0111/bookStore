package recommend.model.dao;

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

import recommend.model.vo.Recommend;

import static common.JDBCTemplate.*;

public class RecommendDAO {
	private Properties prop = new Properties();

	public RecommendDAO() {
		try {
			String fileName = RecommendDAO.class.getResource("/sql/recommend/recommend-query.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	public List<Recommend> seletRecommendList(Connection conn, int cPage, int numPerPage) {
		List<Recommend> recommendList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectRecommendList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, (cPage - 1) * numPerPage + 1);
			pstmt.setInt(2, cPage * numPerPage);
			
			 rset = pstmt.executeQuery();
			 
			 while( rset.next() ) {
				 Recommend r = new Recommend();
				 
				 r.setRecommendNo(rset.getInt("recommend_no"));
				 r.setRecommendBookNo(rset.getString("book_no"));
				 r.setRecommendTitle(rset.getString("recommend_title"));
				 r.setRecommendContent(rset.getString("recommend_content"));
				 r.setRecommendBookTitle(rset.getString("bookTitle"));
				 
				 recommendList.add(r);				 
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}				
		
		return recommendList;
	}

	public int selectRecommendCount(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Recommend> seletRecommendModify(Connection conn, int cPage, int numPerPage) {
		List<Recommend> recommendModify = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectRecommendModify");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, (cPage - 1) * numPerPage + 1);
			pstmt.setInt(2, cPage * numPerPage);
			
			 rset = pstmt.executeQuery();
			 
			 while( rset.next() ) {
				 Recommend r = new Recommend();
				 
				 r.setRecommendNo(rset.getInt("recommend_no"));
				 r.setRecommendBookNo(rset.getString("book_no"));
				 r.setRecommendTitle(rset.getString("recommend_title"));
				 r.setRecommendContent(rset.getString("recommend_content"));
				 
				 recommendModify.add(r);				 
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}				
		
		return recommendModify;
	}
}

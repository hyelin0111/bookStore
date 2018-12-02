package notice.model.dao;

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

import notice.model.vo.Notice;

public class NoticeDAO {
	private Properties prop = new Properties();
	
	public NoticeDAO() {
		try {
			String fileName = NoticeDAO.class.getResource("/sql/notice/notice-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public int selelctNoticeCount(Connection conn) {
		int totalNotice = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectNoticeCount");
		try {
			pstmt = conn.prepareStatement(query);
			rset= pstmt.executeQuery();
			rset.next();
			totalNotice = rset.getInt("cnt");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return totalNotice;
	}

	public List<Notice> selelctNoticeList(Connection conn, int cPage, int numPerPage) {
		List<Notice> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectNoticeListByPaging");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, (cPage - 1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rset.next()) {
				Notice n = new Notice();
				n.setNotice_no(rset.getInt("notice_no"));
				n.setMember_no(rset.getInt("member_no"));
				n.setContent(rset.getString("notice_content"));
				n.setTitle(rset.getString("notice_title"));
				n.setDate(rset.getDate("notice_date"));
				
				list.add(n);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public Notice selectOne(Connection conn, int noticeNo) {
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOne");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				notice = new Notice();
				notice.setNotice_no(rset.getInt("notice_no"));
				notice.setTitle(rset.getString("notice_title"));
				notice.setMember_no(rset.getInt("member_no"));
				notice.setContent(rset.getString("notice_content"));
				notice.setDate(rset.getDate("notice_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return notice;
	}

	public int updateNotice(Connection conn, Notice n) {
		int result = 0;
		PreparedStatement pstmt =null;
		String query = prop.getProperty("updateNotice");
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, n.getNotice_no());
			pstmt.setInt(2, n.getMember_no());
			pstmt.setString(3, n.getTitle());
			pstmt.setString(4, n.getContent());
			pstmt.setInt(5, n.getNotice_no());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteNotice(Connection conn, int notice_no) {
		int result =0;
		PreparedStatement pstmt =null;
		String query = prop.getProperty("deleteNotice");
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, notice_no);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int insertNotice(Connection conn, Notice n) {
		int result =0;
		PreparedStatement pstmt =null;
		String query = prop.getProperty("insertNotice");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, n.getMember_no());
			pstmt.setString(2, n.getContent());
			pstmt.setString(3, n.getTitle());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	

}

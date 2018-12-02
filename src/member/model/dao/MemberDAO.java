package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import member.model.vo.Address;
import member.model.vo.Member;

public class MemberDAO {
	private Properties prop = new Properties();
	public MemberDAO() {
		URL fileUrl = MemberDAO.class.getResource("/sql/member/member-query.properties");
		String fileName = fileUrl.getPath();//절대주소를 String타입으로 리턴
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//login
	public int loginCheck(Connection conn, String id, String password) {
		int result =-1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("loginCheck");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, id);
			pstmt.setString(4, id);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("login_check");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public Member selectOne(Connection conn, String id) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOne");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setMember_no(rset.getInt("member_no"));
				m.setMember_id(rset.getString("member_id"));
				m.setMember_password(rset.getString("member_password"));
				m.setMember_name(rset.getString("member_name"));
				m.setMember_gender(rset.getString("member_gender"));
				m.setMember_birthday(rset.getString("member_birthday"));
				m.setMember_phone(rset.getString("member_phone"));
				m.setMember_email(rset.getString("member_email"));
				m.setMember_interested(rset.getString("member_interested"));
				m.setMember_enrolldate(rset.getDate("member_enrolldate"));
				m.setMember_deletedate(rset.getDate("member_deletedate"));
				m.setMember_status(rset.getString("member_status"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
		
		
	}
	public Member selectOne1(Connection conn, String id) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectMember");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,id);
			rset = pstmt.executeQuery();
			rset.next();
			
			m = new Member();
			m.setMember_no(rset.getInt("member_no"));
			m.setMember_id(rset.getString("member_id"));
			m.setMember_password(rset.getString("member_password"));
			m.setMember_name(rset.getString("member_name"));
			m.setMember_gender(rset.getString("member_gender"));
			m.setMember_birthday(rset.getString("day"));
			m.setMember_phone(rset.getString("member_phone"));
			m.setMember_email(rset.getString("member_email"));
			m.setMember_interested(rset.getString("member_interested"));
			m.setMember_enrolldate(rset.getDate("member_enrolldate"));
			m.setMember_deletedate(rset.getDate("member_deletedate"));
			m.setMember_status(rset.getString("member_status"));
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
		
		
	}

	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_password());
			pstmt.setString(3, member.getMember_name());
			pstmt.setString(4, member.getMember_gender());
			pstmt.setString(5, member.getMember_birthday());
			pstmt.setString(6, member.getMember_phone());
			pstmt.setString(7, member.getMember_email());
			pstmt.setString(8, member.getMember_interested());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int selectLastSeq(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int currval = 0;
		
		String query = prop.getProperty("selectLastSeq");
		try{
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()){
				currval = rset.getInt("currval");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(stmt);
		}
		return currval;
	}

	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt =null;
		String query = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, member.getMember_phone());
			pstmt.setString(2, member.getMember_email());
			pstmt.setString(3, member.getMember_interested());
			pstmt.setString(4, member.getMember_id());
			
			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int deleteMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt =null;
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, member.getMember_id());
			
			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int deleteCheck(Connection conn, String id, String password) {
		int result =0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("deleteCheck");
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("delete_check");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int insertAddress(Connection conn, Address add) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertAddress");
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, add.getMember_no());
			pstmt.setString(2,add.getMember_address1());
			
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Address selcetOneAddress(Connection conn, String member_id) {
		Address address = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOneAddress");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,member_id);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				address = new Address();
				address.setMember_address1(rset.getString("member_address1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return address;
	}

	public int updatePassword(Connection conn, Member member) {
		int result =0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updatePassword");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMember_password());
			pstmt.setString(2, member.getMember_id());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int loginCk(Connection conn, String id, String password) {
		int result =-1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("loginCk");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, id);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("logC");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public Address selectAdd(Connection conn, int member_no) {
		Address a = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectAdd");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,member_no);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				a = new Address();
				a.setMember_no(rset.getInt("member_no"));
				a.setMember_address1(rset.getString("member_address1"));
				a.setMember_address2(rset.getString("member_address2"));
				a.setMember_address3(rset.getString("member_address3"));
				a.setMember_address4(rset.getString("member_address4"));
				a.setAddressStatus(rset.getInt("address_status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return a;
	}

	public int updateAddressStatus(Connection conn, String chk, int no) {
		int result =0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateAddressStatus");
		//System.out.println("MemberDAO@query="+query);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, chk);
			pstmt.setInt(2, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int deleteAddressStatus(Connection conn, int memberNo, int deleteNo) {
		int result =0;
		
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteAddressStatus");
		
		try {
			CallableStatement cs = conn.prepareCall(query);
			
			cs.setInt(1, memberNo);
			cs.setInt(2, deleteNo);
			pstmt = conn.prepareStatement(query);
			
			if(!cs.execute())
				result=1;
			else
				result=0;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	public int insertAddress(Connection conn, int member_no, String memAddress) {
		int result =0;
		
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertAddress");
		
		try {
			CallableStatement cs = conn.prepareCall(query);
			
			cs.setInt(1, member_no);
			cs.setString(2, memAddress);
			pstmt = conn.prepareStatement(query);
			
			if(!cs.execute())
				result=1;
			else
				result=0;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}

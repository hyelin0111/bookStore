package admin.model.dao;

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
import member.model.vo.Member;
import seller.model.vo.Seller;

public class AdminDAO {
	private Properties prop = new Properties();

	public AdminDAO() {
		try {
			String fileName = AdminDAO.class.getResource("/sql/admin/admin-query.properties").getPath();
			prop.load( new FileReader(fileName));			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Book> selectBookListAll(Connection conn, int cPage, int numPerPage) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		
		String query = prop.getProperty("selectBookByAll");
		
		try {
			pstmt = conn.prepareStatement(query);			
			
			pstmt.setInt(1, ((cPage-1)*numPerPage)+1);
			pstmt.setInt(2, cPage*numPerPage);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book b = new Book();
				
				b.setBookNo(rset.getString("book_no"));
				b.setAuthorName(rset.getString("author_name"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookPublisher(rset.getString("book_publisher"));
				b.setIssueDate(rset.getDate("book_issue_date"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setCategory(rset.getString("book_category"));
				b.setBookSaleQty(rset.getInt("book_sale_qty"));
				b.setBookGrade(rset.getDouble("book_grade"));
				
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

	public int selectBookByAllCount(Connection conn) {
		int totalBoard = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectBookByAllCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			
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

	public int deleteBookOne(Connection conn, String bookNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("deleteBookOne");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, bookNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int selectBookWriter(Connection conn, String authorName) {
		int totalBoard = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectBookWriter");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, authorName);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
				totalBoard = rset.getInt("author_no");
			else
				totalBoard = 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalBoard;
	}

	public int insertBookWriter(Connection conn, String authorName) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertBookWriter");
		
		try {
			
			//1. 미완성쿼리문을 가지고 PreparedStatement객체생성
			pstmt = conn.prepareStatement(query);
			//객체생성후 ? 부분 값대입.
			pstmt.setString(1, authorName);

			//2. 쿼리문 실행, 실행결과 받기
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertBookAdminOne(Connection conn, Book b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertBookAdminOne");
		
		try {
			
			//1. 미완성쿼리문을 가지고 PreparedStatement객체생성
			pstmt = conn.prepareStatement(query);
			//객체생성후 ? 부분 값대입.
			pstmt.setString(1, b.getBookNo());
			pstmt.setString(2, String.valueOf(b.getAuthorNo()));
			pstmt.setString(3, b.getBookTitle());
			pstmt.setString(4, b.getBookPublisher());
			pstmt.setDate(5, b.getIssueDate());
			pstmt.setInt(6, b.getBookPage());
			pstmt.setInt(7, b.getBookPrice());
			pstmt.setString(8, b.getCategory());
			pstmt.setString(9, b.getBookStatus());
			pstmt.setInt(10, b.getBookSaleQty());
			pstmt.setDouble(11, b.getBookGrade());

			//2. 쿼리문 실행, 실행결과 받기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public String selectBookOneNo(Connection conn, String bookNo) {
		String totalBoard = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectBookOne");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookNo+"%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalBoard = rset.getString("book_no");
				totalBoard = String.valueOf(Integer.parseInt(totalBoard) + 1); 
			}
			else
				totalBoard = bookNo+"01";
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalBoard;
	}

	public int selectBookOneNoY(Connection conn, String bookNo) {
		int totalBoard = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectBookOneNoY");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
				totalBoard = rset.getInt("cnt");
			else
				totalBoard = 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalBoard;
	}

	public int insertBookAdminOneY(Connection conn, Book b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertBookAdminOneY");
		
		try {
			
			//1. 미완성쿼리문을 가지고 PreparedStatement객체생성
			pstmt = conn.prepareStatement(query);
			//객체생성후 ? 부분 값대입.
			pstmt.setString(1, b.getBookNo());
			pstmt.setString(2, String.valueOf(b.getAuthorNo()));
			pstmt.setString(3, b.getBookTitle());
			pstmt.setString(4, b.getBookPublisher());
			pstmt.setDate(5, b.getIssueDate());
			pstmt.setInt(6, b.getBookPage());
			pstmt.setInt(7, b.getBookPrice());
			pstmt.setString(8, b.getCategory());
			pstmt.setString(9, "Y");
			pstmt.setInt(10, b.getBookSaleQty());
			pstmt.setDouble(11, b.getBookGrade());

			//2. 쿼리문 실행, 실행결과 받기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateBookOne(Connection conn, Book b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateBookOne");
		//System.out.println("AdminDAO@b="+b);
		try {
			
			//1. 미완성쿼리문을 가지고 PreparedStatement객체생성
			pstmt = conn.prepareStatement(query);
			//객체생성후 ? 부분 값대입.
			//pstmt.setString(1, String.valueOf(b.getAuthorNo()));
			pstmt.setString(1, b.getBookTitle());
			pstmt.setString(2, b.getBookPublisher());
			pstmt.setDate(3, b.getIssueDate());
			pstmt.setInt(4, b.getBookPage());
			pstmt.setInt(5, b.getBookPrice());
			pstmt.setString(6, b.getCategory());
			pstmt.setInt(7, b.getBookSaleQty());
			pstmt.setString(8, b.getBookNo());

			//2. 쿼리문 실행, 실행결과 받기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		//System.out.println("AdminDAO@result="+result);
		return result;
	}

	public String selectBookAdminOne(Connection conn, Book b) {
		String totalBoard = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectBookAdminOne");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBookTitle());
			pstmt.setString(2, b.getBookPublisher());
			pstmt.setInt(3, b.getBookPage());
			pstmt.setInt(4, b.getBookPrice());
			pstmt.setString(5, b.getCategory());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalBoard = rset.getString("book_no");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalBoard;
	}
	

	public int selectMemberCount(Connection conn) {
		int totalMember = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectMemberCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			rset.next();
			totalMember = rset.getInt("cnt");
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return totalMember;
	}

	public List<Member> selectMemberList(Connection conn, int cPage, int numPerPage) {
		List<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectMemberListByPaging");
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			
			rset= pstmt.executeQuery();
			list = new ArrayList<>();
			while(rset.next()) {
				Member m = new Member();
				m.setMember_no(rset.getInt("member_no"));
				m.setMember_id(rset.getString("member_id"));
				m.setMember_name(rset.getString("member_name"));
				m.setMember_gender(rset.getString("member_gender"));
				m.setMember_birthday(rset.getString("day"));
				m.setMember_phone(rset.getString("member_phone"));
				m.setMember_email(rset.getString("member_email"));
				m.setMember_interested(rset.getString("member_interested"));
				m.setMember_status(rset.getString("member_status"));
				
				list.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int deleteMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteMember"); 

		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setString(1, member.getMember_id());
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int AdminUpdateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt =null;
		String query = prop.getProperty("adminUpdateMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, member.getMember_password());
			pstmt.setString(2, member.getMember_phone());
			pstmt.setString(3, member.getMember_email());
			pstmt.setString(4, member.getMember_interested());
			pstmt.setString(5, member.getMember_status());
			pstmt.setString(6, member.getMember_id());
			
			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public int selectSellerCount(Connection conn) {
		int totalSeller = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectSellerCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			rset.next();
			totalSeller = rset.getInt("cnt");
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return totalSeller;
	}

	public List<Seller> selectSellerList(Connection conn, int cPage, int numPerPage) {
		List<Seller> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectSellerListByPaging");
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			
			rset= pstmt.executeQuery();
			list = new ArrayList<>();
			while(rset.next()) {
				Seller s = new Seller();
				s.setMember_no(rset.getInt("member_no"));
				s.setSuccess_count(rset.getInt("success_count"));
				s.setTell_ok(rset.getString("tell_ok"));
				s.setEmail_ok(rset.getString("email_ok"));
				s.setAccount_ok(rset.getString("account_ok"));
				s.setDelivery_way(rset.getString("delivery_way"));
				s.setDelivery_island_price(rset.getInt("delivery_island_price"));
				s.setDelivery_price(rset.getInt("delivery_price"));
				s.setSeller_nickname(rset.getString("seller_nickname"));
				s.setDelivery_chul(rset.getString("delivery_chul"));
				s.setAccount_bank(rset.getString("account_bank"));
				s.setMember_id(rset.getString("member_id"));
				s.setMember_name(rset.getString("member_name"));
				s.setMember_status(rset.getString("member_status"));
				list.add(s);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public Seller selectOne(Connection conn, String member_id) {
		Seller s = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectSeller");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member_id);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				s = new Seller();
				s.setMember_no(rset.getInt("member_no"));
				s.setMember_id(rset.getString("member_id"));
				s.setMember_name(rset.getString("member_name"));
				s.setMember_status(rset.getString("member_status"));
				s.setSuccess_count(rset.getInt("success_count"));
				s.setTell_ok(rset.getString("tell_ok"));
				s.setEmail_ok(rset.getString("email_ok"));
				s.setAccount_ok(rset.getString("account_ok"));
				s.setDelivery_way(rset.getString("delivery_way"));
				s.setDelivery_island_price(rset.getInt("delivery_island_price"));
				s.setDelivery_price(rset.getInt("delivery_price"));
				s.setSeller_nickname(rset.getString("seller_nickname"));
				s.setDelivery_chul(rset.getString("delivery_chul"));
				s.setAccount_bank(rset.getString("account_bank"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return s;
	}

	public int AdminUpdateSeller(Connection conn, Seller seller) {
		int result = 0;
		PreparedStatement pstmt =null;
		String query = prop.getProperty("adminUpdateSeller");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, seller.getAccount_bank());
			pstmt.setString(2, seller.getAccount_ok());
			pstmt.setInt(3, seller.getDelivery_price());
			pstmt.setInt(4, seller.getDelivery_island_price());
			pstmt.setString(5, seller.getDelivery_chul());
			pstmt.setInt(6, seller.getMember_no());
			
			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int deleteSeller(Connection conn, Seller seller) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteSeller"); 

		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setInt(1, seller.getMember_no());
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

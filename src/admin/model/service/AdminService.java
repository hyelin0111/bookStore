package admin.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import admin.model.dao.AdminDAO;
import book.model.vo.Book;
import member.model.vo.Member;
import seller.model.vo.Seller;

public class AdminService {

	public AdminService() {
		// TODO Auto-generated constructor stub
	}

	public List<Book> selectBookListAll(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Book> list = new AdminDAO().selectBookListAll(conn, cPage, numPerPage);
		close(conn);
		return list;
	}

	public int selectBookByAllCount() {
		Connection conn = getConnection();
		int totalBoard = new AdminDAO().selectBookByAllCount(conn);
		close(conn);
		return totalBoard;
	}

	public int deleteBookOne(String bookNo) {
		Connection conn = getConnection();
		int result = new AdminDAO().deleteBookOne(conn, bookNo);
		close(conn);
		return result;
	}

	public int insertBookAdminOne(Book b) {
		Connection conn = getConnection();
		// 저자 테이블 있는지 확인
		int resultW = new AdminDAO().selectBookWriter(conn, b.getAuthorName());
		if(resultW == 0) {
			resultW = new AdminDAO().insertBookWriter(conn, b.getAuthorName());
			resultW = new AdminDAO().selectBookWriter(conn, b.getAuthorName());
		}
		
		// 북넘버 뽑기위해 확인
		String resultB = new AdminDAO().selectBookOneNo(conn, b.getBookNo());
		//System.out.println("AdminService@resultB="+resultB);
		
		b.setAuthorNo(resultW);
		b.setBookNo(resultB);
		
		int result = new AdminDAO().insertBookAdminOne(conn, b);
		
		int bookN = new AdminDAO().selectBookOneNoY(conn, b.getBookNo());
		
		int result2 = 0;
		if(bookN==0) {
			result2 = new AdminDAO().insertBookAdminOneY(conn, b);
		}
		close(conn);
		return result;
	}

	public int updateAdminBook(Book b) {
		Connection conn = getConnection();
		int result = new AdminDAO().updateBookOne(conn, b);
		close(conn);
		System.out.println("AdminService@result="+result);
		return result;
	}

	public String selectBookAdminOne(Book b) {
		Connection conn = getConnection();
		String bookNo= new AdminDAO().selectBookAdminOne(conn, b);
		close(conn);
		return bookNo;
	}
	
	public int selectMemberCount() {
		Connection conn = getConnection();
		int totalMember = new AdminDAO().selectMemberCount(conn);
		close(conn);
		return totalMember;
	}

	public List<Member> selectMemberList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Member> list = new AdminDAO().selectMemberList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}


	public int deleteMember(Member member) {
		Connection conn = getConnection();
		int result = new AdminDAO().deleteMember(conn, member);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}

	public int AdminUpdateMember(Member member) {
		Connection conn = getConnection();
		int result = new AdminDAO().AdminUpdateMember(conn,member);
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public int selectSellerCount() {
		Connection conn = getConnection();
		int totalSeller = new AdminDAO().selectSellerCount(conn);
		close(conn);
		return totalSeller;
	}

	public List<Seller> selectSellerList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Seller> list = new AdminDAO().selectSellerList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}

	public Seller selectOne(String member_id) {
		Connection conn = getConnection();
		Seller s = new AdminDAO().selectOne(conn,member_id);
		close(conn);
		return s;
	}

	public int AdminUpdateSeller(Seller seller) {
		Connection conn = getConnection();
		int result = new AdminDAO().AdminUpdateSeller(conn,seller);
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteSeller(Seller seller) {
		Connection conn = getConnection();
		int result = new AdminDAO().deleteSeller(conn, seller);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}
}

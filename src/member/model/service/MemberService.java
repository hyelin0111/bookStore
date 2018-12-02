package member.model.service;


import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Address;
import member.model.vo.Member;
import seller.model.vo.Seller;

public class MemberService {
	//로그인처리를 위한 상수선언
	public static final int LOGIN_OK = 1;
	public static final int WRONG_PASSWORD = 0;
	public static final int ID_NOT_EXIST = -1;
	//회원탈퇴를 위한 상수선언
	public static final int DELETE_OK = 1;
	public static final int WRONG_PWD = 0;
	
	public int loginCheck(String id, String password) {
		Connection conn = getConnection();
		int result = new MemberDAO().loginCheck(conn,id,password);
		close(conn);
		return result;
	}

	public Member selectOne(String id) {
		Connection conn = getConnection();
		Member m = new MemberDAO().selectOne(conn, id);
		close(conn);
		return m;
	}
	public Member selectOne1(String id) {
		Connection conn = getConnection();
		Member m = new MemberDAO().selectOne1(conn, id);
		close(conn);
		return m;
	}
	
	public int inserMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().insertMember(conn,member);
		if(result>0) {
			result = new MemberDAO().selectLastSeq(conn);
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().updateMember(conn,member);
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().deleteMember(conn,member);
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteCheck(String id, String password) {
		Connection conn = getConnection();
		int result = new MemberDAO().deleteCheck(conn,id,password);
		close(conn);
		return result;
	}

	public int insertAddress(Address add) {
		Connection conn = getConnection();
		int result_add = new MemberDAO().insertAddress(conn,add);
		if(result_add>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result_add;
	}


	public Address selectOneAddress(String member_id) {
		Connection conn = getConnection();
		Address address = new MemberDAO().selcetOneAddress(conn,member_id);
		close(conn);
		return address;
	}

	public int updatePassword(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().updatePassword(conn, member);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}

	public int loginCk(String id, String password) {
		Connection conn = getConnection();
		int result = new MemberDAO().loginCk(conn,id,password);
		close(conn);
		return result;
	}

	public Address selectAdd(int member_no) {
		Connection conn = getConnection();
		Address a = new MemberDAO().selectAdd(conn, member_no);
		close(conn);
		return a;
	}

	public int updateAddressStatus(String chk, int no) {
		Connection conn = getConnection();
		int result = new MemberDAO().updateAddressStatus(conn,chk,no);
		close(conn);
		return result;
	}

	public int deleteAddressStatus(int memberNo, int deleteNo) {
		Connection conn = getConnection();
		int result = new MemberDAO().deleteAddressStatus(conn,memberNo,deleteNo);
		close(conn);
		return result;
	}

	public int insertAddress(int member_no, String memAddress) {
		Connection conn = getConnection();
		int result = new MemberDAO().insertAddress(conn,member_no, memAddress);
		close(conn);
		return result;
	}


	
}

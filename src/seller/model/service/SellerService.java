package seller.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import seller.model.dao.SellerDAO;
import seller.model.vo.Seller;
public class SellerService {
	//판매자 회원가입을 위한 상수선언 이미 가입되어있으면 1, 가입되어있지않으면 0
	public static final int EXIST_SELLER = 1;
	public static final int INSERT_OK = 0;
	
	public int insertCheck(int no) {
		Connection conn = getConnection();
		int result = new SellerDAO().insertCheck(conn,no);
		close(conn);
		return result;
	}
	
	
	public int insertSeller(Seller seller) {
		Connection conn = getConnection();
		int result = new SellerDAO().insertSeller(conn,seller);
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}


	public int sellerCheck(int memberNo) {
	      Connection conn = getConnection();
	      int result = new SellerDAO().sellerCheck(conn, memberNo);
	      
	      close(conn);
	      
	      return result;
	}


}

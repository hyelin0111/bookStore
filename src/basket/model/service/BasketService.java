package basket.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import basket.model.dao.BasketDAO;
import basket.model.vo.Basket;

public class BasketService {

	public List<Basket> selectBasketList(int memberNo) {
		Connection conn = getConnection();
		List<Basket> basketList = new BasketDAO().selectBasketList(conn, memberNo);
		
		close(conn);
		
		return basketList;
	}

	public int insertBasket(Basket b) {
		Connection conn = getConnection();
		int result = new BasketDAO().insertBasket(conn, b );
		
		if( result > 0 )
			commit(conn);
		else
			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int deleteBookToBasket(int memberNo, String bookNo, String bookStatus) {
		Connection conn = getConnection();
		int result = new BasketDAO().deleteBookToBasket(conn, memberNo, bookNo, bookStatus);
		
		if( result > 0 )
			commit(conn);
		else
			rollback(conn);
		
		close(conn);
		
		return result;
	}
}

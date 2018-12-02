package oldboard.model.service;

import static common.JDBCTemplate.*;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import book.model.vo.Book;
import oldboard.model.dao.OldBoardDAO;
import oldboard.model.vo.OldBoard;

public class OldBoardService {
	
	public int selectOldBoardCount() {
		Connection conn = getConnection();
		int totalOldBoardCount = new OldBoardDAO().selectOldBoardCount(conn);
		
		close(conn);
		
		return totalOldBoardCount;
	}

	public List<OldBoard> OldBoardList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<OldBoard> oldBoarList = new OldBoardDAO().selectOldBoardList(conn, cPage, numPerPage);		
		
		close(conn);
		
		return oldBoarList;
	}

	public int insertOldBoard(OldBoard ob, int memberNo) {
		Connection conn = getConnection();		
		int result = new OldBoardDAO().insertOldBoard(conn, ob, memberNo);
		
		if(result > 0 )
			commit(conn);
		else
			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public OldBoard selectOneOldBoard(int oldBoardNo) {
		Connection conn = getConnection();
		OldBoard ob = new OldBoardDAO().selectOneOldBoard(conn, oldBoardNo);
		close(conn);
		
		return ob;
	}

	public Book selectOneBook(String bookNo) {
		Connection conn = getConnection();
		Book book = new OldBoardDAO().selectOneBook(conn, bookNo);
		close(conn);
		
		return book;
	}

	public OldBoard selectOnebyOldBoardNo(int oldBoardNo) {
		Connection conn = getConnection();
		OldBoard ob = new OldBoardDAO().selectOnebyOldBoardNo(conn, oldBoardNo);
		close(conn);
		
		return ob;
	}
	
	public int deleteOldBoard(int boardNo) {
	      Connection conn = getConnection();
	      int result = new OldBoardDAO().deleteOldBoard(conn, boardNo);
	      
	      if( result > 0 )
	         commit(conn);
	      else
	         rollback(conn);
	            
	      close(conn);
	      
	      return result;
	   }   
}
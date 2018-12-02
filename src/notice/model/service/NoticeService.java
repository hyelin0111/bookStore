package notice.model.service;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;
public class NoticeService {

	public int selectNoticeCount() {
		Connection conn = getConnection();
		int totalNotice = new NoticeDAO().selelctNoticeCount(conn);
		close(conn);
		return totalNotice;
	}

	public List<Notice> selectNoticeList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Notice> list = new NoticeDAO().selelctNoticeList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}

	public Notice selectOne(int noticeNo) {
		Connection conn = getConnection();
		Notice n = new NoticeDAO().selectOne(conn,noticeNo);
		close(conn);
		return n;
	}

	public int updateNotice(Notice n) {
		Connection conn =getConnection();
		int result = new NoticeDAO().updateNotice(conn, n);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteNotice(int notice_no) {
		Connection conn =getConnection();
		int result = new NoticeDAO().deleteNotice(conn,notice_no);
		if(result>0)commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}

	public int insertNotice(Notice n) {
		Connection conn =getConnection();
		int result = new NoticeDAO().insertNotice(conn,n);
		if(result>0)commit(conn);
		else rollback(conn);
		return result;
	}

}

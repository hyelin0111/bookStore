package recommend.model.service;

import java.sql.Connection;
import java.util.List;

import recommend.model.dao.RecommendDAO;
import recommend.model.vo.Recommend;

import static common.JDBCTemplate.*;

public class RecommendService {

	public List<Recommend> selectRecommendList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Recommend> recommendList = new RecommendDAO().seletRecommendList(conn, cPage, numPerPage);
		
		close(conn);
		
		return recommendList;
	}

	public int selectRecommendCount() {
		Connection conn = getConnection();
		int totalRecommendCount = new RecommendDAO().selectRecommendCount(conn);
		
		close(conn);
		
		return totalRecommendCount;
	}

	public List<Recommend> selectRecommendModify(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Recommend> recommendModify = new RecommendDAO().seletRecommendModify(conn, cPage, numPerPage);
		
		close(conn);
		
		return recommendModify;		
	}
}

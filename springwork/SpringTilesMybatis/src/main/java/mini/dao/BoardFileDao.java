package mini.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFileDao {
		@Autowired
		private SqlSession session;
		
		private String nameSpace = "mini.dao.BoardFileDao.";
}

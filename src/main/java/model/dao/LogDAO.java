package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.Log;

public class LogDAO {
	// 全取得
		public List<Log> getAll() throws Exception {
			
			List<Log> logs = new ArrayList<>();
			Connection con = DAO.getConnection();
			
			PreparedStatement st = con.prepareStatement(
					"SELECT * FROM logs"
			);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Log log = new Log();
				log.setLogId(rs.getInt("log_id"));
				log.setUserId(rs.getString("user_id"));
				log.setActionType(rs.getString("action_type"));
				log.setTargetTable(rs.getString("target_table"));
				log.setActionedAt(rs.getString("actioned_at"));
				logs.add(log);
			}
			
			rs.close();
			st.close();
			con.close();
			
			return logs;	
		}
		
		// 追加
		public static void create(Log log) throws Exception {
			Connection con = DAO.getConnection();
			
			PreparedStatement st = con.prepareStatement(
					"INSERT INTO logs(user_id, action_type, target_table) VALUES(?, ?, ?)"
			);
			st.setString(1, log.getUserId());
			st.setString(2, log.getActionType());
			st.setString(3, log.getTargetTable());
			int line = st.executeUpdate();
			
			st.close();
			con.close();
		}
}
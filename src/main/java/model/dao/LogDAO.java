package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.Log;

public class LogDAO {
	// 全削除
		public static void reset() throws Exception {
	Connection con = DAO.getConnection();
			
			PreparedStatement st = con.prepareStatement(
					"DELETE FROM logs"
			);
			st.executeQuery();
			
			st.close();
			con.close();
		}
	// 全取得
		public static List<Log> findAll() throws Exception {
			
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
			
			st.close();
			con.close();
		}
		
		// 実行者IDで絞り込み
				public static List<Log> findByExecuterId(String executerId) throws Exception {
					Connection con = DAO.getConnection();
					List<Log> logs = new ArrayList<>();
					
					PreparedStatement st = con.prepareStatement(
							"SELECT * FROM logs WHERE user_id = ?"
					);
					st.setString(1,  executerId);
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
					
					st.close();
					con.close();
					
					return logs;
				}
		
		// メソッドで絞り込み
		public static List<Log> findByActionType(String method) throws Exception {
			Connection con = DAO.getConnection();
			List<Log> logs = new ArrayList<>();
			
			PreparedStatement st = con.prepareStatement(
					"SELECT * FROM logs WHERE action_type = ?"
			);
			st.setString(1,  method);
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
			
			st.close();
			con.close();
			
			return logs;
		}
		
		// 対象テーブルで絞り込み
				public static List<Log> findByTargetTable(String targetTable) throws Exception {
					Connection con = DAO.getConnection();
					List<Log> logs = new ArrayList<>();
					
					PreparedStatement st = con.prepareStatement(
							"SELECT * FROM logs WHERE target_table = ?"
					);
					st.setString(1,  targetTable);
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
					
					st.close();
					con.close();
					
					return logs;
				}
}
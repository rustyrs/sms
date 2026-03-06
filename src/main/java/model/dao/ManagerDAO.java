package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.Manager;

public class ManagerDAO {
	
	// 全削除
	public static void reset() throws Exception {
		Connection con = DAO.getConnection();
			
		PreparedStatement st = con.prepareStatement(
				"DELETE FROM managers"
		);
		st.executeQuery();
		
		st.close();
		con.close();
	}
	
	// ログイン
	public boolean login(String id, String password) throws Exception {
		Connection con = DAO.getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"SELECT 1 FROM managers WHERE id = ? AND password = ?"
		);
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		
		boolean isExists = rs.next();
		
		rs.close();
		st.close();
		con.close();
		
		return isExists;
	}
	
	// アカウント情報
	public Manager getDetail(String id, String password) throws Exception {
		Connection con = DAO.getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM managers WHERE id = ? AND password = ? "
		);
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();

		Manager m = new Manager();
		
		if (rs.next()) {
			m.setId(rs.getString("id"));
			m.setName(rs.getString("name"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return m;
	}
	
	// 全取得
	public List<Manager> findAll() throws Exception {		
		List<Manager> list = new ArrayList<>();
		Connection con = DAO.getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM managers"
		);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Manager m = new Manager();
			m.setId(rs.getString("id"));
			m.setName(rs.getString("name"));
			list.add(m);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;	
	}
}
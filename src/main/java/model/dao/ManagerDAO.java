package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.bean.Manager;

public class ManagerDAO {
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
}
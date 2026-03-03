package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.bean.StudentDetail;

public class StudentDetailDAO {
	// ログイン
	public boolean login(int number, String password) throws Exception {
		Connection con = DAO.getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"SELECT 1 FROM student_details WHERE number = ? AND password = ?"
		);
		st.setInt(1, number);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		
		boolean isExists = rs.next();
		
		rs.close();
		st.close();
		con.close();
		
		return isExists;
	}
	
	// アカウント情報
	public StudentDetail getDetail(int number, String password) throws Exception {
		Connection con = DAO.getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM student_details WHERE number = ? AND password = ? "
		);
		st.setInt(1, number);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		

	    StudentDetail s = new StudentDetail();
		
		if (rs.next()) {
			s.setNumber(rs.getInt("number"));
			s.setComment(rs.getString("comment"));
		}
		
		StudentDAO dao = new StudentDAO();
		try {
			s.setName(dao.findById(number));
		} catch (Exception e) {}
		
		rs.close();
		st.close();
		con.close();
		
		return s;
	}
}
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.Student;

public class StudentDAO {
	// studentsテーブル全取得
	public List<Student> getAll() throws Exception {
		
		List<Student> list = new ArrayList<>();
		Connection con = DAO.getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM students"
		);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Student p = new Student();
			p.setId(rs.getInt("student_id"));
			p.setName(rs.getString("student_name"));
			p.setCourse(rs.getInt("course_id"));
			list.add(p);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;	
	}
}
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.Student;

public class StudentDAO {
	// 全取得
	public List<Student> getAll() throws Exception {
		
		List<Student> list = new ArrayList<>();
		Connection con = DAO.getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM students"
		);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt("student_id"));
			s.setName(rs.getString("student_name"));
			s.setCourse(rs.getInt("course_id"));
			list.add(s);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;	
	}
	
	// 名前で絞り込み
	public List<Student> findByName(String name) throws Exception {
		
		List<Student> list = new ArrayList<>();
		Connection con = DAO.getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"SELECT * FROM students WHERE student_name = ?"
		);
		st.setString(1, name);
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt("student_id"));
			s.setName(rs.getString("student_name"));
			s.setCourse(rs.getInt("course_id"));
			list.add(s);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	
	// 学生追加
	public int create(Student s) throws Exception {
		Connection con = DAO.getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"INSERT INTO students(student_id, student_name, course_id) VALUES(?, ?, ?)"
		);
		st.setInt(1, s.getId());
		st.setString(2, s.getName());
		st.setInt(3, s.getCourse());
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
}
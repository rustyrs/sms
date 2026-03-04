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
	
	// 存在を確認するだけ
	public boolean exsists(int number) throws Exception {
		Connection con = DAO.getConnection();
		PreparedStatement statement = con.prepareStatement(
				"SELECT 1 FROM students WHERE student_id = ?"
		);
		statement.setInt(1, number);
		ResultSet rs = statement.executeQuery();
		
		boolean isExsits = rs.next();
		
		rs.close();
		statement.close();
		con.close();
		
		return isExsits;
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
	
	// 上のあいまい版
public List<Student> findByNameFuzzy(String name) throws Exception {
		
		List<Student> list = new ArrayList<>();
		Connection con = DAO.getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"SELECT * FROM students WHERE student_name like ?"
		);
		st.setString(1, "%"+name+"%");
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
	
	// IDで名前を返す
    public String findById(int id) throws Exception {
		
		Connection con = DAO.getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"SELECT * FROM students WHERE student_id = ?"
		);
		st.setInt(1, id);
		ResultSet rs=st.executeQuery();
		
		String name = null;
		
	    if (rs.next()) {
			name = rs.getString("student_name");
	    }
		
		rs.close();
		st.close();
		con.close();
		
		return name;
	}
	
    // IDで詳細を返す
public Student getDetail(int id) throws Exception {
		
		Connection con = DAO.getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"SELECT * FROM students WHERE student_id = ?"
		);
		st.setInt(1, id);
		ResultSet rs=st.executeQuery();
		
		Student s = new Student();
		
	    if (rs.next()) {
			s.setId(rs.getInt("student_id"));
			s.setName(rs.getString("student_name"));
			s.setCourse(rs.getInt("course_id"));
	    }
		
		rs.close();
		st.close();
		con.close();
		
		return s;
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
	
	// 生徒情報更新
	public int update(Student s, int id) throws Exception {
			
		Connection con = DAO.getConnection();
			
		PreparedStatement st = con.prepareStatement(
				"UPDATE students SET student_id=?, student_name=?, course_id=? WHERE student_id=?"
		);
		st.setInt(1, s.getId());
		st.setString(2, s.getName());
		st.setInt(3, s.getCourse());
		st.setInt(4, id);
		int line=st.executeUpdate();
			
		st.close();
		con.close();
		return line;
	}
	
	// 生徒削除
	public int delete(int id) throws Exception {
		
		Connection con = DAO.getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"DELETE FROM students WHERE student_id = ?"
		);
		st.setInt(1, id);
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
}
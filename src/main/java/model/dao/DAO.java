package model.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

// コネクト処理

public class DAO {
	static DataSource ds;

	public static Connection getConnection() throws Exception {
		if (ds==null) {
			InitialContext ic=new InitialContext();
			ds=(DataSource)ic.lookup("java:/comp/env/jdbc/sms");
		}
		return ds.getConnection();
	}
}
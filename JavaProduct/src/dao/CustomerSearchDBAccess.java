package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerSearchDBAccess {

	protected Connection createConnection() {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KIDDA_LA", "user1", "pass1");
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
		
		return con;
	}
	private Connection closeConnection(Connection con){
		
		
		try {
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return con;
	}
}
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;

public class CustomerSearchDBAccess {

	private Connection createConnection() {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KIDDA_LA", "use1", "pass1");
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}

		return con;
	}

	private void closeConnection(Connection con) {

		try {
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}

	public ArrayList<Customer> searchCustomerByTel(String tel) {
		String sql = "SELECT CUSTID, CUSTNAME, KANA, ADDRESS FROM customer WHERE tel = ? ;";
		try (Connection con = createConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			pstmt.setString(1, tel);
			ArrayList<Customer> list = new ArrayList<>();
			while (rs.next()) {
				int custId = rs.getInt("CUSTID");
				String custName = rs.getString("CUSTNAME");
				String kana = rs.getString("KANA");
				String address = rs.getString("ADDRESS");

				list.add(new Customer(custId, custName, kana, tel, address));
			}
			return list;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<Customer> searchCustomerByKana(String kana) {
		String sql = "SELECT CUSTID, CUSTNAME, KANA, TEL, ADDRESS FROM customer WHERE kana like ?;";
		try (Connection con = createConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Customer> list = new ArrayList<>();

			while (rs.next()) {
				int custId = rs.getInt("CUSTID");
				String custName = rs.getString("CUSTNAME");
				kana = rs.getString("KANA");
				String tel = rs.getString("TEL");
				String address = rs.getString("ADDRESS");

				list.add(new Customer(custId, custName, kana, tel, address));
			}
			return list;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<Customer> searchCustomer(String kana, String tel) {
		String sql = "SELECT CUSTID, CUSTNAME, KANA, ADDRESS FROM customer WHERE tel =?;";
		try (Connection con = createConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Customer> list = new ArrayList<>();
			while (rs.next()) {
				int custId = rs.getInt("CUSTID");
				String custName = rs.getString("CUSTNAME");
				kana = rs.getString("KANA");
				String address = rs.getString("ADDRESS");

				list.add(new Customer(custId, custName, kana, tel, address));
			}
			return list;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
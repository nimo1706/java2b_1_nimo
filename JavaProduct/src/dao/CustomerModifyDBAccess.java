/**
 * クラス名：	CustomerModifyDBAccess
 * 概要　　：	顧客情報変更DAO
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Customer;

public class CustomerModifyDBAccess extends CustomerSearchDBAccess {

	public int modifyCustomer(Customer customer) throws Exception {
			String sql = "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?);";

			try (Connection con = createConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);) {

				pstmt.setInt(1, customer.getCustId());
				pstmt.setString(2, customer.getCustName());
				pstmt.setString(3, customer.getKana());
				pstmt.setString(4, customer.getAddress());
				pstmt.setString(5, customer.getTel());
				
				return 0;
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
	}
	
}
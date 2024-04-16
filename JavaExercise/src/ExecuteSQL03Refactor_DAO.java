import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteSQL03Refactor_DAO {

	

	public ProductBean findId(String productId) {
		String dburl = "jdbc:mysql://localhost:3306/受注管理db";
		String sql = "SELECT 商品ID,商品名,単価 FROM 商品マスタ WHERE 商品ID = ?;";

		ProductBean bean = null;

		try (
				Connection con = DriverManager.getConnection(dburl, "user1", "pass1");
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, productId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next() == true) {
				String id = rs.getString("商品ID");
				String name = rs.getString("商品名");
				int price = rs.getInt("単価");

				bean = new ProductBean(id, name, price);
			}

		} catch (SQLException e) {
			System.out.println(
					"DB切断時にエラーが発生しました(商品検索)。");
			e.printStackTrace();
		}
		return bean;
	}

	public int updateId(String productId, int price) {
		String dburl = "jdbc:mysql://localhost:3306/受注管理db";
		String sql = "UPDATE 商品マスタ SET 単価 = ? WHERE 商品ID = ?;";

		int result = 0;

		try (
				Connection con = DriverManager.getConnection(dburl, "user1", "pass1");
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, price);
			pstmt.setString(2, productId);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("DB切断時にエラーが発生しました(商品検索)。");
			e.printStackTrace();
		}

		return result;
	}

	public int insert(ProductBean bean) {
		String dburl = "jdbc:mysql://localhost:3306/受注管理db";
		String sql = "INSERT INTO 商品マスタ VALUES(?,?,?);";
		
		int result = 0;
		
		try(
		Connection con = DriverManager.getConnection (dburl,"user1", "pass1");
		PreparedStatement pstmt = con.prepareStatement(sql);) {
			
		pstmt.setString(1, bean.getId());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPrice());
		
		result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
		System.out.println("DB切断時にエラーが発生しました(商品検索)。");
		e.printStackTrace();
		}
		return result;
	}
}
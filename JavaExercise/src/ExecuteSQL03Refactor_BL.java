
public class ExecuteSQL03Refactor_BL {

	public static void main(String[] args) {

		ExecuteSQL03Refactor_DAO dao = new ExecuteSQL03Refactor_DAO();

		if (dao.findId("F-006") == null) {
			ProductBean bean = new ProductBean("F-006", "ピンクグレープフルーツ", 1400);

			int result = dao.insert(bean);
			System.out.println(result + "件追加。ピンクグレープフルーツを追加しました。");

		} else {
			int result = dao.updateId("F-006", 1500);

			System.out.println(result + "件更新。ピンクグレープフルーツの値段を変更しました。");
		}
	}
	
}

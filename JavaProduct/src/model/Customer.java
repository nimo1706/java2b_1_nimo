package model;

public class Customer {

	import java.util.ArrayList;
	import java.util.List;

	    public static void main(String[] args) {
	        try {
	            // 新しい顧客リストを作成
	            List<Customer> customerList = new ArrayList<>();

	            // ダミーの顧客情報を取得してリストに追加
	            Customer dummyCustomer = orderInputDisplay("dummyCustomerId");
	            customerList.add(dummyCustomer);

	            // リスト内の顧客情報を表示
	            for (Customer customer : customerList) {
	                System.out.println("Customer ID: " + customer.getId());
	                System.out.println("Name: " + customer.getName());
	                System.out.println("Address: " + customer.getAddress());
	                // 他の情報も必要に応じて表示
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	

	
}

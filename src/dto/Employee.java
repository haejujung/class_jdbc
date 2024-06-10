package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// DTO 설계 하고
// 값을 담아서 . 연산자를 사용해 보시오

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private int id;
	private String name;
	private String department;
	private String hire_date;

	
	
//	public static void main(String[] args) {
//
//		String url = "jdbc:mysql://localhost:3306/mydb3?serverTimezone=Asia/Seoul";
//		String user = "root";
//		String password = "asd123";
//
//		Connection connection = null;
//		Statement statement = null;
//		ResultSet resultset = null;
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			connection = DriverManager.getConnection(url, user, password);
//
//			statement = connection.createStatement();
//
//			resultset = statement.executeQuery("select * from tb_student");
//			
//			
//			while(resultset.next()) {
//				System.out.println("User ID : " + resultset.getInt("id"));
//				System.out.println("User Name : " + resultset.getString("name"));
//				System.out.println("Class : " + resultset.getString("class"));
//				System.out.println("-------------------------");
//			}
//			
//
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}

}

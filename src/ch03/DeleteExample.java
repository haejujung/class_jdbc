package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteExample {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "asd123";

		// 필요 데이터 타입
		// JDBC API 레벨(자바 개발자들이 개념화 시켜 놓은 클래스들이다.)
		
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		
		
		// 1. MYSQL 구현체를 사용하겠다는 설정을 해야 한다.
		// JDBC 드라이버 로드 ( MySQL 구현 클래스를 로드)
		
		try {
			// 1. 메모리에 사용하는 드라이버(JDBC API를 구현한 클래스) 클래스를 띄운다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 데이터 베이스 연결 설정
			connection = DriverManager.getConnection(url,user,password);
			
			String query = "delete from employee";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			int rowcount = preparedStatement.executeUpdate();
			System.out.println("delete : " + rowcount);
				
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}

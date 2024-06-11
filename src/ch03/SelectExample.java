package ch03;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExample {

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
			connection = DriverManager.getConnection(url, user, password);

			String query = "select * from employee";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			
			while(resultSet.next()) {
				
				int getId = resultSet.getInt("id");
				String getName = resultSet.getString("name");
				String getDepartment = resultSet.getString("department");
				String getHireDate = resultSet.getString("hire_date");
				double getSalary = resultSet.getDouble("salary");
				
				System.out.println(getId);
				System.out.println(getName);
				System.out.println(getDepartment);
				System.out.println(getHireDate);
				System.out.println(getSalary);
				
				
			}
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

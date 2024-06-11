package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertExample {
	
	public static void main(String[] args) {
		
		
		// Connection 객체를 얻어서 insert 구문을 직접 만들어 보세요.
		// mydb2 사용 , employee 테이블 값을 넣는 코드를 작성하세요
		
		
		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "asd123";
		
		// 필요 데이터 타입
				// JDBC API 레벨(자바 개발자들이 개념화 시켜 놓은 클래스들이다.)
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		// 1. MYSQL 구현체를 사용하겠다는 설정을 해야 한다.
		// JDBC 드라이버 로드 ( MySQL 구현 클래스를 로드)
		
		// 1. 메모리에 사용하는 드라이버(JDBC API를 구;현한 클래스) 클래스를 띄운다.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 데이터 베이스 연결 설정
			connection = DriverManager.getConnection(url,user,password);
			
			// 3. SQL 실행 ( PreparedStatement 객체 사용해보기)

			// 3 - 1 쿼리 만들어 보기
			String query = "insert into employee values(?, ?, ? , ? ,now())";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 7);
			preparedStatement.setString(2, "정해주");
			preparedStatement.setString(3,"IT");
			preparedStatement.setString(4, "9000000.00");
			
			int rowcount = preparedStatement.executeUpdate();
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

		

		
	}

}

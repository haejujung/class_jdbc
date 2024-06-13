package ch04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample2 {
	
	public static void main(String[] args) {
		
		
		// 드라이버 -> mySql 개발자들이 자바코드로 작성한 클래스의 묶음 (.jar)
		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "asd123";
		
		// 구현체를 사용하기 위해서
		// 크래스 Class <-- 최상위 Object 안에 있음
		// 동적 바인딩 처리
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(url,user,password);
			connection.setAutoCommit(false);
			
//			String query = " INSERT INTO user (username, password, email, address, userRole, createDate)"
//					+ "VALUES"
//					+ "(?, ?, ?, ?, ?, NOW()) ";
//			
//			PreparedStatement psmt1 = connection.prepareStatement(query);
//			psmt1.setString(1, "김철수");
//	 		psmt1.setString(2, "asd123");
//	 		psmt1.setString(3, "ab@naver.com");
//	 		psmt1.setString(4, "user");
//	 		psmt1.setString(5, "부산시 진구");
//	 		psmt1.executeUpdate();
	 		
	 		String query2 = " update user set username = ? where username = ? ";
	 		PreparedStatement psmt2 = connection.prepareStatement(query2);
	 		psmt2.setString(1, "이순신");
	 		psmt2.setString(2, "정해주");
	 		psmt2.executeUpdate();
	 		
	 		connection.commit();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}

package ch04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {

	public static void main(String[] args) {

		// 드라이버 -> mySql 개발자들이 자바코드로 작성한 클래스의 묶음 (.jar)
		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "asd123";

		// 구현체를 사용하기 위해서
		// 크래스 Class <-- 최상위 Object 안에 있음
		// 동적 바인딩 처리

		try {
			// mysql 드라이버(구현클래스) 메모리에 로드
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection conn = DriverManager.getConnection(url, user, password)) {
				conn.setAutoCommit(false); // 수동 커밋 모드 설정
				String sqlInsert = " INSERT INTO user (username, password, email, address, userRole, createDate) "
						+ "VALUES(?, ?, ?, ?, ?, NOW()) ";

				PreparedStatement psmt = conn.prepareStatement(sqlInsert);
				psmt.setString(1, "손철수");
				psmt.setString(2, "asd123");
				psmt.setString(3, "ab@naver.com");
				psmt.setString(4, "user");
				psmt.setString(5, "부산시 진구");
				psmt.executeUpdate();

				String sqlUpdate = "update user set email = ? where username = ?";
				PreparedStatement psmt2 = conn.prepareStatement(sqlUpdate);
				psmt2.setString(1, "b@naver.com");
				psmt2.setString(2, "김유신");
				psmt2.executeUpdate();

				// 수동 커밋 모드를 설정했따면 직접 commit() 을 실행 해야
				// 물리적인 저장장치에 영구히 반영이 된다
				if (true) {
					conn.commit();
				} else {
					conn.rollback();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} // end of main

}

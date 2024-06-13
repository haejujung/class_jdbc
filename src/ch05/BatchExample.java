package ch05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchExample {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydb4?serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "asd123";

		Connection conn = null;
		try {

			// MySQL 드라이버
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 자파 표준 API
			conn = DriverManager.getConnection(url, user, password);
			// 트랜잭션 처리
			conn.setAutoCommit(false); // 수동 커밋으로 변경

			// 배치 처리 --> User 테이블에 한번 사용자를 3명을 넣어보자.
			String sql = " insert into user (name, email) values(?, ?) ";
			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setString(1, "유저1");
			psmt.setString(2, "유저1@naver.com");
//			psmt.executeUpdate();
			// 배치 처리 하기위해 호출할 메서드 필요
			psmt.addBatch();

			// 2번 사용자 처리
			psmt.setString(1, "유저2");
			psmt.setString(2, "유저2@naver.com");
			psmt.addBatch();

			psmt.setString(1, "유저3");
			psmt.setString(2, "유저3@naver.com");
			psmt.addBatch();

			int[] rowCounts = psmt.executeBatch();

			conn.commit(); // 물리적인 저장 장치에 영구히 반영하겠다.
			System.out.println("배치 처리 완료 : " + rowCounts.length);

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

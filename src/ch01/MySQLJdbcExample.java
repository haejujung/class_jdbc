package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dto.Employee;

public class MySQLJdbcExample {

	public static void main(String[] args) {

		// 준비물

		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root"; // 상용서비스에서 절대 루트 계정사용 금지
		String password = "asd123";

		// 필요 데이터 타입
		// JDBC API 레벨(자바 개발자들이 개념화 시켜 놓은 클래스들이다.)
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		// 1. MYSQL 구현체를 사용하겠다는 설정을 해야 한다.
		// JDBC 드라이버 로드 ( MySQL 구현 클래스를 로드)
		try {
			// 1. 메모리에 사용하는 드라이버(JDBC API를 구현한 클래스) 클래스를 띄운다.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. 데이터 베이스 연결 설정
			connection = DriverManager.getConnection(url, user, password);

			// 3. SQL 실행
			statement = connection.createStatement();
			// 쿼리를 실행 시키는 메서드 (기억하자)
			resultSet = statement.executeQuery("SELECT * from employee"); // select 실행 시 사용한다.
			// statement.executeUpdate(password); --> Insert, update, delete 사용

			// 구문 분석 -- 파싱

			List<Employee> list = new ArrayList<>();
			
			// 4. 결과 처리
			while (resultSet.next()) {

				Employee employee = new Employee();

				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setHire_date(resultSet.getString("hire_date"));
				list.add(employee);
				
//				System.out.println("User ID : " + resultSet.getInt("id"));
//				System.out.println("USER NAME : " + resultSet.getString("name"));
//				System.out.println("department : " + resultSet.getString("department"));
//				System.out.println("--------------------------");

			}
			
			String temp = list.get(0).toString();
			String temp1 = "안녕하세요";
			System.out.println(temp1);
			System.out.println(temp);
			
//			System.out.println(list.get(0).toString());
//			System.out.println(list.get(1).toString());
//			System.out.println(list.get(2).toString());
//			System.out.println(list.get(3).toString());
//			System.out.println(list.get(4).toString());
//			
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // end of main

} // end of class

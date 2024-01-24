package sec02.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TryCatchEx2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// 예외처리 코드
			System.out.println("클래스 존재 X");
			System.exit(0);
			e.printStackTrace();
		} finally {
			System.out.println("반드시 실행");
		}
		try {
			Connection conn = DriverManager.getConnection(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

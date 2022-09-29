package GYM.model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BodyDAO {
	// 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static BodyDAO dao = new BodyDAO();
	
	// 연결 생성자
	private BodyDAO() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gym_project",
					"root",
					"1234"
				);
		} catch (Exception e) {
			System.out.println("DB오류 : " + e);
		}
	}
}
package GYM.model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import GYM.model.Dto.AdminDTO;

public class DAO {
	
	// 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static DAO dao = new DAO();
	
	// 연결 생성자
	private DAO() {
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
	
	// 메소드
	public static DAO getInstance() {
		return dao;
	}
	
	public void regist( AdminDTO dto ) {
		
		String sql = "insert into gym_admin values( null, ?, ? )";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getAdmin_id());
			ps.setString(2, dto.getAdmin_pw());
			ps.executeUpdate();
			return;
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		
	}
	
}

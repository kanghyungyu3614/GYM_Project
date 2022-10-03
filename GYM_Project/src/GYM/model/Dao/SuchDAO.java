package GYM.model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GYM.model.Dto.SuchDTO;

public class SuchDAO {
	// 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static SuchDAO dao = new SuchDAO();
	
	// 연결 생성자
	private SuchDAO() {
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
	
	// 싱글톤
	public static SuchDAO getInstance() {return dao;}
	
	// 출력
    public ArrayList<SuchDTO> read(){
    	ArrayList<SuchDTO> list = new ArrayList<>();
    	String sql = "select * from such";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			while(rs.next()) {
				SuchDTO such_dto = new SuchDTO(
				rs.getInt(1),
				rs.getInt(2),
				rs.getString(3),
				rs.getString(4),
				rs.getInt(5),
				rs.getString(6),
				rs.getInt(7),
				rs.getString(8));
				list.add(such_dto);
			}
			System.out.println(list);
			return list;
		} catch (Exception e) { return list; }
    }
}

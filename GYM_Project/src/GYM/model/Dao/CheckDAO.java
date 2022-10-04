package GYM.model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GYM.model.Dto.BodyDTO;
import GYM.model.Dto.CheckDTO;

public class CheckDAO {
	// 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static CheckDAO dao = new CheckDAO();
	
	// 연결 생성자
	private CheckDAO() {
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
	
	// 성생
	public static CheckDAO getInstance() { return dao; }
	
	//1. 내용추가 SQL 메소드
	public boolean create(CheckDTO dto) {
			String sql = "insert into member_check values( null , ? , ?);";
			try {
				ps = con.prepareStatement(sql);
				ps.setString( 1 , dto.getCk_name() );
				ps.setString( 2 , dto.getCk_date() );
				ps.executeUpdate(); return true;
			}catch (Exception e) { System.out.println("DB오류: "+e);}
			return false;
			}
	
	//2. 내용 출력 SQL 메소드
    public ArrayList<CheckDTO> read(){
    	ArrayList<CheckDTO> list = new ArrayList<>();
    	String sql = "select * from member_check";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			while(rs.next()) {
				CheckDTO check_list = new CheckDTO(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3));
				list.add(check_list);
			}
			return list;
		} catch (Exception e) { return list;}
    }
}

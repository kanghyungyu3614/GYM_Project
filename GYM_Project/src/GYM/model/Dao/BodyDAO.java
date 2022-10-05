package GYM.model.Dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GYM.model.Dto.BodyDTO;
import GYM.model.Dto.MembershipDTO;
import GYM.model.Dto.PtMemberDTO;

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
	
	// 성생
	public static BodyDAO getInstance() { return dao; }
	//1. 내용추가 SQL 메소드
	public boolean create(BodyDTO dto) {
			String sql = "insert into body values( null , ? , ? , ? , ?);";
			try {
				ps = con.prepareStatement(sql);
				ps.setString( 1 , dto.getBody_name() );
				ps.setString( 2 , dto.getBody_date() );
				ps.setString( 3, dto.getBody_place() );
				ps.setString( 4 , dto.getBody_comment() );
				ps.executeUpdate(); return true;
			}catch (Exception e) { System.out.println("DB오류: "+e);}
			return false;
			}
	//2. 내용 출력 SQL 메소드
    public ArrayList<BodyDTO> read(){
    	ArrayList<BodyDTO> list = new ArrayList<>();
    	String sql = "select * from body";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			while(rs.next()) {
				BodyDTO body_list = new BodyDTO(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4),
				rs.getString(5));
				list.add(body_list);
				
			}
			return list;
		} catch (Exception e) { return list;}
    }
    // 3. 내용 수정 SQL 메소드
    public boolean update(BodyDTO body_dto) {
    	String sql = "update body set body_name = ?, body_date = ?, body_place = ?, body_comment = ? where body_no = ?";
    	try {
    		ps = con.prepareStatement(sql);
    		ps.setString(1, body_dto.getBody_name());
    		ps.setString(2, body_dto.getBody_date());
    		ps.setString(3, body_dto.getBody_place());
    		ps.setString(4, body_dto.getBody_comment());
    		ps.setInt(5, body_dto.getBody_no());
    		ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
    }
    // 4. 내용 삭제 SQL 메소드
    public boolean delete(int body_no) {
    	String sql = "delete from body where body_no = ?";
    	try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, body_no);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
    }
	
} // class end
 
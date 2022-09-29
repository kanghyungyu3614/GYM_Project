package GYM.model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GYM.controller.PtMemberController;
import GYM.model.Dto.MembershipDTO;
import GYM.model.Dto.PtMemberDTO;

public class PtMemberDAO {
	// 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static PtMemberDAO dao = new PtMemberDAO();
	
	// 연결 생성자
	private PtMemberDAO() {
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

	    // 내용 추가 SQL 메소드 
		public static PtMemberDAO getInstance() {return dao;}
		
		//1. 내용추가 SQL 메소드
		public boolean create(PtMemberDTO pt_mem_dto) {
			String sql = "insert into pt_member values(null,?,?,?)";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, pt_mem_dto.getPt_name());
				ps.setString(2, pt_mem_dto.getPt_phone());
				ps.setString(3, pt_mem_dto.getPt_date());
				ps.executeUpdate();
				return true;	
			} catch (Exception e) {return false;}
		}
		//2. 내용 출력 SQL 메소드
	    public ArrayList<PtMemberDTO> read(){
	    	ArrayList<PtMemberDTO> list = new ArrayList<>();
	    	String sql = "select * from pt_member";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();	
				while(rs.next()) {
					PtMemberDTO pt_mem_dto = new PtMemberDTO(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4));
					list.add(pt_mem_dto);
					
				}
				return list;
			} catch (Exception e) { return list;}
	    }
		
		
		
		
}

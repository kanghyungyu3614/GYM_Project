package GYM.model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GYM.model.Dto.BodyDTO;
import GYM.model.Dto.MembershipDTO;
import GYM.model.Dto.PtMemberDTO;
import GYM.model.Dto.SuchDTO;

public class SuchDAO {
	// 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String login_name;
	
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
	
	public void login_save(String login_name) {
		this.login_name = login_name;
		return;
	}
	
	// 출력
    public ArrayList<MembershipDTO> mem_read(){
    	ArrayList<MembershipDTO> list = new ArrayList<>();
    	String sql = "select * from membership where mem_name = " + "'" + login_name + "'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	
			while(rs.next()) {
				MembershipDTO mem_dto = new MembershipDTO(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4),
				rs.getString(5));
				list.add(mem_dto);
			}
			return list;
		} catch (Exception e) { return list; }
    }
    
    public ArrayList<PtMemberDTO> pt_read(){
    	ArrayList<PtMemberDTO> list = new ArrayList<>();
    	String sql = "select * from pt_member where pt_name = " + "'" + login_name + "'";
    	try {
    		ps = con.prepareStatement(sql);
    		rs = ps.executeQuery();	
    		while(rs.next()) {
    			PtMemberDTO pt_dto = new PtMemberDTO(
    					rs.getInt(1),
    					rs.getString(2),
    					rs.getString(3),
    					rs.getString(4));
    			list.add(pt_dto);
    		}
    		return list;
    	} catch (Exception e) { return list; }
    }
    
    public ArrayList<BodyDTO> body_read(){
    	ArrayList<BodyDTO> list = new ArrayList<>();
    	String sql = "select * from body where body_name = " + "'" + login_name + "'";
    	try {
    		ps = con.prepareStatement(sql);
    		rs = ps.executeQuery();	
    		while(rs.next()) {
    			BodyDTO body_dto = new BodyDTO(
    					rs.getInt(1),
    					rs.getString(2),
    					rs.getString(3),
    					rs.getString(4),
    					rs.getString(5));
    			list.add(body_dto);
    		}
    		return list;
    	} catch (Exception e) { return list; }
    }
    
}

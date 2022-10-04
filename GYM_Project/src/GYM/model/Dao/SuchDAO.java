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
	private String login_id;
	
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
	
	public void login_save(String login_id) {
		this.login_id = login_id;
		return;
	}
	
	// 검색테이블 생성
	public boolean create(SuchDTO such_dto) {
		String sql = "insert into such values(null,null,?,?,null,?,null,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, such_dto.getSuch_no());
			ps.setInt(2, such_dto.getMem_no());
			ps.setString(3, such_dto.getMem_start());
			ps.setString(4, such_dto.getMem_end());
			ps.setInt(5, such_dto.getPt_no());
			ps.setString(6, such_dto.getPt_date());
			ps.setInt(7, such_dto.getBody_no());
			ps.setString(8, such_dto.getBody_date());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	// 출력
    public ArrayList<MembershipDTO> mem_read(){
    	ArrayList<MembershipDTO> list = new ArrayList<>();
    	String sql = "select * from membership where mem_name = " + "'" + login_id + "'";
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
    	String sql = "select * from pt_member where pt_name = " + "'" + login_id + "'";
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
    	String sql = "select * from body where body_name = " + "'" + login_id + "'";
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

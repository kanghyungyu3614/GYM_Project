package GYM.model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GYM.model.Dto.MembershipDTO;

public class MembershipDAO {
	// 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static MembershipDAO dao = new MembershipDAO();
	
	// 연결 생성자
	private MembershipDAO() {
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
	public static MembershipDAO getInstance() {return dao;}
	
	// 1. 내용추가 SQL 메소드
	public boolean create(MembershipDTO mem_dto) {
		String sql = "insert into membership values(null,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mem_dto.getMem_name());
			ps.setString(2, mem_dto.getMem_start());
			ps.setString(3, mem_dto.getMem_end());
			ps.setString(4, mem_dto.getMem_comment());
			ps.executeUpdate();
			return true;	
		} catch (Exception e) {
			return false;
		}
	}
	// 2. 내용 출력 SQL 메소드
    public ArrayList<MembershipDTO> read(){
    	ArrayList<MembershipDTO> list = new ArrayList<>();
    	String sql = "select * from membership";
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
		} catch (Exception e) { return list;}
    }
    
    // 3. 내용 수정 SQL 메소드
    public boolean update(MembershipDTO mem_dto) {
    	String sql = "update membership set mem_name = ?, mem_start = ?, mem_end = ?, mem_comment = ? where mem_no = ?";
    	try {
    		ps = con.prepareStatement(sql);
    		ps.setString(1, mem_dto.getMem_name());
    		ps.setString(2, mem_dto.getMem_start());
    		ps.setString(3, mem_dto.getMem_end());
    		ps.setString(4, mem_dto.getMem_comment());
    		ps.setInt(5, mem_dto.getMem_no());
    		ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
    }
    
    // 4. 내용 삭제 SQL 메소드
    public boolean delete(int mem_no) {
    	String sql = "delete from membership where mem_no = ?";
    	try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mem_no);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
    }
	
}

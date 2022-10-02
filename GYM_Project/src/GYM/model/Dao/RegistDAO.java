package GYM.model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GYM.model.Dto.MembershipDTO;
import GYM.model.Dto.RegistDTO;

public class RegistDAO {
	
	// 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static RegistDAO dao = new RegistDAO();
	
	// 연결 생성자
	private RegistDAO() {
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
	
	// 메소드 //
	public static RegistDAO getInstance() {
		return dao;
	}
	
	public boolean regist( RegistDTO dto ) {
		
		String sql = "insert into gym_regist values( null, ?, ? )";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getRegist_id());
			ps.setString(2, dto.getRegist_pw());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			//String sql2 = "select * from gym_regist where regist_id = " + "'" + dto.getRegist_id() + "'";
			ArrayList<RegistDTO> list = new ArrayList<>(); // 아이디 중복검사
			String sql2 = "select * from gym_regist where regist_id = " + "'" + dto.getRegist_id() + "'";
			try {
				ps = con.prepareStatement(sql2);
				rs = ps.executeQuery();	
				while(rs.next()) {
					
					RegistDTO result = new RegistDTO(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3));
					list.add(result);
					
					if(!result.getRegist_id().equals(null)) {
						System.out.println("존재하는 아이디입니다.");
						return false;	// 존재하는 아이디
						
					}
					
				}
			} catch (Exception err) {
				System.out.println(err);
				return false;	// 예기치 못한 에러
			}
			
			return false;
		}
		
	}
	
    public int login(String id, String pw){
    	ArrayList<RegistDTO> list = new ArrayList<>();
    	String sql = "select * from gym_regist";
//		try {
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();	
//			while(rs.next()) {
//				RegistDTO regist_dto = new RegistDTO(
//				rs.getInt(1),
//				rs.getString(2),
//				rs.getString(3));
//				list.add(regist_dto);
//			}
			
//			for(int i = 0; i < list.size(); i++){
			    
//				RegistDTO element = list.get(i)[i].toString();
//			      System.out.println(element);
    			String login_id;
    	
				String sql2 = "select * from gym_regist where regist_id = " + "'" + id + "'";
				try {
					ps = con.prepareStatement(sql2);
					rs = ps.executeQuery();	
					while(rs.next()) {
						
						RegistDTO result = new RegistDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3));
						list.add(result);
						
						if(result.getRegist_id().equals("admin") && result.getRegist_pw().equals(pw)) {
							System.out.println("※ 관리자계정 입니다 ※");
							return 4;	// admin계정 로그인 성공
						} else if(result.getRegist_pw().equals(pw)) {
							return 1;	// 로그인 성공
						} else if(!result.getRegist_pw().equals(pw)) {
							return 2;	// 패스워드 실패
						}
						
					}
				} catch (Exception e) {
					System.out.println(e);
					return 0;	// 예기치 못한 에러
				}
//			}
			
			return 3;	// 아이디 없음
			
//		} catch (Exception e) { return list; }
    }
	
}

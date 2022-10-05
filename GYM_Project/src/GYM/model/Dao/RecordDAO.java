package GYM.model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import GYM.model.Dto.CheckDTO;
import GYM.model.Dto.RecordDTO;

public class RecordDAO {

	// 필드
		private Connection con;
		private PreparedStatement ps;
		private ResultSet rs;
		
		private static RecordDAO dao = new RecordDAO();
		
		// 연결 생성자
		private RecordDAO() {
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
		public static RecordDAO getInstance() { return dao; }
		
		// 1. 내용추가 SQL 메소드
		public boolean create(RecordDTO dto) {
			String sql = "insert into record_exercise values( null , ? , ? , ? , ?);";
			try {
				ps = con.prepareStatement(sql);
				ps.setString( 1 , dto.getRd_name() );
				ps.setString( 2 , dto.getRd_date() );
				ps.setString( 3 , dto.getRd_routine() );
				ps.setString( 4 , dto.getRd_weight());
				ps.executeUpdate(); return true;
			}catch (Exception e) { System.out.println("DB오류: "+e);}
			return false;
			}
		
		//2. 내용 출력 SQL 메소드
	    public ArrayList<RecordDTO> read(){
	    	ArrayList<RecordDTO> list = new ArrayList<>();
	    	String sql = "select * from record_exercise";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();	
				while(rs.next()) {
					RecordDTO record_list = new RecordDTO(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5));
					list.add(record_list);
				}
				return list;
			} catch (Exception e) { return list;}
	    }
		 
		
	    
	
		
	
} // class end

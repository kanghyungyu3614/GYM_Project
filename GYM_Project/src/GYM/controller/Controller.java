package GYM.controller;

import GYM.model.Dao.DAO;
import GYM.model.Dto.AdminDTO;

public class Controller {
	
	public void regist(String admin_id, String admin_pw) {
			// 매개변수 3개 --> 1개의 dto로 선언
		AdminDTO dto = new AdminDTO(0, admin_id, admin_pw);

		DAO.getInstance().regist(dto);
		return;
	}
	
	public int login(String id, String pw) {
		
		// AdminDTO dto = new AdminDTO();
		// String admin_id = dto.admin_id;
		// String admin_pw = dto.admin_pw;
		
		if(id.equals("admin")) {
			if(pw.equals("admin")) {
				return 1;	// 로그인 성공				
			} else {				
				return 2;	// pw 실패
			}
		} else {			
			return 3 ; // id 실패
		}
		
	}
	
}

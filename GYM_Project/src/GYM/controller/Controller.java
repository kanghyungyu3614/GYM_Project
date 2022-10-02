package GYM.controller;

import java.util.ArrayList;

import GYM.model.Dao.RegistDAO;
import GYM.model.Dto.RegistDTO;

public class Controller {
	
	public boolean regist(String id, String pw) {
			// 매개변수 3개 --> 1개의 dto로 선언
		RegistDTO dto = new RegistDTO(0, id, pw);

		return RegistDAO.getInstance().regist(dto);
	}
	
	public int login(String id, String pw) {
		
		// AdminDTO dto = new AdminDTO();
		// String admin_id = dto.admin_id;
		// String admin_pw = dto.admin_pw;
		
//		if(id.equals("admin")) {
//			if(pw.equals("admin")) {
//				return 1;	// 로그인 성공				
//			} else {				
//				return 2;	// pw 실패
//			}
//		} else {			
//			return 3 ; // id 실패
//		}
		
		return RegistDAO.getInstance().login(id, pw);
		
	}
	
}

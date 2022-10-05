package GYM.controller;

import java.util.ArrayList;

import GYM.model.Dao.RegistDAO;
import GYM.model.Dao.SuchDAO;
import GYM.model.Dto.BodyDTO;
import GYM.model.Dto.RegistDTO;

public class Controller {
	
	public void id_save(String login_id) {
		RegistDAO.getInstance().id_save(login_id);
		return;
	}
	
	public boolean regist(String name, String id, String pw) {
			// 매개변수 3개 --> 1개의 dto로 선언
		RegistDTO dto = new RegistDTO(0, name, id, pw);

		return RegistDAO.getInstance().regist(dto);
	}
	
	public int login(String id, String pw) {
		
		return RegistDAO.getInstance().login(id, pw);
		
	}
	
	public ArrayList<RegistDTO> regist_read(String id){
		return RegistDAO.getInstance().read(id);
	}
	
	public boolean update(String change_name, String change_id, String change_pw) {
		RegistDTO dto = new RegistDTO(0, change_name, change_id, change_pw);
		return RegistDAO.getInstance().update(dto);
	}
	
	public boolean delete(String id) {
		return RegistDAO.getInstance().delete(id);
	}
}

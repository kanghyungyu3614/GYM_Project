package GYM.controller;

import java.util.ArrayList;

import GYM.model.Dao.SuchDAO;
import GYM.model.Dto.BodyDTO;
import GYM.model.Dto.MembershipDTO;
import GYM.model.Dto.PtMemberDTO;

public class SuchController {
	
	public void login_save(String login_name, String login_id) {
		SuchDAO.getInstance().login_save(login_name, login_id);
		return;
	}

	public ArrayList<MembershipDTO> mem_read(){
		return SuchDAO.getInstance().mem_read();
	}
	
	public ArrayList<PtMemberDTO> pt_read(){
		return SuchDAO.getInstance().pt_read();
	}
	
	public ArrayList<BodyDTO> body_read(){
		return SuchDAO.getInstance().body_read();
	}
	
}

package GYM.controller;

import java.util.ArrayList;

import GYM.model.Dao.MembershipDAO;
import GYM.model.Dto.MembershipDTO;

public class MembershipController {
	
	public boolean create(String mem_name,String mem_start,String mem_end,String mem_comment) {
		MembershipDTO mem_dto = new MembershipDTO(0,mem_name,mem_start,mem_end,mem_comment);
		return MembershipDAO.getInstance().create(mem_dto);
	}
	
	public ArrayList<MembershipDTO> read(){
		return MembershipDAO.getInstance().read();
	}
	
	public boolean update(int mem_no, String mem_name, String mem_start, String mem_end, String mem_comment) {
		MembershipDTO mem_dto = new MembershipDTO(mem_no, mem_name, mem_start, mem_end, mem_comment);
		return MembershipDAO.getInstance().update(mem_dto);
	}
	
	public boolean delete(int mem_no) {
		return MembershipDAO.getInstance().delete(mem_no);
	}
	
}

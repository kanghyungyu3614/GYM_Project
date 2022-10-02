package GYM.controller;

import java.util.ArrayList;

import GYM.model.Dao.PtMemberDAO;
import GYM.model.Dto.PtMemberDTO;




public class PtMemberController { 
	
	public boolean create(String pt_name,String pt_phone,String pt_date) {
		PtMemberDTO pt_mem_dto = new PtMemberDTO(0, pt_name,pt_phone,pt_date);
		return PtMemberDAO.getInstance().create(pt_mem_dto);
	}
	
	public ArrayList<PtMemberDTO> read(){
		return PtMemberDAO.getInstance().read();
		
	}
	
	public boolean update(int pt_no, String pt_name, String pt_phone, String pt_date) {
		PtMemberDTO pt_dto = new PtMemberDTO(pt_no, pt_name, pt_phone, pt_date);
		return PtMemberDAO.getInstance().update(pt_dto);
	}
	
	public boolean delete(int pt_no) {
		return PtMemberDAO.getInstance().delete(pt_no);
	}

}

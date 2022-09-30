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

}

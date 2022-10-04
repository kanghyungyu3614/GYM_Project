package GYM.controller;

import java.util.ArrayList;

import GYM.model.Dao.BodyDAO;
import GYM.model.Dao.MembershipDAO;
import GYM.model.Dao.PtMemberDAO;
import GYM.model.Dto.BodyDTO;
import GYM.model.Dto.MembershipDTO;
import GYM.model.Dto.PtMemberDTO;

public class BodyController {
 
	
		public boolean create(  String body_name, String body_date, String body_place, String body_comment) {
				BodyDTO boby_dto= new BodyDTO(0 ,  body_name, body_date, body_place, body_comment);
				return BodyDAO.getInstance().create(boby_dto);
		}
			
		public ArrayList<BodyDTO> read(){
			return BodyDAO.getInstance().read();
			
		}	
			 
		public boolean update(int body_no, String body_name, String body_date, String body_place,String body_comment) {
			BodyDTO body_dto = new BodyDTO(body_no, body_name, body_date, body_place,body_comment);
			return BodyDAO.getInstance().update(body_dto);
		}	 
	    
		public boolean delete(int body_no) {
			return BodyDAO.getInstance().delete(body_no);
		}
}

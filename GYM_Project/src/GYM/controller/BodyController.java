package GYM.controller;

import java.util.ArrayList;

import GYM.model.Dao.BodyDAO;
import GYM.model.Dto.BodyDTO;

public class BodyController {
 
	// 1.
		public boolean create(  String body_name, String body_date, String body_place, String body_comment) {
				BodyDTO boby_dto= new BodyDTO(0 ,  body_name, body_date, body_place, body_comment);
				return BodyDAO.getInstance().create(boby_dto);
			}
			
			// 2.
			
			
			//
			 
			 
	
}

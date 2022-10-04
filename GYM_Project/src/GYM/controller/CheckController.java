package GYM.controller;

import java.util.ArrayList;

import GYM.model.Dao.BodyDAO;
import GYM.model.Dao.CheckDAO;
import GYM.model.Dto.BodyDTO;
import GYM.model.Dto.CheckDTO;

public class CheckController {
	
	public boolean create(  String check_name, String check_date) {
		CheckDTO boby_dto= new CheckDTO(0 ,  check_name, check_date);
		return CheckDAO.getInstance().create(boby_dto);
    }
	
	public ArrayList<CheckDTO> read() {
		return CheckDAO.getInstance().read();
	}
}
